package com.coboard.dataaccess.dao;

import com.coboard.dataaccess.api.Dao;
import com.coboard.modelo.Proyecto;

/**
* Interface for   ProyectoDAO.
*
*/
public interface IProyectoDAO extends Dao<Proyecto, Integer> {
	public Integer cantidadUsuariosPorProyecto (Proyecto proyecto);
}
