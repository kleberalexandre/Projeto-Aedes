/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoUsuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Usuario;

/**
 *
 * @author Kleber
 */
@ManagedBean(name = "usuarioController")
@SessionScoped
public class UsuarioController {

    private Usuario usuario = new Usuario();
    /**
     * Creates a new instance of BairroController
     */
    public UsuarioController() {
    }
    
    public void gravar(){
        dao.DaoUsuario daoUsuario = new DaoUsuario();
        Object Usuario = null;
        daoUsuario.inserir(Usuario);
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setPerfil(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
