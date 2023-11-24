package com.udea.app.service;

import com.udea.app.model.Producto;
import com.udea.app.repo.ProductoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepo productoRepository;

    public ProductoService (ProductoRepo productoRepository){
        this.productoRepository = productoRepository;
    }


    public List<Producto> getProducto(){
        return productoRepository.findAll();
    }

    public Producto getProductoById(Integer id){
        return productoRepository.findById(id).orElse(null);
    }

    public Producto saveProducto(Producto producto){
        return productoRepository.save(producto);
    }

    public List<Producto> saveAllProducto(List<Producto> producto){
        return productoRepository.saveAll(producto);
    }

    public String deleteProducto(Integer id){
        productoRepository.deleteById(id);
        return ("Has Eliminado el registro " + id);
    }

    public Producto updateProducto(Producto producto){
        Producto productoEdit = productoRepository.findById(producto.getCodigo()).orElse(null);
        productoEdit.setNombre(producto.getNombre());
        productoEdit.setDescripcion(producto.getDescripcion());
        productoEdit.setCantidadDisponible(producto.getCantidadDisponible());
        productoEdit.setPrecio(producto.getPrecio());
        productoEdit.setEstado(producto.isEstado());
        return productoRepository.save(productoEdit);
    }
}