package com.coboard.dto.mapper;

import com.coboard.modelo.*;
import com.coboard.modelo.Usuario;
import com.coboard.modelo.control.*;
import com.coboard.modelo.dto.UsuarioDTO;

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
public class UsuarioMapper implements IUsuarioMapper {
    private static final Logger log = LoggerFactory.getLogger(UsuarioMapper.class);

    /**
    * Logic injected by Spring that manages Cargo entities
    *
    */
    @Autowired
    ICargoLogic logicCargo1;

    /**
    * Logic injected by Spring that manages Tipousuario entities
    *
    */
    @Autowired
    ITipousuarioLogic logicTipousuario2;

    @Transactional(readOnly = true)
    public UsuarioDTO usuarioToUsuarioDTO(Usuario usuario)
        throws Exception {
        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO();

            usuarioDTO.setIdusuario(usuario.getIdusuario());
            usuarioDTO.setActivo((usuario.getActivo() != null)
                ? usuario.getActivo() : null);
            usuarioDTO.setContrasena((usuario.getContrasena() != null)
                ? usuario.getContrasena() : null);
            usuarioDTO.setCorreo((usuario.getCorreo() != null)
                ? usuario.getCorreo() : null);
            usuarioDTO.setFechacreacion(usuario.getFechacreacion());
            usuarioDTO.setFechamodificacion(usuario.getFechamodificacion());
            usuarioDTO.setNombre((usuario.getNombre() != null)
                ? usuario.getNombre() : null);
            usuarioDTO.setUsuariocreador((usuario.getUsuariocreador() != null)
                ? usuario.getUsuariocreador() : null);
            usuarioDTO.setUsuariomodificador((usuario.getUsuariomodificador() != null)
                ? usuario.getUsuariomodificador() : null);

            if (usuario.getCargo() != null) {
                usuarioDTO.setIdcargo_Cargo(usuario.getCargo().getIdcargo());
                Cargo cargo = logicCargo1.getCargo(usuario.getCargo().getIdcargo());
                usuarioDTO.setNombreCargo(cargo.getNombre());
            } else {
                usuarioDTO.setIdcargo_Cargo(null);
                usuarioDTO.setNombreCargo(null);
            }

            if (usuario.getTipousuario() != null) {
                usuarioDTO.setIdtipousuario_Tipousuario(usuario.getTipousuario()
                                                               .getIdtipousuario());
            } else {
                usuarioDTO.setIdtipousuario_Tipousuario(null);
            }

            return usuarioDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO)
        throws Exception {
        try {
            Usuario usuario = new Usuario();

            usuario.setIdusuario(usuarioDTO.getIdusuario());
            usuario.setActivo((usuarioDTO.getActivo() != null)
                ? usuarioDTO.getActivo() : null);
            usuario.setContrasena((usuarioDTO.getContrasena() != null)
                ? usuarioDTO.getContrasena() : null);
            usuario.setCorreo((usuarioDTO.getCorreo() != null)
                ? usuarioDTO.getCorreo() : null);
            usuario.setFechacreacion(usuarioDTO.getFechacreacion());
            usuario.setFechamodificacion(usuarioDTO.getFechamodificacion());
            usuario.setNombre((usuarioDTO.getNombre() != null)
                ? usuarioDTO.getNombre() : null);
            usuario.setUsuariocreador((usuarioDTO.getUsuariocreador() != null)
                ? usuarioDTO.getUsuariocreador() : null);
            usuario.setUsuariomodificador((usuarioDTO.getUsuariomodificador() != null)
                ? usuarioDTO.getUsuariomodificador() : null);

            Cargo cargo = new Cargo();

            if (usuarioDTO.getIdcargo_Cargo() != null) {
                cargo = logicCargo1.getCargo(usuarioDTO.getIdcargo_Cargo());
            }

            if (cargo != null) {
                usuario.setCargo(cargo);
            }

            Tipousuario tipousuario = new Tipousuario();

            if (usuarioDTO.getIdtipousuario_Tipousuario() != null) {
                tipousuario = logicTipousuario2.getTipousuario(usuarioDTO.getIdtipousuario_Tipousuario());
            }

            if (tipousuario != null) {
                usuario.setTipousuario(tipousuario);
            }

            return usuario;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<UsuarioDTO> listUsuarioToListUsuarioDTO(
        List<Usuario> listUsuario) throws Exception {
        try {
            List<UsuarioDTO> usuarioDTOs = new ArrayList<UsuarioDTO>();

            for (Usuario usuario : listUsuario) {
                UsuarioDTO usuarioDTO = usuarioToUsuarioDTO(usuario);

                usuarioDTOs.add(usuarioDTO);
            }

            return usuarioDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Usuario> listUsuarioDTOToListUsuario(
        List<UsuarioDTO> listUsuarioDTO) throws Exception {
        try {
            List<Usuario> listUsuario = new ArrayList<Usuario>();

            for (UsuarioDTO usuarioDTO : listUsuarioDTO) {
                Usuario usuario = usuarioDTOToUsuario(usuarioDTO);

                listUsuario.add(usuario);
            }

            return listUsuario;
        } catch (Exception e) {
            throw e;
        }
    }
}
