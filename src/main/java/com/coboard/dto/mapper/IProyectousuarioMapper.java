package com.coboard.dto.mapper;

import com.coboard.modelo.Proyectousuario;
import com.coboard.modelo.dto.ProyectousuarioDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IProyectousuarioMapper {
    public ProyectousuarioDTO proyectousuarioToProyectousuarioDTO(
        Proyectousuario proyectousuario) throws Exception;

    public Proyectousuario proyectousuarioDTOToProyectousuario(
        ProyectousuarioDTO proyectousuarioDTO) throws Exception;

    public List<ProyectousuarioDTO> listProyectousuarioToListProyectousuarioDTO(
        List<Proyectousuario> proyectousuarios) throws Exception;

    public List<Proyectousuario> listProyectousuarioDTOToListProyectousuario(
        List<ProyectousuarioDTO> proyectousuarioDTOs) throws Exception;
}
