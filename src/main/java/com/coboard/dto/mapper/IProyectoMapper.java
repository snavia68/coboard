package com.coboard.dto.mapper;

import com.coboard.modelo.Proyecto;
import com.coboard.modelo.dto.ProyectoDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IProyectoMapper {
    public ProyectoDTO proyectoToProyectoDTO(Proyecto proyecto)
        throws Exception;

    public Proyecto proyectoDTOToProyecto(ProyectoDTO proyectoDTO)
        throws Exception;

    public List<ProyectoDTO> listProyectoToListProyectoDTO(
        List<Proyecto> proyectos) throws Exception;

    public List<Proyecto> listProyectoDTOToListProyecto(
        List<ProyectoDTO> proyectoDTOs) throws Exception;
}
