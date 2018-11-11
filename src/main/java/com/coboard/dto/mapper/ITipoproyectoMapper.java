package com.coboard.dto.mapper;

import com.coboard.modelo.Tipoproyecto;
import com.coboard.modelo.dto.TipoproyectoDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ITipoproyectoMapper {
    public TipoproyectoDTO tipoproyectoToTipoproyectoDTO(
        Tipoproyecto tipoproyecto) throws Exception;

    public Tipoproyecto tipoproyectoDTOToTipoproyecto(
        TipoproyectoDTO tipoproyectoDTO) throws Exception;

    public List<TipoproyectoDTO> listTipoproyectoToListTipoproyectoDTO(
        List<Tipoproyecto> tipoproyectos) throws Exception;

    public List<Tipoproyecto> listTipoproyectoDTOToListTipoproyecto(
        List<TipoproyectoDTO> tipoproyectoDTOs) throws Exception;
}
