package com.udea.app.controller;

import com.udea.app.model.Producto;
import com.udea.app.model.Proveedor;
import com.udea.app.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;
    public ProductoController (ProductoService productoService){
        this.productoService = productoService;
    }

    @GetMapping("")
    public String FindAllProductos(Model model){
        List<Producto> productos = productoService.getProducto();
        model.addAttribute("lProducto",productos);
        return "productos";
    }

    @PostMapping("/agregarProducto")
    public RedirectView addProducto(@ModelAttribute Producto producto, Model model){
        model.addAttribute(producto);
        productoService.saveProducto(producto);
        return new RedirectView("/productos");
    }

    @GetMapping("/eliProducto/{id}")
    public RedirectView deleteProducto(@PathVariable Integer id){
        productoService.deleteProducto(id);
        return new RedirectView("/productos");
    }

    @PostMapping("/update")
    public RedirectView updateProducto(@ModelAttribute Producto producto){
        productoService.updateProducto(producto);
        return new RedirectView("/productos");
    }
}
