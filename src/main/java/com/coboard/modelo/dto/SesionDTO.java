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
public class SesionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(SesionDTO.class);
    private Date fechacreacion;
    private Date fechamodificacion;
    private Date fechasesion;
    private Date horafin;
    private Date horasesion;
    private Integer idsesion;
    private String usuariocreador;
    private String usuariomodificador;
    private Integer idproyectousuario_Proyectousuario;

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

    public Date getFechasesion() {
        return fechasesion;
    }

    public void setFechasesion(Date fechasesion) {
        this.fechasesion = fechasesion;
    }

    public Date getHorafin() {
        return horafin;
    }

    public void setHorafin(Date horafin) {
        this.horafin = horafin;
    }

    public Date getHorasesion() {
        return horasesion;
    }

    public void setHorasesion(Date horasesion) {
        this.horasesion = horasesion;
    }

    public Integer getIdsesion() {
        return idsesion;
    }

    public void setIdsesion(Integer idsesion) {
        this.idsesion = idsesion;
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

    public Integer getIdproyectousuario_Proyectousuario() {
        return idproyectousuario_Proyectousuario;
    }

    public void setIdproyectousuario_Proyectousuario(
        Integer idproyectousuario_Proyectousuario) {
        this.idproyectousuario_Proyectousuario = idproyectousuario_Proyectousuario;
    }
}
