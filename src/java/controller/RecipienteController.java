/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoRecipiente;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
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
   
    private List<Recipiente> listaRecipiente;
    
    /**
     * Creates a new instance of RecipienteController
     */
    public RecipienteController() {
    }
    
    @PostConstruct
    public void init(){
        DaoRecipiente daoRecipiente = new DaoRecipiente();
        listaRecipiente = daoRecipiente.listar();
    }
    
    public void gravar(){
        dao.DaoRecipiente daoRecipiente = new DaoRecipiente();
        if (this.recipiente.getId()==null){
            daoRecipiente.inserir(recipiente);
        }else{
            daoRecipiente.atualizar(recipiente);
        }
        recipiente = new Recipiente();
        init();
    }

    public Recipiente getRecipiente() {
        return recipiente;
    }

    public void setPerfil(Recipiente recipiente) {
        this.recipiente = recipiente;
    }

    public List<Recipiente> getListaRecipientes() {
        return listaRecipiente;
    }

    public void setListaRecipiente (List<Recipiente> listaRecipientes) {
        this.listaRecipiente = listaRecipientes;
    }
    
    public void excluir(Recipiente recipiente){
        DaoRecipiente daoRecipiente = new DaoRecipiente();
        daoRecipiente.excluir(recipiente);
        init();
    }
    
    public void alterar(Recipiente recipiente){
        this.recipiente = recipiente;
    }
    
    public void voltar(){
        try {
            util.Util.redirecionar("principal.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(RecipienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

