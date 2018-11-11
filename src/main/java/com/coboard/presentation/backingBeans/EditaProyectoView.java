package com.coboard.presentation.backingBeans;

import com.coboard.modelo.*;
import com.coboard.modelo.dto.ProyectoDTO;

import com.coboard.presentation.businessDelegate.*;

import com.coboard.utilities.*;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.selectonemenu.SelectOneMenu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;


/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class EditaProyectoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private String txtDescripcion;
    private String txtMinimopreguntas;
    private String txtNombre;
    private String txtPorcentajefiltro;
    private String txtUsuariocreador;
    private String txtUsuariomodificador;
    private String txtIdtipoproyecto_Tipoproyecto;
    private String txtIdproyecto;
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
    private List<ProyectoDTO> losProyectos;
    private Proyecto losProyectosEdita;
    private ProyectoDTO selectedProyecto;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public EditaProyectoView() {
        super();
    }

    public String actualizarProyecto() {
    	try {
    		Proyecto proyecto = (Proyecto)FacesUtils.getfromSession("proyecto");
			Date fecha = new Date();
			Integer num = 1;
			proyecto.setActivo(somActiva.getValue().toString().charAt(0));
			proyecto.setDescripcion(txtDescripcion);
			proyecto.setFechacreacion(fecha);
			proyecto.setFechafin(txtFechafin);
			proyecto.setFechainicio(txtFechainicio);
			proyecto.setMinimopreguntas(new Long(txtMinimopreguntas));
			proyecto.setNombre(txtNombre);
			proyecto.setPorcentajefiltro(new Long(txtPorcentajefiltro));
			proyecto.setUsuariocreador("CoBoard");
			Tipoproyecto tipoproyecto = businessDelegatorView.getTipoproyecto(num);
			proyecto.setTipoproyecto(tipoproyecto);
			
			businessDelegatorView.updateProyecto(proyecto);
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Proyecto actualizado con éxito!", ""));
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
    	return "";
    }
    
    public String limpiar() {
    	txtNombre = null;
		txtMinimopreguntas = null;
		txtPorcentajefiltro = null;
		txtFechainicio = new Date();
		txtFechafin = new Date();
		txtDescripcion = null;

		return "";
	}
    
    public String getTxtDescripcion() {
    	Proyecto proyecto=(Proyecto)FacesUtils.getfromSession("proyecto");
    	txtDescripcion = (proyecto.getDescripcion());
        return txtDescripcion;
    }

    public void setTxtDescripcion(String txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public String getTxtMinimopreguntas() {
    	Proyecto proyecto=(Proyecto)FacesUtils.getfromSession("proyecto");
    	txtMinimopreguntas = (proyecto.getMinimopreguntas().toString());
        return txtMinimopreguntas;
    }

    public void setTxtMinimopreguntas(String txtMinimopreguntas) {
        this.txtMinimopreguntas = txtMinimopreguntas;
    }

    public String getTxtNombre() {
    	Proyecto proyecto=(Proyecto)FacesUtils.getfromSession("proyecto");
    	txtNombre = (proyecto.getNombre());
        return txtNombre;
    }

    public void setTxtNombre(String txtNombre) {
        this.txtNombre = txtNombre;
    }

    public String getTxtPorcentajefiltro() {
    	Proyecto proyecto=(Proyecto)FacesUtils.getfromSession("proyecto");
    	txtPorcentajefiltro = (proyecto.getPorcentajefiltro().toString());
        return txtPorcentajefiltro;
    }

    public void setTxtPorcentajefiltro(String txtPorcentajefiltro) {
        this.txtPorcentajefiltro = txtPorcentajefiltro;
    }

    public String getTxtUsuariocreador() {
        return txtUsuariocreador;
    }

    public void setTxtUsuariocreador(String txtUsuariocreador) {
        this.txtUsuariocreador = txtUsuariocreador;
    }

    public String getTxtUsuariomodificador() {
        return txtUsuariomodificador;
    }

    public void setTxtUsuariomodificador(String txtUsuariomodificador) {
        this.txtUsuariomodificador = txtUsuariomodificador;
    }

    public String getTxtIdtipoproyecto_Tipoproyecto() {
        return txtIdtipoproyecto_Tipoproyecto;
    }

    public void setTxtIdtipoproyecto_Tipoproyecto(
    		String txtIdtipoproyecto_Tipoproyecto) {
        this.txtIdtipoproyecto_Tipoproyecto = txtIdtipoproyecto_Tipoproyecto;
    }

    public Date getTxtFechacreacion() {
        return txtFechacreacion;
    }

    public void setTxtFechacreacion(Date txtFechacreacion) {
        this.txtFechacreacion = txtFechacreacion;
    }

    public Date getTxtFechafin() {
    	Proyecto proyecto=(Proyecto)FacesUtils.getfromSession("proyecto");
    	txtFechafin=proyecto.getFechafin();
        return txtFechafin;
    }

    public void setTxtFechafin(Date txtFechafin) {
        this.txtFechafin = txtFechafin;
    }

    public Date getTxtFechainicio() {
    	Proyecto proyecto=(Proyecto)FacesUtils.getfromSession("proyecto");
    	txtFechainicio=proyecto.getFechainicio();
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

    public String getTxtIdproyecto() {
        return txtIdproyecto;
    }

    public void setTxtIdproyecto(String txtIdproyecto) {
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

	public List<ProyectoDTO> getLosProyectos() throws Exception{
		if(losProyectos == null){
			losProyectos = businessDelegatorView.getDataProyecto();
		}
		return losProyectos;
	}

	public void setLosProyectos(List<ProyectoDTO> losProyectos) {
		this.losProyectos = losProyectos;
	}

	public Proyecto getLosProyectosEdita() {
		return losProyectosEdita;
	}

	public void setLosProyectosEdita(Proyecto losProyectosEdita) {
		this.losProyectosEdita = losProyectosEdita;
	}	
}
