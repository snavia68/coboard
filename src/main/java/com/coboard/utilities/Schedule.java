package com.coboard.utilities;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.coboard.modelo.Proyecto;
import com.coboard.modelo.control.IProyectoLogic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@EnableScheduling
@Configuration
@Service("Schedule")
public class Schedule {
	
	@Autowired
	private IProyectoLogic proyectoLogic;
	
	private List<Proyecto> losProyectos;
	//private static final Logger log = LoggerFactory.
	private Date date;
	
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
}
