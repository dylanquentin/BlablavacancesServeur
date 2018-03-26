package fr.iutinfo.skeleton.api;


import fr.iutinfo.skeleton.common.dto.MessagerieDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static fr.iutinfo.skeleton.api.BDDFactory.tableExist;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessagerieResource {
    final static Logger logger = LoggerFactory.getLogger(MessagerieResource.class);
    private static MessagerieDao dao = getDbi().open(MessagerieDao.class);

    public MessagerieResource() throws SQLException {
        if (!tableExist("messages")) {
            logger.debug("Create table messages");
            dao.createMessagesTable();
            dao.insert(new Messagerie(1));
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public MessagerieDto createMessagerie(MessagerieDto dto) {
    	Messagerie m = new Messagerie();
    	m.initFromDto(dto);
        int id = dao.insert(m);
        dto.setId(id);
        return dto;
    }

    @GET
    @Path("/{messageID}")
    public MessagerieDto getUser(@PathParam("id") int id) {
        Messagerie m = dao.findById(id);
        if (id < 0) {
            throw new WebApplicationException(404);
        }
        return m.convertToDto();
    }


    @GET
    public List<MessagerieDto> getAllMessagerie(@QueryParam("q") String query) {
        List<Messagerie> m;
        if (query == null) {
            m = dao.all();
        } else {
            logger.debug("Search preference with query: " + query);
            m = dao.search("%" + query + "%");
        }
        return m.stream().map(Messagerie::convertToDto).collect(Collectors.toList());
    }

    @DELETE
    @Path("/{id}")
    public void deleteMessagerie(@PathParam("id") int id) {
        dao.delete(id);
    }
    
	@PUT
    @Path("/{id}")
    public Response modifyUser(@PathParam("id") int id, Messagerie Messagerie) {
        // Si l'utilisateur est inconnu, on renvoie 404
        if (dao.findById(id) == null) {
	    throw new NotFoundException();
        }
        else {
        	dao.update(id, Messagerie);
	    return Response.status(Response.Status.NO_CONTENT).build();
        }
    }

}

