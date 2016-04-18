package com.mini.dao;

import com.mini.model.Tipoproducto;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;


public class tipoProductoDao implements TipoProductoDaoInt{
    
    Session session;
    
    @Override
    public void addTipoProducto(Tipoproducto tipo) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(tipo);
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
    public void updTipoProducto(Tipoproducto tipo) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(tipo);
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
    public void delTipoProducto(Tipoproducto tipo) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(tipo);
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
    public List<Tipoproducto> allTipoProductos() {
        List<Tipoproducto> list = new ArrayList();
        try{
            session = HibernateUtil.getSessionFactory().openSession();            
            Query query = session.createQuery("from Tipoproducto");
            list = (List<Tipoproducto>) query.list();            
        }catch(HibernateException e){
            System.out.println(e.getMessage());
        }/*finally{
            if(session != null){
                session.close();
            }
        }*/
        return list;
    }

    @Override
    public Tipoproducto findTipoProducto(Tipoproducto tipo) {
        Tipoproducto tip = new Tipoproducto();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            List list = session.createQuery("from Tipoproducto where idTipoProducto=?").setParameter(0, tipo.getIdTipoProducto()).list();
            tip = (Tipoproducto)list.get(0);
        }catch(HibernateException e){
            System.out.print(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if(session != null){
                session.close();
            }
        }
        return tip;
    }
    
    @Override
    public Tipoproducto findTipoProductoById(int id) {
        Tipoproducto tip = new Tipoproducto();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            List list = session.createQuery("from Tipoproducto where idTipoProducto=?").setParameter(0, id).list();
            tip = (Tipoproducto)list.get(0);
        }catch(HibernateException e){
            System.out.print(e.getMessage());
            session.getTransaction().rollback();
        }finally{
            if(session != null){
                session.close();
            }
        }
        return tip;
    }
}
