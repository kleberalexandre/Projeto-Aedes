/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoVisita;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import model.Visita;
import org.primefaces.context.RequestContext;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;


/**
 *
 * @author ronaldomartins
 */
@ManagedBean
@ViewScoped
public class MapController implements Serializable{
    
    private MapModel mapModel;
    private String centerLat;
    private String centerLong;
    
    public MapController() {
    }
    
    @PostConstruct
    public void init(){
        mapModel = new DefaultMapModel();

        DaoVisita daoVisita = new DaoVisita();
        List<Visita> listVisitas = daoVisita.listar();
        if (listVisitas.size() > 0){
            Visita v = listVisitas.get(0);
            centerLat = v.getLatitude();
            centerLong = v.getLongitude();
        }
        for(Visita v: listVisitas){
            
            Marker marker = new Marker(
                    new LatLng(  new Double(v.getLatitude()), new Double(v.getLongitude())  ),
                    "Rua: "+v.getRua().getNome()+"\n"+
                    "Bairro: "+v.getRua().getBairro().getNome()+"\n"+
                    "Recipientes: "+v.getRecipientes().size());
            if (v.getRecipientes().size()> 0)
                marker.setIcon("http://maps.google.com/mapfiles/ms/icons/red-dot.png");
            else
                marker.setIcon("http://maps.google.com/mapfiles/ms/icons/green-dot.png");
            
            
            mapModel.addOverlay(marker);        
        }
    }

    public void setMapModel(MapModel mapModel) {
        this.mapModel = mapModel;
    }

    public MapModel getMapModel() {
        return mapModel;
    }
    
     public void voltar(){
        try {
            util.Util.redirecionar("principal.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(RecipienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getCenterLat() {
        return centerLat;
    }

    public void setCenterLat(String centerLat) {
        this.centerLat = centerLat;
    }

    public String getCenterLong() {
        return centerLong;
    }

    public void setCenterLong(String centerLong) {
        this.centerLong = centerLong;
    }
     
     
}
