package com.coboard.dataaccess.dao;

import com.coboard.dataaccess.api.JpaDaoImpl;
import com.coboard.modelo.Proyecto;
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
 * Usuario entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Usuario
 */
@Scope("singleton")
@Repository("UsuarioDAO")
public class UsuarioDAO extends JpaDaoImpl<Usuario, Integer>
    implements IUsuarioDAO {
    private static final Logger log = LoggerFactory.getLogger(UsuarioDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IUsuarioDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IUsuarioDAO) ctx.getBean("UsuarioDAO");
    }

	@Override
	public List<Usuario> usuariosParaAsignacion(Integer idProyecto) {
		String jpql="select usu FROM Usuario usu where usu.activo='S' and usu.tipousuario.idtipousuario=1 and usu.idusuario not in (select pu.usuario.idusuario from Proyectousuario pu where pu.proyecto.idproyecto="+idProyecto+")";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public List<String> nombresUsuarios(Proyecto proyecto) {
		String jpql="select usu.nombre "
				+ "FROM Usuario usu, Proyectousuario pu, Proyecto p "
				+ "WHERE usu.activo='S' and usu.idusuario=pu.usuario.idusuario and pu.proyecto.idproyecto=p.idproyecto and p.idproyecto="+proyecto.getIdproyecto()+" "
						+ "ORDER BY usu.idusuario";
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public List<Usuario> usuariosConectados(Proyecto proyecto) {
		String jpql="SELECT u FROM Usuario u, Sesion s, Proyecto p, Proyectousuario pu \r\n" + 
				"WHERE s.proyectousuario.idproyectousuario=pu.idproyectousuario AND\r\n" + 
				"	pu.usuario.idusuario = u.idusuario AND pu.proyecto.idproyecto = p.idproyecto\r\n" + 
				"	AND s.fechasesion=CURRENT_DATE AND s.horafin is NULL AND p.idproyecto="+proyecto.getIdproyecto();
		return entityManager.createQuery(jpql).getResultList();
	}
}
