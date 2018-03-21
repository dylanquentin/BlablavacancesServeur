package fr.iutinfo.skeleton.api;

import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static fr.iutinfo.skeleton.api.BDDFactory.tableExist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


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
