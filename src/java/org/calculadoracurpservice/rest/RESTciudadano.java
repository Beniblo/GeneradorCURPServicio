package org.calculadoracurpservice.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.calculadoracurpservice.controller.GeneradorCurp;
import org.calculadoracurpservice.model.Ciudadano;

@Path("restciudadano")
public class RESTciudadano {

    @GET
    @Path("generarcurp")
    @Produces(MediaType.APPLICATION_JSON)
    public Response generarCurp(@QueryParam("nom1") @DefaultValue("NULL") String primerNombre, 
                                @QueryParam("nom2") @DefaultValue("NULL") String segundoNombre,
                                @QueryParam("ap1") @DefaultValue("NULL") String apellidoPaterno,
                                @QueryParam("ap2") @DefaultValue("NULL") String apellidoMaterno,
                                @QueryParam("gen") @DefaultValue("X") char genero,
                                @QueryParam("fn") @DefaultValue("NULL") String fechaDeNacimiento,
                                @QueryParam("ent") @DefaultValue("NULL") String entidad,
                                @QueryParam("cg") @DefaultValue("NULL") String curpGenerada)
    {
        Ciudadano ciudadano = new Ciudadano(primerNombre, segundoNombre, apellidoPaterno, apellidoMaterno,
                                            genero, fechaDeNacimiento, entidad, curpGenerada);
        
        String cp = GeneradorCurp.generarCurpCompleta(ciudadano);
        
        ciudadano.setCurpGenerada(cp);
        
        Gson gson = new Gson();
        String out = gson.toJson(ciudadano);
        
        return Response.status(Response.Status.OK).entity(out).build();
    }
}
