package com.coboard.dto.mapper;

import com.coboard.modelo.*;
import com.coboard.modelo.Votos;
import com.coboard.modelo.control.*;
import com.coboard.modelo.dto.VotosDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class VotosMapper implements IVotosMapper {
    private static final Logger log = LoggerFactory.getLogger(VotosMapper.class);

    /**
    * Logic injected by Spring that manages Informacion entities
    *
    */
    @Autowired
    IInformacionLogic logicInformacion1;

    /**
    * Logic injected by Spring that manages Sesion entities
    *
    */
    @Autowired
    ISesionLogic logicSesion2;

    @Transactional(readOnly = true)
    public VotosDTO votosToVotosDTO(Votos votos) throws Exception {
        try {
            VotosDTO votosDTO = new VotosDTO();

            votosDTO.setIdvoto(votos.getIdvoto());
            votosDTO.setActivo((votos.getActivo() != null) ? votos.getActivo()
                                                           : null);
            votosDTO.setFechacreacion(votos.getFechacreacion());
            votosDTO.setFechamodificacion(votos.getFechamodificacion());
            votosDTO.setUsuariocreador((votos.getUsuariocreador() != null)
                ? votos.getUsuariocreador() : null);
            votosDTO.setUsuariomodificador((votos.getUsuariomodificador() != null)
                ? votos.getUsuariomodificador() : null);
            votosDTO.setVoto((votos.getVoto() != null) ? votos.getVoto() : null);

            if (votos.getInformacion() != null) {
                votosDTO.setIdinformacion_Informacion(votos.getInformacion()
                                                           .getIdinformacion());
            } else {
                votosDTO.setIdinformacion_Informacion(null);
            }

            if (votos.getSesion() != null) {
                votosDTO.setIdsesion_Sesion(votos.getSesion().getIdsesion());
            } else {
                votosDTO.setIdsesion_Sesion(null);
            }

            return votosDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Votos votosDTOToVotos(VotosDTO votosDTO) throws Exception {
        try {
            Votos votos = new Votos();

            votos.setIdvoto(votosDTO.getIdvoto());
            votos.setActivo((votosDTO.getActivo() != null)
                ? votosDTO.getActivo() : null);
            votos.setFechacreacion(votosDTO.getFechacreacion());
            votos.setFechamodificacion(votosDTO.getFechamodificacion());
            votos.setUsuariocreador((votosDTO.getUsuariocreador() != null)
                ? votosDTO.getUsuariocreador() : null);
            votos.setUsuariomodificador((votosDTO.getUsuariomodificador() != null)
                ? votosDTO.getUsuariomodificador() : null);
            votos.setVoto((votosDTO.getVoto() != null) ? votosDTO.getVoto() : null);

            Informacion informacion = new Informacion();

            if (votosDTO.getIdinformacion_Informacion() != null) {
                informacion = logicInformacion1.getInformacion(votosDTO.getIdinformacion_Informacion());
            }

            if (informacion != null) {
                votos.setInformacion(informacion);
            }

            Sesion sesion = new Sesion();

            if (votosDTO.getIdsesion_Sesion() != null) {
                sesion = logicSesion2.getSesion(votosDTO.getIdsesion_Sesion());
            }

            if (sesion != null) {
                votos.setSesion(sesion);
            }

            return votos;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<VotosDTO> listVotosToListVotosDTO(List<Votos> listVotos)
        throws Exception {
        try {
            List<VotosDTO> votosDTOs = new ArrayList<VotosDTO>();

            for (Votos votos : listVotos) {
                VotosDTO votosDTO = votosToVotosDTO(votos);

                votosDTOs.add(votosDTO);
            }

            return votosDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Votos> listVotosDTOToListVotos(List<VotosDTO> listVotosDTO)
        throws Exception {
        try {
            List<Votos> listVotos = new ArrayList<Votos>();

            for (VotosDTO votosDTO : listVotosDTO) {
                Votos votos = votosDTOToVotos(votosDTO);

                listVotos.add(votos);
            }

            return listVotos;
        } catch (Exception e) {
            throw e;
        }
    }
}
