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
public class AdjuntosDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(AdjuntosDTO.class);
    private Date fechacreacion;
    private Date fechamodificacion;
    private Integer idadjuntos;
    private String url;
    private String usuariocreador;
    private String usuariomodificador;
    private Integer idinformacion_Informacion;

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

    public Integer getIdadjuntos() {
        return idadjuntos;
    }

    public void setIdadjuntos(Integer idadjuntos) {
        this.idadjuntos = idadjuntos;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Integer getIdinformacion_Informacion() {
        return idinformacion_Informacion;
    }

    public void setIdinformacion_Informacion(Integer idinformacion_Informacion) {
        this.idinformacion_Informacion = idinformacion_Informacion;
    }
}
