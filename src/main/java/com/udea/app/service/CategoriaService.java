package com.udea.app.service;

import com.udea.app.model.Categoria;
import com.udea.app.repo.CategoriaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService
{
    private final CategoriaRepo iCategoria;

    public  CategoriaService(CategoriaRepo iCategoria)
    {
        this.iCategoria = iCategoria;
    }

    public List<Categoria> getCategoria()
    {
        return iCategoria.findAll();
    }

    public Categoria getCategoriaByid(Integer id){
        return iCategoria.findById(id).orElse(null);
    }
    public  Categoria saveCategoria(Categoria categoria)
    {
        return iCategoria.save(categoria);
    }
    public List<Categoria> saveAllCategorias(List<Categoria> categoria)
    {
        return iCategoria.saveAll(categoria);
    }

    public Categoria deleteCategoria(Integer id){
        this.iCategoria.deleteById(id);
        return iCategoria.findById(id).orElse(null);
    }
    public Categoria updateCategoria(Categoria categoria)
    {
        Categoria categoriaEdit = iCategoria.findById(categoria.getId()).orElse(null);
        categoriaEdit.setId(categoria.getId());
        categoriaEdit.setNombre(categoria.getNombre());
        categoriaEdit.setDescripcion(categoria.getDescripcion());
        categoriaEdit.setEstado(categoria.isEstado());
        return iCategoria.save(categoriaEdit);
    }
}

