package com.coboard.modelo.control;

import com.coboard.modelo.Tipoproyecto;
import com.coboard.modelo.dto.TipoproyectoDTO;

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
public interface ITipoproyectoLogic {
    public List<Tipoproyecto> getTipoproyecto() throws Exception;

    /**
         * Save an new Tipoproyecto entity
         */
    public void saveTipoproyecto(Tipoproyecto entity) throws Exception;

    /**
         * Delete an existing Tipoproyecto entity
         *
         */
    public void deleteTipoproyecto(Tipoproyecto entity)
        throws Exception;

    /**
        * Update an existing Tipoproyecto entity
        *
        */
    public void updateTipoproyecto(Tipoproyecto entity)
        throws Exception;

    /**
         * Load an existing Tipoproyecto entity
         *
         */
    public Tipoproyecto getTipoproyecto(Integer idtipoproyecto)
        throws Exception;

    public List<Tipoproyecto> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tipoproyecto> findPageTipoproyecto(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoproyecto() throws Exception;

    public List<TipoproyectoDTO> getDataTipoproyecto()
        throws Exception;

    public void validateTipoproyecto(Tipoproyecto tipoproyecto)
        throws Exception;
}
