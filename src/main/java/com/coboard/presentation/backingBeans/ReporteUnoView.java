package com.coboard.presentation.backingBeans;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
public class ReporteUnoView {
	

	private List<Proyecto> losProyectos;
	private List<SelectItem> losProyectosSelectItem;
	private SelectOneMenu somProyectos;
	private boolean descargas=true;
	private List<VotosDTO> losvotos;
	private String proyecto;
	
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

	public List<Proyecto> getLosProyectos() {
		return losProyectos;
	}

	public void setLosProyectos(List<Proyecto> losProyectos) {
		this.losProyectos = losProyectos;
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public SelectOneMenu getSomProyectos() {
		return somProyectos;
	}

	public void setSomProyectos(SelectOneMenu somProyectos) {
		this.somProyectos = somProyectos;
	}

	public List<SelectItem> getLosProyectosSelectItem() throws Exception  {
		if (losProyectosSelectItem == null) {
			Usuario usu=(Usuario)FacesUtils.getfromSession("usuario");
			List<Proyecto> losProyectos = businessDelegatorView.proyectosPorUsuario(usu.getIdusuario());
			losProyectosSelectItem = new ArrayList<>();
			for (Proyecto proyecto : losProyectos) {
				losProyectosSelectItem.add(
						new SelectItem(proyecto.getIdproyecto(),proyecto.getNombre()));
			}
		}
		return losProyectosSelectItem;
	}

	public void setLosProyectosSelectItem(List<SelectItem> losProyectosSelectItem) {
		this.losProyectosSelectItem = losProyectosSelectItem;
	}

	public boolean isDescargas() {
		return descargas;
	}

	public void setDescargas(boolean descargas) {
		this.descargas = descargas;
	}

	public List<VotosDTO> getLosvotos() {
		return losvotos;
	}

	public void setLosvotos(List<VotosDTO> losvotos) {
		this.losvotos = losvotos;
	}
	
	public String misVotos() throws NumberFormatException, Exception {
		Proyecto proy=businessDelegatorView.getProyecto(Integer.parseInt(somProyectos.getValue().toString()));
		Usuario usu=(Usuario)FacesUtils.getfromSession("usuario");
		losvotos=businessDelegatorView.votosDeUsuarioPorProyecto(proy, usu);
		proyecto=proy.getNombre();
		descargas=false;
		return "";
	}
    
	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	
	public void exportarPDF() throws JRException, IOException{
			File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/Jasperhp.jasper"));
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(),null, new JRBeanCollectionDataSource(this.getLosvotos()));
			
			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			response.addHeader("Content-disposition","attachment; filename=votosUsuario.pdf");
			ServletOutputStream stream = response.getOutputStream();
			
			JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
			stream.flush();
			stream.close();
			
			FacesContext.getCurrentInstance().responseComplete();			
		}
	
	public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);
 
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String logo = externalContext.getRealPath("") + File.separator + "images" + File.separator + "logocb.png";
         
        pdf.add(Image.getInstance(logo));
        pdf.addTitle(proyecto);
    }
}