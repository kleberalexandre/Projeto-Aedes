/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.DaoAtividade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author kleber
 */
@Path("atividade")
public class AtividadeResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public AtividadeResource() {
    }

    /**
     * Retrieves representation of an instance of ws.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public String listar() {
        DaoAtividade daoAtividade = new DaoAtividade();
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(daoAtividade.listar());
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
