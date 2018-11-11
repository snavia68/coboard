package com.coboard.presentation.businessDelegate;

import com.coboard.aws.s3.IS3Services;
import com.coboard.modelo.Adjuntos;
import com.coboard.modelo.Cargo;
import com.coboard.modelo.Informacion;
import com.coboard.modelo.Proyecto;
import com.coboard.modelo.Proyectousuario;
import com.coboard.modelo.Sesion;
import com.coboard.modelo.Tipoproyecto;
import com.coboard.modelo.Tipousuario;
import com.coboard.modelo.Usuario;
import com.coboard.modelo.Votos;
import com.coboard.modelo.control.AdjuntosLogic;
import com.coboard.modelo.control.CargoLogic;
import com.coboard.modelo.control.IAdjuntosLogic;
import com.coboard.modelo.control.ICargoLogic;
import com.coboard.modelo.control.IInformacionLogic;
import com.coboard.modelo.control.IProyectoLogic;
import com.coboard.modelo.control.IProyectousuarioLogic;
import com.coboard.modelo.control.ISesionLogic;
import com.coboard.modelo.control.ITipoproyectoLogic;
import com.coboard.modelo.control.ITipousuarioLogic;
import com.coboard.modelo.control.IUsuarioLogic;
import com.coboard.modelo.control.IVotosLogic;
import com.coboard.modelo.control.InformacionLogic;
import com.coboard.modelo.control.ProyectoLogic;
import com.coboard.modelo.control.ProyectousuarioLogic;
import com.coboard.modelo.control.SesionLogic;
import com.coboard.modelo.control.TipoproyectoLogic;
import com.coboard.modelo.control.TipousuarioLogic;
import com.coboard.modelo.control.UsuarioLogic;
import com.coboard.modelo.control.VotosLogic;
import com.coboard.modelo.dto.AdjuntosDTO;
import com.coboard.modelo.dto.CargoDTO;
import com.coboard.modelo.dto.InformacionDTO;
import com.coboard.modelo.dto.ProyectoDTO;
import com.coboard.modelo.dto.ProyectousuarioDTO;
import com.coboard.modelo.dto.SesionDTO;
import com.coboard.modelo.dto.TipoproyectoDTO;
import com.coboard.modelo.dto.TipousuarioDTO;
import com.coboard.modelo.dto.UsuarioDTO;
import com.coboard.modelo.dto.VotosDTO;

import com.coboard.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;

import java.sql.*;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Use a Business Delegate to reduce coupling between presentation-tier clients and business services.
* The Business Delegate hides the underlying implementation details of the business service, such as lookup and access details of the EJB architecture.
*
* The Business Delegate acts as a client-side business abstraction; it provides an abstraction for, and thus hides,
* the implementation of the business services. Using a Business Delegate reduces the coupling between presentation-tier clients and
* the system's business services. Depending on the implementation strategy, the Business Delegate may shield clients from possible
* volatility in the implementation of the business service API. Potentially, this reduces the number of changes that must be made to the
* presentation-tier client code when the business service API or its underlying implementation changes.
*
* However, interface methods in the Business Delegate may still require modification if the underlying business service API changes.
* Admittedly, though, it is more likely that changes will be made to the business service rather than to the Business Delegate.
*
* Often, developers are skeptical when a design goal such as abstracting the business layer causes additional upfront work in return
* for future gains. However, using this pattern or its strategies results in only a small amount of additional upfront work and provides
* considerable benefits. The main benefit is hiding the details of the underlying service. For example, the client can become transparent
* to naming and lookup services. The Business Delegate also handles the exceptions from the business services, such as java.rmi.Remote
* exceptions, Java Messages Service (JMS) exceptions and so on. The Business Delegate may intercept such service level exceptions and
* generate application level exceptions instead. Application level exceptions are easier to handle by the clients, and may be user friendly.
* The Business Delegate may also transparently perform any retry or recovery operations necessary in the event of a service failure without
* exposing the client to the problem until it is determined that the problem is not resolvable. These gains present a compelling reason to
* use the pattern.
*
* Another benefit is that the delegate may cache results and references to remote business services. Caching can significantly improve performance,
* because it limits unnecessary and potentially costly round trips over the network.
*
* A Business Delegate uses a component called the Lookup Service. The Lookup Service is responsible for hiding the underlying implementation
* details of the business service lookup code. The Lookup Service may be written as part of the Delegate, but we recommend that it be
* implemented as a separate component, as outlined in the Service Locator pattern (See "Service Locator" on page 368.)
*
* When the Business Delegate is used with a Session Facade, typically there is a one-to-one relationship between the two.
* This one-to-one relationship exists because logic that might have been encapsulated in a Business Delegate relating to its interaction
* with multiple business services (creating a one-to-many relationship) will often be factored back into a Session Facade.
*
* Finally, it should be noted that this pattern could be used to reduce coupling between other tiers, not simply the presentation and the
* business tiers.
*
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("BusinessDelegatorView")
public class BusinessDelegatorView implements IBusinessDelegatorView {
    private static final Logger log = LoggerFactory.getLogger(BusinessDelegatorView.class);
    @Autowired
    private IAdjuntosLogic adjuntosLogic;
    @Autowired
    private ICargoLogic cargoLogic;
    @Autowired
    private IInformacionLogic informacionLogic;
    @Autowired
    private IProyectoLogic proyectoLogic;
    @Autowired
    private IProyectousuarioLogic proyectousuarioLogic;
    @Autowired
    private ISesionLogic sesionLogic;
    @Autowired
    private ITipoproyectoLogic tipoproyectoLogic;
    @Autowired
    private ITipousuarioLogic tipousuarioLogic;
    @Autowired
    private IUsuarioLogic usuarioLogic;
    @Autowired
    private IVotosLogic votosLogic;
    @Autowired
    private IS3Services s3services;

