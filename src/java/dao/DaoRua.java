/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Bairro;
import model.Rua;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Kleber
 */
public class DaoRua extends Dao{

    public List<Rua> listar(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Rua> lista = null;
        try{
            lista = session.createQuery(" from Rua").list();
            transaction.commit();
        }catch(Exception ex){
            transaction.rollback();
        }finally{
            return lista;
        }
    }
    
    public List<Rua> listarByBairroId(Integer idBairro){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Rua> lista = null;
        try{
            lista = session.createQuery(" from Rua r where r.bairro.id = :idBairro")
                    .setParameter("idBairro", idBairro)
                    .list();
            transaction.commit();
        }catch(Exception ex){
            transaction.rollback();
        }finally{
            return lista;
        }
    }

    public Rua getById(Integer id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Rua rua = null;
        try{
            rua = (Rua) session.get(Rua.class, id);
            transaction.commit();
        }catch(Exception ex){
            transaction.rollback();
        }finally{
            return rua;
        }        
    }

}
