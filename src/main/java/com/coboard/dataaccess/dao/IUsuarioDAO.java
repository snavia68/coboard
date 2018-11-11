package com.coboard.dataaccess.dao;

import com.coboard.dataaccess.api.Dao;
import com.coboard.modelo.Proyecto;
import com.coboard.modelo.Usuario;
import com.coboard.modelo.dto.UsuarioDTO;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for   UsuarioDAO.
*
*/
public interface IUsuarioDAO extends Dao<Usuario, Integer> {
	
	
	public List<Usuario> usuariosParaAsignacion(Integer idProyecto);
	
	public List<Usuario> usuariosConectados(Proyecto proyecto);
	
	public List<String> nombresUsuarios(Proyecto proyecto);
}
