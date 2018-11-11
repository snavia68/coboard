package com.coboard.modelo.control;

import com.coboard.modelo.Informacion;
import com.coboard.modelo.Proyecto;
import com.coboard.modelo.Usuario;
import com.coboard.modelo.dto.InformacionDTO;

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
public interface IInformacionLogic {
    public List<Informacion> getInformacion() throws Exception;

    /**
         * Save an new Informacion entity
         */
    public void saveInformacion(Informacion entity) throws Exception;

    /**
         * Delete an existing Informacion entity
         *
         */
    public void deleteInformacion(Informacion entity) throws Exception;

    /**
        * Update an existing Informacion entity
        *
        */
    public void updateInformacion(Informacion entity) throws Exception;

    /**
         * Load an existing Informacion entity
         *
         */
    public Informacion getInformacion(Integer idinformacion)
        throws Exception;
    
    public List<Informacion> getVariableByProject(Proyecto proyecto);

    public List<Informacion> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Informacion> findPageInformacion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberInformacion() throws Exception;

    public List<InformacionDTO> getDataInformacion() throws Exception;
    public List<Informacion> listarVariablesProyecto(Proyecto proyecto) throws Exception;
    public void validateInformacion(Informacion informacion) throws Exception;
}
