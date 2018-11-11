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
@Table(name = "informacion", schema = "public")
public class Informacion implements java.io.Serializable {
    
    private Integer idinformacion;
    @NotNull
    private Proyecto proyecto;
    @NotNull
    private char activo;
    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String descripcion;
    @NotNull
    private Date fechacreacion;
    private Date fechamodificacion;
    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String usuariocreador;
    private String usuariomodificador;
    private Integer filtro;
    private Set<Adjuntos> adjuntoses = new HashSet<Adjuntos>(0);
    private Set<Votos> votoses = new HashSet<Votos>(0);

    public Informacion() {
    }

    public Informacion(Integer idinformacion, char activo,
        Set<Adjuntos> adjuntoses, String descripcion, Date fechacreacion,
        Date fechamodificacion, Proyecto proyecto, String usuariocreador,
        String usuariomodificador, Set<Votos> votoses) {
        this.idinformacion = idinformacion;
        this.proyecto = proyecto;
        this.activo = activo;
        this.descripcion = descripcion;
        this.fechacreacion = fechacreacion;
        this.fechamodificacion = fechamodificacion;
        this.usuariocreador = usuariocreador;
        this.usuariomodificador = usuariomodificador;
        this.adjuntoses = adjuntoses;
        this.votoses = votoses;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idinformacion", unique = true, nullable = false)
    public Integer getIdinformacion() {
        return this.idinformacion;
    }

    public void setIdinformacion(Integer idinformacion) {
        this.idinformacion = idinformacion;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idproyecto")
    public Proyecto getProyecto() {
        return this.proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "informacion")
    public Set<Adjuntos> getAdjuntoses() {
        return this.adjuntoses;
    }

    public void setAdjuntoses(Set<Adjuntos> adjuntoses) {
        this.adjuntoses = adjuntoses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "informacion")
    public Set<Votos> getVotoses() {
        return this.votoses;
    }

    public void setVotoses(Set<Votos> votoses) {
        this.votoses = votoses;
    }
    
    @Column(name = "filtro")
	public Integer getFiltro() {
		return filtro;
	}

	public void setFiltro(Integer filtro) {
		this.filtro = filtro;
	}
}
