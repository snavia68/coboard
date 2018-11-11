package com.coboard.presentation.backingBeans;

import com.coboard.modelo.Informacion;
import com.coboard.modelo.Sesion;
import com.coboard.modelo.Usuario;
import com.coboard.modelo.Votos;
import com.coboard.modelo.dto.VotosDTO;
import com.coboard.presentation.businessDelegate.*;
import com.coboard.utilities.FacesUtils;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class VotosView implements Serializable {
    private static final long serialVersionUID = 1L;
    private InputText txtActivo;
    private InputText txtUsuariocreador;
    private InputText txtUsuariomodificador;
    private InputText txtVoto;
    private InputText txtIdinformacion_Informacion;
    private InputText txtIdsesion_Sesion;
    private InputText txtIdvoto;
    private Calendar txtFechacreacion;
    private Calendar txtFechamodificacion;
    private CommandButton btnDeAcuerdo;
    private CommandButton btnDesacuerdo;
    private List<VotosDTO> data;
    private VotosDTO selectedVotos;
    private boolean showDialog;
    private Informacion informacion;
    
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public VotosView() {
        super();
    }
    
    public InputText getTxtActivo() {
        return txtActivo;
    }

    public void setTxtActivo(InputText txtActivo) {
        this.txtActivo = txtActivo;
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

    public InputText getTxtVoto() {
        return txtVoto;
    }

    public void setTxtVoto(InputText txtVoto) {
        this.txtVoto = txtVoto;
    }

    public InputText getTxtIdinformacion_Informacion() {
        return txtIdinformacion_Informacion;
    }

    public void setTxtIdinformacion_Informacion(
        InputText txtIdinformacion_Informacion) {
        this.txtIdinformacion_Informacion = txtIdinformacion_Informacion;
    }

    public InputText getTxtIdsesion_Sesion() {
        return txtIdsesion_Sesion;
    }

    public void setTxtIdsesion_Sesion(InputText txtIdsesion_Sesion) {
        this.txtIdsesion_Sesion = txtIdsesion_Sesion;
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

    public InputText getTxtIdvoto() {
        return txtIdvoto;
    }

    public void setTxtIdvoto(InputText txtIdvoto) {
        this.txtIdvoto = txtIdvoto;
    }

    public List<VotosDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataVotos();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<VotosDTO> votosDTO) {
        this.data = votosDTO;
    }

    public VotosDTO getSelectedVotos() {
        return selectedVotos;
    }

    public void setSelectedVotos(VotosDTO votos) {
        this.selectedVotos = votos;
    }
    
    public CommandButton getBtnDeAcuerdo() {
		return btnDeAcuerdo;
	}

	public void setBtnDeAcuerdo(CommandButton btnDeAcuerdo) {
		this.btnDeAcuerdo = btnDeAcuerdo;
	}

	public CommandButton getBtnDesacuerdo() {
		return btnDesacuerdo;
	}

	public void setBtnDesacuerdo(CommandButton btnDesacuerdo) {
		this.btnDesacuerdo = btnDesacuerdo;
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
    
    public String deAcuerdo() {
    	try {
    		Usuario usu=(Usuario)FacesUtils.getfromSession("usuario");
    		Sesion ses=(Sesion)FacesUtils.getfromSession("sesion");
    		Votos votos = businessDelegatorView.existeVoto(informacion.getIdinformacion(), usu.getIdusuario());
    		
    		if(votos == null) {
    			Votos voto = new Votos();
    			Date fecha = new Date();
    			voto.setActivo("S");
    			voto.setFechacreacion(fecha);
    			voto.setInformacion(informacion);
    			voto.setSesion(ses);
    			voto.setUsuariocreador(usu.getNombre());
    			voto.setVoto("Acuerdo");
    			
    			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO, "Voto registrado con éxito!", "Votó: De Acuerdo"));
    			businessDelegatorView.saveVotos(voto);
    		} else {
    			Date fechaModi = new Date();
    			votos.setFechamodificacion(fechaModi);
    			votos.setUsuariomodificador(usu.getNombre());
    			votos.setSesion(ses);
    			votos.setVoto("Acuerdo");
    			
    			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO, "Voto registrado con éxito!", "Votó: De Acuerdo"));
    			businessDelegatorView.updateVotos(votos);
    		}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
    	
    	return "";
    }
    
    public String desacuerdo() {
    	try {
    		Usuario usu=(Usuario)FacesUtils.getfromSession("usuario");
    		Sesion ses=(Sesion)FacesUtils.getfromSession("sesion");
    		Votos votos = businessDelegatorView.existeVoto(informacion.getIdinformacion(), usu.getIdusuario());
    		
    		if(votos == null) {
    			Votos voto = new Votos();
    			Date fecha = new Date();
    			voto.setActivo("S");
    			voto.setFechacreacion(fecha);
    			voto.setInformacion(informacion);
    			voto.setSesion(ses);
    			voto.setUsuariocreador(usu.getNombre());
    			voto.setVoto("Desacuerdo");
    			
    			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO, "Voto registrado con éxito!", "Votó: Desacuerdo"));
    			businessDelegatorView.saveVotos(voto);
    		} else {
    			Date fechaModi = new Date();
    			votos.setFechamodificacion(fechaModi);
    			votos.setSesion(ses);
    			votos.setUsuariomodificador(usu.getNombre());
    			votos.setVoto("Desacuerdo");
    			
    			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO, "Voto registrado con éxito!", "Votó: Desacuerdo"));
    			businessDelegatorView.updateVotos(votos);
    		}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
    	
    	return "";
    }

	public Informacion getInformacion() {
		return informacion;
	}

	public void setInformacion(Informacion informacion) {
		this.informacion = informacion;
	}
    
    
}