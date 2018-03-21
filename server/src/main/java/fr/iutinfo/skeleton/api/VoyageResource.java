package fr.iutinfo.skeleton.api;

import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static fr.iutinfo.skeleton.api.BDDFactory.tableExist;

import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static fr.iutinfo.skeleton.api.BDDFactory.tableExist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        if (!tableExist("voyage")) {
            logger.debug("Create table voyage");
            dao.createVoyageTable();

            dao.insert(new Voyage(1, 1 , "Petit weekend à Paris","Paris"));

        }
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
	public List<Voyage> getPizzas() {
		return new ArrayList<Voyage>(voyages.values());
	}

  /*  @GET
    @Path("/{ville}")
    public UserDto getVille(@PathParam("ville") String name) {
        Voyage voyage = dao.findByName(name);
        if (user == null) {
            throw new WebApplicationException(404);
        }
        return user.convertToDto();
    }

    @GET
    public List<UserDto> getAllUsers(@QueryParam("q") String query) {
        List<User> users;
        if (query == null) {
            users = dao.all();
        } else {
            logger.debug("Search users with query: " + query);
            users = dao.search("%" + query + "%");
        }
        return users.stream().map(User::convertToDto).collect(Collectors.toList());
    }

    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam("id") int id) {
        dao.delete(id);
    }
    
	@PUT
    @Path("/{id}")
    public Response modifyUser(@PathParam("id") int id, User user) {
        // Si l'utilisateur est inconnu, on renvoie 404
        if (id != user.getId()) {
	    throw new NotFoundException();
        }
        else {
        	dao.update(id, user);
	    return Response.status(Response.Status.NO_CONTENT).build();
        }
    }*/

}
