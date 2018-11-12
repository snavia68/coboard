package com.coboard.presentation.businessDelegate;

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

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IBusinessDelegatorView {
    public List<Adjuntos> getAdjuntos() throws Exception;

    public void saveAdjuntos(Adjuntos entity) throws Exception;

    public void deleteAdjuntos(Adjuntos entity) throws Exception;

    public void updateAdjuntos(Adjuntos entity) throws Exception;

    public Adjuntos getAdjuntos(Integer idadjuntos) throws Exception;

    public List<Adjuntos> findByCriteriaInAdjuntos(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Adjuntos> findPageAdjuntos(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberAdjuntos() throws Exception;

    public List<AdjuntosDTO> getDataAdjuntos() throws Exception;

    public void validateAdjuntos(Adjuntos adjuntos) throws Exception;
    
    public Adjuntos findAdjuntoByInformacion(Integer idinformacion) throws Exception;

    public List<Cargo> getCargo() throws Exception;

    public void saveCargo(Cargo entity) throws Exception;

    public void deleteCargo(Cargo entity) throws Exception;

    public void updateCargo(Cargo entity) throws Exception;

    public Cargo getCargo(Integer idcargo) throws Exception;

    public List<Cargo> findByCriteriaInCargo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Cargo> findPageCargo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCargo() throws Exception;

    public List<CargoDTO> getDataCargo() throws Exception;

    public void validateCargo(Cargo cargo) throws Exception;

    public List<Informacion> getInformacion() throws Exception;

    public void saveInformacion(Informacion entity) throws Exception;

    public void deleteInformacion(Informacion entity) throws Exception;

    public void updateInformacion(Informacion entity) throws Exception;
    
    public List<Informacion> listarVariablesProyecto(Proyecto proyecto) throws Exception;
    
    public Informacion getInformacion(Integer idinformacion)
        throws Exception;

    public List<Informacion> findByCriteriaInInformacion(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Informacion> findPageInformacion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberInformacion() throws Exception;

    public List<InformacionDTO> getDataInformacion() throws Exception;

    public void validateInformacion(Informacion informacion)
        throws Exception;

    public List<Proyecto> getProyecto() throws Exception;

    public void saveProyecto(Proyecto entity) throws Exception;

    public void deleteProyecto(Proyecto entity) throws Exception;

    public void updateProyecto(Proyecto entity) throws Exception;

    public Proyecto getProyecto(Integer idproyecto) throws Exception;

    public List<Proyecto> findByCriteriaInProyecto(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Proyecto> findPageProyecto(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberProyecto() throws Exception;

    public List<ProyectoDTO> getDataProyecto() throws Exception;

    public void validateProyecto(Proyecto proyecto) throws Exception;
    
    public Integer cantidadUsuariosPorProyecto (Proyecto proyecto);

    public List<Proyectousuario> getProyectousuario() throws Exception;

    public void saveProyectousuario(Proyectousuario entity)
        throws Exception;

    public void deleteProyectousuario(Proyectousuario entity)
        throws Exception;

    public void updateProyectousuario(Proyectousuario entity)
        throws Exception;

    public Proyectousuario getProyectousuario(Integer idproyectousuario)
        throws Exception;

    public List<Proyectousuario> findByCriteriaInProyectousuario(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<Proyectousuario> findPageProyectousuario(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberProyectousuario() throws Exception;

    public List<ProyectousuarioDTO> getDataProyectousuario()
        throws Exception;

    public void validateProyectousuario(Proyectousuario proyectousuario)
        throws Exception;

    public List<Sesion> getSesion() throws Exception;

    public void saveSesion(Sesion entity) throws Exception;

    public void deleteSesion(Sesion entity) throws Exception;

    public void updateSesion(Sesion entity) throws Exception;

    public Sesion getSesion(Integer idsesion) throws Exception;

    public List<Sesion> findByCriteriaInSesion(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Sesion> findPageSesion(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;
    
    public List<Sesion> sesionesEntreFechas (Date fechaInicio, Date fechaFin);

    public Long findTotalNumberSesion() throws Exception;

    public List<SesionDTO> getDataSesion() throws Exception;

    public void validateSesion(Sesion sesion) throws Exception;

    public List<Tipoproyecto> getTipoproyecto() throws Exception;

    public void saveTipoproyecto(Tipoproyecto entity) throws Exception;

    public void deleteTipoproyecto(Tipoproyecto entity)
        throws Exception;

    public void updateTipoproyecto(Tipoproyecto entity)
        throws Exception;

    public Tipoproyecto getTipoproyecto(Integer idtipoproyecto)
        throws Exception;

    public List<Tipoproyecto> findByCriteriaInTipoproyecto(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tipoproyecto> findPageTipoproyecto(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoproyecto() throws Exception;

    public List<TipoproyectoDTO> getDataTipoproyecto()
        throws Exception;

    public void validateTipoproyecto(Tipoproyecto tipoproyecto)
        throws Exception;

    public List<Tipousuario> getTipousuario() throws Exception;

    public void saveTipousuario(Tipousuario entity) throws Exception;

    public void deleteTipousuario(Tipousuario entity) throws Exception;

    public void updateTipousuario(Tipousuario entity) throws Exception;

    public Tipousuario getTipousuario(Integer idtipousuario)
        throws Exception;

    public List<Tipousuario> findByCriteriaInTipousuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tipousuario> findPageTipousuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipousuario() throws Exception;

    public List<TipousuarioDTO> getDataTipousuario() throws Exception;

    public void validateTipousuario(Tipousuario tipousuario)
        throws Exception;

    public List<Usuario> getUsuario() throws Exception;

    public void saveUsuario(Usuario entity) throws Exception;

    public void deleteUsuario(Usuario entity) throws Exception;

    public void updateUsuario(Usuario entity) throws Exception;

    public Usuario getUsuario(Integer idusuario) throws Exception;

    public List<Usuario> findByCriteriaInUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Usuario> findPageUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberUsuario() throws Exception;

    public List<UsuarioDTO> getDataUsuario() throws Exception;

    public void validateUsuario(Usuario usuario) throws Exception;

    public List<Votos> getVotos() throws Exception;

    public void saveVotos(Votos entity) throws Exception;

    public void deleteVotos(Votos entity) throws Exception;

    public void updateVotos(Votos entity) throws Exception;

    public Votos getVotos(Integer idvoto) throws Exception;

    public List<Votos> findByCriteriaInVotos(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Votos> findPageVotos(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberVotos() throws Exception;

    public List<VotosDTO> getDataVotos() throws Exception;

    public void validateVotos (Votos votos) throws Exception;
    
    public Votos existeVoto (Integer idinformacion, Integer idusuario);
    
    public Integer cantidadVotosVariables (Informacion informacion);
    
	public Integer cantidadVotosPorEstado (String votos, Informacion informacion);
	
	public Integer cantidadVotosTotalesPorVariable (Informacion informacion, Votos votos);
    
    public Usuario getUsuarioByEmail(String correo);
    

    public List<Usuario> usuariosParaAsignacion(Integer idProyecto);
    
    public List<Usuario> usuariosPorProyecto(Integer idProyecto);
    
    public Proyectousuario buscarPorUsuario(Integer idUsuario, Integer idProyecto);

    
    public void createBucket(String bucketName)throws Exception;
	
	public String uploadPrivate(String bucketName,String key, File file )throws Exception;
	public String uploadPublicRead(String bucketName,String key, File file )throws Exception;
	
	public List<String> listBucketsName()throws Exception;
	 
	public InputStream download(String bucketName, String key)throws Exception;
	 
	public void deleteObject(String bucketName, String key)throws Exception;
	 
	public void deleteBucket(String bucketName)throws Exception;
	
	public String getUrl(String bucketName, String key)throws Exception;
	
	public List<Informacion> getVariableByProject(Proyecto proyecto);
    
	public List<Proyecto> proyectosPorUsuario(Integer idUsuario);

	public List<VotosDTO> votosDeUsuarios(Proyecto proyecto);
	
	public List<String> nombresUsuarios(Proyecto proyecto);
	
	public List<Usuario> usuariosConectados(Proyecto proyecto);
	
	public List<VotosDTO> votosDeUsuarioPorProyecto(Proyecto proyecto, Usuario usuario);
}
