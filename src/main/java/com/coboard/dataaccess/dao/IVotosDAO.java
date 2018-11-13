package com.coboard.dataaccess.dao;

import com.coboard.dataaccess.api.Dao;
import com.coboard.modelo.Informacion;
import com.coboard.modelo.Proyecto;
import com.coboard.modelo.Usuario;
import com.coboard.modelo.Votos;
import com.coboard.modelo.dto.VotosDTO;

import java.util.List;


/**
* Interface for   VotosDAO.
*
*/
public interface IVotosDAO extends Dao<Votos, Integer> {
	
	public List<VotosDTO> votosDeUsuarios(Proyecto proyecto);
	public Votos existeVoto (Integer idinformacion, Integer idusuario);
	public List<VotosDTO> votosDeUsuarioPorProyecto(Proyecto proyecto, Usuario usuario);
	public Long cantidadVotosVariables (Informacion informacion);
	public Long cantidadVotosPorEstado (String votos, Informacion informacion);
	public Long cantidadVotosTotalesPorVariable (Informacion informacion, Votos votos);
}
