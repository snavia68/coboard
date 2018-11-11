package com.coboard.dataaccess.dao;

import com.coboard.dataaccess.api.JpaDaoImpl;

import com.coboard.modelo.Informacion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * A data access object (DAO) providing persistence and search support for
 * Informacion entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Informacion
 */
@Scope("singleton")
@Repository("InformacionDAO")
public class InformacionDAO extends JpaDaoImpl<Informacion, Integer>
    implements IInformacionDAO {
    private static final Logger log = LoggerFactory.getLogger(InformacionDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IInformacionDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IInformacionDAO) ctx.getBean("InformacionDAO");
    }
}
