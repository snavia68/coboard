package com.coboard.dto.mapper;

import com.coboard.modelo.*;
import com.coboard.modelo.Adjuntos;
import com.coboard.modelo.control.*;
import com.coboard.modelo.dto.AdjuntosDTO;

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
public class AdjuntosMapper implements IAdjuntosMapper {
    private static final Logger log = LoggerFactory.getLogger(AdjuntosMapper.class);

    /**
    * Logic injected by Spring that manages Informacion entities
    *
    */
    @Autowired
    IInformacionLogic logicInformacion1;

    @Transactional(readOnly = true)
    public AdjuntosDTO adjuntosToAdjuntosDTO(Adjuntos adjuntos)
        throws Exception {
        try {
            AdjuntosDTO adjuntosDTO = new AdjuntosDTO();

            adjuntosDTO.setIdadjuntos(adjuntos.getIdadjuntos());
            adjuntosDTO.setFechacreacion(adjuntos.getFechacreacion());
            adjuntosDTO.setFechamodificacion(adjuntos.getFechamodificacion());
            adjuntosDTO.setUrl((adjuntos.getUrl() != null) ? adjuntos.getUrl()
                                                           : null);
            adjuntosDTO.setUsuariocreador((adjuntos.getUsuariocreador() != null)
                ? adjuntos.getUsuariocreador() : null);
            adjuntosDTO.setUsuariomodificador((adjuntos.getUsuariomodificador() != null)
                ? adjuntos.getUsuariomodificador() : null);

            if (adjuntos.getInformacion() != null) {
                adjuntosDTO.setIdinformacion_Informacion(adjuntos.getInformacion()
                                                                 .getIdinformacion());
            } else {
                adjuntosDTO.setIdinformacion_Informacion(null);
            }

            return adjuntosDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Adjuntos adjuntosDTOToAdjuntos(AdjuntosDTO adjuntosDTO)
        throws Exception {
        try {
            Adjuntos adjuntos = new Adjuntos();

            adjuntos.setIdadjuntos(adjuntosDTO.getIdadjuntos());
            adjuntos.setFechacreacion(adjuntosDTO.getFechacreacion());
            adjuntos.setFechamodificacion(adjuntosDTO.getFechamodificacion());
            adjuntos.setUrl((adjuntosDTO.getUrl() != null)
                ? adjuntosDTO.getUrl() : null);
            adjuntos.setUsuariocreador((adjuntosDTO.getUsuariocreador() != null)
                ? adjuntosDTO.getUsuariocreador() : null);
            adjuntos.setUsuariomodificador((adjuntosDTO.getUsuariomodificador() != null)
                ? adjuntosDTO.getUsuariomodificador() : null);

            Informacion informacion = new Informacion();

            if (adjuntosDTO.getIdinformacion_Informacion() != null) {
                informacion = logicInformacion1.getInformacion(adjuntosDTO.getIdinformacion_Informacion());
            }

            if (informacion != null) {
                adjuntos.setInformacion(informacion);
            }

            return adjuntos;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<AdjuntosDTO> listAdjuntosToListAdjuntosDTO(
        List<Adjuntos> listAdjuntos) throws Exception {
        try {
            List<AdjuntosDTO> adjuntosDTOs = new ArrayList<AdjuntosDTO>();

            for (Adjuntos adjuntos : listAdjuntos) {
                AdjuntosDTO adjuntosDTO = adjuntosToAdjuntosDTO(adjuntos);

                adjuntosDTOs.add(adjuntosDTO);
            }

            return adjuntosDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Adjuntos> listAdjuntosDTOToListAdjuntos(
        List<AdjuntosDTO> listAdjuntosDTO) throws Exception {
        try {
            List<Adjuntos> listAdjuntos = new ArrayList<Adjuntos>();

            for (AdjuntosDTO adjuntosDTO : listAdjuntosDTO) {
                Adjuntos adjuntos = adjuntosDTOToAdjuntos(adjuntosDTO);

                listAdjuntos.add(adjuntos);
            }

            return listAdjuntos;
        } catch (Exception e) {
            throw e;
        }
    }
}
