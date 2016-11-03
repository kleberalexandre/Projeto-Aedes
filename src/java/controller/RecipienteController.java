/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoRecipiente;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Recipiente;

/**
 *
 * @author Kleber
 */
@ManagedBean(name = "recipienteController")
@SessionScoped
public class RecipienteController {

    private Recipiente recipiente = new Recipiente();
    /**
     * Creates a new instance of BairroController
     */
    public RecipienteController() {
    }
    
    public void gravar(){
        dao.DaoRecipiente daoRecipiente = new DaoRecipiente();
        daoRecipiente.inserir(recipiente);
        recipiente = new Recipiente();
    }

    public Recipiente getPerfil() {
        return recipiente;
    }

    public void setRecipiente (Recipiente recipiente) {
        this.recipiente = recipiente;
    }
    
    
    
}
