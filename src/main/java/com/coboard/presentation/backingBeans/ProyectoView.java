package com.coboard.presentation.backingBeans;

import com.coboard.exceptions.*;

import com.coboard.modelo.*;
import com.coboard.modelo.dto.ProyectoDTO;
import com.coboard.modelo.dto.VotosDTO;
import com.coboard.presentation.businessDelegate.*;

import com.coboard.utilities.*;

import org.joda.time.DateTime;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputnumber.InputNumber;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;


/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class ProyectoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private InputTextarea txtDescripcion;
    private InputNumber txtMinimopreguntas;
    private InputText txtNombre;
    private InputNumber txtPorcentajefiltro;
    private InputText txtUsuariocreador;
    private InputText txtUsuariomodificador;
    private InputText txtIdtipoproyecto_Tipoproyecto;
    private InputText txtIdproyecto;
    private Date txtFechacreacion;
    private Date txtFechafin;
    private Date txtFechainicio;
    private Date txtFechamodificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private SelectOneMenu somActiva;
    private SelectOneMenu somTipoProyecto;
    private List<ProyectoDTO> data;
    private List<SelectItem> losTipoProyectoSelectItem;
    private List<Proyecto> losProyectos;
    private List<Proyecto> proyectosFiltrados;
    private Proyecto losProyectosEdita;
    private ProyectoDTO selectedProyecto;
    private Proyecto entity;
    private boolean showDialog;
    
    private List<VotosDTO> losVotos;
    private List<String> losUsuarios;
    
    private List<Usuario> usuariosOnline;
    private List<Mensaje> losMensajes;
    
    private String mensaje;
    
    private int idusuario;
    
    Proyecto proyecto;
    
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    @PostConstruct
    public void init() {
    	proyecto =  (Proyecto)FacesUtils.getfromSession("proyecto");
    }
    
    public String crearProyecto() {
    	try {
    		Proyecto proyecto = new Proyecto();
			Date fecha = new Date();
			Integer filtroInicial = 1;
			proyecto.setActivo(somActiva.getValue().toString().charAt(0));
			proyecto.setDescripcion(txtDescripcion.getValue().toString());
			proyecto.setFechacreacion(fecha);
			proyecto.setFechafin(txtFechafin);
			proyecto.setFechainicio(txtFechainicio);
			proyecto.setMinimopreguntas(new Long(txtMinimopreguntas.getValue().toString()));
			proyecto.setNombre(txtNombre.getValue().toString());
			proyecto.setPorcentajefiltro(new Long(txtPorcentajefiltro.getValue().toString()));
			proyecto.setUsuariocreador("CoBoard");
			Tipoproyecto tipoproyecto = businessDelegatorView.getTipoproyecto(Integer.parseInt(somTipoProyecto.getValue().toString()));
			proyecto.setTipoproyecto(tipoproyecto);
			proyecto.setFiltro(filtroInicial);
			
			FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO, "¡El proyecto " + txtNombre.getValue().toString() + " ha sido creado con éxito!", ""));
			businessDelegatorView.saveProyecto(proyecto);
			
			txtNombre.resetValue();
			txtMinimopreguntas.resetValue();
			txtPorcentajefiltro.resetValue();
			txtFechainicio = new Date();
			txtFechafin = new Date();
			txtDescripcion.resetValue();
			
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
    	return "vistaProyectos.xhtml";
    }
    
    public String limpiar() {
    	txtNombre.resetValue();
		txtMinimopreguntas.resetValue();
		txtPorcentajefiltro.resetValue();
		txtFechainicio = new Date();
		txtFechafin = new Date();
		txtDescripcion.resetValue();

		return "";
	}

    public InputTextarea getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(InputTextarea txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public InputNumber getTxtMinimopreguntas() {
        return txtMinimopreguntas;
    }

    public void setTxtMinimopreguntas(InputNumber txtMinimopreguntas) {
        this.txtMinimopreguntas = txtMinimopreguntas;
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public InputNumber getTxtPorcentajefiltro() {
        return txtPorcentajefiltro;
    }

    public void setTxtPorcentajefiltro(InputNumber txtPorcentajefiltro) {
        this.txtPorcentajefiltro = txtPorcentajefiltro;
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

    public InputText getTxtIdtipoproyecto_Tipoproyecto() {
        return txtIdtipoproyecto_Tipoproyecto;
    }

    public void setTxtIdtipoproyecto_Tipoproyecto(
        InputText txtIdtipoproyecto_Tipoproyecto) {
        this.txtIdtipoproyecto_Tipoproyecto = txtIdtipoproyecto_Tipoproyecto;
    }

    public Date getTxtFechacreacion() {
        return txtFechacreacion;
    }

    public void setTxtFechacreacion(Date txtFechacreacion) {
        this.txtFechacreacion = txtFechacreacion;
    }

    public Date getTxtFechafin() {
        return txtFechafin;
    }

    public void setTxtFechafin(Date txtFechafin) {
        this.txtFechafin = txtFechafin;
    }

    public Date getTxtFechainicio() {
        return txtFechainicio;
    }

    public void setTxtFechainicio(Date txtFechainicio) {
        this.txtFechainicio = txtFechainicio;
    }

    public Date getTxtFechamodificacion() {
        return txtFechamodificacion;
    }

    public void setTxtFechamodificacion(Date txtFechamodificacion) {
        this.txtFechamodificacion = txtFechamodificacion;
    }

    public InputText getTxtIdproyecto() {
        return txtIdproyecto;
    }

    public void setTxtIdproyecto(InputText txtIdproyecto) {
        this.txtIdproyecto = txtIdproyecto;
    }

    public List<ProyectoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataProyecto();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<ProyectoDTO> proyectoDTO) {
        this.data = proyectoDTO;
    }

    public ProyectoDTO getSelectedProyecto() {
        return selectedProyecto;
    }

    public void setSelectedProyecto(ProyectoDTO proyecto) {
        this.selectedProyecto = proyecto;
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

	public SelectOneMenu getSomActiva() {
		return somActiva;
	}

	public void setSomActiva(SelectOneMenu somActiva) {
		this.somActiva = somActiva;
	}

	public SelectOneMenu getSomTipoProyecto() {
		return somTipoProyecto;
	}

	public void setSomTipoProyecto(SelectOneMenu somTipoProyecto) {
		this.somTipoProyecto = somTipoProyecto;
	}

	public List<SelectItem> getLosTipoProyectoSelectItem() throws Exception{
		if(losTipoProyectoSelectItem==null) {
			List<Tipoproyecto> losTipoProyecto=businessDelegatorView.getTipoproyecto();
			losTipoProyectoSelectItem=new ArrayList<>();
			for(Tipoproyecto tipoProyecto: losTipoProyecto) {
				losTipoProyectoSelectItem.add(new SelectItem(tipoProyecto.getIdtipoproyecto(), tipoProyecto.getIdtipoproyecto()+" - "+tipoProyecto.getNombre()));
			}
		}
		return losTipoProyectoSelectItem;
	}

	public void setLosTipoProyectoSelectItem(List<SelectItem> losTipoProyectoSelectItem) {
		this.losTipoProyectoSelectItem = losTipoProyectoSelectItem;
	}

	public List<Proyecto> getLosProyectos() throws Exception{
		if(losProyectos == null){
			losProyectos = businessDelegatorView.getProyecto();
		}
		return losProyectos;
	}

	public void setLosProyectos(List<Proyecto> losProyectos) {
		this.losProyectos = losProyectos;
	}

	public Proyecto getLosProyectosEdita() {
		return losProyectosEdita;
	}

	public void setLosProyectosEdita(Proyecto losProyectosEdita) {
		this.losProyectosEdita = losProyectosEdita;
	}

	public String editarProyecto() {
		FacesUtils.putinSession("proyecto", losProyectosEdita);
		return "editaProyectos.xhtml";
		
	}

	public List<Proyecto> getProyectosFiltrados() {
		return proyectosFiltrados;
	}

	public void setProyectosFiltrados(List<Proyecto> proyectosFiltrados) {
		this.proyectosFiltrados = proyectosFiltrados;
	}

	public List<VotosDTO> getLosVotos() {
		Proyecto proyecto =  (Proyecto)FacesUtils.getfromSession("proyecto");
		losVotos=businessDelegatorView.votosDeUsuarios(proyecto);
		
		return losVotos;
	}

	public void setLosVotos(List<VotosDTO> losVotos) {
		this.losVotos = losVotos;
	}

	public List<String> getLosUsuarios() {
		losUsuarios = businessDelegatorView.nombresUsuarios(proyecto);
		return losUsuarios;
	}

	public void setLosUsuarios(List<String> losUsuarios) {
		this.losUsuarios = losUsuarios;
	}

	public List<Usuario> getUsuariosOnline() {
		
		Proyecto proyecto =  (Proyecto)FacesUtils.getfromSession("proyecto");
		usuariosOnline = businessDelegatorView.usuariosConectados(proyecto);
		
		return usuariosOnline;
	}

	public void setUsuariosOnline(List<Usuario> usuariosOnline) {
		this.usuariosOnline = usuariosOnline;
	}

	public List<Mensaje> getLosMensajes() throws Exception {
		
		proyecto =  (Proyecto)FacesUtils.getfromSession("proyecto");
		losMensajes = businessDelegatorView.mensajesPorProyecto(proyecto.getIdproyecto());
		
		return losMensajes;
	}

	public void setLosMensajes(List<Mensaje> losMensajes) {
		this.losMensajes = losMensajes;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}	
	
	public String sendMessage() {
		try {
			proyecto =  (Proyecto)FacesUtils.getfromSession("proyecto");
			Usuario usu=(Usuario)FacesUtils.getfromSession("usuario");
			
			DateTime now = DateTime.now();
			Date date = now.toDate();
			
			Mensaje msj = new Mensaje();
			
			msj.setIdproyecto(proyecto.getIdproyecto());
			msj.setIdusuario(usu.getIdusuario());
			msj.setUsuario(usu.getNombre());
			msj.setFecha(new Date());
			msj.setHora(date);
			msj.setMensaje(mensaje);
			
			businessDelegatorView.saveMensaje(msj);;
			
			mensaje= "";
			
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
    	return "";
	}

	public int getIdusuario() {
		Usuario usu=(Usuario)FacesUtils.getfromSession("usuario");
		idusuario = usu.getIdusuario();
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	
	
	
}
