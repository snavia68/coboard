package com.coboard.dataaccess.dao;

import com.coboard.dataaccess.api.JpaDaoImpl;

import com.coboard.modelo.Adjuntos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * A data access object (DAO) providing persistence and search support for
 * Adjuntos entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Adjuntos
 */
@Scope("singleton")
@Repository("AdjuntosDAO")
public class AdjuntosDAO extends JpaDaoImpl<Adjuntos, Integer>
    implements IAdjuntosDAO {
    private static final Logger log = LoggerFactory.getLogger(AdjuntosDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IAdjuntosDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IAdjuntosDAO) ctx.getBean("AdjuntosDAO");
    }

	@Override
	public Adjuntos findAdjuntoByInformacion(Integer idinformacion) {
		String jpql ="SELECT adj FROM Adjuntos adj WHERE adj.informacion.idinformacion=:id";
		return (Adjuntos)entityManager.createQuery(jpql).setParameter("id",idinformacion).getSingleResult();
	}
}
