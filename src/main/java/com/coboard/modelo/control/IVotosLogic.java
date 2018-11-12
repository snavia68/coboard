package com.coboard.modelo.control;

import com.coboard.modelo.Informacion;
import com.coboard.modelo.Proyecto;
import com.coboard.modelo.Usuario;
import com.coboard.modelo.Votos;
import com.coboard.modelo.dto.VotosDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IVotosLogic {
    public List<Votos> getVotos() throws Exception;

    /**
         * Save an new Votos entity
         */
    public void saveVotos(Votos entity) throws Exception;

    /**
         * Delete an existing Votos entity
         *
         */
    public void deleteVotos(Votos entity) throws Exception;

    /**
        * Update an existing Votos entity
        *
        */
    public void updateVotos(Votos entity) throws Exception;

    /**
         * Load an existing Votos entity
         *
         */
    public Votos getVotos(Integer idvoto) throws Exception;

    public List<Votos> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Votos> findPageVotos(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberVotos() throws Exception;

    public List<VotosDTO> getDataVotos() throws Exception;

    public void validateVotos(Votos votos) throws Exception;
    
    public List<VotosDTO> votosDeUsuarios(Proyecto proyecto);
    
    public Votos existeVoto (Integer idinformacion, Integer idusuario);
    
    public List<VotosDTO> votosDeUsuarioPorProyecto(Proyecto proyecto, Usuario usuario);
    
    public Integer cantidadVotosVariables (Informacion informacion);
    
	public Integer cantidadVotosPorEstado (Votos votos);
	
	public Integer cantidadVotosTotalesPorVariable (Informacion informacion, Votos votos);
}
