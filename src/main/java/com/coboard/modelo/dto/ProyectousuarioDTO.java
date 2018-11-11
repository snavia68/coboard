package com.coboard.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class ProyectousuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ProyectousuarioDTO.class);
    private Date fechacreacion;
    private Date fechamodificacion;
    private Integer idproyectousuario;
    private String usuariocreador;
    private String usuariomodificador;
    private Integer idproyecto_Proyecto;
    private Integer idusuario_Usuario;

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public Integer getIdproyectousuario() {
        return idproyectousuario;
    }

    public void setIdproyectousuario(Integer idproyectousuario) {
        this.idproyectousuario = idproyectousuario;
    }

    public String getUsuariocreador() {
        return usuariocreador;
    }

    public void setUsuariocreador(String usuariocreador) {
        this.usuariocreador = usuariocreador;
    }

    public String getUsuariomodificador() {
        return usuariomodificador;
    }

    public void setUsuariomodificador(String usuariomodificador) {
        this.usuariomodificador = usuariomodificador;
    }

    public Integer getIdproyecto_Proyecto() {
        return idproyecto_Proyecto;
    }

    public void setIdproyecto_Proyecto(Integer idproyecto_Proyecto) {
        this.idproyecto_Proyecto = idproyecto_Proyecto;
    }

    public Integer getIdusuario_Usuario() {
        return idusuario_Usuario;
    }

    public void setIdusuario_Usuario(Integer idusuario_Usuario) {
        this.idusuario_Usuario = idusuario_Usuario;
    }
}
