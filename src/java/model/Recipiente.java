/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Kleber
 */
@Entity
@Table(name = "recipiente")
public class Recipiente {
    @Column(nullable = false, length = 15)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;   
    @Column(nullable = false, length = 150)
    private String descricao;
    @Column(nullable = false, length = 20)
    private String risco;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
  
    private String recipiente;

    public String getRecipiente() {
        return recipiente;
    }

    public void setRecipiente(String recipiente) {
        this.recipiente = recipiente;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    
}
