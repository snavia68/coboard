package com.coboard.presentation.backingBeans;

import com.coboard.exceptions.*;

import com.coboard.modelo.*;
import com.coboard.modelo.dto.AdjuntosDTO;

import com.coboard.presentation.businessDelegate.*;

import com.coboard.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
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
public class AdjuntosView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(AdjuntosView.class);
    private InputText txtUrl;
    private InputText txtUsuariocreador;
    private InputText txtUsuariomodificador;
    private InputText txtIdinformacion_Informacion;
    private InputText txtIdadjuntos;
    private Calendar txtFechacreacion;
    private Calendar txtFechamodificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<AdjuntosDTO> data;
    private AdjuntosDTO selectedAdjuntos;
    private Adjuntos entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public AdjuntosView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedAdjuntos = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedAdjuntos = null;

        if (txtUrl != null) {
            txtUrl.setValue(null);
            txtUrl.setDisabled(true);
        }

        if (txtUsuariocreador != null) {
            txtUsuariocreador.setValue(null);
            txtUsuariocreador.setDisabled(true);
        }

        if (txtUsuariomodificador != null) {
            txtUsuariomodificador.setValue(null);
            txtUsuariomodificador.setDisabled(true);
        }

        if (txtIdinformacion_Informacion != null) {
            txtIdinformacion_Informacion.setValue(null);
            txtIdinformacion_Informacion.setDisabled(true);
        }

        if (txtFechacreacion != null) {
            txtFechacreacion.setValue(null);
            txtFechacreacion.setDisabled(true);
        }

        if (txtFechamodificacion != null) {
            txtFechamodificacion.setValue(null);
            txtFechamodificacion.setDisabled(true);
        }

        if (txtIdadjuntos != null) {
            txtIdadjuntos.setValue(null);
            txtIdadjuntos.setDisabled(false);
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
            Integer idadjuntos = FacesUtils.checkInteger(txtIdadjuntos);
            entity = (idadjuntos != null)
                ? businessDelegatorView.getAdjuntos(idadjuntos) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtUrl.setDisabled(false);
            txtUsuariocreador.setDisabled(false);
            txtUsuariomodificador.setDisabled(false);
            txtIdinformacion_Informacion.setDisabled(false);
            txtFechacreacion.setDisabled(false);
            txtFechamodificacion.setDisabled(false);
            txtIdadjuntos.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtFechacreacion.setValue(entity.getFechacreacion());
            txtFechacreacion.setDisabled(false);
            txtFechamodificacion.setValue(entity.getFechamodificacion());
            txtFechamodificacion.setDisabled(false);
            txtUrl.setValue(entity.getUrl());
            txtUrl.setDisabled(false);
            txtUsuariocreador.setValue(entity.getUsuariocreador());
            txtUsuariocreador.setDisabled(false);
            txtUsuariomodificador.setValue(entity.getUsuariomodificador());
            txtUsuariomodificador.setDisabled(false);
            txtIdinformacion_Informacion.setValue(entity.getInformacion()
                                                        .getIdinformacion());
            txtIdinformacion_Informacion.setDisabled(false);
            txtIdadjuntos.setValue(entity.getIdadjuntos());
            txtIdadjuntos.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedAdjuntos = (AdjuntosDTO) (evt.getComponent().getAttributes()
                                             .get("selectedAdjuntos"));
        txtFechacreacion.setValue(selectedAdjuntos.getFechacreacion());
        txtFechacreacion.setDisabled(false);
        txtFechamodificacion.setValue(selectedAdjuntos.getFechamodificacion());
        txtFechamodificacion.setDisabled(false);
        txtUrl.setValue(selectedAdjuntos.getUrl());
        txtUrl.setDisabled(false);
        txtUsuariocreador.setValue(selectedAdjuntos.getUsuariocreador());
        txtUsuariocreador.setDisabled(false);
        txtUsuariomodificador.setValue(selectedAdjuntos.getUsuariomodificador());
        txtUsuariomodificador.setDisabled(false);
        txtIdinformacion_Informacion.setValue(selectedAdjuntos.getIdinformacion_Informacion());
        txtIdinformacion_Informacion.setDisabled(false);
        txtIdadjuntos.setValue(selectedAdjuntos.getIdadjuntos());
        txtIdadjuntos.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedAdjuntos == null) && (entity == null)) {
                action_create();
            } else {
                action_modify();
            }

            data = null;
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_create() {
        try {
            entity = new Adjuntos();

            Integer idadjuntos = FacesUtils.checkInteger(txtIdadjuntos);

            entity.setFechacreacion(FacesUtils.checkDate(txtFechacreacion));
            entity.setFechamodificacion(FacesUtils.checkDate(
                    txtFechamodificacion));
            entity.setIdadjuntos(idadjuntos);
            entity.setUrl(FacesUtils.checkString(txtUrl));
            entity.setUsuariocreador(FacesUtils.checkString(txtUsuariocreador));
            entity.setUsuariomodificador(FacesUtils.checkString(
                    txtUsuariomodificador));
            entity.setInformacion((FacesUtils.checkInteger(
                    txtIdinformacion_Informacion) != null)
                ? businessDelegatorView.getInformacion(FacesUtils.checkInteger(
                        txtIdinformacion_Informacion)) : null);
            businessDelegatorView.saveAdjuntos(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            entity = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            if (entity == null) {
                Integer idadjuntos = new Integer(selectedAdjuntos.getIdadjuntos());
                entity = businessDelegatorView.getAdjuntos(idadjuntos);
            }

            entity.setFechacreacion(FacesUtils.checkDate(txtFechacreacion));
            entity.setFechamodificacion(FacesUtils.checkDate(
                    txtFechamodificacion));
            entity.setUrl(FacesUtils.checkString(txtUrl));
            entity.setUsuariocreador(FacesUtils.checkString(txtUsuariocreador));
            entity.setUsuariomodificador(FacesUtils.checkString(
                    txtUsuariomodificador));
            entity.setInformacion((FacesUtils.checkInteger(
                    txtIdinformacion_Informacion) != null)
                ? businessDelegatorView.getInformacion(FacesUtils.checkInteger(
                        txtIdinformacion_Informacion)) : null);
            businessDelegatorView.updateAdjuntos(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedAdjuntos = (AdjuntosDTO) (evt.getComponent().getAttributes()
                                                 .get("selectedAdjuntos"));

            Integer idadjuntos = new Integer(selectedAdjuntos.getIdadjuntos());
            entity = businessDelegatorView.getAdjuntos(idadjuntos);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idadjuntos = FacesUtils.checkInteger(txtIdadjuntos);
            entity = businessDelegatorView.getAdjuntos(idadjuntos);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteAdjuntos(entity);
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

    public String action_modifyWitDTO(Date fechacreacion,
        Date fechamodificacion, Integer idadjuntos, String url,
        String usuariocreador, String usuariomodificador,
        Integer idinformacion_Informacion) throws Exception {
        try {
            entity.setFechacreacion(FacesUtils.checkDate(fechacreacion));
            entity.setFechamodificacion(FacesUtils.checkDate(fechamodificacion));
            entity.setUrl(FacesUtils.checkString(url));
            entity.setUsuariocreador(FacesUtils.checkString(usuariocreador));
            entity.setUsuariomodificador(FacesUtils.checkString(
                    usuariomodificador));
            businessDelegatorView.updateAdjuntos(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("AdjuntosView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(InputText txtUrl) {
        this.txtUrl = txtUrl;
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

    public InputText getTxtIdinformacion_Informacion() {
        return txtIdinformacion_Informacion;
    }

    public void setTxtIdinformacion_Informacion(
        InputText txtIdinformacion_Informacion) {
        this.txtIdinformacion_Informacion = txtIdinformacion_Informacion;
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

    public InputText getTxtIdadjuntos() {
        return txtIdadjuntos;
    }

    public void setTxtIdadjuntos(InputText txtIdadjuntos) {
        this.txtIdadjuntos = txtIdadjuntos;
    }

    public List<AdjuntosDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataAdjuntos();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<AdjuntosDTO> adjuntosDTO) {
        this.data = adjuntosDTO;
    }

    public AdjuntosDTO getSelectedAdjuntos() {
        return selectedAdjuntos;
    }

    public void setSelectedAdjuntos(AdjuntosDTO adjuntos) {
        this.selectedAdjuntos = adjuntos;
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
}
