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
@Table(name = "sesion", schema = "public")
public class Sesion implements java.io.Serializable {
    
    private Integer idsesion;
    @NotNull
    private Proyectousuario proyectousuario;
    @NotNull
    private Date fechacreacion;
    private Date fechamodificacion;
    @NotNull
    private Date fechasesion;
    private Date fechasesionfin;
    private Date horafin;
    @NotNull
    private Date horasesion;
    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String usuariocreador;
    private String usuariomodificador;
    private Set<Votos> votoses = new HashSet<Votos>(0);

    public Sesion() {
    }

    public Sesion(Integer idsesion, Date fechacreacion, Date fechamodificacion,
        Date fechasesion, Date horafin, Date horasesion,
        Proyectousuario proyectousuario, String usuariocreador,
        String usuariomodificador, Set<Votos> votoses) {
        this.idsesion = idsesion;
        this.proyectousuario = proyectousuario;
        this.fechacreacion = fechacreacion;
        this.fechamodificacion = fechamodificacion;
        this.fechasesion = fechasesion;
        this.horafin = horafin;
        this.horasesion = horasesion;
        this.usuariocreador = usuariocreador;
        this.usuariomodificador = usuariomodificador;
        this.votoses = votoses;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idsesion", unique = true, nullable = false)
    public Integer getIdsesion() {
        return this.idsesion;
    }

    public void setIdsesion(Integer idsesion) {
        this.idsesion = idsesion;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idproyectousuario")
    public Proyectousuario getProyectousuario() {
        return this.proyectousuario;
    }

    public void setProyectousuario(Proyectousuario proyectousuario) {
        this.proyectousuario = proyectousuario;
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

    @Column(name = "fechasesion", nullable = false)
    public Date getFechasesion() {
        return this.fechasesion;
    }

    public void setFechasesion(Date fechasesion) {
        this.fechasesion = fechasesion;
    }
    
    @Column(name = "fechasesionfin")
    public Date getFechasesionfin() {
		return fechasesionfin;
	}

	public void setFechasesionfin(Date fechasesionfin) {
		this.fechasesionfin = fechasesionfin;
	}

	@Column(name = "horafin")
    public Date getHorafin() {
        return this.horafin;
    }

    public void setHorafin(Date horafin) {
        this.horafin = horafin;
    }

    @Column(name = "horasesion", nullable = false)
    public Date getHorasesion() {
        return this.horasesion;
    }

    public void setHorasesion(Date horasesion) {
        this.horasesion = horasesion;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sesion")
    public Set<Votos> getVotoses() {
        return this.votoses;
    }

    public void setVotoses(Set<Votos> votoses) {
        this.votoses = votoses;
    }
}
