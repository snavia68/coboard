package com.coboard.dto.mapper;

import com.coboard.modelo.Sesion;
import com.coboard.modelo.dto.SesionDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ISesionMapper {
    public SesionDTO sesionToSesionDTO(Sesion sesion) throws Exception;

    public Sesion sesionDTOToSesion(SesionDTO sesionDTO)
        throws Exception;

    public List<SesionDTO> listSesionToListSesionDTO(List<Sesion> sesions)
        throws Exception;

    public List<Sesion> listSesionDTOToListSesion(List<SesionDTO> sesionDTOs)
        throws Exception;
}
