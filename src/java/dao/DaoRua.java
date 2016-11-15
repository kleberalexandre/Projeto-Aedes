/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Bairro;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Kleber
 */
public class DaoRua extends Dao{

    public List<Bairro> listar(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Bairro> lista = null;
        try{
            lista = session.createQuery(" from Rua").list();
            transaction.commit();
        }catch(Exception ex){
            transaction.rollback();
        }finally{
            return lista;
        }
    }

}
