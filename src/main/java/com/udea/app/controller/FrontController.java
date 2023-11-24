package com.udea.app.controller;

import com.udea.app.model.*;
import com.udea.app.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class FrontController {
    @Autowired
    private CargoService cargoService;
    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private ProductoService productoService;
    @GetMapping()
    public String cargo(Model model){

        return "index";
    }
    @GetMapping("/newCargo")
    public String newCargo(Model model){
        model.addAttribute("allcargo",new Cargo());
        return "newCargo";
    }

    @GetMapping("/newEmpleado")
    public String newEmpleado(Model model){
        model.addAttribute("empleadoNew", new Empleado());
        return "empleadoNew";
    }

    @GetMapping("/newCategoria")
    public String newCategoria(Model model){
        model.addAttribute("categoriaNew", new Categoria());
        return "categoriaNew";
    }

    @GetMapping("/newProveedor")
    public String newProveedor(Model model){
        model.addAttribute("proveedorNew", new Proveedor());
        return "proveedorNew";
    }

    @GetMapping("/newProducto")
    public String newProducto(Model model){
        model.addAttribute("productoNew", new Producto());
        return "productoNew";
    }

    @GetMapping("/updateCargo/{id}")
    public String updateCargo(@PathVariable Integer id, Model model){
        Cargo cargo = cargoService.getCargoByid(id);
        if (cargo != null){
            model.addAttribute("upCargo", cargo);
            return "editCargo";
        }else {
            return "redirect:/cargos";
        }
    }

    @GetMapping("/updateEmpleado/{id}")
    public String updateEmpleado(@PathVariable Integer id, Model model){
        Empleado empleado = empleadoService.getEmpleadoById(id);
        if (empleado != null){
            model.addAttribute("upEmpleado", empleado);
            return "editEmpleado";
        }else {
            return "redirect:/empleados";
        }
    }

    @GetMapping("/updateCategoria/{id}")
    public String updateCategoria(@PathVariable Integer id, Model model){
        Categoria categoria = categoriaService.getCategoriaByid(id);
        if (categoria != null){
            model.addAttribute("upCategoria", categoria);
            return "editCategoria";
        }else {
            return "redirect:/categorias";
        }
    }

    @GetMapping("/updateProveedor/{id}")
    public String updateProveedor(@PathVariable Integer id, Model model){
        Proveedor proveedor = proveedorService.getProveedorById(id);
        if (proveedor != null){
            model.addAttribute("upProveedor", proveedor);
            return "editProveedor";
        }else {
            return "redirect:/proveedores";
        }
    }

    @GetMapping("/updateProducto/{id}")
    public String updateProducto(@PathVariable Integer id, Model model){
        Producto producto = productoService.getProductoById(id);
        if (producto != null){
            model.addAttribute("upProducto", producto);
            return "editProducto";
        }else {
            return "redirect:/productos";
        }
    }

}
