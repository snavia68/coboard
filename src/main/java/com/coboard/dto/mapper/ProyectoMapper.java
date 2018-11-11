package com.coboard.dto.mapper;

import com.coboard.modelo.*;
import com.coboard.modelo.Proyecto;
import com.coboard.modelo.control.*;
import com.coboard.modelo.dto.ProyectoDTO;

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
public class ProyectoMapper implements IProyectoMapper {

    /**
    * Logic injected by Spring that manages Tipoproyecto entities
    *
    */
    @Autowired
    ITipoproyectoLogic logicTipoproyecto1;

    @Transactional(readOnly = true)
    public ProyectoDTO proyectoToProyectoDTO(Proyecto proyecto)
        throws Exception {
        try {
            ProyectoDTO proyectoDTO = new ProyectoDTO();

            proyectoDTO.setIdproyecto(proyecto.getIdproyecto());
            proyectoDTO.setActivo((proyecto.getActivo() != ' ')
                ? proyecto.getActivo() : null);
            proyectoDTO.setDescripcion((proyecto.getDescripcion() != null)
                ? proyecto.getDescripcion() : null);
            proyectoDTO.setFechacreacion(proyecto.getFechacreacion());
            proyectoDTO.setFechafin(proyecto.getFechafin());
            proyectoDTO.setFechainicio(proyecto.getFechainicio());
            proyectoDTO.setFechamodificacion(proyecto.getFechamodificacion());
            proyectoDTO.setMinimopreguntas((proyecto.getMinimopreguntas() != null)
                ? proyecto.getMinimopreguntas() : null);
            proyectoDTO.setNombre((proyecto.getNombre() != null)
                ? proyecto.getNombre() : null);
            proyectoDTO.setPorcentajefiltro((proyecto.getPorcentajefiltro() != null)
                ? proyecto.getPorcentajefiltro() : null);
            proyectoDTO.setUsuariocreador((proyecto.getUsuariocreador() != null)
                ? proyecto.getUsuariocreador() : null);
            proyectoDTO.setUsuariomodificador((proyecto.getUsuariomodificador() != null)
                ? proyecto.getUsuariomodificador() : null);

            if (proyecto.getTipoproyecto() != null) {
                proyectoDTO.setIdtipoproyecto_Tipoproyecto(proyecto.getTipoproyecto()
                                                                   .getIdtipoproyecto());
            } else {
                proyectoDTO.setIdtipoproyecto_Tipoproyecto(null);
            }

            return proyectoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Proyecto proyectoDTOToProyecto(ProyectoDTO proyectoDTO)
        throws Exception {
        try {
            Proyecto proyecto = new Proyecto();

            proyecto.setIdproyecto(proyectoDTO.getIdproyecto());
            proyecto.setActivo((proyectoDTO.getActivo() != ' ')
                ? proyectoDTO.getActivo() : null);
            proyecto.setDescripcion((proyectoDTO.getDescripcion() != null)
                ? proyectoDTO.getDescripcion() : null);
            proyecto.setFechacreacion(proyectoDTO.getFechacreacion());
            proyecto.setFechafin(proyectoDTO.getFechafin());
            proyecto.setFechainicio(proyectoDTO.getFechainicio());
            proyecto.setFechamodificacion(proyectoDTO.getFechamodificacion());
            proyecto.setMinimopreguntas((proyectoDTO.getMinimopreguntas() != null)
                ? proyectoDTO.getMinimopreguntas() : null);
            proyecto.setNombre((proyectoDTO.getNombre() != null)
                ? proyectoDTO.getNombre() : null);
            proyecto.setPorcentajefiltro((proyectoDTO.getPorcentajefiltro() != null)
                ? proyectoDTO.getPorcentajefiltro() : null);
            proyecto.setUsuariocreador((proyectoDTO.getUsuariocreador() != null)
                ? proyectoDTO.getUsuariocreador() : null);
            proyecto.setUsuariomodificador((proyectoDTO.getUsuariomodificador() != null)
                ? proyectoDTO.getUsuariomodificador() : null);

            Tipoproyecto tipoproyecto = new Tipoproyecto();

            if (proyectoDTO.getIdtipoproyecto_Tipoproyecto() != null) {
                tipoproyecto = logicTipoproyecto1.getTipoproyecto(proyectoDTO.getIdtipoproyecto_Tipoproyecto());
            }

            if (tipoproyecto != null) {
                proyecto.setTipoproyecto(tipoproyecto);
            }

            return proyecto;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ProyectoDTO> listProyectoToListProyectoDTO(
        List<Proyecto> listProyecto) throws Exception {
        try {
            List<ProyectoDTO> proyectoDTOs = new ArrayList<ProyectoDTO>();

            for (Proyecto proyecto : listProyecto) {
                ProyectoDTO proyectoDTO = proyectoToProyectoDTO(proyecto);

                proyectoDTOs.add(proyectoDTO);
            }

            return proyectoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Proyecto> listProyectoDTOToListProyecto(
        List<ProyectoDTO> listProyectoDTO) throws Exception {
        try {
            List<Proyecto> listProyecto = new ArrayList<Proyecto>();

            for (ProyectoDTO proyectoDTO : listProyectoDTO) {
                Proyecto proyecto = proyectoDTOToProyecto(proyectoDTO);

                listProyecto.add(proyecto);
            }

            return listProyecto;
        } catch (Exception e) {
            throw e;
        }
    }
}
