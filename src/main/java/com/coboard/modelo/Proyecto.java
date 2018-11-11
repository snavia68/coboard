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
@Table(name = "proyecto", schema = "public")
public class Proyecto implements java.io.Serializable {
    
    private Integer idproyecto;
    @NotNull
    private Tipoproyecto tipoproyecto;
    @NotNull
    private char activo;
    @NotNull
    @NotEmpty
    @Size(max = 250)
    private String descripcion;
    @NotNull
    private Date fechacreacion;
    @NotNull
    private Date fechafin;
    @NotNull
    private Date fechainicio;
    private Date fechamodificacion;
    @NotNull
    private Long minimopreguntas;
    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String nombre;
    @NotNull
    private Long porcentajefiltro;
    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String usuariocreador;
    private String usuariomodificador;
    private Integer filtro;
    
    private Set<Informacion> informacions = new HashSet<Informacion>(0);
    private Set<Proyectousuario> proyectousuarios = new HashSet<Proyectousuario>(0);

    public Proyecto() {
    }

    public Proyecto(Integer idproyecto, char activo, String descripcion,
        Date fechacreacion, Date fechafin, Date fechainicio,
        Date fechamodificacion, Set<Informacion> informacions,
        Long minimopreguntas, String nombre, Long porcentajefiltro,
        Set<Proyectousuario> proyectousuarios, Tipoproyecto tipoproyecto,
        String usuariocreador, String usuariomodificador) {
        this.idproyecto = idproyecto;
        this.tipoproyecto = tipoproyecto;
        this.activo = activo;
        this.descripcion = descripcion;
        this.fechacreacion = fechacreacion;
        this.fechafin = fechafin;
        this.fechainicio = fechainicio;
        this.fechamodificacion = fechamodificacion;
        this.minimopreguntas = minimopreguntas;
        this.nombre = nombre;
        this.porcentajefiltro = porcentajefiltro;
        this.usuariocreador = usuariocreador;
        this.usuariomodificador = usuariomodificador;
        this.informacions = informacions;
        this.proyectousuarios = proyectousuarios;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idproyecto", unique = true, nullable = false)
    public Integer getIdproyecto() {
        return this.idproyecto;
    }

    public void setIdproyecto(Integer idproyecto) {
        this.idproyecto = idproyecto;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtipoproyecto")
    public Tipoproyecto getTipoproyecto() {
        return this.tipoproyecto;
    }

    public void setTipoproyecto(Tipoproyecto tipoproyecto) {
        this.tipoproyecto = tipoproyecto;
    }

    @Column(name = "activo", nullable = false)
    public char getActivo() {
        return this.activo;
    }

    public void setActivo(char activo) {
        this.activo = activo;
    }

    @Column(name = "descripcion", nullable = false)
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "fechacreacion", nullable = false)
    public Date getFechacreacion() {
        return this.fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    @Column(name = "fechafin", nullable = false)
    public Date getFechafin() {
        return this.fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    @Column(name = "fechainicio", nullable = false)
    public Date getFechainicio() {
        return this.fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    @Column(name = "fechamodificacion")
    public Date getFechamodificacion() {
        return this.fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    @Column(name = "minimopreguntas", nullable = false)
    public Long getMinimopreguntas() {
        return this.minimopreguntas;
    }

    public void setMinimopreguntas(Long minimopreguntas) {
        this.minimopreguntas = minimopreguntas;
    }

    @Column(name = "nombre", nullable = false)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "porcentajefiltro", nullable = false)
    public Long getPorcentajefiltro() {
        return this.porcentajefiltro;
    }

    public void setPorcentajefiltro(Long porcentajefiltro) {
        this.porcentajefiltro = porcentajefiltro;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "proyecto")
    public Set<Informacion> getInformacions() {
        return this.informacions;
    }

    public void setInformacions(Set<Informacion> informacions) {
        this.informacions = informacions;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "proyecto")
    public Set<Proyectousuario> getProyectousuarios() {
        return this.proyectousuarios;
    }

    public void setProyectousuarios(Set<Proyectousuario> proyectousuarios) {
        this.proyectousuarios = proyectousuarios;
    }
    
    @Column(name = "filtro")
	public Integer getFiltro() {
		return filtro;
	}

	public void setFiltro(Integer filtro) {
		this.filtro = filtro;
	}
}
