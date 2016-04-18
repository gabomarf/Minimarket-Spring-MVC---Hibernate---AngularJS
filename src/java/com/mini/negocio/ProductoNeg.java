package com.mini.negocio;

import com.mini.dao.ProductoDao;
import com.mini.dao.ProductoDaoInt;
import com.mini.model.Producto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductoNeg {

    public ProductoDaoInt productoDao = new ProductoDao();    
    
    public void addProcuto(Producto producto) {
         productoDao.addProcuto(producto);
    }

    
    public void updProducto(Producto producto) {
         productoDao.updProducto(producto);
    }

    
    public void delProducto(Producto producto) {        
         productoDao.delProducto(productoDao.findProducto(producto));
    }

    
    public Producto findProducto(Producto producto) {
        return productoDao.findProducto(producto);
    }

    
    public List<Producto> allProducto() {
         TipoProductoNeg negTipo = new TipoProductoNeg();
         List<Producto> productos = new ArrayList<Producto>();
         for(Producto p : productoDao.allProducto()){
                Producto producto = new Producto();
                producto.setIdProducto(p.getIdProducto());
                producto.setNombreProducto(p.getNombreProducto());
                producto.setDescripccion(p.getDescripccion());
                producto.setValor(p.getValor());
                producto.setStock(p.getStock());
                producto.setDsct(p.getDsct());
                producto.setCodigo(p.getCodigo());
                producto.setTipoproducto(negTipo.findTipoProductoById(p.getTipoproducto().getIdTipoProducto()));
                productos.add(producto);
            }
        return productos;
    }
    
}
