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
@Table(name = "usuario", schema = "public")
public class Usuario implements java.io.Serializable {
	
    private Integer idusuario;
    @NotNull
    private Cargo cargo;
    @NotNull
    private Tipousuario tipousuario;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String activo;
    @NotNull
    @NotEmpty
    @Size(max = 20)
    private String contrasena;
    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String correo;
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
    private Set<Proyectousuario> proyectousuarios = new HashSet<Proyectousuario>(0);

    public Usuario() {
    }

    public Usuario(Integer idusuario, String activo, Cargo cargo,
        String contrasena, String correo, Date fechacreacion,
        Date fechamodificacion, String nombre,
        Set<Proyectousuario> proyectousuarios, Tipousuario tipousuario,
        String usuariocreador, String usuariomodificador) {
        this.idusuario = idusuario;
        this.cargo = cargo;
        this.tipousuario = tipousuario;
        this.activo = activo;
        this.contrasena = contrasena;
        this.correo = correo;
        this.fechacreacion = fechacreacion;
        this.fechamodificacion = fechamodificacion;
        this.nombre = nombre;
        this.usuariocreador = usuariocreador;
        this.usuariomodificador = usuariomodificador;
        this.proyectousuarios = proyectousuarios;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idusuario", unique = true, nullable = false)
    public Integer getIdusuario() {
        return this.idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcargo")
    public Cargo getCargo() {
        return this.cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtipousuario")
    public Tipousuario getTipousuario() {
        return this.tipousuario;
    }

    public void setTipousuario(Tipousuario tipousuario) {
        this.tipousuario = tipousuario;
    }

    @Column(name = "activo", nullable = false)
    public String getActivo() {
        return this.activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    @Column(name = "contrasena", nullable = false)
    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Column(name = "correo", nullable = false)
    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    public Set<Proyectousuario> getProyectousuarios() {
        return this.proyectousuarios;
    }

    public void setProyectousuarios(Set<Proyectousuario> proyectousuarios) {
        this.proyectousuarios = proyectousuarios;
    }
}