package com.coboard.dataaccess.dao;

import com.coboard.dataaccess.api.JpaDaoImpl;

import com.coboard.modelo.Sesion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * A data access object (DAO) providing persistence and search support for
 * Sesion entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Sesion
 */
@Scope("singleton")
@Repository("SesionDAO")
public class SesionDAO extends JpaDaoImpl<Sesion, Integer> implements ISesionDAO {
    private static final Logger log = LoggerFactory.getLogger(SesionDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static ISesionDAO getFromApplicationContext(ApplicationContext ctx) {
        return (ISesionDAO) ctx.getBean("SesionDAO");
    }

	@Override
	public List<Sesion> sesionesEntreFechas(Date fechaInicio, Date fechaFin) {
		String jpql="SELECT se.usuariocreador, se.fechasesion, se.horasesion, se.fechasesionfin, se.horafin FROM Sesion se WHERE se.fechasesion BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "' ORDER BY (se.fechasesion)";
		return entityManager.createQuery(jpql).getResultList();
	}
}
