package com.udea.app.controller;

import com.udea.app.model.Cargo;
import com.udea.app.model.Empleado;
import com.udea.app.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/empleados")
public class EmpleadoController {
    @Autowired
    private final EmpleadoService empleadoService;
    @Autowired
    public EmpleadoController(EmpleadoService empleadoService){
        this.empleadoService = empleadoService;
    }

    @GetMapping("")
    public String FindAllCargo(Model model){
        List<Empleado> empleado = empleadoService.getEmpleadoAll();
        model.addAttribute("lEmpleados",empleado);
        return "empleados";
    }
    @GetMapping ("/eliempleado/{id}")
    public RedirectView deleteCargo(@PathVariable Integer id){
        empleadoService.deleteEmpleado(id);
        return new RedirectView("/empleados");
    }

    @PostMapping("/update")
    public RedirectView updateEmpleado(@ModelAttribute Empleado empleado){
        empleadoService.updateEmpleado(empleado);
        return new RedirectView("/empleados");
    }

    @PostMapping("/agregarEmpleado")
    public RedirectView addEmpleado(@ModelAttribute Empleado empleado, Model model){
        model.addAttribute(empleado);
        empleadoService.saveEmpleado(empleado);
        return new RedirectView("/empleados");
    }


//    @PostMapping("/agregarEmpleado")
//    public Empleado saveEmpleado (@RequestBody Empleado empleado){
//        return empleadoService.saveEmpleado(empleado);
//    }
//
//    @GetMapping("/{id}")
//    public Empleado getEmpleadoById(@PathVariable Integer id){
//        return empleadoService.getEmpleadoById(id);
//    }
//
//    @GetMapping
//    public List<Empleado> findAllEmpleados(){
//
//        return empleadoService.getEmpleadoAll();
//    }
//    @PostMapping("delete/{id}")
//    public String deleteProveedor(Integer id){
//        return empleadoService.deleteEmpleado(id);
//    }
//
//    @PostMapping("/agregarTodosEmpleados")
//    public List<Empleado> saveAllEmpleado(@RequestBody List<Empleado> empleados){
//        return empleadoService.saveAllEmpleados(empleados);
//    }
//
//    @PutMapping("/actualizarEmpleado")
//    public Empleado updateEmpleado(@RequestBody Empleado empleado){
//        return  empleadoService.updateEmpleado(empleado);
//    }
}
