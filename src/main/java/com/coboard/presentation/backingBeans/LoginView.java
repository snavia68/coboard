package com.coboard.presentation.backingBeans;

import com.coboard.modelo.Usuario;
import com.coboard.utilities.*;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;


@ViewScoped
@ManagedBean(name = "loginView")
public class LoginView {
    private String userId;
    private String password;
    @ManagedProperty(value = "#{authenticationManager}")
    private AuthenticationManager authenticationManager = null;

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(
        AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String login() {
        try {
            Authentication request = new UsernamePasswordAuthenticationToken(this.getUserId(),
                    this.getPassword());
            Authentication result = authenticationManager.authenticate(request);
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(result);

            FacesUtils.getHttpSession(true)
                      .setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
            
            Usuario usuario=(Usuario)FacesUtils.getfromSession("usuario");
            
            if (usuario.getTipousuario().getIdtipousuario()==1) {
            	return "/XHTML/inicioUsuario.xhtml";
            }
            if (usuario.getTipousuario().getIdtipousuario()==2) {
            	return "vistaProyectos.xhtml";
            }
            
        } catch (AuthenticationException e) {
            FacesUtils.addErrorMessage("Hay un error con el correo electronico o la contraseña");
            return "/login.xhtml";
        }

        return "/XHTML/menuUsuario.xhtml";
    }
    
    public String register() {
    	return "registro.xhtml";
    }
    
}
