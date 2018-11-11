package com.coboard.modelo.control;

import com.coboard.modelo.Tipousuario;
import com.coboard.modelo.dto.TipousuarioDTO;

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
public interface ITipousuarioLogic {
    public List<Tipousuario> getTipousuario() throws Exception;

    /**
         * Save an new Tipousuario entity
         */
    public void saveTipousuario(Tipousuario entity) throws Exception;

    /**
         * Delete an existing Tipousuario entity
         *
         */
    public void deleteTipousuario(Tipousuario entity) throws Exception;

    /**
        * Update an existing Tipousuario entity
        *
        */
    public void updateTipousuario(Tipousuario entity) throws Exception;

    /**
         * Load an existing Tipousuario entity
         *
         */
    public Tipousuario getTipousuario(Integer idtipousuario)
        throws Exception;

    public List<Tipousuario> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tipousuario> findPageTipousuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipousuario() throws Exception;

    public List<TipousuarioDTO> getDataTipousuario() throws Exception;

    public void validateTipousuario(Tipousuario tipousuario)
        throws Exception;
    
}
