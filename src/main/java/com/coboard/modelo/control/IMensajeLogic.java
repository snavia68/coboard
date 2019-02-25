package com.coboard.modelo.control;

import java.util.List;

import com.coboard.modelo.Mensaje;


public interface IMensajeLogic {
	public List<Mensaje> getMensaje() throws Exception;

    /**
         * Save an new Cargo entity
         */
    public void saveMensaje(Mensaje entity) throws Exception;

   
    public Mensaje getMensaje(Integer idmensaje) throws Exception;

    public List<Mensaje> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public Long findTotalNumberMensaje() throws Exception;

    public void validateMensaje(Mensaje mensaje) throws Exception;
    
    public List<Mensaje> mensajesPorProyecto(Integer idProyecto);
}
