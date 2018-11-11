package com.coboard.modelo.control;

import com.coboard.modelo.Sesion;
import com.coboard.modelo.dto.SesionDTO;

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
public interface ISesionLogic {
    public List<Sesion> getSesion() throws Exception;

    /**
         * Save an new Sesion entity
         */
    public void saveSesion(Sesion entity) throws Exception;

    /**
         * Delete an existing Sesion entity
         *
         */
    public void deleteSesion(Sesion entity) throws Exception;

    /**
        * Update an existing Sesion entity
        *
        */
    public void updateSesion(Sesion entity) throws Exception;

    /**
         * Load an existing Sesion entity
         *
         */
    public Sesion getSesion(Integer idsesion) throws Exception;

    public List<Sesion> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Sesion> findPageSesion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberSesion() throws Exception;

    public List<SesionDTO> getDataSesion() throws Exception;

    public void validateSesion(Sesion sesion) throws Exception;
}
