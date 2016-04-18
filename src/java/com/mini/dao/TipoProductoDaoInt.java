package com.mini.dao;

import com.mini.model.Tipoproducto;
import java.util.List;

public interface TipoProductoDaoInt {
    public void addTipoProducto(Tipoproducto tipo);
    public void updTipoProducto(Tipoproducto tipo);
    public void delTipoProducto(Tipoproducto tipo);
    public List<Tipoproducto> allTipoProductos();
    public Tipoproducto findTipoProducto(Tipoproducto tipo);
    public Tipoproducto findTipoProductoById(int id);
}
