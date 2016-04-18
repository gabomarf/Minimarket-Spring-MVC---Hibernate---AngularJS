package com.mini.dao;

import com.mini.model.Producto;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;


public class ProductoDao implements ProductoDaoInt{
    
    Session session;
        
    @Override
    public void addProcuto(Producto producto) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(producto);
            session.getTransaction().commit();
        }catch(HibernateException e){
            System.out.print(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public void updProducto(Producto producto) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(producto);
            session.getTransaction().commit();
        }catch(HibernateException e){
            System.out.print(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if(session != null){
                session.close();
            }
        }
    }

    @Override
    public void delProducto(Producto producto) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(producto);
            session.getTransaction().commit();
        }catch(HibernateException e){
            System.out.print(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if(session != null){
                session.close();
            }
        }
       
    }

    @Override
    public Producto findProducto(Producto producto) {
        Producto prod = new Producto();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            List list = session.createQuery("from Producto where idProducto=?").setParameter(0, producto.getIdProducto()).list();
            prod = (Producto)list.get(0);
        }catch(HibernateException e){
            System.out.print(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if(session != null){
                session.close();
            }
        }
        return prod;
    }

    @Override
    public List<Producto> allProducto() {
        List<Producto> list = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();            
            Query query = session.createQuery("from Producto");
            list = (List<Producto>) query.list();            
        }catch(HibernateException e){
            System.out.println(e.getMessage());
        }finally{
            if(session != null){
                session.close();
            }
        }
        return list;
    }
}
