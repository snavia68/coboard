package com.coboard.dataaccess.dao;

import java.util.List;

import com.coboard.dataaccess.api.Dao;
import com.coboard.modelo.Mensaje;

public interface IMensajeDAO extends Dao<Mensaje, Integer>{

	public List<Mensaje> mensajesPorProyecto(Integer idProyecto);
}
