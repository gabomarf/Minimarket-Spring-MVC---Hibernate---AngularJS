package com.mini.controllers;

import com.mini.model.Producto;
import com.mini.negocio.ProductoNeg;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController para los productos
 */
@RestController
@RequestMapping(value="/Producto")
public class ProductoController {
    
    @Autowired
    ProductoNeg negProducto;
    
    /**
     *Retorna lista de los productos existentes mediente metodo GET
     */
    @ResponseBody
    @RequestMapping(value="/productos", method = RequestMethod.GET)
    public List<Producto> allProductos(){
        List<Producto> productos = new ArrayList<Producto>();
        try{
            productos = negProducto.allProducto();            
        }catch(Exception e){
            
        }
        return productos;
    }
    
    /**
     * Retorna un producto
     */
    @ResponseBody
    @RequestMapping(value="/productos/{id}", method = RequestMethod.GET)
    public Producto getProducto(@PathVariable("id") int id){    
        Producto Producto = new  Producto(); 
        Producto.setIdProducto(id);        
        try{
            Producto = negProducto.findProducto(Producto);
        }catch(Exception e){            
        }  
        return Producto;
    }
    
    /**
     * Manejo de ADD de un producto
     */
    @RequestMapping(value="/productos", method = RequestMethod.POST)
    public boolean addProducto(@RequestBody Producto producto) {
        try{
            negProducto.addProcuto(producto);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    /**
     * Manejo de UPDATE de un producto
     */
    @RequestMapping(value="/productos/", method = RequestMethod.PUT)
    public boolean updProducto(@RequestBody Producto producto) {
        try{
            negProducto.updProducto(producto);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    /**
     * Manejo de DELETE de un producto
     */
    @RequestMapping(value="/productos/{id}", method = RequestMethod.DELETE)
    public boolean delProducto(@PathVariable("id") int id){
        Producto producto = new Producto();
        producto.setIdProducto(id);        
        try{
            negProducto.delProducto(producto);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    
    
}
