package com.coboard.presentation.backingBeans;


import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.joda.time.DateTime;
import org.springframework.security.authentication.AuthenticationManager;

import com.coboard.modelo.Proyecto;
import com.coboard.modelo.Proyectousuario;
import com.coboard.modelo.Sesion;
import com.coboard.modelo.Tipousuario;
import com.coboard.modelo.Usuario;
import com.coboard.presentation.businessDelegate.IBusinessDelegatorView;
import com.coboard.utilities.FacesUtils;

@ViewScoped
@ManagedBean(name = "inicioView")
public class InicioView {
	private List<Proyecto> losProyectos;
	private Proyecto proyectoAVotar;
	
	private String usuario;
    @ManagedProperty(value = "#{authenticationManager}")
    private AuthenticationManager authenticationManager = null;
    
    @ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
    
	public String getUsuario() {
		Usuario usu=(Usuario)FacesUtils.getfromSession("usuario");
		usuario=usu.getNombre();
		
		
		return usuario;
	}
	
	 public String checkForSesion() throws Exception{
	    	
	    	if (FacesUtils.getfromSession("sesion")!=null) {
	    		DateTime now = DateTime.now();
				Date date = now.toDate();
				
				Usuario usuario = (Usuario)FacesUtils.getfromSession("usuario");
				
				Sesion sesion = (Sesion)FacesUtils.getfromSession("sesion");
				sesion.setFechamodificacion(new Date());
				sesion.setUsuariomodificador(usuario.getNombre());
				sesion.setHorafin(date);
				
				businessDelegatorView.updateSesion(sesion);
				
				FacesUtils.putinSession("sesion", sesion);
			}
	    	
	    	return "";
	    }
	    
	
	public void setUsuario(String userId) {
		this.usuario = userId;
	}
	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	  
	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}
	
	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}
	
	public Proyecto getProyectoAVotar() {
		return proyectoAVotar;
	}

	public void setProyectoAVotar(Proyecto proyectoAVotar) {
		this.proyectoAVotar = proyectoAVotar;
	}
	
	public String logOut() {
    	return "/coboard/index.xhtml";
    }
	
	public String changeContra() {
    	return "/XHTML/contraUsuario.xhtml";
    }
	
	public String proyectos() {
    	return "/XHTML/inicioUsuario.xhtml";
    }
	
public String votarProyecto() throws Exception {
		
		if (FacesUtils.getfromSession("sesion")==null) {
			
			FacesUtils.putinSession("proyecto", proyectoAVotar);
			
			Usuario usuario = (Usuario)FacesUtils.getfromSession("usuario");
			Proyecto proyecto = (Proyecto)FacesUtils.getfromSession("proyecto");
			Proyectousuario proyectousuario = businessDelegatorView.buscarPorUsuario(usuario.getIdusuario(), proyecto.getIdproyecto());
			
			DateTime now = DateTime.now();
			Date date = now.toDate();
			
			Sesion sesion = new Sesion();
			sesion.setProyectousuario(proyectousuario);
			sesion.setFechasesion(new Date());
			sesion.setHorasesion(date);
			sesion.setFechacreacion(new Date());
			sesion.setUsuariocreador(usuario.getNombre());
			
			businessDelegatorView.saveSesion(sesion);
			
			FacesUtils.putinSession("sesion", sesion);
		} else if (FacesUtils.getfromSession("sesion")!=null) {
			DateTime now = DateTime.now();
			Date date = now.toDate();
			
			Usuario usuario = (Usuario)FacesUtils.getfromSession("usuario");
			
			Sesion sesion = (Sesion)FacesUtils.getfromSession("sesion");
			sesion.setFechamodificacion(new Date());
			sesion.setUsuariomodificador(usuario.getNombre());
			sesion.setHorafin(date);
			
			businessDelegatorView.updateSesion(sesion);
			
			FacesUtils.putinSession("sesion", null);
			
			votarProyecto();
		}
		return "/gestionVotosInfo.xhtml";
	}
	
	private void cerrarSesion() throws Exception {
		DateTime now = DateTime.now();
		Date date = now.toDate();
		
		Usuario usuario = (Usuario)FacesUtils.getfromSession("usuario");
		
		Sesion sesion = (Sesion)FacesUtils.getfromSession("sesion");
		sesion.setFechamodificacion(new Date());
		sesion.setUsuariomodificador(usuario.getNombre());
		sesion.setFechasesionfin(new Date());
		sesion.setHorafin(date);
		
		businessDelegatorView.updateSesion(sesion);
		
		FacesUtils.putinSession("sesion", null);
	}
	
	public String cerrarSesionMisProyectos() throws Exception {
		if(FacesUtils.getfromSession("sesion") != null) {
			cerrarSesion();
		}
		return "/XHTML/inicioUsuario.xhtml";
	}
	
	public String cerrarSesionMisReportes() throws Exception {
		if(FacesUtils.getfromSession("sesion") != null) {
			cerrarSesion();
		}
		return "/reportesVistaUno.xhtml";
	}
	
	public String cerrarSesionCambioContra() throws Exception {
		if(FacesUtils.getfromSession("sesion") != null) {
			cerrarSesion();
		}
		return "/XHTML/contraUsuario.xhtml";
	}
	
	public String cerrarSesionLogOut() throws Exception {
		if(FacesUtils.getfromSession("sesion") != null) {
			cerrarSesion();
		}
		return "/index.xhtml";
	}

	public List<Proyecto> getLosProyectos() {
		if(losProyectos == null){
			Usuario usu=(Usuario)FacesUtils.getfromSession("usuario");
			losProyectos = businessDelegatorView.proyectosPorUsuario(usu.getIdusuario());
		}
		return losProyectos;
	}
	public void setLosProyectos(List<Proyecto> losProyectos) {
		this.losProyectos = losProyectos;
	}
}
