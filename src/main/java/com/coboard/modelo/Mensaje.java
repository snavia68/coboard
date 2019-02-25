package com.coboard.modelo;
import org.hibernate.validator.constraints.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "mensaje", schema = "public")
public class Mensaje implements java.io.Serializable{

	private Integer idmensaje;
	
	@NotNull
    private Integer idproyecto;
	
    @NotNull
    private Integer idusuario;
    
    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String usuario;
    
    @NotNull
    @NotEmpty
    @Size(max = 300)
    private String mensaje;
    
    private Date hora;
    
    private Date fecha;

    public Mensaje() {
    }
    
	public Mensaje(Integer idmensaje, Integer idproyecto, Integer idusuario, String usuario, String mensaje, Date hora, Date fecha) {
		
		this.idmensaje = idmensaje;
		this.idproyecto = idproyecto;
		this.idusuario = idusuario;
		this.usuario = usuario;
		this.mensaje = mensaje;
		this.fecha = fecha;
		this.hora = hora;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idmensaje", unique = true, nullable = false)
	public Integer getIdmensaje() {
		return idmensaje;
	}

	public void setIdmensaje(Integer idinformacion) {
		this.idmensaje = idinformacion;
	}

	@Column(name = "idproyecto", nullable = false)
	public Integer getIdproyecto() {
		return idproyecto;
	}

	public void setIdproyecto(Integer idproyecto) {
		this.idproyecto = idproyecto;
	}

	@Column(name = "idusuario", nullable = false)
	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	@Column(name = "mensaje", nullable = false)
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Column(name = "fecha", nullable = false)
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "usuario", nullable = false)
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Column(name = "hora", nullable = false)
	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}
	
}
