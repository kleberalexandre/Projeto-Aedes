/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoBairro;
import dao.DaoRecipiente;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
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

    private Bairro recipiente = new Bairro();
   
    private List<Bairro> listaBairros;
    private Bairro bairro;
    
    /**
     * Creates a new instance of RecipienteController
     */
    public BairroController() {
    }
    
    @PostConstruct
    public void init(){
        DaoBairro daoBairro = new DaoBairro();
        listaBairros = daoBairro.listar();
    }
    
    public void gravar(){
        dao.DaoBairro daoBairro = new DaoBairro();
        if (this.bairro.getId()==null){
            daoBairo.inserir(bairro);
        }else{
            DaoBairro.atualizar(bairro)
        }
        bairro Bairro = new bairro();
        init();
    }
  

    
    public void excluir(Bairro bairro){
        DaoBairro daoBairro = new DaoBairro();
        daoBairro.excluir(bairro);
        init();
    }
    
    public void alterar(Bairro bairro){
        this.bairro = bairro;
    }


    
    public void voltar(){
        try {
            util.Util.redirecionar("principal.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(BairroController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public List<Bairro> getListaBairro() {
        return listaBairros;
    }

    public void setListaBairro(List<Bairro> bairros) {
        this.listaBairros = listaBairros;
    }

    private static class daoBairo {

        private static void inserir(Bairro bairro) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public daoBairo() {
        }
    }

    private static class bairro {

        public bairro() {
        }
    }

   
    }
    
    


