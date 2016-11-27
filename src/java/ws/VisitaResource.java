/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.*;
import dao.DaoRecipiente;
import dao.DaoRua;
import dao.DaoSituacaoImovel;
import dao.DaoTipoVisita;
import dao.DaoUsuario;
import dao.DaoVisita;
import java.lang.reflect.Type;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Recipiente;
import model.Rua;
import model.SituacaoImovel;
import model.TipoVisita;
import model.Usuario;
import model.Visita;

/**
 * REST Web Service
 *
 * @author kleber
 */
@Path("visita")
public class VisitaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public VisitaResource() {
    }

    /**
     * Retrieves representation of an instance of ws.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public String listar() {
        DaoVisita daoVisita = new DaoVisita();
        Gson gson = new Gson();
        return gson.toJson(daoVisita.listar());
    }
    
    @PUT
    @Path("/put/{idRua}/{numero}/{nomeResponsavel}/{idsituacaoimovel}/{idagente}/{idTipoVisita}/{latitude}/{longitude}")
    @Produces(MediaType.APPLICATION_JSON)
    public String put(
            @PathParam("idRua") String idRua,
            @PathParam("numero") String numero,
            @PathParam("nomeResponsavel") String nomeResponsavel,
            @PathParam("idsituacaoimovel") String idsituacaoimovel,
            @PathParam("idagente") String idagente,
            @PathParam("idTipoVisita") String idTipoVisita,
            @PathParam("latitude") String latitude,
            @PathParam("longitude") String longitude) {
        String resp = "falha";
        try{
            DaoVisita daoVisita = new DaoVisita();
            Visita visita = new Visita();
            Rua rua = (new DaoRua()).getById(new Integer(idRua));
            SituacaoImovel situacaoImovel = (new DaoSituacaoImovel()).getById(new Integer(idsituacaoimovel));
            Usuario agente = (new DaoUsuario()).getById(new Integer(idagente));
            TipoVisita tipoVisita = (new DaoTipoVisita()).getById(new Integer(idTipoVisita));
            visita.setAgente(agente);
            visita.setNomeResponsavel(nomeResponsavel);
            visita.setNumero(numero);
            visita.setRua(rua);
            visita.setSituacaoImovel(situacaoImovel);
            visita.setTipoVisita(tipoVisita);
            visita.setLatitude(latitude);
            visita.setLongitude(longitude);
            (new DaoVisita()).inserir(visita);
            resp = visita.getId()+"";
        }catch(Exception ex){
            resp = "falha";
        }
        
        Gson gson = new Gson();
        return gson.toJson(resp);
        
    }     

    @PUT
    @Path("/putRecipiente/{idVisita}/{idRecipiente}")
    @Produces(MediaType.APPLICATION_JSON)
    public String putRecipiente(@PathParam("idVisita") String idVisita,
            @PathParam("idRecipiente") String idRecipiente){
        String resp = "falha";
        try{
            DaoVisita daoVisita = new DaoVisita();
            DaoRecipiente daoRecipiente= new DaoRecipiente();
            Visita visita = daoVisita.getById(Integer.parseInt(idVisita));
            Recipiente recipiente = daoRecipiente.getById(Integer.parseInt(idRecipiente));
            visita.getRecipientes().add(recipiente);
            recipiente.getVisitas().add(visita);
            daoVisita.atualizar(visita);
            resp="sucesso";
        }catch(Exception ex){
            resp="falha";
        }
        return resp;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
