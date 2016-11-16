/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoTratamentoQuimico;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.TratamentoQuimico;

/**
 *
 * @author Kleber
 */
@ManagedBean(name = "tratamentoQuimicoController")
@SessionScoped
public class TratamentoQuimicoController {

    private TratamentoQuimico tratamentoQuimico = new TratamentoQuimico();
   
    private List<TratamentoQuimico> listaTratamentoQuimico;
    
    /**
     * Creates a new instance of TratamentoQuimicoController
     */
    public TratamentoQuimicoController() {
    }
    
    @PostConstruct
    public void init(){
        DaoTratamentoQuimico daoTratamentoQuimico = new DaoTratamentoQuimico();
        listaTratamentoQuimico = daoTratamentoQuimico.listar();
    }
    
    public void gravar(){
        dao.DaoTratamentoQuimico daoTratamentoQuimico = new DaoTratamentoQuimico();
        if (this.tratamentoQuimico.getId()==null){
            daoTratamentoQuimico.inserir(tratamentoQuimico);
        }else{
            daoTratamentoQuimico.atualizar(tratamentoQuimico);
        }
        tratamentoQuimico = new TratamentoQuimico();
        init();
    
    }
    
  

    
    public void excluir(TratamentoQuimico tratamentoQuimico){
        DaoTratamentoQuimico daoTratamentoQuimico = new DaoTratamentoQuimico();
        daoTratamentoQuimico.excluir(tratamentoQuimico);
        init();
    }
    
    public void alterar(TratamentoQuimico tratamentoQuimico){
        this.tratamentoQuimico = tratamentoQuimico;
    }


    
    public void voltar(){
        try {
            util.Util.redirecionar("principal.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(TratamentoQuimicoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TratamentoQuimico getTratamentoQuimico() {
        return tratamentoQuimico;
    }

    public void setTratamentoQuimico(TratamentoQuimico tratamentoQuimico) {
        this.tratamentoQuimico = tratamentoQuimico;
    }

    public List<TratamentoQuimico> getListaTratamentoQuimico() {
        return listaTratamentoQuimico;
    }

    public void setListaTratamentoQuimico(List<TratamentoQuimico> listaTratamentoQuimico) {
        this.listaTratamentoQuimico = listaTratamentoQuimico;
    }
    
}
    

