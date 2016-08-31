/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.List;

/**
 *
 * @author Kleber
 */
public class Visita {
    private Integer id;
    private String rua;
    private String numero;
    private String responsavel;
    private String situacaoimovel;
    private List recipientes;
    private List tratamentoquimico;
    private String tipovisita; 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getSituacaoimovel() {
        return situacaoimovel;
    }

    public void setSituacaoimovel(String situacaoimovel) {
        this.situacaoimovel = situacaoimovel;
    }

    public List getRecipientes() {
        return recipientes;
    }

    public void setRecipientes(List recipientes) {
        this.recipientes = recipientes;
    }

    public List getTratamentoquimico() {
        return tratamentoquimico;
    }

    public void setTratamentoquimico(List tratamentoquimico) {
        this.tratamentoquimico = tratamentoquimico;
    }

    public String getTipovisita() {
        return tipovisita;
    }

    public void setTipovisita(String tipovisita) {
        this.tipovisita = tipovisita;
    }
    
}
