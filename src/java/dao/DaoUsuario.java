/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author cpdpas2
 */
public class DaoUsuario extends Dao {
    public Usuario logar(String usuario, String senha){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Usuario u = null;
        try{
            u = (Usuario)
            session.createQuery(" from Usuario u where u.login = :login and u.senha = :senha")
                    .setParameter("login", usuario)
                    .setParameter("senha", senha)
                    .uniqueResult();
            return u;
        }catch(Exception ex){
            
        }
        finally{
            return u;
        }
    }
}
