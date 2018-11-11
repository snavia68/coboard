package com.coboard.dto.mapper;

import com.coboard.modelo.Adjuntos;
import com.coboard.modelo.dto.AdjuntosDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IAdjuntosMapper {
    public AdjuntosDTO adjuntosToAdjuntosDTO(Adjuntos adjuntos)
        throws Exception;

    public Adjuntos adjuntosDTOToAdjuntos(AdjuntosDTO adjuntosDTO)
        throws Exception;

    public List<AdjuntosDTO> listAdjuntosToListAdjuntosDTO(
        List<Adjuntos> adjuntoss) throws Exception;

    public List<Adjuntos> listAdjuntosDTOToListAdjuntos(
        List<AdjuntosDTO> adjuntosDTOs) throws Exception;
}
