package com.coboard.presentation.backingBeans;

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
import org.primefaces.component.selectonemenu.SelectOneMenu;
import com.coboard.modelo.Proyecto;
import com.coboard.modelo.Usuario;
import com.coboard.modelo.dto.VotosDTO;
import com.coboard.presentation.businessDelegate.IBusinessDelegatorView;
import com.coboard.utilities.FacesUtils;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;

@ManagedBean
@ViewScoped
public class ListadoProyectosView {
	private List<Proyecto> losProyectos;
	private List<SelectItem> losProyectosSelectItem;
	private SelectOneMenu somProyectos;
	private boolean descargas=true;
	private String proyecto;
	
	private List<VotosDTO> losVotos;
    private List<String> losUsuarios;
	
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
			List<Proyecto> losProyectos = businessDelegatorView.getProyecto();
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

	public List<VotosDTO> getLosVotos() {
		return losVotos;
	}

	public void setLosVotos(List<VotosDTO> losVotos) {
		this.losVotos = losVotos;
	}

	public List<String> getLosUsuarios() {
		return losUsuarios;
	}

	public void setLosUsuarios(List<String> losUsuarios) {
		this.losUsuarios = losUsuarios;
	}
	
	public String misVotos() throws NumberFormatException, Exception {
		Proyecto proy=businessDelegatorView.getProyecto(Integer.parseInt(somProyectos.getValue().toString()));
		losUsuarios = businessDelegatorView.nombresUsuarios(proy);
		losVotos=businessDelegatorView.votosDeUsuarios(proy);
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
