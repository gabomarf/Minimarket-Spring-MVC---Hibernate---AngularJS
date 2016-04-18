package com.mini.dao;

import com.mini.model.Producto;
import java.util.List;


public interface ProductoDaoInt {
    public void addProcuto(Producto producto);
    public void updProducto(Producto producto);
    public void delProducto(Producto producto);
    public Producto findProducto(Producto producto);
    public List<Producto> allProducto();
}
