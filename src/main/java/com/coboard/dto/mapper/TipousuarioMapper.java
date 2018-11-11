package com.coboard.dto.mapper;

import com.coboard.modelo.*;
import com.coboard.modelo.Tipousuario;
import com.coboard.modelo.control.*;
import com.coboard.modelo.dto.TipousuarioDTO;

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
public class TipousuarioMapper implements ITipousuarioMapper {
    private static final Logger log = LoggerFactory.getLogger(TipousuarioMapper.class);

    @Transactional(readOnly = true)
    public TipousuarioDTO tipousuarioToTipousuarioDTO(Tipousuario tipousuario)
        throws Exception {
        try {
            TipousuarioDTO tipousuarioDTO = new TipousuarioDTO();

            tipousuarioDTO.setIdtipousuario(tipousuario.getIdtipousuario());
            tipousuarioDTO.setActivo((tipousuario.getActivo() != null)
                ? tipousuario.getActivo() : null);
            tipousuarioDTO.setFechacreacion(tipousuario.getFechacreacion());
            tipousuarioDTO.setFechamodificacion(tipousuario.getFechamodificacion());
            tipousuarioDTO.setNombre((tipousuario.getNombre() != null)
                ? tipousuario.getNombre() : null);
            tipousuarioDTO.setUsuariocreador((tipousuario.getUsuariocreador() != null)
                ? tipousuario.getUsuariocreador() : null);
            tipousuarioDTO.setUsuariomodificador((tipousuario.getUsuariomodificador() != null)
                ? tipousuario.getUsuariomodificador() : null);

            return tipousuarioDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Tipousuario tipousuarioDTOToTipousuario(
        TipousuarioDTO tipousuarioDTO) throws Exception {
        try {
            Tipousuario tipousuario = new Tipousuario();

            tipousuario.setIdtipousuario(tipousuarioDTO.getIdtipousuario());
            tipousuario.setActivo((tipousuarioDTO.getActivo() != null)
                ? tipousuarioDTO.getActivo() : null);
            tipousuario.setFechacreacion(tipousuarioDTO.getFechacreacion());
            tipousuario.setFechamodificacion(tipousuarioDTO.getFechamodificacion());
            tipousuario.setNombre((tipousuarioDTO.getNombre() != null)
                ? tipousuarioDTO.getNombre() : null);
            tipousuario.setUsuariocreador((tipousuarioDTO.getUsuariocreador() != null)
                ? tipousuarioDTO.getUsuariocreador() : null);
            tipousuario.setUsuariomodificador((tipousuarioDTO.getUsuariomodificador() != null)
                ? tipousuarioDTO.getUsuariomodificador() : null);

            return tipousuario;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TipousuarioDTO> listTipousuarioToListTipousuarioDTO(
        List<Tipousuario> listTipousuario) throws Exception {
        try {
            List<TipousuarioDTO> tipousuarioDTOs = new ArrayList<TipousuarioDTO>();

            for (Tipousuario tipousuario : listTipousuario) {
                TipousuarioDTO tipousuarioDTO = tipousuarioToTipousuarioDTO(tipousuario);

                tipousuarioDTOs.add(tipousuarioDTO);
            }

            return tipousuarioDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Tipousuario> listTipousuarioDTOToListTipousuario(
        List<TipousuarioDTO> listTipousuarioDTO) throws Exception {
        try {
            List<Tipousuario> listTipousuario = new ArrayList<Tipousuario>();

            for (TipousuarioDTO tipousuarioDTO : listTipousuarioDTO) {
                Tipousuario tipousuario = tipousuarioDTOToTipousuario(tipousuarioDTO);

                listTipousuario.add(tipousuario);
            }

            return listTipousuario;
        } catch (Exception e) {
            throw e;
        }
    }
}
