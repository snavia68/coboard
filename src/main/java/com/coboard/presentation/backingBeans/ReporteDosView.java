package com.coboard.presentation.backingBeans;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.component.selectonemenu.SelectOneMenu;

import com.coboard.modelo.Proyecto;
import com.coboard.modelo.Sesion;
import com.coboard.modelo.Usuario;
import com.coboard.modelo.Votos;
import com.coboard.modelo.dto.VotosDTO;
import com.coboard.presentation.businessDelegate.IBusinessDelegatorView;
import com.coboard.utilities.FacesUtils;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean
@ViewScoped
public class ReporteDosView {
	
	private List<Sesion> lasSesiones;
	private Date fechaInicio;
	private Date fechaFin;
	private boolean descargas=true;
	
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

	
	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public boolean isDescargas() {
		return descargas;
	}

	public void setDescargas(boolean descargas) {
		this.descargas = descargas;
	}

	
	public List<Sesion> getLasSesiones() {
		return lasSesiones;
	}

	public void setLasSesiones(List<Sesion> lasSesiones) {
		this.lasSesiones = lasSesiones;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public void buscarSesiones(){
		lasSesiones=businessDelegatorView.sesionesEntreFechas(fechaInicio, fechaFin);
		descargas=false;
	}
	
	public void exportarPDF() throws JRException, IOException{
			File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/JasperSesiones.jasper"));
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(),null, new JRBeanCollectionDataSource(this.getLasSesiones()));
			
			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			response.addHeader("Content-disposition","attachment; filename=reporteSesiones.pdf");
			ServletOutputStream stream = response.getOutputStream();
			
			JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
			stream.flush();
			stream.close();
			
			FacesContext.getCurrentInstance().responseComplete();			
		}
	
	
}