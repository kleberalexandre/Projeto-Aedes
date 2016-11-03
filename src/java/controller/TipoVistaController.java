/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoTipovisita;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Tipovisita;

/**
 *
 * @author Kleber
 */
@ManagedBean(name = "tipovisitaController")
@SessionScoped
public class TipoVistaController {

    private Tipovisita tipovisita = new Tipovisita();
    /**
     * Creates a new instance of BairroController
     */
    public TipoVistaController() {
    }
    
    public void gravar(){
        dao.DaoTipovisita daoTipovisita = new DaoTipovisita();
        daoTipovisita.inserir(tipovisita);
        tipovisita = new Tipovisita();
    }

    public Tipovisita getPerfil() {
        return tipovisita;
    }

    public void setRecipiente (Tipovisita tipovisita) {
        this.tipovisita = tipovisita;
    }
    
    
    
}
