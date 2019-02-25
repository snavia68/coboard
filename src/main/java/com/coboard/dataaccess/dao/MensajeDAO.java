package com.coboard.dataaccess.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.coboard.dataaccess.api.JpaDaoImpl;
import com.coboard.modelo.Mensaje;

@Scope("singleton")
@Repository("MensajeDAO")
public class MensajeDAO extends JpaDaoImpl<Mensaje, Integer> implements IMensajeDAO{
	private static final Logger log = LoggerFactory.getLogger(MensajeDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IMensajeDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IMensajeDAO) ctx.getBean("MensajeDAO");
    }
    
    @Override
	public List<Mensaje> mensajesPorProyecto(Integer idProyecto) {
		String jpql="select m FROM Mensaje m where m.idproyecto="+idProyecto;
		return entityManager.createQuery(jpql).getResultList();
	}
}
