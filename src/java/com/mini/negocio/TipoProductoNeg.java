package com.mini.negocio;

import com.mini.dao.TipoProductoDaoInt;
import com.mini.dao.tipoProductoDao;
import com.mini.model.Tipoproducto;
import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TipoProductoNeg implements Serializable{

    public TipoProductoDaoInt daoTipoProducto = new tipoProductoDao();
    
    
    public void addTipoProducto(Tipoproducto tipo) {
        daoTipoProducto.addTipoProducto(tipo);
    }

    
    public void updTipoProducto(Tipoproducto tipo) {
        daoTipoProducto.updTipoProducto(tipo);
    }

    
    public void delTipoProducto(Tipoproducto tipo) {        
        daoTipoProducto.delTipoProducto(daoTipoProducto.findTipoProducto(tipo));
    }

    
    public List<Tipoproducto> allTipoProductos() {
        return daoTipoProducto.allTipoProductos();
    }

    
    public Tipoproducto findTipoProducto(Tipoproducto tipo) {
        return daoTipoProducto.findTipoProducto(tipo);
    }
    
    public Tipoproducto findTipoProductoById(int id){
        return daoTipoProducto.findTipoProductoById(id);
    }
    
}
