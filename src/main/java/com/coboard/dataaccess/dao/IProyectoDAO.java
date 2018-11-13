package com.coboard.dataaccess.dao;

import java.math.BigInteger;

import com.coboard.dataaccess.api.Dao;
import com.coboard.modelo.Proyecto;

/**
* Interface for   ProyectoDAO.
*
*/
public interface IProyectoDAO extends Dao<Proyecto, Integer> {
	public Long cantidadUsuariosPorProyecto (Proyecto proyecto);
}
