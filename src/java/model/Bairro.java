/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Kleber
 */
@Entity
@Table(name = "bairro")
public class Bairro {
    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Expose
    private String nome;
    
    @OneToMany(mappedBy = "bairro")
    private List<Rua> ruas = new ArrayList<Rua>();
    

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

    public List<Rua> getRuas() {
        return ruas;
    }

    public void setRuas(List<Rua> ruas) {
        this.ruas = ruas;
    }
    
    
}
