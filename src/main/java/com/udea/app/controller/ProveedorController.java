package com.udea.app.controller;

import com.udea.app.model.Empleado;
import com.udea.app.model.Proveedor;
import com.udea.app.service.ProveedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
@Controller
@CrossOrigin
@RequestMapping("/proveedores")
public class ProveedorController {

    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService){
        this.proveedorService = proveedorService;
    }


    @GetMapping("")
    public String FindAllProveedor(Model model){
        List<Proveedor> proveedor = proveedorService.getProveedor();
        model.addAttribute("lProveedor",proveedor);
        return "proveedores";
    }

    @GetMapping ("/eliProveedor/{id}")
    public RedirectView deleteProveedor(@PathVariable Integer id){
        proveedorService.deleteProveedor(id);
        return new RedirectView("/proveedores");
    }

    @PostMapping("/agregarProveedor")
    public RedirectView addProveedor(@ModelAttribute Proveedor proveedor, Model model){
        model.addAttribute(proveedor);
        proveedorService.saveProveedor(proveedor);
        return new RedirectView("/proveedores");
    }

    @PostMapping("/update")
    public RedirectView updateProveedor(@ModelAttribute Proveedor proveedor){
        proveedorService.updateProveedor(proveedor);
        return new RedirectView("/proveedores");
    }
}
