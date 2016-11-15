/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoSituacaoImovel;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.SituacaoImovel;

/**
 *
 * @author Kleber
 */
@ManagedBean(name = "situacaoImovelController")
@SessionScoped
public class SituacaoImovelController {

    private SituacaoImovel recipiente = new SituacaoImovel();
   
    private List<SituacaoImovel> listaSituacaoImovel;
    
    /**
     * Creates a new instance of SituacaoImovelController
     */
    public SituacaoImovelController() {
    }
    
    @PostConstruct
    public void init(){
        DaoSituacaoImovel daoSituacaoImovel = new DaoSituacaoImovel();
        listaSituacaoImovel = daoSituacaoImovel.listar();
    }
    
    public void gravar(){
        dao.DaoSituacaoImovel daoSituacaoImovel = new DaoSituacaoImovel();
        if (this.recipiente.getId()==null){
            daoSituacaoImovel.inserir(recipiente);
        }else{
            daoSituacaoImovel.atualizar(recipiente);
        }
        recipiente = new SituacaoImovel();
        init();
    }
  

    
    public void excluir(SituacaoImovel recipiente){
        DaoSituacaoImovel daoSituacaoImovel = new DaoSituacaoImovel();
        daoSituacaoImovel.excluir(recipiente);
        init();
    }
    
    public void alterar(SituacaoImovel recipiente){
        this.recipiente = recipiente;
    }


    
    public void voltar(){
        try {
            util.Util.redirecionar("principal.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(SituacaoImovelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public SituacaoImovel getSituacaoImovel() {
        return recipiente;
    }

    public void setSituacaoImovel(SituacaoImovel recipiente) {
        this.recipiente = recipiente;
    }

    public List<SituacaoImovel> getListaSituacaoImovel() {
        return listaSituacaoImovel;
    }

    public void setListaSituacaoImovel(List<SituacaoImovel> listaSituacaoImovel) {
        this.listaSituacaoImovel = listaSituacaoImovel;
    }
    
    
}

