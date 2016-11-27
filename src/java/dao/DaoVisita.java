/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Visita;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author cpdpas2
 */
public class DaoVisita extends Dao {
    public List<Visita> listar(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Visita> lista = null;
        try{
            lista = session.createQuery(" from Visita").list();
            transaction.commit();
        }catch(Exception ex){
            transaction.rollback();
        }finally{
            return lista;
        }
    }
    
    public Visita getById(Integer id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Visita visita = null;
        try{
            visita = (Visita) session.get(Visita.class, id);
            transaction.commit();
        }catch(Exception ex){
            transaction.rollback();
        }finally{
            return visita;
        }        
    }        
    
}
