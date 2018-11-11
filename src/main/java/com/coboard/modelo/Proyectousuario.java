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
@Table(name = "proyectousuario", schema = "public")
public class Proyectousuario implements java.io.Serializable {
    
    private Integer idproyectousuario;
    @NotNull
    private Proyecto proyecto;
    @NotNull
    private Usuario usuario;
    @NotNull
    private Date fechacreacion;
    private Date fechamodificacion;
    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String usuariocreador;
    private String usuariomodificador;
    private Set<Sesion> sesions = new HashSet<Sesion>(0);

    public Proyectousuario() {
    }

    public Proyectousuario(Integer idproyectousuario, Date fechacreacion,
        Date fechamodificacion, Proyecto proyecto, Set<Sesion> sesions,
        Usuario usuario, String usuariocreador, String usuariomodificador) {
        this.idproyectousuario = idproyectousuario;
        this.proyecto = proyecto;
        this.usuario = usuario;
        this.fechacreacion = fechacreacion;
        this.fechamodificacion = fechamodificacion;
        this.usuariocreador = usuariocreador;
        this.usuariomodificador = usuariomodificador;
        this.sesions = sesions;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idproyectousuario", unique = true, nullable = false)
    public Integer getIdproyectousuario() {
        return this.idproyectousuario;
    }

    public void setIdproyectousuario(Integer idproyectousuario) {
        this.idproyectousuario = idproyectousuario;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idproyecto")
    public Proyecto getProyecto() {
        return this.proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idusuario")
    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "proyectousuario")
    public Set<Sesion> getSesions() {
        return this.sesions;
    }

    public void setSesions(Set<Sesion> sesions) {
        this.sesions = sesions;
    }
}
