package com.coboard.dto.mapper;

import com.coboard.modelo.Tipousuario;
import com.coboard.modelo.dto.TipousuarioDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ITipousuarioMapper {
    public TipousuarioDTO tipousuarioToTipousuarioDTO(Tipousuario tipousuario)
        throws Exception;

    public Tipousuario tipousuarioDTOToTipousuario(
        TipousuarioDTO tipousuarioDTO) throws Exception;

    public List<TipousuarioDTO> listTipousuarioToListTipousuarioDTO(
        List<Tipousuario> tipousuarios) throws Exception;

    public List<Tipousuario> listTipousuarioDTOToListTipousuario(
        List<TipousuarioDTO> tipousuarioDTOs) throws Exception;
}
