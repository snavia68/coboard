package com.coboard.dto.mapper;

import com.coboard.modelo.Votos;
import com.coboard.modelo.dto.VotosDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IVotosMapper {
    public VotosDTO votosToVotosDTO(Votos votos) throws Exception;

    public Votos votosDTOToVotos(VotosDTO votosDTO) throws Exception;

    public List<VotosDTO> listVotosToListVotosDTO(List<Votos> votoss)
        throws Exception;

    public List<Votos> listVotosDTOToListVotos(List<VotosDTO> votosDTOs)
        throws Exception;
}
