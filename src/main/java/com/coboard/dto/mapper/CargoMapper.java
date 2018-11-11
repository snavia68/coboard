package com.coboard.dto.mapper;

import com.coboard.modelo.*;
import com.coboard.modelo.Cargo;
import com.coboard.modelo.control.*;
import com.coboard.modelo.dto.CargoDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class CargoMapper implements ICargoMapper {
    private static final Logger log = LoggerFactory.getLogger(CargoMapper.class);

    @Transactional(readOnly = true)
    public CargoDTO cargoToCargoDTO(Cargo cargo) throws Exception {
        try {
            CargoDTO cargoDTO = new CargoDTO();

            cargoDTO.setIdcargo(cargo.getIdcargo());
            cargoDTO.setActivo((cargo.getActivo() != null) ? cargo.getActivo()
                                                           : null);
            cargoDTO.setFechacreacion(cargo.getFechacreacion());
            cargoDTO.setFechamodificacion(cargo.getFechamodificacion());
            cargoDTO.setNombre((cargo.getNombre() != null) ? cargo.getNombre()
                                                           : null);
            cargoDTO.setUsuariocreador((cargo.getUsuariocreador() != null)
                ? cargo.getUsuariocreador() : null);
            cargoDTO.setUsuariomodificador((cargo.getUsuariomodificador() != null)
                ? cargo.getUsuariomodificador() : null);

            return cargoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Cargo cargoDTOToCargo(CargoDTO cargoDTO) throws Exception {
        try {
            Cargo cargo = new Cargo();

            cargo.setIdcargo(cargoDTO.getIdcargo());
            cargo.setActivo((cargoDTO.getActivo() != null)
                ? cargoDTO.getActivo() : null);
            cargo.setFechacreacion(cargoDTO.getFechacreacion());
            cargo.setFechamodificacion(cargoDTO.getFechamodificacion());
            cargo.setNombre((cargoDTO.getNombre() != null)
                ? cargoDTO.getNombre() : null);
            cargo.setUsuariocreador((cargoDTO.getUsuariocreador() != null)
                ? cargoDTO.getUsuariocreador() : null);
            cargo.setUsuariomodificador((cargoDTO.getUsuariomodificador() != null)
                ? cargoDTO.getUsuariomodificador() : null);

            return cargo;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<CargoDTO> listCargoToListCargoDTO(List<Cargo> listCargo)
        throws Exception {
        try {
            List<CargoDTO> cargoDTOs = new ArrayList<CargoDTO>();

            for (Cargo cargo : listCargo) {
                CargoDTO cargoDTO = cargoToCargoDTO(cargo);

                cargoDTOs.add(cargoDTO);
            }

            return cargoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Cargo> listCargoDTOToListCargo(List<CargoDTO> listCargoDTO)
        throws Exception {
        try {
            List<Cargo> listCargo = new ArrayList<Cargo>();

            for (CargoDTO cargoDTO : listCargoDTO) {
                Cargo cargo = cargoDTOToCargo(cargoDTO);

                listCargo.add(cargo);
            }

            return listCargo;
        } catch (Exception e) {
            throw e;
        }
    }
}
