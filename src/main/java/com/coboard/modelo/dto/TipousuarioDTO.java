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
public class TipousuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipousuarioDTO.class);
    private String activo;
    private Date fechacreacion;
    private Date fechamodificacion;
    private Integer idtipousuario;
    private String nombre;
    private String usuariocreador;
    private String usuariomodificador;

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

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

    public Integer getIdtipousuario() {
        return idtipousuario;
    }

    public void setIdtipousuario(Integer idtipousuario) {
        this.idtipousuario = idtipousuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
}
