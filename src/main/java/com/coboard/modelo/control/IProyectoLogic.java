package com.coboard.modelo.control;

import com.coboard.modelo.Proyecto;
import com.coboard.modelo.dto.ProyectoDTO;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IProyectoLogic {
    public List<Proyecto> getProyecto() throws Exception;

    /**
         * Save an new Proyecto entity
         */
    public void saveProyecto(Proyecto entity) throws Exception;

    /**
         * Delete an existing Proyecto entity
         *
         */
    public void deleteProyecto(Proyecto entity) throws Exception;

    /**
        * Update an existing Proyecto entity
        *
        */
    public void updateProyecto(Proyecto entity) throws Exception;

    /**
         * Load an existing Proyecto entity
         *
         */
    public Proyecto getProyecto(Integer idproyecto) throws Exception;

    public List<Proyecto> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Proyecto> findPageProyecto(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberProyecto() throws Exception;

    public List<ProyectoDTO> getDataProyecto() throws Exception;

    public void validateProyecto(Proyecto proyecto) throws Exception;
    
    public Long cantidadUsuariosPorProyecto (Proyecto proyecto);
    
}
