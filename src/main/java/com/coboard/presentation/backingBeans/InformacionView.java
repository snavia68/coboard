package com.coboard.presentation.backingBeans;

import com.coboard.exceptions.*;
import com.coboard.modelo.*;
import com.coboard.modelo.dto.InformacionDTO;
import com.coboard.presentation.businessDelegate.*;
import com.coboard.utilities.*;
import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.link.Link;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class InformacionView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(InformacionView.class);
    private InputText txtActivo;
    private InputText txtDescripcion;
    private InputText txtUsuariocreador;
    private InputText txtUsuariomodificador;
    private InputText txtIdproyecto_Proyecto;
    private InputText txtIdinformacion;
    private Calendar txtFechacreacion;
    private Calendar txtFechamodificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<InformacionDTO> data;
    private List<Informacion> variablesFiltradas;
    private List<Informacion> lasVariables;
    private InformacionDTO selectedInformacion;
    private Informacion entity;
    private Link archivo;
    private Informacion variableSelected;
    private StreamedContent file;
    
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public InformacionView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedInformacion = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedInformacion = null;

        if (txtActivo != null) {
            txtActivo.setValue(null);
            txtActivo.setDisabled(true);
        }

        if (txtDescripcion != null) {
            txtDescripcion.setValue(null);
            txtDescripcion.setDisabled(true);
        }

        if (txtUsuariocreador != null) {
            txtUsuariocreador.setValue(null);
            txtUsuariocreador.setDisabled(true);
        }

        if (txtUsuariomodificador != null) {
            txtUsuariomodificador.setValue(null);
            txtUsuariomodificador.setDisabled(true);
        }

        if (txtIdproyecto_Proyecto != null) {
            txtIdproyecto_Proyecto.setValue(null);
            txtIdproyecto_Proyecto.setDisabled(true);
        }

        if (txtFechacreacion != null) {
            txtFechacreacion.setValue(null);
            txtFechacreacion.setDisabled(true);
        }

        if (txtFechamodificacion != null) {
            txtFechamodificacion.setValue(null);
            txtFechamodificacion.setDisabled(true);
        }

        if (txtIdinformacion != null) {
            txtIdinformacion.setValue(null);
            txtIdinformacion.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtFechacreacion() {
        Date inputDate = (Date) txtFechacreacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtFechamodificacion() {
        Date inputDate = (Date) txtFechamodificacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Integer idinformacion = FacesUtils.checkInteger(txtIdinformacion);
            entity = (idinformacion != null)
                ? businessDelegatorView.getInformacion(idinformacion) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtActivo.setDisabled(false);
            txtDescripcion.setDisabled(false);
            txtUsuariocreador.setDisabled(false);
            txtUsuariomodificador.setDisabled(false);
            txtIdproyecto_Proyecto.setDisabled(false);
            txtFechacreacion.setDisabled(false);
            txtFechamodificacion.setDisabled(false);
            txtIdinformacion.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtActivo.setValue(entity.getActivo());
            txtActivo.setDisabled(false);
            txtDescripcion.setValue(entity.getDescripcion());
            txtDescripcion.setDisabled(false);
            txtFechacreacion.setValue(entity.getFechacreacion());
            txtFechacreacion.setDisabled(false);
            txtFechamodificacion.setValue(entity.getFechamodificacion());
            txtFechamodificacion.setDisabled(false);
            txtUsuariocreador.setValue(entity.getUsuariocreador());
            txtUsuariocreador.setDisabled(false);
            txtUsuariomodificador.setValue(entity.getUsuariomodificador());
            txtUsuariomodificador.setDisabled(false);
            txtIdproyecto_Proyecto.setValue(entity.getProyecto().getIdproyecto());
            txtIdproyecto_Proyecto.setDisabled(false);
            txtIdinformacion.setValue(entity.getIdinformacion());
            txtIdinformacion.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedInformacion = (InformacionDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedInformacion"));
        txtActivo.setValue(selectedInformacion.getActivo());
        txtActivo.setDisabled(false);
        txtDescripcion.setValue(selectedInformacion.getDescripcion());
        txtDescripcion.setDisabled(false);
        txtFechacreacion.setValue(selectedInformacion.getFechacreacion());
        txtFechacreacion.setDisabled(false);
        txtFechamodificacion.setValue(selectedInformacion.getFechamodificacion());
        txtFechamodificacion.setDisabled(false);
        txtUsuariocreador.setValue(selectedInformacion.getUsuariocreador());
        txtUsuariocreador.setDisabled(false);
        txtUsuariomodificador.setValue(selectedInformacion.getUsuariomodificador());
        txtUsuariomodificador.setDisabled(false);
        txtIdproyecto_Proyecto.setValue(selectedInformacion.getIdproyecto_Proyecto());
        txtIdproyecto_Proyecto.setDisabled(false);
        txtIdinformacion.setValue(selectedInformacion.getIdinformacion());
        txtIdinformacion.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }
    
    
    public void descargarArchivos(){
    	
		try {
	    	Adjuntos adjuntos = businessDelegatorView.findAdjuntoByInformacion(variableSelected.getIdinformacion());
	    	InputStream fileConsulta = businessDelegatorView.download("coboard-cloud2", adjuntos.getUrl());
			
	    	file = new DefaultStreamedContent(fileConsulta, "",adjuntos.getUrl());
	    	
	    	
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha descargado el archivo: "+adjuntos.getUrl(), ""));
    	
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
    	
    	
    }
    
    public StreamedContent getFile() {
        return file;
    }
    
    public String action_save() {
        try {
            if ((selectedInformacion == null) && (entity == null)) {
                
            } else {
                
            }

            data = null;
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    
   


    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedInformacion = (InformacionDTO) (evt.getComponent()
                                                       .getAttributes()
                                                       .get("selectedInformacion"));

            Integer idinformacion = new Integer(selectedInformacion.getIdinformacion());
            entity = businessDelegatorView.getInformacion(idinformacion);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idinformacion = FacesUtils.checkInteger(txtIdinformacion);
            entity = businessDelegatorView.getInformacion(idinformacion);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteInformacion(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data = null;
        } catch (Exception e) {
            throw e;
        }
    }

    public String action_closeDialog() {
        setShowDialog(false);
        action_clear();

        return "";
    }


    public InputText getTxtActivo() {
        return txtActivo;
    }

    public void setTxtActivo(InputText txtActivo) {
        this.txtActivo = txtActivo;
    }

    public InputText getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(InputText txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public InputText getTxtUsuariocreador() {
        return txtUsuariocreador;
    }

    public void setTxtUsuariocreador(InputText txtUsuariocreador) {
        this.txtUsuariocreador = txtUsuariocreador;
    }

    public InputText getTxtUsuariomodificador() {
        return txtUsuariomodificador;
    }

    public void setTxtUsuariomodificador(InputText txtUsuariomodificador) {
        this.txtUsuariomodificador = txtUsuariomodificador;
    }

    public InputText getTxtIdproyecto_Proyecto() {
        return txtIdproyecto_Proyecto;
    }

    public void setTxtIdproyecto_Proyecto(InputText txtIdproyecto_Proyecto) {
        this.txtIdproyecto_Proyecto = txtIdproyecto_Proyecto;
    }

    public Calendar getTxtFechacreacion() {
        return txtFechacreacion;
    }

    public void setTxtFechacreacion(Calendar txtFechacreacion) {
        this.txtFechacreacion = txtFechacreacion;
    }

    public Calendar getTxtFechamodificacion() {
        return txtFechamodificacion;
    }

    public void setTxtFechamodificacion(Calendar txtFechamodificacion) {
        this.txtFechamodificacion = txtFechamodificacion;
    }

    public InputText getTxtIdinformacion() {
        return txtIdinformacion;
    }

    public void setTxtIdinformacion(InputText txtIdinformacion) {
        this.txtIdinformacion = txtIdinformacion;
    }

    public List<InformacionDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataInformacion();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<InformacionDTO> informacionDTO) {
        this.data = informacionDTO;
    }

    public InformacionDTO getSelectedInformacion() {
        return selectedInformacion;
    }

    public void setSelectedInformacion(InformacionDTO informacion) {
        this.selectedInformacion = informacion;
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

    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }

    public IBusinessDelegatorView getBusinessDelegatorView() {
        return businessDelegatorView;
    }

    public void setBusinessDelegatorView(
        IBusinessDelegatorView businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }

	public List<Informacion> getVariablesFiltradas() {
		return variablesFiltradas;
	}

	public void setVariablesFiltradas(List<Informacion> variablesFiltradas) {
		this.variablesFiltradas = variablesFiltradas;
	}

	public List<Informacion> getLasVariables() throws Exception {
		if(lasVariables == null) {
			Proyecto proyecto =  (Proyecto)FacesUtils.getfromSession("proyecto");
			lasVariables = businessDelegatorView.listarVariablesProyecto(proyecto);
			
		}
		return lasVariables;
	}
	
	
	public Informacion getVariableSelected() {
		return variableSelected;
	}

	public void setVariableSelected(Informacion variableSelected) {
		this.variableSelected = variableSelected;
	}

	public void setLasVariables(List<Informacion> lasVariables) {
		this.lasVariables = lasVariables;
	}
    
}
