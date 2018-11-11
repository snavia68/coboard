package com.coboard.presentation.backingBeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.coboard.modelo.Adjuntos;
import com.coboard.modelo.Informacion;
import com.coboard.modelo.Proyecto;
import com.coboard.modelo.Usuario;
import com.coboard.modelo.dto.InformacionDTO;
import com.coboard.presentation.businessDelegate.IBusinessDelegatorView;
import com.coboard.utilities.FacesUtils;

@ManagedBean
@ViewScoped
public class VariablesView implements Serializable  {
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	
	private Informacion variableSelected;
	
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(VariablesView.class);
	
	private InputText txtDescripcion;
	
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
	
    private OutputLabel archivo;
    
    private Informacion entity;
    private InformacionDTO selectedInformacion;
    
    private List<SelectItem> losProyectosSelectItem;
    private List<Informacion> lasVariables;
    private List<Informacion> filteredVariables;
    
    private OutputLabel ruta;
    
    private UploadedFile file;
    
    private SelectOneMenu somProyectos;
    private SelectOneMenu somActivo;
    
    private Date fechaSimple;
    
    public Date getFechaSimple (){
    	return fechaSimple;
    }
    
    public String formatearFecha(){
    	return  new SimpleDateFormat("dd-MM-yyyy").format(fechaSimple);
    }
    public String limpiar(){
    	
    	somActivo.resetValue();
    	txtDescripcion.setValue(null);
    	return "";
    }
    
    
    public String nombreProyecto(Integer id){
    	try {
			return businessDelegatorView.getProyecto(id).getNombre().toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
    }
    
    public void subirFileUpload(){
    	
    	try {
    	File fileSubir = new File(file.getFileName());
    	
    	FileOutputStream fileOutput = new FileOutputStream(fileSubir);
    	fileOutput.write(file.getContents());
    	
    	Usuario usuario=(Usuario)FacesUtils.getfromSession("usuario");
    	Proyecto proyectoSes=(Proyecto)FacesUtils.getfromSession("proyecto");
    	
    	FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Se subió el archivo con éxito", "Archivo adjuntado a la variable."));

    	
    	//amazon 
    	
    	businessDelegatorView.uploadPublicRead("coboard-cloud2",proyectoSes.getNombre()+"_"+file.getFileName()+"_"+usuario.getNombre(),fileSubir);  
    	
    	log.info("URL :"+businessDelegatorView.getUrl("coboard-cloud2", file.getFileName()));
    	log.info("URL : cliente/");
    	}
    	catch (Exception e) {
			e.printStackTrace();
		}
 	}
    
    
    public void actualizarArchivo(){
    	try {
        	File fileSubir = new File(file.getFileName());
        	
        	FileOutputStream fileOutput = new FileOutputStream(fileSubir);
        	fileOutput.write(file.getContents());
        	
        	Usuario usuario=(Usuario)FacesUtils.getfromSession("usuario");
        	Proyecto proyectoSes=(Proyecto)FacesUtils.getfromSession("proyecto");
        	
        	FacesContext.getCurrentInstance().addMessage("",
    				new FacesMessage(FacesMessage.SEVERITY_INFO, "Se actualizó el archivo con éxito", "Archivo adjuntado a la variable."));

        	businessDelegatorView.uploadPublicRead("coboard-cloud2", proyectoSes.getNombre()+"_"+file.getFileName()+"_"+usuario.getNombre(),fileSubir);  
        	
        	log.info("URL :"+businessDelegatorView.getUrl("coboard-cloud2", file.getFileName()));
        	log.info("URL : cliente/");
        	}
        	catch (Exception e) {
    			e.printStackTrace();
    		}
    }
    
    public String action_create(){
    	try {
		
    		Proyecto proyectoSes=(Proyecto)FacesUtils.getfromSession("proyecto");
    		Integer num = 1;
    		Date fecha = new Date();
    		Informacion variable = new Informacion();
    		Proyecto proyecto = proyectoSes;
    		Usuario usuario=(Usuario)FacesUtils.getfromSession("usuario");
    		
    		variable.setProyecto(proyecto);
    		variable.setActivo(somActivo.getValue().toString().charAt(0));
    		variable.setDescripcion(txtDescripcion.getValue().toString()); 		
    		variable.setFechacreacion(fecha);
    		variable.setUsuariocreador(usuario.getNombre());
    		businessDelegatorView.saveInformacion(variable);
    		
    		if (!file.getFileName().equals("")) {
				
    			subirFileUpload();
    			
    			Adjuntos adjunto = new Adjuntos();
        		adjunto.setUrl(proyecto.getNombre()+"_"+file.getFileName()+"_"+usuario.getNombre());
        		adjunto.setInformacion(variable);
        		adjunto.setUsuariocreador(usuario.getNombre());
        		adjunto.setFechacreacion(fecha);
        	
        		
        		businessDelegatorView.saveAdjuntos(adjunto);
			}	
    		
    		FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha guardado la variable", "Variable creada con éxito"));
    		limpiar();
    		lasVariables=null;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
    	
    	return "";
    }
    
    public String update_variable(){
    	try {
    		Date fecha = new Date();
    		    		
    		Informacion variable = variableSelected; 
        	Proyecto proyectoSes=(Proyecto)FacesUtils.getfromSession("proyecto");
    		Usuario usuario=(Usuario)FacesUtils.getfromSession("usuario");
    		
    		variable.setActivo(somActivo.getValue().toString().charAt(0));
    		variable.setDescripcion(txtDescripcion.getValue().toString()); 		
    		variable.setFechamodificacion(fecha);
    		variable.setUsuariocreador("CoBoard");
    		   		
    		businessDelegatorView.updateInformacion(variable);

    		if (!file.getFileName().equals("")) {
				
    			businessDelegatorView.deleteObject("coboard-cloud2", ruta.getValue().toString());
    			
    			subirFileUpload();
    			
    			Adjuntos adjunto = businessDelegatorView.findAdjuntoByInformacion(variableSelected.getIdinformacion());

        		adjunto.setUrl(proyectoSes.getNombre()+"_"+file.getFileName()+"_"+usuario.getNombre());
        		adjunto.setUsuariocreador(usuario.getNombre());
        		adjunto.setFechamodificacion(fecha);
        		ruta.resetValue();
        		
        		businessDelegatorView.updateAdjuntos(adjunto);
			}	
    		
    		
    		FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha actualizado la variable", "Variable actualizada con éxito"));
    		limpiar();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));		}
    	return "";
    }
    
