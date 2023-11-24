package com.udea.app.service;

import com.udea.app.model.Proveedor;
import com.udea.app.repo.ProveedorRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    private final ProveedorRepo iProveedor;

    public ProveedorService(ProveedorRepo iProveedor) {
        this.iProveedor = iProveedor;
    }

    public List<Proveedor> getProveedor(){
        return iProveedor.findAll();
    }
    public Proveedor getProveedorById(Integer id){
        return iProveedor.findById(id).orElse(null);
    }

    public Proveedor saveProveedor(Proveedor proveedor){
        return iProveedor.save(proveedor);
    }

    public List<Proveedor> saveAllProveedor(List<Proveedor> proveedor){
        return iProveedor.saveAll(proveedor);
    }

    public String deleteProveedor(Integer id){
        iProveedor.deleteById(id);
        return ("Has Eliminado el registro " + id);
    }

    public Proveedor updateProveedor(Proveedor proveedor){
        Proveedor proveedorEdit = iProveedor.findById(proveedor.getId()).orElse(null);
        proveedorEdit.setNombre(proveedor.getNombre());
        proveedorEdit.setTelefono(proveedor.getTelefono());
        proveedorEdit.setDireccion(proveedor.getDireccion());
        proveedorEdit.setCorreo(proveedor.getCorreo());
        proveedorEdit.setEstado(proveedor.isEstado());
        return iProveedor.save(proveedorEdit);
    }
}
