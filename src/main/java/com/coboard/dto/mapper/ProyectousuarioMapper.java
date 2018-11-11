package com.coboard.dto.mapper;

import com.coboard.modelo.*;
import com.coboard.modelo.Proyectousuario;
import com.coboard.modelo.control.*;
import com.coboard.modelo.dto.ProyectousuarioDTO;

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
public class ProyectousuarioMapper implements IProyectousuarioMapper {
    private static final Logger log = LoggerFactory.getLogger(ProyectousuarioMapper.class);

    /**
    * Logic injected by Spring that manages Proyecto entities
    *
    */
    @Autowired
    IProyectoLogic logicProyecto1;

    /**
    * Logic injected by Spring that manages Usuario entities
    *
    */
    @Autowired
    IUsuarioLogic logicUsuario2;

    @Transactional(readOnly = true)
    public ProyectousuarioDTO proyectousuarioToProyectousuarioDTO(
        Proyectousuario proyectousuario) throws Exception {
        try {
            ProyectousuarioDTO proyectousuarioDTO = new ProyectousuarioDTO();

            proyectousuarioDTO.setIdproyectousuario(proyectousuario.getIdproyectousuario());
            proyectousuarioDTO.setFechacreacion(proyectousuario.getFechacreacion());
            proyectousuarioDTO.setFechamodificacion(proyectousuario.getFechamodificacion());
            proyectousuarioDTO.setUsuariocreador((proyectousuario.getUsuariocreador() != null)
                ? proyectousuario.getUsuariocreador() : null);
            proyectousuarioDTO.setUsuariomodificador((proyectousuario.getUsuariomodificador() != null)
                ? proyectousuario.getUsuariomodificador() : null);

            if (proyectousuario.getProyecto() != null) {
                proyectousuarioDTO.setIdproyecto_Proyecto(proyectousuario.getProyecto()
                                                                         .getIdproyecto());
            } else {
                proyectousuarioDTO.setIdproyecto_Proyecto(null);
            }

            if (proyectousuario.getUsuario() != null) {
                proyectousuarioDTO.setIdusuario_Usuario(proyectousuario.getUsuario()
                                                                       .getIdusuario());
            } else {
                proyectousuarioDTO.setIdusuario_Usuario(null);
            }

            return proyectousuarioDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Proyectousuario proyectousuarioDTOToProyectousuario(
        ProyectousuarioDTO proyectousuarioDTO) throws Exception {
        try {
            Proyectousuario proyectousuario = new Proyectousuario();

            proyectousuario.setIdproyectousuario(proyectousuarioDTO.getIdproyectousuario());
            proyectousuario.setFechacreacion(proyectousuarioDTO.getFechacreacion());
            proyectousuario.setFechamodificacion(proyectousuarioDTO.getFechamodificacion());
            proyectousuario.setUsuariocreador((proyectousuarioDTO.getUsuariocreador() != null)
                ? proyectousuarioDTO.getUsuariocreador() : null);
            proyectousuario.setUsuariomodificador((proyectousuarioDTO.getUsuariomodificador() != null)
                ? proyectousuarioDTO.getUsuariomodificador() : null);

            Proyecto proyecto = new Proyecto();

            if (proyectousuarioDTO.getIdproyecto_Proyecto() != null) {
                proyecto = logicProyecto1.getProyecto(proyectousuarioDTO.getIdproyecto_Proyecto());
            }

            if (proyecto != null) {
                proyectousuario.setProyecto(proyecto);
            }

            Usuario usuario = new Usuario();

            if (proyectousuarioDTO.getIdusuario_Usuario() != null) {
                usuario = logicUsuario2.getUsuario(proyectousuarioDTO.getIdusuario_Usuario());
            }

            if (usuario != null) {
                proyectousuario.setUsuario(usuario);
            }

            return proyectousuario;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ProyectousuarioDTO> listProyectousuarioToListProyectousuarioDTO(
        List<Proyectousuario> listProyectousuario) throws Exception {
        try {
            List<ProyectousuarioDTO> proyectousuarioDTOs = new ArrayList<ProyectousuarioDTO>();

            for (Proyectousuario proyectousuario : listProyectousuario) {
                ProyectousuarioDTO proyectousuarioDTO = proyectousuarioToProyectousuarioDTO(proyectousuario);

                proyectousuarioDTOs.add(proyectousuarioDTO);
            }

            return proyectousuarioDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Proyectousuario> listProyectousuarioDTOToListProyectousuario(
        List<ProyectousuarioDTO> listProyectousuarioDTO)
        throws Exception {
        try {
            List<Proyectousuario> listProyectousuario = new ArrayList<Proyectousuario>();

            for (ProyectousuarioDTO proyectousuarioDTO : listProyectousuarioDTO) {
                Proyectousuario proyectousuario = proyectousuarioDTOToProyectousuario(proyectousuarioDTO);

                listProyectousuario.add(proyectousuario);
            }

            return listProyectousuario;
        } catch (Exception e) {
            throw e;
        }
    }
}
