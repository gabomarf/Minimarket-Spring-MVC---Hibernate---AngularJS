package com.mini.controllers;

import java.net.BindException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controllador de paginas 
 * @author gabo
 */
@Controller
public class pagesController {
    
    public pagesController() {
        
    }
    
    /**
     * Redireccionador a la pagina principal 
     */
    @RequestMapping("Home")
    public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, 
            BindException errors) throws Exception {
        ModelAndView mv = new ModelAndView("index");        
        return mv;
    }     
    
    /**
     * Redireccionador a la administración de tipos de productos
     */
    @RequestMapping("Tipos/tipos")
    public String tipos(){
        return "TipoProductos/TipoProductos";
    }
    
    /**
     * Redireccionador a la administración de productos
     */
    @RequestMapping("Productos/productos")
    public String productos(){
        return "Producto/Productos";
    }
}
