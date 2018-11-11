package com.coboard.dataaccess.dao;

import com.coboard.dataaccess.api.JpaDaoImpl;
import com.coboard.modelo.Adjuntos;
import com.coboard.modelo.Proyecto;
import com.coboard.modelo.Proyectousuario;
import com.coboard.modelo.Usuario;
import com.coboard.modelo.dto.UsuarioDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * A data access object (DAO) providing persistence and search support for
 * Proyectousuario entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Proyectousuario
 */
@Scope("singleton")
@Repository("ProyectousuarioDAO")
public class ProyectousuarioDAO extends JpaDaoImpl<Proyectousuario, Integer>
    implements IProyectousuarioDAO {
    private static final Logger log = LoggerFactory.getLogger(ProyectousuarioDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IProyectousuarioDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IProyectousuarioDAO) ctx.getBean("ProyectousuarioDAO");
    }

	@Override
	public List<Usuario> usuariosPorProyecto(Integer idProyecto) {
		String jpql="select pu.usuario FROM Proyectousuario pu where pu.proyecto.idproyecto="+idProyecto;
		return entityManager.createQuery(jpql).getResultList();
	}
	@Override
	public Proyectousuario buscarPorUsuario(Integer idUsuario, Integer idProyecto) {
		String jpql="select pu FROM Proyectousuario pu where pu.usuario.idusuario="+idUsuario+" and pu.proyecto.idproyecto="+idProyecto;
		return (Proyectousuario)entityManager.createQuery(jpql).getSingleResult();
	}

	@Override
	public List<Proyecto> proyectosPorUsuario(Integer idUsuario) {
		String jpql = "SELECT pro FROM Proyecto pro, Proyectousuario pu WHERE pu.proyecto.idproyecto = pro.idproyecto AND pu.usuario.idusuario=:id";
		return entityManager.createQuery(jpql).setParameter("id",idUsuario).getResultList();
	}
}
