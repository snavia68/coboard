package com.coboard.utilities;

import java.math.BigInteger;
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
import com.coboard.modelo.control.IVotosLogic;
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
	@Autowired
	private IInformacionLogic informacionLogic;
	@Autowired
	private IVotosLogic votosLogic;
	
	private List<Proyecto> losProyectos;
	private List<Informacion> variablesPorProyecto;

	private Date date;
	
	private Long porcentajeAceptacion;
	private Long cantidadUsuariosEnElProyecto;
	private Long cantidadUsuariosAFavor;
	private Long cantidadAComparar;
	private Integer filtroActual;
	private Integer filtroActualProyecto;
	
	private static final Logger log = LoggerFactory.getLogger(Schedule.class);
	
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
			cantidadUsuariosEnElProyecto = proyectoLogic.cantidadUsuariosPorProyecto(proyecto);
			cantidadAComparar = cantidadUsuariosEnElProyecto * (porcentajeAceptacion/100);
			variablesPorProyecto = informacionLogic.listarVariablesProyecto(proyecto);
			for(Informacion informacion : variablesPorProyecto) {
				cantidadUsuariosAFavor = votosLogic.cantidadVotosPorEstado("Acuerdo",informacion);
				filtroActual = informacion.getFiltro();
				filtroActualProyecto = proyecto.getFiltro();
				if((cantidadUsuariosAFavor >= cantidadAComparar) && filtroActual <= 3) {
					informacion.setFiltro(filtroActual+1);
					proyecto.setFiltro(filtroActualProyecto+1);
					proyectoLogic.updateProyecto(proyecto);
					informacionLogic.updateInformacion(informacion);
					log.info("La variable " + informacion.getDescripcion() + " cambió de filtro.");
					log.info("El proyecto " + proyecto.getNombre() + " cambió de filtro.");
				}
			}
		}
	}
}
