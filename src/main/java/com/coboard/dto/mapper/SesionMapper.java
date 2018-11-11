package com.coboard.dto.mapper;

import com.coboard.modelo.*;
import com.coboard.modelo.Sesion;
import com.coboard.modelo.control.*;
import com.coboard.modelo.dto.SesionDTO;

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
public class SesionMapper implements ISesionMapper {
    private static final Logger log = LoggerFactory.getLogger(SesionMapper.class);

    /**
    * Logic injected by Spring that manages Proyectousuario entities
    *
    */
    @Autowired
    IProyectousuarioLogic logicProyectousuario1;

    @Transactional(readOnly = true)
    public SesionDTO sesionToSesionDTO(Sesion sesion) throws Exception {
        try {
            SesionDTO sesionDTO = new SesionDTO();

            sesionDTO.setIdsesion(sesion.getIdsesion());
            sesionDTO.setFechacreacion(sesion.getFechacreacion());
            sesionDTO.setFechamodificacion(sesion.getFechamodificacion());
            sesionDTO.setFechasesion(sesion.getFechasesion());
            sesionDTO.setHorafin(sesion.getHorafin());
            sesionDTO.setHorasesion(sesion.getHorasesion());
            sesionDTO.setUsuariocreador((sesion.getUsuariocreador() != null)
                ? sesion.getUsuariocreador() : null);
            sesionDTO.setUsuariomodificador((sesion.getUsuariomodificador() != null)
                ? sesion.getUsuariomodificador() : null);
            sesionDTO.setIdproyectousuario_Proyectousuario((sesion.getProyectousuario()
                                                                  .getIdproyectousuario() != null)
                ? sesion.getProyectousuario().getIdproyectousuario() : null);

            return sesionDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Sesion sesionDTOToSesion(SesionDTO sesionDTO)
        throws Exception {
        try {
            Sesion sesion = new Sesion();

            sesion.setIdsesion(sesionDTO.getIdsesion());
            sesion.setFechacreacion(sesionDTO.getFechacreacion());
            sesion.setFechamodificacion(sesionDTO.getFechamodificacion());
            sesion.setFechasesion(sesionDTO.getFechasesion());
            sesion.setHorafin(sesionDTO.getHorafin());
            sesion.setHorasesion(sesionDTO.getHorasesion());
            sesion.setUsuariocreador((sesionDTO.getUsuariocreador() != null)
                ? sesionDTO.getUsuariocreador() : null);
            sesion.setUsuariomodificador((sesionDTO.getUsuariomodificador() != null)
                ? sesionDTO.getUsuariomodificador() : null);

            Proyectousuario proyectousuario = new Proyectousuario();

            if (sesionDTO.getIdproyectousuario_Proyectousuario() != null) {
                proyectousuario = logicProyectousuario1.getProyectousuario(sesionDTO.getIdproyectousuario_Proyectousuario());
            }

            if (proyectousuario != null) {
                sesion.setProyectousuario(proyectousuario);
            }

            return sesion;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<SesionDTO> listSesionToListSesionDTO(List<Sesion> listSesion)
        throws Exception {
        try {
            List<SesionDTO> sesionDTOs = new ArrayList<SesionDTO>();

            for (Sesion sesion : listSesion) {
                SesionDTO sesionDTO = sesionToSesionDTO(sesion);

                sesionDTOs.add(sesionDTO);
            }

            return sesionDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Sesion> listSesionDTOToListSesion(List<SesionDTO> listSesionDTO)
        throws Exception {
        try {
            List<Sesion> listSesion = new ArrayList<Sesion>();

            for (SesionDTO sesionDTO : listSesionDTO) {
                Sesion sesion = sesionDTOToSesion(sesionDTO);

                listSesion.add(sesion);
            }

            return listSesion;
        } catch (Exception e) {
            throw e;
        }
    }
}
