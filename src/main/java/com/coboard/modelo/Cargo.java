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
@Table(name = "cargo", schema = "public")
public class Cargo implements java.io.Serializable {
    
    private Integer idcargo;
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
    private String nombre;
    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String usuariocreador;
    private String usuariomodificador;
    private Set<Usuario> usuarios = new HashSet<Usuario>(0);

    public Cargo() {
    }

    public Cargo(Integer idcargo, String activo, Date fechacreacion,
        Date fechamodificacion, String nombre, String usuariocreador,
        String usuariomodificador, Set<Usuario> usuarios) {
        this.idcargo = idcargo;
        this.activo = activo;
        this.fechacreacion = fechacreacion;
        this.fechamodificacion = fechamodificacion;
        this.nombre = nombre;
        this.usuariocreador = usuariocreador;
        this.usuariomodificador = usuariomodificador;
        this.usuarios = usuarios;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idcargo", unique = true, nullable = false)
    public Integer getIdcargo() {
        return this.idcargo;
    }

    public void setIdcargo(Integer idcargo) {
        this.idcargo = idcargo;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cargo")
    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