    public String verAction(){
    	Proyecto proyecto;
		try {
			proyecto = businessDelegatorView.getProyecto(variableSelected.getProyecto().getIdproyecto());
		
			Adjuntos adjuntos = businessDelegatorView.findAdjuntoByInformacion(variableSelected.getIdinformacion());
			
			log.info("Key de búsqueda: " + adjuntos.getUrl());
			
			InputStream fileConsulta = businessDelegatorView.download("coboard-cloud2", adjuntos.getUrl());
			
			//file.write(new FileO);
			ruta.setValue(adjuntos.getUrl());		
			
			somActivo.setValue(variableSelected.getActivo());
			txtDescripcion.setValue(variableSelected.getDescripcion());
			btnSave.setDisabled(true);
			//ruta.setValue(businessDelegatorView.getUrl("coboard-cloud", file.getFileName()));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
    	return "";
    }
    
    public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}
	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}
	
	public List<SelectItem> getLosProyectosSelectItem() throws Exception{
		if (losProyectosSelectItem == null) {
			List<Proyecto> losProyectos = businessDelegatorView.getProyecto();
			losProyectosSelectItem = new ArrayList<>();
			for (Proyecto proyecto : losProyectos) {
				losProyectosSelectItem.add(
						new SelectItem(proyecto.getIdproyecto(), proyecto.getIdproyecto()+ " ) " + proyecto.getNombre()));
			}
		}
		
		return losProyectosSelectItem;
	}
	public void setLosProyectosSelectItem(List<SelectItem> losProyectosSelectItem) {
		this.losProyectosSelectItem = losProyectosSelectItem;
	}
	public InputText getTxtDescripcion() {
		return txtDescripcion;
	}
	public void setTxtDescripcion(InputText txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}
	public CommandButton getBtnSave() {
		return btnSave;
	}
	public void setBtnSave(CommandButton btnSave) {
		this.btnSave = btnSave;
	}
	public CommandButton getBtnModify() {
		return btnModify;
	}
	public void setBtnModify(CommandButton btnModify) {
		this.btnModify = btnModify;
	}
	public CommandButton getBtnDelete() {
		return btnDelete;
	}
	public void setBtnDelete(CommandButton btnDelete) {
		this.btnDelete = btnDelete;
	}
	public CommandButton getBtnClear() {
		return btnClear;
	}
	public void setBtnClear(CommandButton btnClear) {
		this.btnClear = btnClear;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static Logger getLog() {
		return log;
	}
		
	public Informacion getEntity() {
		return entity;
	}
	public void setEntity(Informacion entity) {
		this.entity = entity;
	}
	public InformacionDTO getSelectedInformacion() {
		return selectedInformacion;
	}
	public void setSelectedInformacion(InformacionDTO selectedInformacion) {
		this.selectedInformacion = selectedInformacion;
	}
	public UploadedFile getFile() {
		return file;
	}
	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public SelectOneMenu getSomProyectos() {
		return somProyectos;
	}

	public void setSomProyectos(SelectOneMenu somProyectos) {
		this.somProyectos = somProyectos;
	}

	public SelectOneMenu getSomActivo() {
		return somActivo;
	}

	public void setSomActivo(SelectOneMenu somActivo) {
		this.somActivo = somActivo;
	}

	public List<Informacion> getLasVariables() throws Exception {
		if(lasVariables==null) {
			Proyecto proyecto=(Proyecto)FacesUtils.getfromSession("proyecto");
				lasVariables= businessDelegatorView.getVariableByProject(proyecto);
			
		}
		return lasVariables;
	}

	public void setLasVariables(List<Informacion> lasVariables) {
		this.lasVariables = lasVariables;
	}

	public Informacion getVariableSelected() {
		return variableSelected;
	}

	public void setVariableSelected(Informacion variableSelected) {
		this.variableSelected = variableSelected;
	}

	public OutputLabel getArchivo() {
		return archivo;
	}

	public void setArchivo(OutputLabel archivo) {
		this.archivo = archivo;
	}

	public List<Informacion> getFilteredVariables() {
		return filteredVariables;
	}

	public void setFilteredVariables(List<Informacion> filteredVariables) {
		this.filteredVariables = filteredVariables;
	}

	public OutputLabel getRuta() {
		return ruta;
	}

	public void setRuta(OutputLabel ruta) {
		this.ruta = ruta;
	}   
}
