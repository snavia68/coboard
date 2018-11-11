package com.coboard.dataaccess.dao;

import com.coboard.dataaccess.api.JpaDaoImpl;

import com.coboard.modelo.Proyecto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * A data access object (DAO) providing persistence and search support for
 * Proyecto entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Proyecto
 */
@Scope("singleton")
@Repository("ProyectoDAO")
public class ProyectoDAO extends JpaDaoImpl<Proyecto, Integer>
    implements IProyectoDAO {
    private static final Logger log = LoggerFactory.getLogger(ProyectoDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IProyectoDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IProyectoDAO) ctx.getBean("ProyectoDAO");
    }
}
