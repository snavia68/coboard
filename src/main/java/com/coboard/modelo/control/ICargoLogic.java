package com.coboard.modelo.control;

import com.coboard.modelo.Cargo;
import com.coboard.modelo.dto.CargoDTO;

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
public interface ICargoLogic {
    public List<Cargo> getCargo() throws Exception;

    /**
         * Save an new Cargo entity
         */
    public void saveCargo(Cargo entity) throws Exception;

    /**
         * Delete an existing Cargo entity
         *
         */
    public void deleteCargo(Cargo entity) throws Exception;

    /**
        * Update an existing Cargo entity
        *
        */
    public void updateCargo(Cargo entity) throws Exception;

    /**
         * Load an existing Cargo entity
         *
         */
    public Cargo getCargo(Integer idcargo) throws Exception;

    public List<Cargo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Cargo> findPageCargo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCargo() throws Exception;

    public List<CargoDTO> getDataCargo() throws Exception;

    public void validateCargo(Cargo cargo) throws Exception;
}
