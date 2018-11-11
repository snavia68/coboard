package com.coboard.presentation.backingBeans;

import com.coboard.modelo.*;
import com.coboard.modelo.dto.ProyectousuarioDTO;
import com.coboard.presentation.businessDelegate.*;
import com.coboard.utilities.*;
import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class ProyectousuarioView implements Serializable {
    private static final long serialVersionUID = 1L;
    private InputText txtUsuariocreador;
    private InputText txtUsuariomodificador;
    private InputText txtIdproyecto_Proyecto;
    private InputText txtIdusuario_Usuario;
    private InputText txtIdproyectousuario;
    private Calendar txtFechacreacion;
    private Calendar txtFechamodificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<ProyectousuarioDTO> data;
    private List<Proyectousuario> listaProyectos;
    private List<Proyectousuario> proyectosUsuarioFiltrados;
    private List<Usuario> usuario;
    private List<Usuario> usuarioProyect;
    private List<Usuario> usuarioSelected;
    private List<Usuario> usuarioSelected2;
    private ProyectousuarioDTO selectedProyectousuario;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public ProyectousuarioView() {
        super();
    }
    
    public List<Proyectousuario> getListaProyectos() throws Exception{
    	if(listaProyectos == null){
    		listaProyectos = businessDelegatorView.getProyectousuario();
		}
		return listaProyectos;
	}

	public void setListaProyectos(List<Proyectousuario> listaProyectos) {
		this.listaProyectos = listaProyectos;
	}
	
	public List<Proyectousuario> getProyectosUsuarioFiltrados() {
		return proyectosUsuarioFiltrados;
	}

	public void setProyectosUsuarioFiltrados(List<Proyectousuario> proyectosUsuarioFiltrados) {
		this.proyectosUsuarioFiltrados = proyectosUsuarioFiltrados;
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

    public InputText getTxtIdusuario_Usuario() {
        return txtIdusuario_Usuario;
    }

    public void setTxtIdusuario_Usuario(InputText txtIdusuario_Usuario) {
        this.txtIdusuario_Usuario = txtIdusuario_Usuario;
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

    public InputText getTxtIdproyectousuario() {
        return txtIdproyectousuario;
    }

    public void setTxtIdproyectousuario(InputText txtIdproyectousuario) {
        this.txtIdproyectousuario = txtIdproyectousuario;
    }

    public List<ProyectousuarioDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataProyectousuario();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<ProyectousuarioDTO> proyectousuarioDTO) {
        this.data = proyectousuarioDTO;
    }

    public ProyectousuarioDTO getSelectedProyectousuario() {
        return selectedProyectousuario;
    }

    public void setSelectedProyectousuario(ProyectousuarioDTO proyectousuario) {
        this.selectedProyectousuario = proyectousuario;
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

	public List<Usuario> getUsuario() {
		if (usuario==null) {
			Proyecto proyecto=(Proyecto)FacesUtils.getfromSession("proyecto");
			
			usuario=businessDelegatorView.usuariosParaAsignacion(proyecto.getIdproyecto());
		}
		
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarioProyect() {
		if (usuarioProyect==null) {
			Proyecto proyecto=(Proyecto)FacesUtils.getfromSession("proyecto");
			
			usuarioProyect=businessDelegatorView.usuariosPorProyecto(proyecto.getIdproyecto());
		}
		return usuarioProyect;
	}

	public void setUsuarioProyect(List<Usuario> usuarioProyect) {
		this.usuarioProyect = usuarioProyect;
	}

	public List<Usuario> getUsuarioSelected() {
		return usuarioSelected;
	}

	public void setUsuarioSelected(List<Usuario> usuarioSelected) {
		this.usuarioSelected = usuarioSelected;
	}
    
	public void asignarUsuarios() throws Exception {
		
		for (int i = 0; i < usuarioSelected.size(); i++) {
			Proyecto proyecto=(Proyecto)FacesUtils.getfromSession("proyecto");
			Proyectousuario proyectousuario = new Proyectousuario();
			proyectousuario.setProyecto(proyecto);
			proyectousuario.setFechacreacion(new Date());
			proyectousuario.setUsuariocreador("CoBoard");
			proyectousuario.setUsuario(usuarioSelected.get(i));
			businessDelegatorView.saveProyectousuario(proyectousuario);
		}
		FacesUtils.addInfoMessage("Se vincularon los usuarios al proyecto exitosamente");
		usuario=null;
		usuarioProyect=null;
		usuarioSelected=null;
		usuarioSelected2=null;
	}
	
	public void desvincularUsuarios() throws Exception {
		
		for (int i = 0; i < usuarioSelected2.size(); i++) {
			Proyecto proyecto=(Proyecto)FacesUtils.getfromSession("proyecto");
			Proyectousuario proyectousuario = businessDelegatorView.buscarPorUsuario(usuarioSelected2.get(i).getIdusuario(), proyecto.getIdproyecto());
			
			businessDelegatorView.deleteProyectousuario(proyectousuario);
		}
		FacesUtils.addInfoMessage("Se desvincularon los usuarios al proyecto exitosamente");
		usuario=null;
		usuarioProyect=null;
		usuarioSelected=null;
		usuarioSelected2=null;
	}

	public List<Usuario> getUsuarioSelected2() {
		return usuarioSelected2;
	}

	public void setUsuarioSelected2(List<Usuario> usuarioSelected2) {
		this.usuarioSelected2 = usuarioSelected2;
	}
    
	
}
