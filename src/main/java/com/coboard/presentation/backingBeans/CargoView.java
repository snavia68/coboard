package com.coboard.presentation.backingBeans;

import com.coboard.exceptions.*;

import com.coboard.modelo.*;
import com.coboard.modelo.dto.CargoDTO;

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
public class CargoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CargoView.class);
    private InputText txtActivo;
    private InputText txtNombre;
    private InputText txtUsuariocreador;
    private InputText txtUsuariomodificador;
    private InputText txtIdcargo;
    private Calendar txtFechacreacion;
    private Calendar txtFechamodificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<CargoDTO> data;
    private CargoDTO selectedCargo;
    private Cargo entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public CargoView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedCargo = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedCargo = null;

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

        if (txtIdcargo != null) {
            txtIdcargo.setValue(null);
            txtIdcargo.setDisabled(false);
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
            Integer idcargo = FacesUtils.checkInteger(txtIdcargo);
            entity = (idcargo != null)
                ? businessDelegatorView.getCargo(idcargo) : null;
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
            txtIdcargo.setDisabled(false);
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
            txtIdcargo.setValue(entity.getIdcargo());
            txtIdcargo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedCargo = (CargoDTO) (evt.getComponent().getAttributes()
                                       .get("selectedCargo"));
        txtActivo.setValue(selectedCargo.getActivo());
        txtActivo.setDisabled(false);
        txtFechacreacion.setValue(selectedCargo.getFechacreacion());
        txtFechacreacion.setDisabled(false);
        txtFechamodificacion.setValue(selectedCargo.getFechamodificacion());
        txtFechamodificacion.setDisabled(false);
        txtNombre.setValue(selectedCargo.getNombre());
        txtNombre.setDisabled(false);
        txtUsuariocreador.setValue(selectedCargo.getUsuariocreador());
        txtUsuariocreador.setDisabled(false);
        txtUsuariomodificador.setValue(selectedCargo.getUsuariomodificador());
        txtUsuariomodificador.setDisabled(false);
        txtIdcargo.setValue(selectedCargo.getIdcargo());
        txtIdcargo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedCargo == null) && (entity == null)) {
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
            entity = new Cargo();

            Integer idcargo = FacesUtils.checkInteger(txtIdcargo);

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setFechacreacion(FacesUtils.checkDate(txtFechacreacion));
            entity.setFechamodificacion(FacesUtils.checkDate(
                    txtFechamodificacion));
            entity.setIdcargo(idcargo);
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setUsuariocreador(FacesUtils.checkString(txtUsuariocreador));
            entity.setUsuariomodificador(FacesUtils.checkString(
                    txtUsuariomodificador));
            businessDelegatorView.saveCargo(entity);
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
                Integer idcargo = new Integer(selectedCargo.getIdcargo());
                entity = businessDelegatorView.getCargo(idcargo);
            }

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setFechacreacion(FacesUtils.checkDate(txtFechacreacion));
            entity.setFechamodificacion(FacesUtils.checkDate(
                    txtFechamodificacion));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setUsuariocreador(FacesUtils.checkString(txtUsuariocreador));
            entity.setUsuariomodificador(FacesUtils.checkString(
                    txtUsuariomodificador));
            businessDelegatorView.updateCargo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedCargo = (CargoDTO) (evt.getComponent().getAttributes()
                                           .get("selectedCargo"));

            Integer idcargo = new Integer(selectedCargo.getIdcargo());
            entity = businessDelegatorView.getCargo(idcargo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idcargo = FacesUtils.checkInteger(txtIdcargo);
            entity = businessDelegatorView.getCargo(idcargo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteCargo(entity);
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
        Date fechamodificacion, Integer idcargo, String nombre,
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
            businessDelegatorView.updateCargo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("CargoView").requestRender();
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

    public InputText getTxtIdcargo() {
        return txtIdcargo;
    }

    public void setTxtIdcargo(InputText txtIdcargo) {
        this.txtIdcargo = txtIdcargo;
    }

    public List<CargoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataCargo();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<CargoDTO> cargoDTO) {
        this.data = cargoDTO;
    }

    public CargoDTO getSelectedCargo() {
        return selectedCargo;
    }

    public void setSelectedCargo(CargoDTO cargo) {
        this.selectedCargo = cargo;
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
