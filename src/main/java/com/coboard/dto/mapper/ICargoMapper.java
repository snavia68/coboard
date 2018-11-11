package com.coboard.dto.mapper;

import com.coboard.modelo.Cargo;
import com.coboard.modelo.dto.CargoDTO;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ICargoMapper {
    public CargoDTO cargoToCargoDTO(Cargo cargo) throws Exception;

    public Cargo cargoDTOToCargo(CargoDTO cargoDTO) throws Exception;

    public List<CargoDTO> listCargoToListCargoDTO(List<Cargo> cargos)
        throws Exception;

    public List<Cargo> listCargoDTOToListCargo(List<CargoDTO> cargoDTOs)
        throws Exception;
}
