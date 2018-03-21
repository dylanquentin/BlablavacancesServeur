package fr.iutinfo.skeleton.api;

import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static fr.iutinfo.skeleton.api.BDDFactory.tableExist;
<<<<<<< HEAD
=======

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.UserDto;

@Path("/voyage")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VoyageResource {
  /*  final static Logger logger = LoggerFactory.getLogger(VoyageResource.class);
    private static VoyageDAO dao = getDbi().open(VoyageDAO.class);

    public VoyageResource() throws SQLException {
        if (!tableExist("voyage")) {
            logger.debug("Create table voyage");
            dao.createVoyageTable();
            dao.insert(new Voyage(0, 0 , "Paris"));
        }
    }

    @POST
    public UserDto createUser(UserDto dto) {
        Voyage voyage = new Voyage();
        int id = dao.insert(user);
        dto.setId(id);
        return dto;
    }

    @GET
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
>>>>>>> branch 'master' of https://git-iut.univ-lille1.fr/catteauk/BlablaVacancesServeur.git

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.VoyageDto;

public class VoyageResource {
	@Path("/voyage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public class UserResource {
	    final Logger logger = LoggerFactory.getLogger(VoyageResource.class);
	    private VoyageDao dao = getDbi().open(VoyageDao.class);

	    public UserResource() throws SQLException {
	        if (!tableExist("users")) {
	            logger.debug("Create table users");
	            dao.createVoyageTable();
	            dao.insert(new Voyage(0,0, "Camping à plusieurs proche de la mer", "Dunkerque"));
	        }
	    }

	    @POST
	    public VoyageDto createVoyage(VoyageDto dto,int idUser) {
	        Voyage voyage = new Voyage();
	        voyage.initFromDto(dto);
	        int id = dao.insert(voyage);
	        dto.setId(id);
	        dto.setIdUser(idUser);
	        return dto;
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
}
