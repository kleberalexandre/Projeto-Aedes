/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoPerfil;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Bairro;
import model.Perfil;

/**
 *
 * @author Kleber
 */
@ManagedBean(name = "perfilController")
@SessionScoped
public class PerfilController {

    private Perfil perfil = new Perfil();
    /**
     * Creates a new instance of BairroController
     */
    public PerfilController() {
    }
    
    public void gravar(){
        dao.DaoPerfil daoPerfil = new DaoPerfil();
        daoPerfil.inserir(perfil);
        perfil = new Perfil();
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    
    
    
}
