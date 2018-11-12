package com.coboard.utilities;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.coboard.modelo.Informacion;
import com.coboard.modelo.Proyecto;
import com.coboard.modelo.control.IInformacionLogic;
import com.coboard.modelo.control.IProyectoLogic;
import com.coboard.presentation.businessDelegate.BusinessDelegatorView;
import com.coboard.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@EnableScheduling
@Configuration
@Service("Schedule")
public class Schedule {
	
	@Autowired
	private IProyectoLogic proyectoLogic;
	private IInformacionLogic informacionLogic;
	
	private List<Proyecto> losProyectos;
	private List<Informacion> variablesPorProyecto;
	//private static final Logger log = LoggerFactory.
	private Date date;
	
	private Long porcentajeAceptacion;
	private Integer cantidadUsuariosEnElProyecto;
	private Integer cantidadUsuariosAFavor;
	private Integer cantidadVotosAFavor;
	private Integer cantidadAComparar;
	private Integer filtroActual;
	
	private static final Logger log = LoggerFactory.getLogger(Schedule.class);
	
	private IBusinessDelegatorView businessDelegatorView;
	
	public void proyectosVencidos() throws Exception{
		date = new Date();
		
		losProyectos = proyectoLogic.getProyecto();
		
		for (Proyecto proyecto : losProyectos) {
			if (proyecto.getFechafin().equals(date) == true || proyecto.getFechafin().before(date)) {
				proyecto.setActivo('N');
				proyectoLogic.updateProyecto(proyecto);
				log.info("El proyecto "+proyecto.getNombre()+" ha expirado");
			}
		}
	}
	
	public void filtroVariables() throws Exception{
		losProyectos = proyectoLogic.getProyecto();
		for (Proyecto proyecto : losProyectos) {
			porcentajeAceptacion = proyecto.getPorcentajefiltro();
			cantidadUsuariosEnElProyecto = businessDelegatorView.cantidadUsuariosPorProyecto(proyecto);
			cantidadAComparar = (int) (cantidadUsuariosEnElProyecto * (porcentajeAceptacion/100));
			variablesPorProyecto = businessDelegatorView.listarVariablesProyecto(proyecto);
			for(Informacion informacion : variablesPorProyecto) {
				cantidadUsuariosAFavor = businessDelegatorView.cantidadVotosPorEstado("Acuerdo",informacion);
				filtroActual = informacion.getFiltro();
				if(cantidadUsuariosAFavor >= cantidadAComparar && filtroActual < 3) {
					informacion.setFiltro(filtroActual+1);
					businessDelegatorView.updateInformacion(informacion);
					log.info("la variable " + informacion.getDescripcion() + " cambió de filtro.");
				}
			}
		}
	}
}
