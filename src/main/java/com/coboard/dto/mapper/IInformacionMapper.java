package com.coboard.dto.mapper;

import com.coboard.modelo.Informacion;
import com.coboard.modelo.dto.InformacionDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IInformacionMapper {
    public InformacionDTO informacionToInformacionDTO(Informacion informacion)
        throws Exception;

    public Informacion informacionDTOToInformacion(
        InformacionDTO informacionDTO) throws Exception;

    public List<InformacionDTO> listInformacionToListInformacionDTO(
        List<Informacion> informacions) throws Exception;

    public List<Informacion> listInformacionDTOToListInformacion(
        List<InformacionDTO> informacionDTOs) throws Exception;
}
