package com.coboard.dataaccess.dao;

import com.coboard.dataaccess.api.Dao;

import com.coboard.modelo.Adjuntos;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


public interface IAdjuntosDAO extends Dao<Adjuntos, Integer> {
	public Adjuntos findAdjuntoByInformacion(Integer idinformacion);
}
