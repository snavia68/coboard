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
    private String descripcioninformacion;
    private String descripcion;
    private String nombresusuarios;
    private String votosrealizados;
    private List<String[]> listaVotosUsuarios;

    public VotosDTO(String descripcioninformacion, String nombresusuarios, String votosrealizados) {
		super();
		this.descripcioninformacion = descripcioninformacion;
		this.nombresusuarios = nombresusuarios;
		this.votosrealizados = votosrealizados;
		
		listaVotosUsuarios = new ArrayList<String[]>();
		
		String[] usuariosSplit = nombresusuarios.split(",");
		String[] votosSplit = votosrealizados.split(",");
		
		for (int i = 0; i < usuariosSplit.length; i++) {
			String[] llave = {usuariosSplit[i], votosSplit[i]};
			
			listaVotosUsuarios.add(llave);
		}
		
		
	}
    
    public VotosDTO(String descripcioninformacion, String votosrealizados) {
		super();
		this.descripcion = descripcioninformacion;
		this.voto = votosrealizados;
			
		
	}

    
	public VotosDTO() {
		super();
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public String getdescripcioninformacion() {
		return descripcioninformacion;
	}

	public void setdescripcioninformacion(String descripcioninformacion) {
		this.descripcioninformacion = descripcioninformacion;
	}

	public String getnombresusuarios() {
		return nombresusuarios;
	}

	public void setnombresusuarios(String nombresusuarios) {
		this.nombresusuarios = nombresusuarios;
	}

	public String getvotosrealizados() {
		return votosrealizados;
	}

	public void setvotosrealizados(String votosrealizados) {
		this.votosrealizados = votosrealizados;
	}

	public List<String[]> getListaVotosUsuarios() {
		return listaVotosUsuarios;
	}


	public void setListaVotosUsuarios(List<String[]> listaVotosUsuarios) {
		this.listaVotosUsuarios = listaVotosUsuarios;
	}
    
    
}
