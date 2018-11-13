package com.coboard.dataaccess.dao;

import com.coboard.dataaccess.api.JpaDaoImpl;
import com.coboard.modelo.Informacion;
import com.coboard.modelo.Proyecto;
import com.coboard.modelo.Usuario;
import com.coboard.modelo.Votos;
import com.coboard.modelo.dto.VotosDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


/**
 * A data access object (DAO) providing persistence and search support for
 * Votos entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Votos
 */
@Scope("singleton")
@Repository("VotosDAO")
public class VotosDAO extends JpaDaoImpl<Votos, Integer> implements IVotosDAO {
    private static final Logger log = LoggerFactory.getLogger(VotosDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IVotosDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IVotosDAO) ctx.getBean("VotosDAO");
    }

	@Override
	public List<VotosDTO> votosDeUsuarios(Proyecto proyecto) {
		try {
			String sql="SELECT i.descripcion descripcionInformacion, STRING_AGG(u.nombre, ',' ORDER BY u.idUsuario) nombresUsuarios, STRING_AGG(COALESCE(v.voto, ' '), ','  ORDER BY u.idUsuario) votosRealizados \r\n" + 
					"FROM Proyecto p \r\n" + 
					"INNER JOIN Proyectousuario pu on pu.idproyecto=p.idproyecto  \r\n" + 
					"INNER JOIN Usuario u on u.idusuario=pu.idusuario \r\n" + 
					"INNER JOIN Informacion i on i.idproyecto=p.idproyecto \r\n" + 
					"LEFT JOIN ( \r\n" + 
					"	SELECT v.voto, v.idinformacion, pu.idUsuario \r\n" + 
					"	FROM Votos v \r\n" + 
					"	INNER JOIN Sesion s on s.idSesion = v.idSesion \r\n" + 
					"	INNER JOIN Proyectousuario pu on s.idproyectousuario=pu.idproyectousuario \r\n" + 
					"	where v.activo='S' \r\n" + 
					") v ON v.idinformacion=i.idinformacion AND v.idusuario = u.idusuario \r\n" + 
					"WHERE p.idproyecto="+ proyecto.getIdproyecto() +" \r\n" + 
					"GROUP BY i.idinformacion";
				
			Query query = entityManager.createNativeQuery(sql);
				
			List<Object[]> resultado = query.getResultList();
			List<VotosDTO> votos = new ArrayList<VotosDTO>();
			
			for (Object[] voto : resultado) {
				votos.add(new VotosDTO((String) voto[0],(String) voto[1],(String) voto[2]));
			}
			
			return votos;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}
	
	@Override
	public Votos existeVoto (Integer idInformacion, Integer idUsuario) {
		String jpql2 = "SELECT count(vo.idvoto) FROM Votos vo, Sesion se, Proyectousuario pr WHERE vo.informacion.idinformacion=" +idInformacion+ " AND pr.usuario.idusuario="+idUsuario+" AND vo.sesion.idsesion=se.idsesion AND se.proyectousuario.idproyectousuario=pr.idproyectousuario";
		Long votos2 = (Long)entityManager.createQuery(jpql2).getSingleResult();
		if(votos2 == 1) {
			String jpql = "SELECT vo FROM Votos vo, Sesion se, Proyectousuario pr WHERE vo.informacion.idinformacion=" +idInformacion+ " AND pr.usuario.idusuario="+idUsuario+" AND vo.sesion.idsesion=se.idsesion AND se.proyectousuario.idproyectousuario=pr.idproyectousuario";
			Votos votos = (Votos)entityManager.createQuery(jpql).getSingleResult();
			return votos;
		} else {
			Votos votos = new Votos(); 
			return votos = null;
		}
	}
	
	@Override
	public List<VotosDTO> votosDeUsuarioPorProyecto(Proyecto proyecto, Usuario usuario) {
		try {
			String sql="SELECT informacion.descripcion, voto\r\n" + 
					"FROM votos, proyectousuario, sesion, informacion\r\n" + 
					"WHERE votos.idsesion=sesion.idsesion AND sesion.idproyectousuario=proyectousuario.idproyectousuario\r\n" + 
					"AND proyectousuario.idusuario="+usuario.getIdusuario()+" AND proyectousuario.idproyecto="+proyecto.getIdproyecto()+" AND votos.idinformacion=informacion.idinformacion";
				
			Query query = entityManager.createNativeQuery(sql);
				
			List<Object[]> resultado = query.getResultList();
			List<VotosDTO> votos = new ArrayList<VotosDTO>();
			
			for (Object[] voto : resultado) {
				votos.add(new VotosDTO((String) voto[0],(String) voto[1]));
			}
			
			return votos;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		} 
	}

	@Override
	public Long cantidadVotosVariables(Informacion informacion) {
		String jpql = "SELECT COUNT(vo.idvoto) FROM Votos vo WHERE vo.idinformacion = " + informacion.getIdinformacion();
		Long cantidad = (Long)entityManager.createQuery(jpql).getSingleResult();
		return cantidad;
	}

	@Override
	public Long cantidadVotosPorEstado(String votos, Informacion informacion) {
		String jpql = "SELECT COUNT(vo.idvoto) FROM Votos vo WHERE vo.voto = '" + votos + "' AND vo.informacion.idinformacion = " + informacion.getIdinformacion();
		Long cantidad = (Long)entityManager.createQuery(jpql).getSingleResult();
		return cantidad;
	}

	@Override
	public Long cantidadVotosTotalesPorVariable(Informacion informacion, Votos votos) {
		String jpql = "SELECT COUNT(vo.idvoto) FROM Votos vo WHERE vo.idinformacion = " + informacion.getIdinformacion() + " AND vo.voto = '" + votos.getVoto() +"'";
		Long cantidad = (Long)entityManager.createQuery(jpql).getSingleResult();
		return cantidad;
	}
	
}
