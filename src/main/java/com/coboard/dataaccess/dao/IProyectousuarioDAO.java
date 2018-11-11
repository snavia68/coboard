package com.coboard.dataaccess.dao;

import com.coboard.dataaccess.api.Dao;
import com.coboard.modelo.Proyecto;
import com.coboard.modelo.Proyectousuario;
import com.coboard.modelo.Usuario;
import com.coboard.modelo.dto.UsuarioDTO;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for   ProyectousuarioDAO.
*
*/
public interface IProyectousuarioDAO extends Dao<Proyectousuario, Integer> {
	
	public List<Usuario> usuariosPorProyecto(Integer idProyecto);
	public Proyectousuario buscarPorUsuario(Integer idUsuario, Integer idProyecto);
	public List<Proyecto> proyectosPorUsuario(Integer idUsuario);
}
