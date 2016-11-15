/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.TipoVisita;
import model.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Kleber
 */
public class DaoTipoVisita extends Dao {

       public List<TipoVisita> listar(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<TipoVisita> lista = null;
        try{
            lista = session.createQuery(" from TipoVisita").list();
            transaction.commit();
        }catch(Exception ex){
            transaction.rollback();
        }finally{
            return lista;
        }
    }
}
