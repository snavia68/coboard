package com.coboard.presentation.backingBeans;

import com.coboard.exceptions.*;

import com.coboard.modelo.*;
import com.coboard.modelo.dto.SesionDTO;

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
public class SesionView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(SesionView.class);
    private InputText txtUsuariocreador;
    private InputText txtUsuariomodificador;
    private InputText txtIdproyectousuario_Proyectousuario;
    private InputText txtIdsesion;
    private Calendar txtFechacreacion;
    private Calendar txtFechamodificacion;
    private Calendar txtFechasesion;
    private Calendar txtHorafin;
    private Calendar txtHorasesion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<SesionDTO> data;
    private SesionDTO selectedSesion;
    private Sesion entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public SesionView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedSesion = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedSesion = null;

        if (txtUsuariocreador != null) {
            txtUsuariocreador.setValue(null);
            txtUsuariocreador.setDisabled(true);
        }

        if (txtUsuariomodificador != null) {
            txtUsuariomodificador.setValue(null);
            txtUsuariomodificador.setDisabled(true);
        }

        if (txtIdproyectousuario_Proyectousuario != null) {
            txtIdproyectousuario_Proyectousuario.setValue(null);
            txtIdproyectousuario_Proyectousuario.setDisabled(true);
        }

        if (txtFechacreacion != null) {
            txtFechacreacion.setValue(null);
            txtFechacreacion.setDisabled(true);
        }

        if (txtFechamodificacion != null) {
            txtFechamodificacion.setValue(null);
            txtFechamodificacion.setDisabled(true);
        }

        if (txtFechasesion != null) {
            txtFechasesion.setValue(null);
            txtFechasesion.setDisabled(true);
        }

        if (txtHorafin != null) {
            txtHorafin.setValue(null);
            txtHorafin.setDisabled(true);
        }

        if (txtHorasesion != null) {
            txtHorasesion.setValue(null);
            txtHorasesion.setDisabled(true);
        }

        if (txtIdsesion != null) {
            txtIdsesion.setValue(null);
            txtIdsesion.setDisabled(false);
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

    public void listener_txtFechasesion() {
        Date inputDate = (Date) txtFechasesion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtHorafin() {
        Date inputDate = (Date) txtHorafin.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtHorasesion() {
        Date inputDate = (Date) txtHorasesion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Integer idsesion = FacesUtils.checkInteger(txtIdsesion);
            entity = (idsesion != null)
                ? businessDelegatorView.getSesion(idsesion) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtUsuariocreador.setDisabled(false);
            txtUsuariomodificador.setDisabled(false);
            txtIdproyectousuario_Proyectousuario.setDisabled(false);
            txtFechacreacion.setDisabled(false);
            txtFechamodificacion.setDisabled(false);
            txtFechasesion.setDisabled(false);
            txtHorafin.setDisabled(false);
            txtHorasesion.setDisabled(false);
            txtIdsesion.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtFechacreacion.setValue(entity.getFechacreacion());
            txtFechacreacion.setDisabled(false);
            txtFechamodificacion.setValue(entity.getFechamodificacion());
            txtFechamodificacion.setDisabled(false);
            txtFechasesion.setValue(entity.getFechasesion());
            txtFechasesion.setDisabled(false);
            txtHorafin.setValue(entity.getHorafin());
            txtHorafin.setDisabled(false);
            txtHorasesion.setValue(entity.getHorasesion());
            txtHorasesion.setDisabled(false);
            txtUsuariocreador.setValue(entity.getUsuariocreador());
            txtUsuariocreador.setDisabled(false);
            txtUsuariomodificador.setValue(entity.getUsuariomodificador());
            txtUsuariomodificador.setDisabled(false);
            txtIdproyectousuario_Proyectousuario.setValue(entity.getProyectousuario()
                                                                .getIdproyectousuario());
            txtIdproyectousuario_Proyectousuario.setDisabled(false);
            txtIdsesion.setValue(entity.getIdsesion());
            txtIdsesion.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedSesion = (SesionDTO) (evt.getComponent().getAttributes()
                                         .get("selectedSesion"));
        txtFechacreacion.setValue(selectedSesion.getFechacreacion());
        txtFechacreacion.setDisabled(false);
        txtFechamodificacion.setValue(selectedSesion.getFechamodificacion());
        txtFechamodificacion.setDisabled(false);
        txtFechasesion.setValue(selectedSesion.getFechasesion());
        txtFechasesion.setDisabled(false);
        txtHorafin.setValue(selectedSesion.getHorafin());
        txtHorafin.setDisabled(false);
        txtHorasesion.setValue(selectedSesion.getHorasesion());
        txtHorasesion.setDisabled(false);
        txtUsuariocreador.setValue(selectedSesion.getUsuariocreador());
        txtUsuariocreador.setDisabled(false);
        txtUsuariomodificador.setValue(selectedSesion.getUsuariomodificador());
        txtUsuariomodificador.setDisabled(false);
        txtIdproyectousuario_Proyectousuario.setValue(selectedSesion.getIdproyectousuario_Proyectousuario());
        txtIdproyectousuario_Proyectousuario.setDisabled(false);
        txtIdsesion.setValue(selectedSesion.getIdsesion());
        txtIdsesion.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedSesion == null) && (entity == null)) {
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
            entity = new Sesion();

            Integer idsesion = FacesUtils.checkInteger(txtIdsesion);

            entity.setFechacreacion(FacesUtils.checkDate(txtFechacreacion));
            entity.setFechamodificacion(FacesUtils.checkDate(
                    txtFechamodificacion));
            entity.setFechasesion(FacesUtils.checkDate(txtFechasesion));
            entity.setHorafin(FacesUtils.checkDate(txtHorafin));
            entity.setHorasesion(FacesUtils.checkDate(txtHorasesion));
            entity.setIdsesion(idsesion);
            entity.setUsuariocreador(FacesUtils.checkString(txtUsuariocreador));
            entity.setUsuariomodificador(FacesUtils.checkString(
                    txtUsuariomodificador));
            entity.setProyectousuario((FacesUtils.checkInteger(
                    txtIdproyectousuario_Proyectousuario) != null)
                ? businessDelegatorView.getProyectousuario(
                    FacesUtils.checkInteger(
                        txtIdproyectousuario_Proyectousuario)) : null);
            businessDelegatorView.saveSesion(entity);
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
                Integer idsesion = new Integer(selectedSesion.getIdsesion());
                entity = businessDelegatorView.getSesion(idsesion);
            }

            entity.setFechacreacion(FacesUtils.checkDate(txtFechacreacion));
            entity.setFechamodificacion(FacesUtils.checkDate(
                    txtFechamodificacion));
            entity.setFechasesion(FacesUtils.checkDate(txtFechasesion));
            entity.setHorafin(FacesUtils.checkDate(txtHorafin));
            entity.setHorasesion(FacesUtils.checkDate(txtHorasesion));
            entity.setUsuariocreador(FacesUtils.checkString(txtUsuariocreador));
            entity.setUsuariomodificador(FacesUtils.checkString(
                    txtUsuariomodificador));
            entity.setProyectousuario((FacesUtils.checkInteger(
                    txtIdproyectousuario_Proyectousuario) != null)
                ? businessDelegatorView.getProyectousuario(
                    FacesUtils.checkInteger(
                        txtIdproyectousuario_Proyectousuario)) : null);
            businessDelegatorView.updateSesion(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedSesion = (SesionDTO) (evt.getComponent().getAttributes()
                                             .get("selectedSesion"));

            Integer idsesion = new Integer(selectedSesion.getIdsesion());
            entity = businessDelegatorView.getSesion(idsesion);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idsesion = FacesUtils.checkInteger(txtIdsesion);
            entity = businessDelegatorView.getSesion(idsesion);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteSesion(entity);
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
        Date fechamodificacion, Date fechasesion, Date horafin,
        Date horasesion, Integer idsesion, String usuariocreador,
        String usuariomodificador, Integer idproyectousuario_Proyectousuario)
        throws Exception {
        try {
            entity.setFechacreacion(FacesUtils.checkDate(fechacreacion));
            entity.setFechamodificacion(FacesUtils.checkDate(fechamodificacion));
            entity.setFechasesion(FacesUtils.checkDate(fechasesion));
            entity.setHorafin(FacesUtils.checkDate(horafin));
            entity.setHorasesion(FacesUtils.checkDate(horasesion));
            entity.setUsuariocreador(FacesUtils.checkString(usuariocreador));
            entity.setUsuariomodificador(FacesUtils.checkString(
                    usuariomodificador));
            businessDelegatorView.updateSesion(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("SesionView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
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

    public InputText getTxtIdproyectousuario_Proyectousuario() {
        return txtIdproyectousuario_Proyectousuario;
    }

    public void setTxtIdproyectousuario_Proyectousuario(
        InputText txtIdproyectousuario_Proyectousuario) {
        this.txtIdproyectousuario_Proyectousuario = txtIdproyectousuario_Proyectousuario;
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

    public Calendar getTxtFechasesion() {
        return txtFechasesion;
    }

    public void setTxtFechasesion(Calendar txtFechasesion) {
        this.txtFechasesion = txtFechasesion;
    }

    public Calendar getTxtHorafin() {
        return txtHorafin;
    }

    public void setTxtHorafin(Calendar txtHorafin) {
        this.txtHorafin = txtHorafin;
    }

    public Calendar getTxtHorasesion() {
        return txtHorasesion;
    }

    public void setTxtHorasesion(Calendar txtHorasesion) {
        this.txtHorasesion = txtHorasesion;
    }

    public InputText getTxtIdsesion() {
        return txtIdsesion;
    }

    public void setTxtIdsesion(InputText txtIdsesion) {
        this.txtIdsesion = txtIdsesion;
    }

    public List<SesionDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataSesion();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<SesionDTO> sesionDTO) {
        this.data = sesionDTO;
    }

    public SesionDTO getSelectedSesion() {
        return selectedSesion;
    }

    public void setSelectedSesion(SesionDTO sesion) {
        this.selectedSesion = sesion;
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
