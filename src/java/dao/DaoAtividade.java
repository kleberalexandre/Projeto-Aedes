/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Atividade;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author cpdpas2
 */
public class  DaoAtividade extends Dao{

       public List<Atividade> listar(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Atividade> lista = null;
        try{
            lista = session.createQuery(" from Atividade").list();
            transaction.commit();
        }catch(Exception ex){
            transaction.rollback();
        }finally{
            return lista;
        }
    }
}
