/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Kleber
 */
public class Quadra {
    private Integer id;
    private String nome;   
    private List ruas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Lista getRuas() {
        return ruas;
    }

    public void setRuas(Lista ruas) {
        this.ruas = ruas;
    }
}
