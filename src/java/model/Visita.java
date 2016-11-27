/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Kleber
 */
@Entity
@Table(name = "visita")
public class Visita {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @ManyToOne
    @JoinColumn(name = "idrua")
    private Rua rua;
    private String numero;
    private String nomeResponsavel;
    @ManyToOne
    @JoinColumn(name = "idsituacaoimovel")
    private SituacaoImovel situacaoImovel;
    @ManyToOne
    @JoinColumn(name = "idagente")
    private Usuario agente; 
    @ManyToOne
    @JoinColumn(name = "idtipovisita")
    private TipoVisita tipoVisita;

    private String longitude;
    private String latitude;
    
    
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name="visita_recipiente",
          joinColumns = {@JoinColumn(name="visita_id",referencedColumnName = "id")},
          inverseJoinColumns = {@JoinColumn(name="recipiente_id",referencedColumnName = "id")}
    )    
    private List<Recipiente> recipientes = new ArrayList<Recipiente>();
    
    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public Rua getRua() {
        return rua;
    }

    public void setRua(Rua rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public SituacaoImovel getSituacaoImovel() {
        return situacaoImovel;
    }

    public void setSituacaoImovel(SituacaoImovel situacaoImovel) {
        this.situacaoImovel = situacaoImovel;
    }

    public Usuario getAgente() {
        return agente;
    }

    public void setAgente(Usuario agente) {
        this.agente = agente;
    }

    public TipoVisita getTipoVisita() {
        return tipoVisita;
    }

    public void setTipoVisita(TipoVisita tipoVisita) {
        this.tipoVisita = tipoVisita;
    }

    public List<Recipiente> getRecipientes() {
        return recipientes;
    }

    public void setRecipientes(List<Recipiente> recipientes) {
        this.recipientes = recipientes;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    
    
}
