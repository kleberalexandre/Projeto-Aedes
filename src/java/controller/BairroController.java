/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoBairro;
import dao.DaoRecipiente;
import dao.DaoRua;
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
import model.Rua;
import org.primefaces.context.RequestContext;


/**
 *
 * @author Kleber
 */
@ManagedBean(name = "bairroController")
@SessionScoped
public class BairroController {
   
    private List<Bairro> listaBairros;
    private Bairro bairro;
    private Bairro bairroSelecionadoRua;
    private Rua rua;
    /**
     * Creates a new instance of RecipienteController
     */
    public BairroController() {
    }
    
    @PostConstruct
    public void init(){
        DaoBairro daoBairro = new DaoBairro();
        listaBairros = daoBairro.listar();
        this.bairro = new Bairro();
    }
    
    public void gravar(){
        DaoBairro daoBairro = new DaoBairro();
        if (this.bairro.getId()==null){
            daoBairro.inserir(bairro);
        }else{
            daoBairro.atualizar(bairro);
        }
        this.bairro = new Bairro();
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
    
    public void abrirRuas(Bairro bairro){
        this.bairroSelecionadoRua = bairro;
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogRuas').show();");
    }

    public List<Bairro> getListaBairros() {
        return listaBairros;
    }

    public void setListaBairros(List<Bairro> listaBairros) {
        this.listaBairros = listaBairros;
    }

    public Bairro getBairroSelecionadoRua() {
        return bairroSelecionadoRua;
    }

    public void setBairroSelecionadoRua(Bairro bairroSelecionadoRua) {
        this.bairroSelecionadoRua = bairroSelecionadoRua;
    }
    
    public void abrirInserirRua(){
        this.rua = new Rua();
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogInserirRuas').show();");        
    }
    
    public void gravarRua(){
        DaoRua daoRua = new DaoRua();
        this.rua.setBairro(this.bairroSelecionadoRua);
        this.bairroSelecionadoRua.getRuas().add(this.rua);
        daoRua.inserir(this.rua);
    }

    public Rua getRua() {
        return rua;
    }

    public void setRua(Rua rua) {
        this.rua = rua;
    }
    
    public void excluirRua(Rua rua){
        DaoRua daoRua = new DaoRua();
        daoRua.excluir(rua);
        this.bairroSelecionadoRua.getRuas().remove(rua);
    }
    
    public void alterarRua(){
        DaoRua daoRua = new DaoRua();
        daoRua.atualizar(this.rua);
        
    }
    
    public void abrirAlterarRua(Rua rua){
        this.rua = rua;
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogAlterarRuas').show();");          
    }
}


