package com.udea.app.controller;

import com.udea.app.model.Cargo;
import com.udea.app.model.Empleado;
import com.udea.app.service.CargoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.thymeleaf.model.IModel;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/cargos")
public class CargoController {

    private final CargoService cargoservice;

    public CargoController(CargoService cargoservice){
        this.cargoservice = cargoservice;
    }

    @PostMapping("/agregarCargo")
    public RedirectView saveCargo(@ModelAttribute Cargo cargo, Model model){
        model.addAttribute(cargo);
        cargoservice.saveCargo(cargo);
        return new RedirectView("/cargos");
    }

    @GetMapping("")
    public String FindAllCargo(Model model){
        List<Cargo> cargo = cargoservice.getCargo();
        model.addAttribute("allcargo",cargo);
        return "cargo";
    }

    @GetMapping("/{id}")
    public Cargo getCargoById(@PathVariable Integer id){

        return cargoservice.getCargoByid(id);
    }

    @GetMapping ("/elicargo/{id}")
    public RedirectView deleteCargo(@PathVariable Integer id){
        cargoservice.deleteCargo(id);
        return new RedirectView("/cargos");
    }


    @PostMapping("/update")
    public RedirectView updateCargo(@ModelAttribute Cargo cargo){
        cargoservice.updateCargo(cargo);
        return new RedirectView("/cargos");
    }
//    @PutMapping("/actualizarCargo")
//    public RedirectView updateCargo(@ModelAttribute Cargo cargo, Model model){
//        model.addAttribute(cargo);
//        cargoservice.updateCargo(cargo);
//        return new RedirectView("/cargos");
//    }



}
