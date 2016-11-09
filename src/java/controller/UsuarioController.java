
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoUsuario;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
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
    private List<Usuario> listaUsuarios;
    /**
     * Creates a new instance of BairroController
     */
    public UsuarioController() {
    }
    
    @PostConstruct
    public void init(){
        DaoUsuario daoUsuario = new DaoUsuario();
        listaUsuarios = daoUsuario.listar();
    }
    
    public void gravar(){
        dao.DaoUsuario daoUsuario = new DaoUsuario();
        if (this.usuario.getId()==null){
            daoUsuario.inserir(usuario);
        }else{
            daoUsuario.atualizar(usuario);
        }
        usuario = new Usuario();
        init();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setPerfil(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    public void excluir(Usuario usuario){
        DaoUsuario daoUsuario = new DaoUsuario();
        daoUsuario.excluir(usuario);
        init();
    }
    
    public void alterar(Usuario usuario){
        this.usuario = usuario;
    }
    
    public void voltar(){
        try {
            util.Util.redirecionar("principal.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
