package com.coboard.modelo.control;

import com.coboard.modelo.Adjuntos;
import com.coboard.modelo.dto.AdjuntosDTO;

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
public interface IAdjuntosLogic {
    public List<Adjuntos> getAdjuntos() throws Exception;

    /**
         * Save an new Adjuntos entity
         */
    public void saveAdjuntos(Adjuntos entity) throws Exception;

    /**
         * Delete an existing Adjuntos entity
         *
         */
    public void deleteAdjuntos(Adjuntos entity) throws Exception;

    /**
        * Update an existing Adjuntos entity
        *
        */
    public void updateAdjuntos(Adjuntos entity) throws Exception;

    /**
         * Load an existing Adjuntos entity
         *
         */
    public Adjuntos getAdjuntos(Integer idadjuntos) throws Exception;

    public List<Adjuntos> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Adjuntos> findPageAdjuntos(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberAdjuntos() throws Exception;

    public List<AdjuntosDTO> getDataAdjuntos() throws Exception;

    public void validateAdjuntos(Adjuntos adjuntos) throws Exception;
    
    public Adjuntos findAdjuntoByInformacion(Integer idinformacion) throws Exception;
}