    public List<Adjuntos> getAdjuntos() throws Exception {
        return adjuntosLogic.getAdjuntos();
    }

    public void saveAdjuntos(Adjuntos entity) throws Exception {
        adjuntosLogic.saveAdjuntos(entity);
    }

    public void deleteAdjuntos(Adjuntos entity) throws Exception {
        adjuntosLogic.deleteAdjuntos(entity);
    }

    public void updateAdjuntos(Adjuntos entity) throws Exception {
        adjuntosLogic.updateAdjuntos(entity);
    }

    public Adjuntos getAdjuntos(Integer idadjuntos) throws Exception {
        Adjuntos adjuntos = null;

        try {
            adjuntos = adjuntosLogic.getAdjuntos(idadjuntos);
        } catch (Exception e) {
            throw e;
        }

        return adjuntos;
    }

    public List<Adjuntos> findByCriteriaInAdjuntos(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return adjuntosLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Adjuntos> findPageAdjuntos(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return adjuntosLogic.findPageAdjuntos(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberAdjuntos() throws Exception {
        return adjuntosLogic.findTotalNumberAdjuntos();
    }

    public List<AdjuntosDTO> getDataAdjuntos() throws Exception {
        return adjuntosLogic.getDataAdjuntos();
    }

    public void validateAdjuntos(Adjuntos adjuntos) throws Exception {
        adjuntosLogic.validateAdjuntos(adjuntos);
    }

    public List<Cargo> getCargo() throws Exception {
        return cargoLogic.getCargo();
    }

    public void saveCargo(Cargo entity) throws Exception {
        cargoLogic.saveCargo(entity);
    }

    public void deleteCargo(Cargo entity) throws Exception {
        cargoLogic.deleteCargo(entity);
    }

    public void updateCargo(Cargo entity) throws Exception {
        cargoLogic.updateCargo(entity);
    }

    public Cargo getCargo(Integer idcargo) throws Exception {
        Cargo cargo = null;

        try {
            cargo = cargoLogic.getCargo(idcargo);
        } catch (Exception e) {
            throw e;
        }

        return cargo;
    }

    public List<Cargo> findByCriteriaInCargo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return cargoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Cargo> findPageCargo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return cargoLogic.findPageCargo(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberCargo() throws Exception {
        return cargoLogic.findTotalNumberCargo();
    }

    public List<CargoDTO> getDataCargo() throws Exception {
        return cargoLogic.getDataCargo();
    }

    public void validateCargo(Cargo cargo) throws Exception {
        cargoLogic.validateCargo(cargo);
    }

    public List<Informacion> getInformacion() throws Exception {
        return informacionLogic.getInformacion();
    }

    public void saveInformacion(Informacion entity) throws Exception {
        informacionLogic.saveInformacion(entity);
    }

    public void deleteInformacion(Informacion entity) throws Exception {
        informacionLogic.deleteInformacion(entity);
    }

    public void updateInformacion(Informacion entity) throws Exception {
        informacionLogic.updateInformacion(entity);
    }

    public Informacion getInformacion(Integer idinformacion)
        throws Exception {
        Informacion informacion = null;

        try {
            informacion = informacionLogic.getInformacion(idinformacion);
        } catch (Exception e) {
            throw e;
        }

        return informacion;
    }

    public List<Informacion> findByCriteriaInInformacion(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return informacionLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Informacion> findPageInformacion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return informacionLogic.findPageInformacion(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberInformacion() throws Exception {
        return informacionLogic.findTotalNumberInformacion();
    }

    public List<InformacionDTO> getDataInformacion() throws Exception {
        return informacionLogic.getDataInformacion();
    }

    public void validateInformacion(Informacion informacion)
        throws Exception {
        informacionLogic.validateInformacion(informacion);
    }

    public List<Proyecto> getProyecto() throws Exception {
        return proyectoLogic.getProyecto();
    }

    public void saveProyecto(Proyecto entity) throws Exception {
        proyectoLogic.saveProyecto(entity);
    }

    public void deleteProyecto(Proyecto entity) throws Exception {
        proyectoLogic.deleteProyecto(entity);
    }

    public void updateProyecto(Proyecto entity) throws Exception {
        proyectoLogic.updateProyecto(entity);
    }

    public Proyecto getProyecto(Integer idproyecto) throws Exception {
        Proyecto proyecto = null;

        try {
            proyecto = proyectoLogic.getProyecto(idproyecto);
        } catch (Exception e) {
            throw e;
        }

        return proyecto;
    }

    public List<Proyecto> findByCriteriaInProyecto(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return proyectoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Proyecto> findPageProyecto(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return proyectoLogic.findPageProyecto(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberProyecto() throws Exception {
        return proyectoLogic.findTotalNumberProyecto();
    }

    public List<ProyectoDTO> getDataProyecto() throws Exception {
        return proyectoLogic.getDataProyecto();
    }

    public void validateProyecto(Proyecto proyecto) throws Exception {
        proyectoLogic.validateProyecto(proyecto);
    }

    public List<Proyectousuario> getProyectousuario() throws Exception {
        return proyectousuarioLogic.getProyectousuario();
    }

    public void saveProyectousuario(Proyectousuario entity)
        throws Exception {
        proyectousuarioLogic.saveProyectousuario(entity);
    }

    public void deleteProyectousuario(Proyectousuario entity)
        throws Exception {
        proyectousuarioLogic.deleteProyectousuario(entity);
    }

    public void updateProyectousuario(Proyectousuario entity)
        throws Exception {
        proyectousuarioLogic.updateProyectousuario(entity);
    }

    public Proyectousuario getProyectousuario(Integer idproyectousuario)
        throws Exception {
        Proyectousuario proyectousuario = null;

        try {
            proyectousuario = proyectousuarioLogic.getProyectousuario(idproyectousuario);
        } catch (Exception e) {
            throw e;
        }

        return proyectousuario;
    }

    public List<Proyectousuario> findByCriteriaInProyectousuario(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return proyectousuarioLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Proyectousuario> findPageProyectousuario(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return proyectousuarioLogic.findPageProyectousuario(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberProyectousuario() throws Exception {
        return proyectousuarioLogic.findTotalNumberProyectousuario();
    }

    public List<ProyectousuarioDTO> getDataProyectousuario()
        throws Exception {
        return proyectousuarioLogic.getDataProyectousuario();
    }

    public void validateProyectousuario(Proyectousuario proyectousuario)
        throws Exception {
        proyectousuarioLogic.validateProyectousuario(proyectousuario);
    }

    public List<Sesion> getSesion() throws Exception {
        return sesionLogic.getSesion();
    }

    public void saveSesion(Sesion entity) throws Exception {
        sesionLogic.saveSesion(entity);
    }

    public void deleteSesion(Sesion entity) throws Exception {
        sesionLogic.deleteSesion(entity);
    }

    public void updateSesion(Sesion entity) throws Exception {
        sesionLogic.updateSesion(entity);
    }

    public Sesion getSesion(Integer idsesion) throws Exception {
        Sesion sesion = null;

        try {
            sesion = sesionLogic.getSesion(idsesion);
        } catch (Exception e) {
            throw e;
        }

        return sesion;
    }

    public List<Sesion> findByCriteriaInSesion(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return sesionLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Sesion> findPageSesion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return sesionLogic.findPageSesion(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberSesion() throws Exception {
        return sesionLogic.findTotalNumberSesion();
    }

    public List<SesionDTO> getDataSesion() throws Exception {
        return sesionLogic.getDataSesion();
    }

    public void validateSesion(Sesion sesion) throws Exception {
        sesionLogic.validateSesion(sesion);
    }

    public List<Tipoproyecto> getTipoproyecto() throws Exception {
        return tipoproyectoLogic.getTipoproyecto();
    }

    public void saveTipoproyecto(Tipoproyecto entity) throws Exception {
        tipoproyectoLogic.saveTipoproyecto(entity);
    }

    public void deleteTipoproyecto(Tipoproyecto entity)
        throws Exception {
        tipoproyectoLogic.deleteTipoproyecto(entity);
    }

    public void updateTipoproyecto(Tipoproyecto entity)
        throws Exception {
        tipoproyectoLogic.updateTipoproyecto(entity);
    }

    public Tipoproyecto getTipoproyecto(Integer idtipoproyecto)
        throws Exception {
        Tipoproyecto tipoproyecto = null;

        try {
            tipoproyecto = tipoproyectoLogic.getTipoproyecto(idtipoproyecto);
        } catch (Exception e) {
            throw e;
        }

        return tipoproyecto;
    }

    public List<Tipoproyecto> findByCriteriaInTipoproyecto(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return tipoproyectoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Tipoproyecto> findPageTipoproyecto(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tipoproyectoLogic.findPageTipoproyecto(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoproyecto() throws Exception {
        return tipoproyectoLogic.findTotalNumberTipoproyecto();
    }

    public List<TipoproyectoDTO> getDataTipoproyecto()
        throws Exception {
        return tipoproyectoLogic.getDataTipoproyecto();
    }

    public void validateTipoproyecto(Tipoproyecto tipoproyecto)
        throws Exception {
        tipoproyectoLogic.validateTipoproyecto(tipoproyecto);
    }

    public List<Tipousuario> getTipousuario() throws Exception {
        return tipousuarioLogic.getTipousuario();
    }

    public void saveTipousuario(Tipousuario entity) throws Exception {
        tipousuarioLogic.saveTipousuario(entity);
    }

    public void deleteTipousuario(Tipousuario entity) throws Exception {
        tipousuarioLogic.deleteTipousuario(entity);
    }

    public void updateTipousuario(Tipousuario entity) throws Exception {
        tipousuarioLogic.updateTipousuario(entity);
    }

    public Tipousuario getTipousuario(Integer idtipousuario)
        throws Exception {
        Tipousuario tipousuario = null;

        try {
            tipousuario = tipousuarioLogic.getTipousuario(idtipousuario);
        } catch (Exception e) {
            throw e;
        }

        return tipousuario;
    }

    public List<Tipousuario> findByCriteriaInTipousuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return tipousuarioLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Tipousuario> findPageTipousuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tipousuarioLogic.findPageTipousuario(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipousuario() throws Exception {
        return tipousuarioLogic.findTotalNumberTipousuario();
    }

    public List<TipousuarioDTO> getDataTipousuario() throws Exception {
        return tipousuarioLogic.getDataTipousuario();
    }

    public void validateTipousuario(Tipousuario tipousuario)
        throws Exception {
        tipousuarioLogic.validateTipousuario(tipousuario);
    }

    public List<Usuario> getUsuario() throws Exception {
        return usuarioLogic.getUsuario();
    }

    public void saveUsuario(Usuario entity) throws Exception {
        usuarioLogic.saveUsuario(entity);
    }

    public void deleteUsuario(Usuario entity) throws Exception {
        usuarioLogic.deleteUsuario(entity);
    }

    public void updateUsuario(Usuario entity) throws Exception {
        usuarioLogic.updateUsuario(entity);
    }

    public Usuario getUsuario(Integer idusuario) throws Exception {
        Usuario usuario = null;

        try {
            usuario = usuarioLogic.getUsuario(idusuario);
        } catch (Exception e) {
            throw e;
        }

        return usuario;
    }

    public List<Usuario> findByCriteriaInUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return usuarioLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Usuario> findPageUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return usuarioLogic.findPageUsuario(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberUsuario() throws Exception {
        return usuarioLogic.findTotalNumberUsuario();
    }

    public List<UsuarioDTO> getDataUsuario() throws Exception {
        return usuarioLogic.getDataUsuario();
    }

    public void validateUsuario(Usuario usuario) throws Exception {
        usuarioLogic.validateUsuario(usuario);
    }

    public List<Votos> getVotos() throws Exception {
        return votosLogic.getVotos();
    }

    public void saveVotos(Votos entity) throws Exception {
        votosLogic.saveVotos(entity);
    }

    public void deleteVotos(Votos entity) throws Exception {
        votosLogic.deleteVotos(entity);
    }

    public void updateVotos(Votos entity) throws Exception {
        votosLogic.updateVotos(entity);
    }

    public Votos getVotos(Integer idvoto) throws Exception {
        Votos votos = null;

        try {
            votos = votosLogic.getVotos(idvoto);
        } catch (Exception e) {
            throw e;
        }

        return votos;
    }

    public List<Votos> findByCriteriaInVotos(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return votosLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Votos> findPageVotos(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return votosLogic.findPageVotos(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberVotos() throws Exception {
        return votosLogic.findTotalNumberVotos();
    }

    public List<VotosDTO> getDataVotos() throws Exception {
        return votosLogic.getDataVotos();
    }

    public void validateVotos(Votos votos) throws Exception {
        votosLogic.validateVotos(votos);
    }

	@Override
	public Usuario getUsuarioByEmail(String correo){
		return usuarioLogic.getUsuarioByEmail(correo);
	}

	@Override
	public List<Usuario> usuariosParaAsignacion(Integer idProyecto) {
		return usuarioLogic.usuariosParaAsignacion(idProyecto);
	}

	@Override
	public List<Usuario> usuariosPorProyecto(Integer idProyecto) {
		return proyectousuarioLogic.usuariosPorProyecto(idProyecto);
	}

	@Override
	public Proyectousuario buscarPorUsuario(Integer idUsuario, Integer idProyecto) {
		return proyectousuarioLogic.buscarPorUsuario(idUsuario, idProyecto);
	}

	public void createBucket(String bucketName) throws Exception {
		s3services.createBucket(bucketName);
		
	}

	@Override
	public String uploadPrivate(String bucketName, String key, File file) throws Exception {
		return s3services.uploadPrivate(bucketName, key, file);
	}

	@Override
	public String uploadPublicRead(String bucketName, String key, File file) throws Exception {
		return s3services.uploadPublicRead(bucketName, key, file);
	}

	@Override
	public List<String> listBucketsName() throws Exception {
		return s3services.listBucketsName();
	}

	@Override
	public InputStream download(String bucketName, String key) throws Exception {
		return s3services.download(bucketName, key);
	}

	@Override
	public void deleteObject(String bucketName, String key) throws Exception {
		s3services.deleteObject(bucketName, key);
	}

	@Override
	public void deleteBucket(String bucketName) throws Exception {
		s3services.deleteBucket(bucketName);
	}

	@Override
	public String getUrl(String bucketName, String key) throws Exception {
		return s3services.getUrl(bucketName, key);
	}

	@Override
	public List<Informacion> getVariableByProject(Proyecto proyecto) {
		
		return informacionLogic.getVariableByProject(proyecto);
	}

	@Override
	public Adjuntos findAdjuntoByInformacion(Integer idinformacion) throws Exception {
		return adjuntosLogic.findAdjuntoByInformacion(idinformacion);
	}

	@Override
	public List<Proyecto> proyectosPorUsuario(Integer idUsuario) {
		return proyectousuarioLogic.proyectosPorUsuario(idUsuario);
	}

	@Override
	public List<Informacion> listarVariablesProyecto(Proyecto proyecto) throws Exception {
		return informacionLogic.listarVariablesProyecto(proyecto);
	}

	@Override
	public List<VotosDTO> votosDeUsuarios(Proyecto proyecto) {
		return votosLogic.votosDeUsuarios(proyecto);
	}
	
	@Override
	public Votos existeVoto(Integer idinformacion, Integer idusuario) {
		return votosLogic.existeVoto(idinformacion, idusuario);
	}

	@Override
	public List<String> nombresUsuarios(Proyecto proyecto) {
		return usuarioLogic.nombresUsuarios(proyecto);
	}

	@Override
	public List<Usuario> usuariosConectados(Proyecto proyecto) {
		return usuarioLogic.usuariosConectados(proyecto);
	}
	
	@Override
	public List<VotosDTO> votosDeUsuarioPorProyecto(Proyecto proyecto, Usuario usuario) {
		return votosLogic.votosDeUsuarioPorProyecto(proyecto, usuario);
	}
}
