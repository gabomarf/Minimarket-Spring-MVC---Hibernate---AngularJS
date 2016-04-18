package com.mini.controllers;

import com.mini.model.Tipoproducto;
import com.mini.negocio.TipoProductoNeg;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * RestController para los tipos de productos
 */
@RestController
@RequestMapping(value="/tipolist")
public class TiposProductosController {
    
    @Autowired
    TipoProductoNeg negTipo;
   
    /**
     *Retorna lista de los tipos de productos existentes mediente metodo GET
     */
    @ResponseBody
    @RequestMapping(value="/lsttipos", method = RequestMethod.GET)
    public  List<Tipoproducto> allTiposProductos(){    
        List<Tipoproducto> tiposProductos = new ArrayList<Tipoproducto>(); 
        try{
        tiposProductos = (ArrayList<Tipoproducto>)negTipo.allTipoProductos();
        }catch(Exception e){
            
        }  
        return tiposProductos;
    }
    
    /**
     * Retorna un tipo de producto
     */
    @ResponseBody
    @RequestMapping(value="/lsttipos/{id}", method = RequestMethod.GET)
    public Tipoproducto getTipoProducto(@PathVariable("id") int id){    
        Tipoproducto tipoProducto = new  Tipoproducto();        
        try{
            tipoProducto = negTipo.findTipoProductoById(id);
        }catch(Exception e){
            
        }  
        return tipoProducto;
    }
    
    /**
     * Manejo de ADD de un tipo de producto
     */
    @RequestMapping(value="/lsttipos", method = RequestMethod.POST)
    public boolean addTipo(@RequestBody Tipoproducto tipo) {
        try{
            negTipo.addTipoProducto(tipo);
            return true;
        }catch(Exception e){
            return false;
        }
    }
        
    /**
     * Manejo de DELETE de un tipo de producto
     */
    @RequestMapping(value="/lsttipos/{id}", method = RequestMethod.DELETE)
    public boolean delTipo(@PathVariable("id") int id) {
        Tipoproducto tipo = new Tipoproducto();
        tipo.setIdTipoProducto(id);
        try{
            negTipo.delTipoProducto(tipo);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    /**
     * Manejo de UPDATE de un tipo de producto
     */
    @RequestMapping(value="/lsttipos/", method = RequestMethod.PUT)
    public boolean updTipo(@RequestBody Tipoproducto tipo) {
        try{
            negTipo.updTipoProducto(tipo);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
