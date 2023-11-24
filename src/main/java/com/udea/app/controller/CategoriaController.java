package com.udea.app.controller;

import com.udea.app.model.Cargo;
import com.udea.app.model.Categoria;
import com.udea.app.model.Empleado;
import com.udea.app.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaservice;

    public CategoriaController(CategoriaService categoriaservice)
    {
        this.categoriaservice = categoriaservice;
    }

    @GetMapping("")
    public String FindAllCategoria(Model model){
        List<Categoria> categoria = categoriaservice.getCategoria();
        model.addAttribute("categorias",categoria);
        return "categorias";
    }

    @PostMapping("/agregarCategoria")
    public RedirectView addCategoria(@ModelAttribute Categoria categoria, Model model){
        model.addAttribute(categoria);
        categoriaservice.saveCategoria(categoria);
        return new RedirectView("/categorias");
    }

    @GetMapping ("/eliCategoria/{id}")
    public RedirectView deleteCategoria(@PathVariable Integer id){
        categoriaservice.deleteCategoria(id);
        return new RedirectView("/categorias");
    }

    @PostMapping("/update")
    public RedirectView updateCategoria(@ModelAttribute Categoria categoria){
        categoriaservice.updateCategoria(categoria);
        return new RedirectView("/categorias");
    }
}
