package com.coboard.dataaccess.dao;

import com.coboard.dataaccess.api.JpaDaoImpl;

import com.coboard.modelo.Cargo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * A data access object (DAO) providing persistence and search support for
 * Cargo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Cargo
 */
@Scope("singleton")
@Repository("CargoDAO")
public class CargoDAO extends JpaDaoImpl<Cargo, Integer> implements ICargoDAO {
    private static final Logger log = LoggerFactory.getLogger(CargoDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static ICargoDAO getFromApplicationContext(ApplicationContext ctx) {
        return (ICargoDAO) ctx.getBean("CargoDAO");
    }
}
