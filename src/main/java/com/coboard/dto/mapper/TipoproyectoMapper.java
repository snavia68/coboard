package com.coboard.dto.mapper;

import com.coboard.modelo.*;
import com.coboard.modelo.Tipoproyecto;
import com.coboard.modelo.control.*;
import com.coboard.modelo.dto.TipoproyectoDTO;

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
public class TipoproyectoMapper implements ITipoproyectoMapper {
    private static final Logger log = LoggerFactory.getLogger(TipoproyectoMapper.class);

    @Transactional(readOnly = true)
    public TipoproyectoDTO tipoproyectoToTipoproyectoDTO(
        Tipoproyecto tipoproyecto) throws Exception {
        try {
            TipoproyectoDTO tipoproyectoDTO = new TipoproyectoDTO();

            tipoproyectoDTO.setIdtipoproyecto(tipoproyecto.getIdtipoproyecto());
            tipoproyectoDTO.setFechacreacion(tipoproyecto.getFechacreacion());
            tipoproyectoDTO.setFechamodificacion(tipoproyecto.getFechamodificacion());
            tipoproyectoDTO.setNombre((tipoproyecto.getNombre() != null)
                ? tipoproyecto.getNombre() : null);
            tipoproyectoDTO.setUsuariocreador((tipoproyecto.getUsuariocreador() != null)
                ? tipoproyecto.getUsuariocreador() : null);
            tipoproyectoDTO.setUsuariomodificador((tipoproyecto.getUsuariomodificador() != null)
                ? tipoproyecto.getUsuariomodificador() : null);

            return tipoproyectoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Tipoproyecto tipoproyectoDTOToTipoproyecto(
        TipoproyectoDTO tipoproyectoDTO) throws Exception {
        try {
            Tipoproyecto tipoproyecto = new Tipoproyecto();

            tipoproyecto.setIdtipoproyecto(tipoproyectoDTO.getIdtipoproyecto());
            tipoproyecto.setFechacreacion(tipoproyectoDTO.getFechacreacion());
            tipoproyecto.setFechamodificacion(tipoproyectoDTO.getFechamodificacion());
            tipoproyecto.setNombre((tipoproyectoDTO.getNombre() != null)
                ? tipoproyectoDTO.getNombre() : null);
            tipoproyecto.setUsuariocreador((tipoproyectoDTO.getUsuariocreador() != null)
                ? tipoproyectoDTO.getUsuariocreador() : null);
            tipoproyecto.setUsuariomodificador((tipoproyectoDTO.getUsuariomodificador() != null)
                ? tipoproyectoDTO.getUsuariomodificador() : null);

            return tipoproyecto;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipoproyectoDTO> listTipoproyectoToListTipoproyectoDTO(
        List<Tipoproyecto> listTipoproyecto) throws Exception {
        try {
            List<TipoproyectoDTO> tipoproyectoDTOs = new ArrayList<TipoproyectoDTO>();

            for (Tipoproyecto tipoproyecto : listTipoproyecto) {
                TipoproyectoDTO tipoproyectoDTO = tipoproyectoToTipoproyectoDTO(tipoproyecto);

                tipoproyectoDTOs.add(tipoproyectoDTO);
            }

            return tipoproyectoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Tipoproyecto> listTipoproyectoDTOToListTipoproyecto(
        List<TipoproyectoDTO> listTipoproyectoDTO) throws Exception {
        try {
            List<Tipoproyecto> listTipoproyecto = new ArrayList<Tipoproyecto>();

            for (TipoproyectoDTO tipoproyectoDTO : listTipoproyectoDTO) {
                Tipoproyecto tipoproyecto = tipoproyectoDTOToTipoproyecto(tipoproyectoDTO);

                listTipoproyecto.add(tipoproyecto);
            }

            return listTipoproyecto;
        } catch (Exception e) {
            throw e;
        }
    }
}
