package com.udea.app.service;

import com.udea.app.model.Empleado;
import com.udea.app.repo.EmpleadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {
    @Autowired
    private final EmpleadoRepo iEmpleado;

    @Autowired
    public EmpleadoService(EmpleadoRepo iEmpleado) {
        this.iEmpleado = iEmpleado;
    }


    public List<Empleado> getEmpleadoAll(){
        return this.iEmpleado.findAll();
    }

    public Empleado getEmpleadoById(Integer id){
        return this.iEmpleado.findById(id).orElse(null);
    }

    public Empleado saveEmpleado(Empleado empleado){
        return this.iEmpleado.save(empleado);
    }

    public List<Empleado> saveAllEmpleados(List<Empleado> empleado){
        return this.iEmpleado.saveAll(empleado);
    }

    public String deleteEmpleado(Integer id){
        this.iEmpleado.deleteById(id);
        return ("Has Eliminado el registro " + id);
    }

    public Empleado updateEmpleado(Empleado empleado){
        Empleado empleadoEdit = this.iEmpleado.findById(empleado.getId()).orElse(null);

        empleadoEdit.setNombre1(empleado.getNombre1());
        empleadoEdit.setNombre2(empleado.getNombre2());
        empleadoEdit.setApellido1(empleado.getApellido1());
        empleadoEdit.setApellido2(empleado.getApellido2());
        empleadoEdit.setTelefono(empleado.getTelefono());
        empleadoEdit.setDireccion(empleado.getDireccion());
        empleadoEdit.setCorreo(empleado.getCorreo());
        empleadoEdit.setEstado(empleado.isEstado());
        return this.iEmpleado.save(empleadoEdit);
    }
}
