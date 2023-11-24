package com.udea.app.service;

import com.udea.app.model.Cargo;
import com.udea.app.repo.CargoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {
    private final CargoRepo iCargo;

    public CargoService(CargoRepo iCargo) {
        this.iCargo = iCargo;
    }

    public List<Cargo> getCargo() {
        return iCargo.findAll();
    }

    public Cargo getCargoByid(Integer id) {

        return iCargo.findById(id).orElse(null);
    }

    public Cargo saveCargo(Cargo cargo) {
        return iCargo.save(cargo);
    }

    public List<Cargo> saveAllCargo(List<Cargo> cargo) {
        return iCargo.saveAll(cargo);
    }

    public String deleteCargo(Integer id) {
        iCargo.deleteById(id);
        return ("Has Eliminado el registro " + id);
    }

    public Cargo updateCargo(Cargo cargo) {
        Cargo cargoEdit = iCargo.findById(cargo.getCodigo()).orElse(null);
            cargoEdit.setNombre(cargo.getNombre());

        cargoEdit.setDescripcion(cargo.getDescripcion());
        cargoEdit.setEstado(cargo.isEstado());
        return iCargo.save(cargoEdit);
    }

}
