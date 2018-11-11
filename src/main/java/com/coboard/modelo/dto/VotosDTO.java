package com.coboard.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class VotosDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(VotosDTO.class);
    private String activo;
    private Date fechacreacion;
    private Date fechamodificacion;
    private Integer idvoto;
    private String usuariocreador;
    private String usuariomodificador;
    private String voto;
    private Integer idinformacion_Informacion;
    private Integer idsesion_Sesion;
    private String descripcionInformacion;
    private String nombresUsuarios;
    private String votosRealizados;
    private List<String[]> listaVotosUsuarios;

    public VotosDTO(String descripcionInformacion, String nombresUsuarios, String votosRealizados) {
		super();
		this.descripcionInformacion = descripcionInformacion;
		this.nombresUsuarios = nombresUsuarios;
		this.votosRealizados = votosRealizados;
		
		listaVotosUsuarios = new ArrayList<String[]>();
		
		String[] usuariosSplit = nombresUsuarios.split(",");
		String[] votosSplit = votosRealizados.split(",");
		
		for (int i = 0; i < usuariosSplit.length; i++) {
			String[] llave = {usuariosSplit[i], votosSplit[i]};
			
			listaVotosUsuarios.add(llave);
		}
		
		
	}
    
    public VotosDTO(String descripcionInformacion, String votosRealizados) {
		super();
		this.descripcionInformacion = descripcionInformacion;
		this.votosRealizados = votosRealizados;
			
		
	}

    
	public VotosDTO() {
		super();
	}


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

    public Integer getIdvoto() {
        return idvoto;
    }

    public void setIdvoto(Integer idvoto) {
        this.idvoto = idvoto;
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

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }

    public Integer getIdinformacion_Informacion() {
        return idinformacion_Informacion;
    }

    public void setIdinformacion_Informacion(Integer idinformacion_Informacion) {
        this.idinformacion_Informacion = idinformacion_Informacion;
    }

    public Integer getIdsesion_Sesion() {
        return idsesion_Sesion;
    }

    public void setIdsesion_Sesion(Integer idsesion_Sesion) {
        this.idsesion_Sesion = idsesion_Sesion;
    }

	public String getDescripcionInformacion() {
		return descripcionInformacion;
	}

	public void setDescripcionInformacion(String descripcionInformacion) {
		this.descripcionInformacion = descripcionInformacion;
	}

	public String getNombresUsuarios() {
		return nombresUsuarios;
	}

	public void setNombresUsuarios(String nombresUsuarios) {
		this.nombresUsuarios = nombresUsuarios;
	}

	public String getVotosRealizados() {
		return votosRealizados;
	}

	public void setVotosRealizados(String votosRealizados) {
		this.votosRealizados = votosRealizados;
	}

	public List<String[]> getListaVotosUsuarios() {
		return listaVotosUsuarios;
	}


	public void setListaVotosUsuarios(List<String[]> listaVotosUsuarios) {
		this.listaVotosUsuarios = listaVotosUsuarios;
	}
    
    
}
