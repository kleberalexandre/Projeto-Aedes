/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoAtividade;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Atividade;

/**
 *
 * @author Kleber
 */
@ManagedBean(name = "atividadeController")
@SessionScoped
public class AtividadeController {

    private Atividade atividade = new Atividade();
    private List<Atividade> listaAtividade;
    
    /**
     * Creates a new instance of RecipienteController
     */
    public AtividadeController() {
    }
    
    @PostConstruct
    public void init(){
        DaoAtividade daoAtividade = new DaoAtividade();
        listaAtividade = daoAtividade.listar();
    }
    
    public void gravar(){
        dao.DaoAtividade daoAtividade = new DaoAtividade();
        if (this.atividade.getId()==null){
            daoAtividade.inserir(atividade);
        }else{
            daoAtividade.atualizar(atividade);
        }
        atividade = new Atividade ();
        init();
    }
  

    
    public void excluir(Atividade atividade){
        DaoAtividade daoAtividade = new DaoAtividade();
        daoAtividade.excluir(atividade);
        init();
    }
    
    public void alterar(Atividade atividade){
        this.atividade = atividade;
    }


    
    public void voltar(){
        try {
            util.Util.redirecionar("principal.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(AtividadeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public List<Atividade> getListaAtividade() {
        return listaAtividade;
    }

    public void setListaAtividade(List<Atividade> listaAtividade) {
        this.listaAtividade = listaAtividade;
    }
    

}

   
    

  
    


