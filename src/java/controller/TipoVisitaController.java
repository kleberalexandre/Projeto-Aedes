/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoTipoVisita;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.TipoVisita;

/**
 *
 * @author Kleber
 */
@ManagedBean(name = "tipovisitaController")
@SessionScoped
public class TipoVisitaController {

    private TipoVisita recipiente = new TipoVisita();
   
    private List<TipoVisita> listaTipoVisita;
    
    /**
     * Creates a new instance of TipoVisitaController
     */
    public TipoVisitaController() {
    }
    
    @PostConstruct
    public void init(){
        DaoTipoVisita daoTipoVisita = new DaoTipoVisita();
        listaTipoVisita = daoTipoVisita.listar();
    }
    
    public void gravar(){
        dao.DaoTipoVisita daoTipoVisita = new DaoTipoVisita();
        if (this.recipiente.getId()==null){
            daoTipoVisita.inserir(recipiente);
        }else{
            daoTipoVisita.atualizar(recipiente);
        }
        recipiente = new TipoVisita();
        init();
    }
  

    
    public void excluir(TipoVisita recipiente){
        DaoTipoVisita daoTipoVisita = new DaoTipoVisita();
        daoTipoVisita.excluir(recipiente);
        init();
    }
    
    public void alterar(TipoVisita recipiente){
        this.recipiente = recipiente;
    }


    
    public void voltar(){
        try {
            util.Util.redirecionar("principal.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(TipoVisitaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TipoVisita getTipoVisita() {
        return recipiente;
    }

    public void setTipoVisita(TipoVisita recipiente) {
        this.recipiente = recipiente;
    }

    public List<TipoVisita> getListaTipoVisita() {
        return listaTipoVisita;
    }

    public void setListaTipoVisita(List<TipoVisita> listaTipoVisita) {
        this.listaTipoVisita = listaTipoVisita;
    }
    
    
}

