package com.coboard.dto.mapper;

import com.coboard.modelo.*;
import com.coboard.modelo.Informacion;
import com.coboard.modelo.control.*;
import com.coboard.modelo.dto.InformacionDTO;

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
public class InformacionMapper implements IInformacionMapper {
    private static final Logger log = LoggerFactory.getLogger(InformacionMapper.class);

    /**
    * Logic injected by Spring that manages Proyecto entities
    *
    */
    @Autowired
    IProyectoLogic logicProyecto1;

    @Transactional(readOnly = true)
    public InformacionDTO informacionToInformacionDTO(Informacion informacion)
        throws Exception {
        try {
            InformacionDTO informacionDTO = new InformacionDTO();

            informacionDTO.setIdinformacion(informacion.getIdinformacion());
            informacionDTO.setActivo((informacion.getActivo() != ' ')
                ? informacion.getActivo() : null);
            informacionDTO.setDescripcion((informacion.getDescripcion() != null)
                ? informacion.getDescripcion() : null);
            informacionDTO.setFechacreacion(informacion.getFechacreacion());
            informacionDTO.setFechamodificacion(informacion.getFechamodificacion());
            informacionDTO.setUsuariocreador((informacion.getUsuariocreador() != null)
                ? informacion.getUsuariocreador() : null);
            informacionDTO.setUsuariomodificador((informacion.getUsuariomodificador() != null)
                ? informacion.getUsuariomodificador() : null);

            if (informacion.getProyecto() != null) {
                informacionDTO.setIdproyecto_Proyecto(informacion.getProyecto()
                                                                 .getIdproyecto());
            } else {
                informacionDTO.setIdproyecto_Proyecto(null);
            }

            return informacionDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Informacion informacionDTOToInformacion(
        InformacionDTO informacionDTO) throws Exception {
        try {
            Informacion informacion = new Informacion();

            informacion.setIdinformacion(informacionDTO.getIdinformacion());
            informacion.setActivo((informacionDTO.getActivo() != ' ')
                ? informacionDTO.getActivo() : null);
            informacion.setDescripcion((informacionDTO.getDescripcion() != null)
                ? informacionDTO.getDescripcion() : null);
            informacion.setFechacreacion(informacionDTO.getFechacreacion());
            informacion.setFechamodificacion(informacionDTO.getFechamodificacion());
            informacion.setUsuariocreador((informacionDTO.getUsuariocreador() != null)
                ? informacionDTO.getUsuariocreador() : null);
            informacion.setUsuariomodificador((informacionDTO.getUsuariomodificador() != null)
                ? informacionDTO.getUsuariomodificador() : null);

            Proyecto proyecto = new Proyecto();

            if (informacionDTO.getIdproyecto_Proyecto() != null) {
                proyecto = logicProyecto1.getProyecto(informacionDTO.getIdproyecto_Proyecto());
            }

            if (proyecto != null) {
                informacion.setProyecto(proyecto);
            }

            return informacion;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<InformacionDTO> listInformacionToListInformacionDTO(
        List<Informacion> listInformacion) throws Exception {
        try {
            List<InformacionDTO> informacionDTOs = new ArrayList<InformacionDTO>();

            for (Informacion informacion : listInformacion) {
                InformacionDTO informacionDTO = informacionToInformacionDTO(informacion);

                informacionDTOs.add(informacionDTO);
            }

            return informacionDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Informacion> listInformacionDTOToListInformacion(
        List<InformacionDTO> listInformacionDTO) throws Exception {
        try {
            List<Informacion> listInformacion = new ArrayList<Informacion>();

            for (InformacionDTO informacionDTO : listInformacionDTO) {
                Informacion informacion = informacionDTOToInformacion(informacionDTO);

                listInformacion.add(informacion);
            }

            return listInformacion;
        } catch (Exception e) {
            throw e;
        }
    }
}
