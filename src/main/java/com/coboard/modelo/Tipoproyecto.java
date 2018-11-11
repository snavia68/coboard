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
@Table(name = "tipoproyecto", schema = "public")
public class Tipoproyecto implements java.io.Serializable {
    
    private Integer idtipoproyecto;
    @NotNull
    private Date fechacreacion;
    private Date fechamodificacion;
    @NotNull
    @NotEmpty
    @Size(max = 70)
    private String nombre;
    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String usuariocreador;
    private String usuariomodificador;
    private Set<Proyecto> proyectos = new HashSet<Proyecto>(0);

    public Tipoproyecto() {
    }

    public Tipoproyecto(Integer idtipoproyecto, Date fechacreacion,
        Date fechamodificacion, String nombre, Set<Proyecto> proyectos,
        String usuariocreador, String usuariomodificador) {
        this.idtipoproyecto = idtipoproyecto;
        this.fechacreacion = fechacreacion;
        this.fechamodificacion = fechamodificacion;
        this.nombre = nombre;
        this.usuariocreador = usuariocreador;
        this.usuariomodificador = usuariomodificador;
        this.proyectos = proyectos;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idtipoproyecto", unique = true, nullable = false)
    public Integer getIdtipoproyecto() {
        return this.idtipoproyecto;
    }

    public void setIdtipoproyecto(Integer idtipoproyecto) {
        this.idtipoproyecto = idtipoproyecto;
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

    @Column(name = "nombre", nullable = false)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoproyecto")
    public Set<Proyecto> getProyectos() {
        return this.proyectos;
    }

    public void setProyectos(Set<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
}
