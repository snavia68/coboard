package com.coboard.presentation.backingBeans;

import com.coboard.exceptions.*;

import com.coboard.modelo.*;
import com.coboard.modelo.dto.TipousuarioDTO;

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
public class TipousuarioView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipousuarioView.class);
    private InputText txtActivo;
    private InputText txtNombre;
    private InputText txtUsuariocreador;
    private InputText txtUsuariomodificador;
    private InputText txtIdtipousuario;
    private Calendar txtFechacreacion;
    private Calendar txtFechamodificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TipousuarioDTO> data;
    private TipousuarioDTO selectedTipousuario;
    private Tipousuario entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public TipousuarioView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedTipousuario = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTipousuario = null;

        if (txtActivo != null) {
            txtActivo.setValue(null);
            txtActivo.setDisabled(true);
        }

        if (txtNombre != null) {
            txtNombre.setValue(null);
            txtNombre.setDisabled(true);
        }

        if (txtUsuariocreador != null) {
            txtUsuariocreador.setValue(null);
            txtUsuariocreador.setDisabled(true);
        }

        if (txtUsuariomodificador != null) {
            txtUsuariomodificador.setValue(null);
            txtUsuariomodificador.setDisabled(true);
        }

        if (txtFechacreacion != null) {
            txtFechacreacion.setValue(null);
            txtFechacreacion.setDisabled(true);
        }

        if (txtFechamodificacion != null) {
            txtFechamodificacion.setValue(null);
            txtFechamodificacion.setDisabled(true);
        }

        if (txtIdtipousuario != null) {
            txtIdtipousuario.setValue(null);
            txtIdtipousuario.setDisabled(false);
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
            Integer idtipousuario = FacesUtils.checkInteger(txtIdtipousuario);
            entity = (idtipousuario != null)
                ? businessDelegatorView.getTipousuario(idtipousuario) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtActivo.setDisabled(false);
            txtNombre.setDisabled(false);
            txtUsuariocreador.setDisabled(false);
            txtUsuariomodificador.setDisabled(false);
            txtFechacreacion.setDisabled(false);
            txtFechamodificacion.setDisabled(false);
            txtIdtipousuario.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtActivo.setValue(entity.getActivo());
            txtActivo.setDisabled(false);
            txtFechacreacion.setValue(entity.getFechacreacion());
            txtFechacreacion.setDisabled(false);
            txtFechamodificacion.setValue(entity.getFechamodificacion());
            txtFechamodificacion.setDisabled(false);
            txtNombre.setValue(entity.getNombre());
            txtNombre.setDisabled(false);
            txtUsuariocreador.setValue(entity.getUsuariocreador());
            txtUsuariocreador.setDisabled(false);
            txtUsuariomodificador.setValue(entity.getUsuariomodificador());
            txtUsuariomodificador.setDisabled(false);
            txtIdtipousuario.setValue(entity.getIdtipousuario());
            txtIdtipousuario.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTipousuario = (TipousuarioDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedTipousuario"));
        txtActivo.setValue(selectedTipousuario.getActivo());
        txtActivo.setDisabled(false);
        txtFechacreacion.setValue(selectedTipousuario.getFechacreacion());
        txtFechacreacion.setDisabled(false);
        txtFechamodificacion.setValue(selectedTipousuario.getFechamodificacion());
        txtFechamodificacion.setDisabled(false);
        txtNombre.setValue(selectedTipousuario.getNombre());
        txtNombre.setDisabled(false);
        txtUsuariocreador.setValue(selectedTipousuario.getUsuariocreador());
        txtUsuariocreador.setDisabled(false);
        txtUsuariomodificador.setValue(selectedTipousuario.getUsuariomodificador());
        txtUsuariomodificador.setDisabled(false);
        txtIdtipousuario.setValue(selectedTipousuario.getIdtipousuario());
        txtIdtipousuario.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTipousuario == null) && (entity == null)) {
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
            entity = new Tipousuario();

            Integer idtipousuario = FacesUtils.checkInteger(txtIdtipousuario);

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setFechacreacion(FacesUtils.checkDate(txtFechacreacion));
            entity.setFechamodificacion(FacesUtils.checkDate(
                    txtFechamodificacion));
            entity.setIdtipousuario(idtipousuario);
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setUsuariocreador(FacesUtils.checkString(txtUsuariocreador));
            entity.setUsuariomodificador(FacesUtils.checkString(
                    txtUsuariomodificador));
            businessDelegatorView.saveTipousuario(entity);
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
                Integer idtipousuario = new Integer(selectedTipousuario.getIdtipousuario());
                entity = businessDelegatorView.getTipousuario(idtipousuario);
            }

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setFechacreacion(FacesUtils.checkDate(txtFechacreacion));
            entity.setFechamodificacion(FacesUtils.checkDate(
                    txtFechamodificacion));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setUsuariocreador(FacesUtils.checkString(txtUsuariocreador));
            entity.setUsuariomodificador(FacesUtils.checkString(
                    txtUsuariomodificador));
            businessDelegatorView.updateTipousuario(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTipousuario = (TipousuarioDTO) (evt.getComponent()
                                                       .getAttributes()
                                                       .get("selectedTipousuario"));

            Integer idtipousuario = new Integer(selectedTipousuario.getIdtipousuario());
            entity = businessDelegatorView.getTipousuario(idtipousuario);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idtipousuario = FacesUtils.checkInteger(txtIdtipousuario);
            entity = businessDelegatorView.getTipousuario(idtipousuario);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTipousuario(entity);
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

    public String action_modifyWitDTO(String activo, Date fechacreacion,
        Date fechamodificacion, Integer idtipousuario, String nombre,
        String usuariocreador, String usuariomodificador)
        throws Exception {
        try {
            entity.setActivo(FacesUtils.checkString(activo));
            entity.setFechacreacion(FacesUtils.checkDate(fechacreacion));
            entity.setFechamodificacion(FacesUtils.checkDate(fechamodificacion));
            entity.setNombre(FacesUtils.checkString(nombre));
            entity.setUsuariocreador(FacesUtils.checkString(usuariocreador));
            entity.setUsuariomodificador(FacesUtils.checkString(
                    usuariomodificador));
            businessDelegatorView.updateTipousuario(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TipousuarioView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtActivo() {
        return txtActivo;
    }

    public void setTxtActivo(InputText txtActivo) {
        this.txtActivo = txtActivo;
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
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

    public InputText getTxtIdtipousuario() {
        return txtIdtipousuario;
    }

    public void setTxtIdtipousuario(InputText txtIdtipousuario) {
        this.txtIdtipousuario = txtIdtipousuario;
    }

    public List<TipousuarioDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTipousuario();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TipousuarioDTO> tipousuarioDTO) {
        this.data = tipousuarioDTO;
    }

    public TipousuarioDTO getSelectedTipousuario() {
        return selectedTipousuario;
    }

    public void setSelectedTipousuario(TipousuarioDTO tipousuario) {
        this.selectedTipousuario = tipousuario;
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
