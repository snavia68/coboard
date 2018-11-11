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
public class InformacionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(InformacionDTO.class);
    private char activo;
    private String descripcion;
    private Date fechacreacion;
    private Date fechamodificacion;
    private Integer idinformacion;
    private String usuariocreador;
    private String usuariomodificador;
    private Integer idproyecto_Proyecto;

    public char getActivo() {
        return activo;
    }

    public void setActivo(char activo) {
        this.activo = activo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Integer getIdinformacion() {
        return idinformacion;
    }

    public void setIdinformacion(Integer idinformacion) {
        this.idinformacion = idinformacion;
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
}
