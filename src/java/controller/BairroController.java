/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoBairro;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Bairro;

/**
 *
 * @author Kleber
 */
@ManagedBean(name = "bairroController")
@SessionScoped
public class BairroController {

    private Bairro bairro = new Bairro();
    /**
     * Creates a new instance of BairroController
     */
    public BairroController() {
    }
    
    public void gravar(){
        dao.DaoBairro daoBairro = new DaoBairro();
        daoBairro.inserir(bairro);
        bairro = new Bairro();
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }
    
    
    
}
