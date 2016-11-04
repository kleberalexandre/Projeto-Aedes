/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoVisita;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Visita;

/**
 *
 * @author Kleber
 */
@ManagedBean(name = "visitaController")
@SessionScoped
public class VisitaController {

    private Visita visita = new Visita();
    /**
     * Creates a new instance of BairroController
     */
    public VisitaController() {
    }
    
    public void gravar(){
        dao.DaoVisita daoVisita = new DaoVisita();
        Object Visita = null;
      
        daoVisita.inserir(Visita);
        visita = new Visita();
    }

    public Visita getVisita() {
        return visita;
    }

    public void setPerfil(Visita visita) {
        this.visita = visita;
    }
    
    
    
}
