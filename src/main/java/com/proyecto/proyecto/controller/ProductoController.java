package com.proyecto.proyecto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.proyecto.proyecto.model.Producto;
import com.proyecto.proyecto.model.Usuario;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/producto")
public class ProductoController {
    private List<Producto> productos = new
    ArrayList<>(Arrays.asList(new Producto(1, "Guayaba", 1000, 7)));


    @GetMapping("/todos")/*Consultar datos del Producto */
    public List<Producto>getProductos(){
        return productos;

    }
    @GetMapping("/{nombre}")
    public Producto getidproducto(@PathVariable String nombre) {
        for(Producto p: productos) {
            if(p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
            }
            return null;
    }
    @PostMapping("/new")
    public Producto creaproducto(@RequestBody Producto producto) {
        productos.add(producto);
        return producto;
        
       
    }
    @PutMapping("/cambiar")
    public Producto putproducto(@RequestBody Producto producto) {
        for(Producto p : productos) {
            if(p.getIdProducto() == producto.getIdProducto()) {
                p.setNombre(producto.getNombre());
                p.setValor(producto.getValor());
                p.setCantidad(producto.getCantidad());
                return p;
                
                
            }
        }
        
        return null;
    }
    @DeleteMapping("/borrar/{idProducto}")
    public Producto deleteproducto(@PathVariable int idProducto) {
        for (Producto p : productos) {
            if (p.getIdProducto() == idProducto) {
                productos.remove(p);
                return p;
            }
        }
        return null;
    
        
    }
}
    

    



