package com.coboard.modelo.control;

import com.coboard.modelo.Proyecto;
import com.coboard.modelo.Proyectousuario;
import com.coboard.modelo.Usuario;
import com.coboard.modelo.dto.ProyectousuarioDTO;
import com.coboard.modelo.dto.UsuarioDTO;

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
public interface IProyectousuarioLogic {
    public List<Proyectousuario> getProyectousuario() throws Exception;

    /**
         * Save an new Proyectousuario entity
         */
    public void saveProyectousuario(Proyectousuario entity)
        throws Exception;

    /**
         * Delete an existing Proyectousuario entity
         *
         */
    public void deleteProyectousuario(Proyectousuario entity)
        throws Exception;

    /**
        * Update an existing Proyectousuario entity
        *
        */
    public void updateProyectousuario(Proyectousuario entity)
        throws Exception;

    /**
         * Load an existing Proyectousuario entity
         *
         */
    public Proyectousuario getProyectousuario(Integer idproyectousuario)
        throws Exception;

    public List<Proyectousuario> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Proyectousuario> findPageProyectousuario(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberProyectousuario() throws Exception;

    public List<ProyectousuarioDTO> getDataProyectousuario()
        throws Exception;

    public void validateProyectousuario(Proyectousuario proyectousuario)
        throws Exception;
    
    public List<Usuario> usuariosPorProyecto(Integer idProyecto);
    
    public Proyectousuario buscarPorUsuario(Integer idUsuario, Integer idProyecto);
    
    public List<Proyecto> proyectosPorUsuario(Integer idUsuario);
}
