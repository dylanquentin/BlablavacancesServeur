package fr.iutinfo.skeleton.api;

import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static fr.iutinfo.skeleton.api.BDDFactory.tableExist;

import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static fr.iutinfo.skeleton.api.BDDFactory.tableExist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.UserDto;
import fr.iutinfo.skeleton.common.dto.VoyageDto;

@Path("/voyage")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class VoyageResource {
    final static Logger logger = LoggerFactory.getLogger(VoyageResource.class);
    private static VoyageDao dao = getDbi().open(VoyageDao.class);
	private static Map<Integer, Voyage> voyages = new HashMap<>();
	@Context
	public UriInfo uriInfo;
    public VoyageResource() throws SQLException {
        if (!tableExist("voyages")) {
            logger.debug("Create table voyage");
            dao.createVoyageTable();
            dao.insert(new Voyage(1, 1 , "Petit weekend à Paris","Paris"));
        }
        dao.insert(new Voyage(1, 1 , "Petit weekend à Paris","Paris"));
    }
    
    @POST
    public Response createVoyage(Voyage voyage) {      
    	   if ( voyages.containsKey(voyage.getId()) ) {
               return Response.status(Response.Status.CONFLICT).build();
           }
           else {
               voyages.put(voyage.getId(), voyage);
               // On renvoie 201 et l'instance de la ressource dans le Header HTTP 'Location'
               String tp = "" + voyage.getId();
               URI instanceURI = uriInfo.getAbsolutePathBuilder().path(tp).build();
               return Response.created(instanceURI).build();
           }
    }
  
	@GET
	public List<Voyage> getVoyage() {
		return new ArrayList<Voyage>(voyages.values());
	}
	
/*
  @GET
    @Path("/{ville}")
    public VoyageDto getVoyageVille(@PathParam("ville") String ville) {
        Voyage voyage = dao.findByName(ville);
        if (ville == null) {
            throw new WebApplicationException(404);
        }
        return voyage.convertToDto();
    }
   
    @GET
	@Path("/{name}")
	    public VoyageDto getVoyage(@PathParam("name") String name) {
	        Voyage voyage = dao.findByName(name);
	        if (voyage == null) {
	            throw new WebApplicationException(404);
	        }
	        return voyage.convertToDto();
	    }

   @GET
	    public List<VoyageDto> getAllVoyages(@QueryParam("q") String query) {
	        List<Voyage> voyages;
	        if (query == null) {
	            voyages = dao.all();
	        } else {
	            logger.debug("Search voyages with query: " + query);
	            voyages = dao.search("%" + query + "%");
	        }
	        return voyages.stream().map(Voyage::convertToDto).collect(Collectors.toList());
	    }
*/
	
    @DELETE
    @Path("/{id}")
    public void deleteVoyage(@PathParam("id") int id) {
        dao.delete(id);
    }
    
	@PUT
    @Path("/{id}")
    public Response modifVoyage(@PathParam("id") int id, Voyage voyage) {
        // Si l'utilisateur est inconnu, on renvoie 404
        if (id != voyage.getId()) {
	    throw new NotFoundException();
        }
        else {
        	dao.update(id, voyage);
	    return Response.status(Response.Status.NO_CONTENT).build();
        }
    }
}
