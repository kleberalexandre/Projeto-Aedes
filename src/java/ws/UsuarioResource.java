/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.*;
import dao.DaoRua;
import dao.DaoUsuario;
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
import model.Usuario;

/**
 * REST Web Service
 *
 * @author kleber
 */
@Path("usuario")
public class UsuarioResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public UsuarioResource() {
    }

    /**
     * Retrieves representation of an instance of ws.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public String listar() {
        DaoUsuario daoUsuario = new DaoUsuario();
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(daoUsuario.listar());
    }
    
    @PUT
    @Path("/logar/{usuario}/{senha}")
    @Produces(MediaType.APPLICATION_JSON)
    public String listarById(@PathParam("usuario") String usuario, @PathParam("senha") String senha) {
        DaoUsuario daoUsuario = new DaoUsuario();
        Gson gson = new Gson();
        if (daoUsuario.logar(usuario, senha) == null)
            return gson.toJson("falha");
        else
            return gson.toJson("sucesso");
    }    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
