package com.coboard.modelo;

import org.hibernate.validator.constraints.*;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "votos", schema = "public")
public class Votos implements java.io.Serializable {
    
    private Integer idvoto;
    @NotNull
    private Informacion informacion;
    @NotNull
    private Sesion sesion;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotNull
    private Date fechacreacion;
    private Date fechamodificacion;
    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String usuariocreador;
    private String usuariomodificador;
    @NotNull
    @NotEmpty
    @Size(max = 10)
    private String voto;
    //@NotNull
    //@NotEmpty
    @Size(max = 10)
    private String votoanterior;

    public Votos() {
    }

    public Votos(Integer idvoto, String activo, Date fechacreacion,
        Date fechamodificacion, Informacion informacion, Sesion sesion,
        String usuariocreador, String usuariomodificador, String voto) {
        this.idvoto = idvoto;
        this.informacion = informacion;
        this.sesion = sesion;
        this.activo = activo;
        this.fechacreacion = fechacreacion;
        this.fechamodificacion = fechamodificacion;
        this.usuariocreador = usuariocreador;
        this.usuariomodificador = usuariomodificador;
        this.voto = voto;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idvoto", unique = true, nullable = false)
    public Integer getIdvoto() {
        return this.idvoto;
    }

    public void setIdvoto(Integer idvoto) {
        this.idvoto = idvoto;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idinformacion")
    public Informacion getInformacion() {
        return this.informacion;
    }

    public void setInformacion(Informacion informacion) {
        this.informacion = informacion;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idsesion")
    public Sesion getSesion() {
        return this.sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    @Column(name = "activo", nullable = false)
    public String getActivo() {
        return this.activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    @Column(name = "fechacreacion", nullable = false)
    public Date getFechacreacion() {
        return this.fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    @Column(name = "fechamodificacion")
    public Date getFechamodificacion() {
        return this.fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    @Column(name = "usuariocreador", nullable = false)
    public String getUsuariocreador() {
        return this.usuariocreador;
    }

    public void setUsuariocreador(String usuariocreador) {
        this.usuariocreador = usuariocreador;
    }

    @Column(name = "usuariomodificador")
    public String getUsuariomodificador() {
        return this.usuariomodificador;
    }

    public void setUsuariomodificador(String usuariomodificador) {
        this.usuariomodificador = usuariomodificador;
    }

    @Column(name = "voto", nullable = false)
    public String getVoto() {
        return this.voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }
    
    @Column(name = "votoanterior")
	public String getVotoanterior() {
		return this.votoanterior;
	}

	public void setVotoanterior(String votoanterior) {
		this.votoanterior = votoanterior;
	}
    
}
