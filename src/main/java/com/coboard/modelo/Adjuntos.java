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
@Table(name = "adjuntos", schema = "public")
public class Adjuntos implements java.io.Serializable {
    
    private Integer idadjuntos;
    @NotNull
    private Informacion informacion;
    @NotNull
    private Date fechacreacion;
    private Date fechamodificacion;
    @NotNull
    @NotEmpty
    @Size(max = 300)
    private String url;
    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String usuariocreador;
    private String usuariomodificador;

    public Adjuntos() {
    }

    public Adjuntos(Integer idadjuntos, Date fechacreacion,
        Date fechamodificacion, Informacion informacion, String url,
        String usuariocreador, String usuariomodificador) {
        this.idadjuntos = idadjuntos;
        this.informacion = informacion;
        this.fechacreacion = fechacreacion;
        this.fechamodificacion = fechamodificacion;
        this.url = url;
        this.usuariocreador = usuariocreador;
        this.usuariomodificador = usuariomodificador;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idadjuntos", unique = true, nullable = false)
    public Integer getIdadjuntos() {
        return this.idadjuntos;
    }

    public void setIdadjuntos(Integer idadjuntos) {
        this.idadjuntos = idadjuntos;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idinformacion")
    public Informacion getInformacion() {
        return this.informacion;
    }

    public void setInformacion(Informacion informacion) {
        this.informacion = informacion;
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

    @Column(name = "url", nullable = false)
    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
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
}
