package com.coboard.presentation.backingBeans;

import com.coboard.exceptions.*;

import com.coboard.modelo.*;
import com.coboard.modelo.dto.CargoDTO;
import com.coboard.modelo.dto.UsuarioDTO;

import com.coboard.presentation.businessDelegate.*;

import com.coboard.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

/**
 * @author Zathura Code Generator http://zathuracode.org www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class UsuarioView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(UsuarioView.class);
	private InputText txtActivo;
	private Password txtContrasena;
	private Password txtContrasenaActual;
	private InputText txtCorreo;
	private InputText txtNombre;
	private InputText txtUsuariocreador;
	private InputText txtUsuariomodificador;
	private InputText txtIdcargo_Cargo;
	private InputText txtIdtipousuario_Tipousuario;
	private InputText txtIdusuario;
	private Calendar txtFechacreacion;
	private Calendar txtFechamodificacion;
	private SelectOneMenu somCargo;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<UsuarioDTO> data;
	private List<SelectItem> losCargosSelectItem;
	private UsuarioDTO selectedUsuario;
	private Usuario entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public UsuarioView() {
		super();
	}

	public String action_new() {
		action_clear();
		selectedUsuario = null;
		setShowDialog(true);

		return "";
	}

	public String limpiar() {

		txtCorreo.setValue(null);
		txtNombre.setValue(null);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedUsuario = null;

		if (txtActivo != null) {
			txtActivo.setValue(null);
			txtActivo.setDisabled(true);
		}

		if (txtContrasena != null) {
			txtContrasena.setValue(null);
			txtContrasena.setDisabled(true);
		}

		if (txtCorreo != null) {
			txtCorreo.setValue(null);
			txtCorreo.setDisabled(true);
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

		if (txtIdcargo_Cargo != null) {
			txtIdcargo_Cargo.setValue(null);
			txtIdcargo_Cargo.setDisabled(true);
		}

		if (txtIdtipousuario_Tipousuario != null) {
			txtIdtipousuario_Tipousuario.setValue(null);
			txtIdtipousuario_Tipousuario.setDisabled(true);
		}

		if (txtFechacreacion != null) {
			txtFechacreacion.setValue(null);
			txtFechacreacion.setDisabled(true);
		}

		if (txtFechamodificacion != null) {
			txtFechamodificacion.setValue(null);
			txtFechamodificacion.setDisabled(true);
		}

		if (txtIdusuario != null) {
			txtIdusuario.setValue(null);
			txtIdusuario.setDisabled(false);
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
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechamodificacion() {
		Date inputDate = (Date) txtFechamodificacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtId() {
		try {
			Integer idusuario = FacesUtils.checkInteger(txtIdusuario);
			entity = (idusuario != null) ? businessDelegatorView.getUsuario(idusuario) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtActivo.setDisabled(false);
			txtContrasena.setDisabled(false);
			txtCorreo.setDisabled(false);
			txtNombre.setDisabled(false);
			txtUsuariocreador.setDisabled(false);
			txtUsuariomodificador.setDisabled(false);
			txtIdcargo_Cargo.setDisabled(false);
			txtIdtipousuario_Tipousuario.setDisabled(false);
			txtFechacreacion.setDisabled(false);
			txtFechamodificacion.setDisabled(false);
			txtIdusuario.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtActivo.setValue(entity.getActivo());
			txtActivo.setDisabled(false);
			txtContrasena.setValue(entity.getContrasena());
			txtContrasena.setDisabled(false);
			txtCorreo.setValue(entity.getCorreo());
			txtCorreo.setDisabled(false);
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
			txtIdcargo_Cargo.setValue(entity.getCargo().getIdcargo());
			txtIdcargo_Cargo.setDisabled(false);
			txtIdtipousuario_Tipousuario.setValue(entity.getTipousuario().getIdtipousuario());
			txtIdtipousuario_Tipousuario.setDisabled(false);
			txtIdusuario.setValue(entity.getIdusuario());
			txtIdusuario.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedUsuario = (UsuarioDTO) (evt.getComponent().getAttributes().get("selectedUsuario"));
		txtActivo.setValue(selectedUsuario.getActivo());
		txtActivo.setDisabled(false);
		txtContrasena.setValue(selectedUsuario.getContrasena());
		txtContrasena.setDisabled(false);
		txtCorreo.setValue(selectedUsuario.getCorreo());
		txtCorreo.setDisabled(false);
		txtFechacreacion.setValue(selectedUsuario.getFechacreacion());
		txtFechacreacion.setDisabled(false);
		txtFechamodificacion.setValue(selectedUsuario.getFechamodificacion());
		txtFechamodificacion.setDisabled(false);
		txtNombre.setValue(selectedUsuario.getNombre());
		txtNombre.setDisabled(false);
		txtUsuariocreador.setValue(selectedUsuario.getUsuariocreador());
		txtUsuariocreador.setDisabled(false);
		txtUsuariomodificador.setValue(selectedUsuario.getUsuariomodificador());
		txtUsuariomodificador.setDisabled(false);
		txtIdcargo_Cargo.setValue(selectedUsuario.getIdcargo_Cargo());
		txtIdcargo_Cargo.setDisabled(false);
		txtIdtipousuario_Tipousuario.setValue(selectedUsuario.getIdtipousuario_Tipousuario());
		txtIdtipousuario_Tipousuario.setDisabled(false);
		txtIdusuario.setValue(selectedUsuario.getIdusuario());
		txtIdusuario.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedUsuario == null) && (entity == null)) {
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

	public static String contrasenaRandom(){
        String password = "";
        String[] elementos = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Random r = new Random();
        for (int i = 0; i < 9; i++) {
        	password += elementos[r.nextInt(62)];
        }
        
        return password;
    }
	
	public String registrarUsuario() {
		try {

			Integer num = 1;
			Date fecha = new Date();
			String contra= contrasenaRandom();
			Usuario usuario = new Usuario();
			usuario.setActivo("S");
			usuario.setContrasena(contra);
			usuario.setCorreo(txtCorreo.getValue().toString());
			usuario.setNombre(txtNombre.getValue().toString());
			usuario.setFechacreacion(fecha);
			usuario.setUsuariocreador("CoBoard");
			Cargo cargo = businessDelegatorView.getCargo(Integer.parseInt(somCargo.getValue().toString()));
			usuario.setCargo(cargo);
			Tipousuario tipousuario = businessDelegatorView.getTipousuario(num);
			usuario.setTipousuario(tipousuario);

			businessDelegatorView.saveUsuario(usuario);
			limpiar();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return "";
	}
	
	public String cambiarContra() {
		try {

			Usuario user = (Usuario)FacesUtils.getfromSession("usuario");
			if (user.getContrasena().equals(txtContrasenaActual.getValue().toString())) {
				Date fecha = new Date();
				Usuario usuario=(Usuario)FacesUtils.getfromSession("usuario");
				usuario.setContrasena(txtContrasena.getValue().toString());
				usuario.setFechamodificacion(fecha);
				usuario.setUsuariomodificador(usuario.getCorreo());

				businessDelegatorView.updateUsuario(usuario);
				FacesContext.getCurrentInstance().addMessage("",
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Contraseña modificada exitosamente.", "Puede verificar su nueva contraseña en el correo electronico."));
				
			}else {
				
				FacesContext.getCurrentInstance().addMessage("",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "La contraseña actual no es la correcta.", "Verifique que este ingresando la contraseña actual."));
				
			}
			
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
		return "";
	}

	public String action_create() {
		try {
			entity = new Usuario();

			Integer idusuario = FacesUtils.checkInteger(txtIdusuario);

			entity.setActivo(FacesUtils.checkString(txtActivo));
			entity.setContrasena(FacesUtils.checkString(txtContrasena));
			entity.setCorreo(FacesUtils.checkString(txtCorreo));
			entity.setFechacreacion(FacesUtils.checkDate(txtFechacreacion));
			entity.setFechamodificacion(FacesUtils.checkDate(txtFechamodificacion));
			entity.setIdusuario(idusuario);
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setUsuariocreador(FacesUtils.checkString(txtUsuariocreador));
			entity.setUsuariomodificador(FacesUtils.checkString(txtUsuariomodificador));
			entity.setCargo((FacesUtils.checkInteger(txtIdcargo_Cargo) != null)
					? businessDelegatorView.getCargo(FacesUtils.checkInteger(txtIdcargo_Cargo))
					: null);
			entity.setTipousuario((FacesUtils.checkInteger(txtIdtipousuario_Tipousuario) != null)
					? businessDelegatorView.getTipousuario(FacesUtils.checkInteger(txtIdtipousuario_Tipousuario))
					: null);
			businessDelegatorView.saveUsuario(entity);
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
				Integer idusuario = new Integer(selectedUsuario.getIdusuario());
				entity = businessDelegatorView.getUsuario(idusuario);
			}

			entity.setActivo(FacesUtils.checkString(txtActivo));
			entity.setContrasena(FacesUtils.checkString(txtContrasena));
			entity.setCorreo(FacesUtils.checkString(txtCorreo));
			entity.setFechacreacion(FacesUtils.checkDate(txtFechacreacion));
			entity.setFechamodificacion(FacesUtils.checkDate(txtFechamodificacion));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setUsuariocreador(FacesUtils.checkString(txtUsuariocreador));
			entity.setUsuariomodificador(FacesUtils.checkString(txtUsuariomodificador));
			entity.setCargo((FacesUtils.checkInteger(txtIdcargo_Cargo) != null)
					? businessDelegatorView.getCargo(FacesUtils.checkInteger(txtIdcargo_Cargo))
					: null);
			entity.setTipousuario((FacesUtils.checkInteger(txtIdtipousuario_Tipousuario) != null)
					? businessDelegatorView.getTipousuario(FacesUtils.checkInteger(txtIdtipousuario_Tipousuario))
					: null);
			businessDelegatorView.updateUsuario(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedUsuario = (UsuarioDTO) (evt.getComponent().getAttributes().get("selectedUsuario"));

			Integer idusuario = new Integer(selectedUsuario.getIdusuario());
			entity = businessDelegatorView.getUsuario(idusuario);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Integer idusuario = FacesUtils.checkInteger(txtIdusuario);
			entity = businessDelegatorView.getUsuario(idusuario);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteUsuario(entity);
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

	public String action_modifyWitDTO(String activo, String contrasena, String correo, Date fechacreacion,
			Date fechamodificacion, Integer idusuario, String nombre, String usuariocreador, String usuariomodificador,
			Integer idcargo_Cargo, Integer idtipousuario_Tipousuario) throws Exception {
		try {
			entity.setActivo(FacesUtils.checkString(activo));
			entity.setContrasena(FacesUtils.checkString(contrasena));
			entity.setCorreo(FacesUtils.checkString(correo));
			entity.setFechacreacion(FacesUtils.checkDate(fechacreacion));
			entity.setFechamodificacion(FacesUtils.checkDate(fechamodificacion));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setUsuariocreador(FacesUtils.checkString(usuariocreador));
			entity.setUsuariomodificador(FacesUtils.checkString(usuariomodificador));
			businessDelegatorView.updateUsuario(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("UsuarioView").requestRender();
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

	public Password getTxtContrasena() {
		return txtContrasena;
	}

	public void setTxtContrasena(Password txtContrasena) {
		this.txtContrasena = txtContrasena;
	}

	public InputText getTxtCorreo() {
		return txtCorreo;
	}

	public void setTxtCorreo(InputText txtCorreo) {
		this.txtCorreo = txtCorreo;
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

	public InputText getTxtIdcargo_Cargo() {
		return txtIdcargo_Cargo;
	}

	public void setTxtIdcargo_Cargo(InputText txtIdcargo_Cargo) {
		this.txtIdcargo_Cargo = txtIdcargo_Cargo;
	}

	public InputText getTxtIdtipousuario_Tipousuario() {
		return txtIdtipousuario_Tipousuario;
	}

	public void setTxtIdtipousuario_Tipousuario(InputText txtIdtipousuario_Tipousuario) {
		this.txtIdtipousuario_Tipousuario = txtIdtipousuario_Tipousuario;
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

	public InputText getTxtIdusuario() {
		return txtIdusuario;
	}

	public void setTxtIdusuario(InputText txtIdusuario) {
		this.txtIdusuario = txtIdusuario;
	}

	public List<UsuarioDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataUsuario();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<UsuarioDTO> usuarioDTO) {
		this.data = usuarioDTO;
	}

	public UsuarioDTO getSelectedUsuario() {
		return selectedUsuario;
	}

	public void setSelectedUsuario(UsuarioDTO usuario) {
		this.selectedUsuario = usuario;
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

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public boolean isShowDialog() {
		return showDialog;
	}

	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}

	public SelectOneMenu getSomCargo() {
		return somCargo;
	}

	public void setSomCargo(SelectOneMenu somCargo) {
		this.somCargo = somCargo;
	}

	public List<SelectItem> getLosCargosSelectItem() throws Exception {
		if (losCargosSelectItem == null) {
			List<Cargo> losCargos = businessDelegatorView.getCargo();
			losCargosSelectItem = new ArrayList<>();
			for (Cargo cargo : losCargos) {
				losCargosSelectItem.add(
						new SelectItem(cargo.getIdcargo(), cargo.getIdcargo() + ". " + cargo.getNombre()));
			}
		}
		return losCargosSelectItem;
	}

	public void setLosCargosSelectItem(List<SelectItem> losCargosSelectItem) {
		this.losCargosSelectItem = losCargosSelectItem;
	}

	public Password getTxtContrasenaActual() {
		return txtContrasenaActual;
	}

	public void setTxtContrasenaActual(Password txtContrasenaActual) {
		this.txtContrasenaActual = txtContrasenaActual;
	}

	
}
