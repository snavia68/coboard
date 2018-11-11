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
public class ProyectoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ProyectoDTO.class);
    private char activo;
    private String descripcion;
    private Date fechacreacion;
    private Date fechafin;
    private Date fechainicio;
    private Date fechamodificacion;
    private Integer idproyecto;
    private Long minimopreguntas;
    private String nombre;
    private Long porcentajefiltro;
    private String usuariocreador;
    private String usuariomodificador;
    private Integer idtipoproyecto_Tipoproyecto;

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

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public Integer getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(Integer idproyecto) {
        this.idproyecto = idproyecto;
    }

    public Long getMinimopreguntas() {
        return minimopreguntas;
    }

    public void setMinimopreguntas(Long minimopreguntas) {
        this.minimopreguntas = minimopreguntas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getPorcentajefiltro() {
        return porcentajefiltro;
    }

    public void setPorcentajefiltro(Long porcentajefiltro) {
        this.porcentajefiltro = porcentajefiltro;
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

    public Integer getIdtipoproyecto_Tipoproyecto() {
        return idtipoproyecto_Tipoproyecto;
    }

    public void setIdtipoproyecto_Tipoproyecto(
        Integer idtipoproyecto_Tipoproyecto) {
        this.idtipoproyecto_Tipoproyecto = idtipoproyecto_Tipoproyecto;
    }
}
