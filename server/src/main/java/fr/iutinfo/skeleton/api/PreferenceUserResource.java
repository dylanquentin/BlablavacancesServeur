package fr.iutinfo.skeleton.api;


import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static fr.iutinfo.skeleton.api.BDDFactory.tableExist;

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

import fr.iutinfo.skeleton.common.dto.PreferenceUserDto;
import fr.iutinfo.skeleton.common.dto.UserDto;

@Path("/PreferenceUser")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PreferenceUserResource {
    final static Logger logger = LoggerFactory.getLogger(PreferenceUserResource.class);
    private static PreferenceUserDao dao = getDbi().open(PreferenceUserDao.class);
    
    public PreferenceUserResource() throws SQLException {
        if (!tableExist("PreferenceUser")) {
            logger.debug("Create table PreferenceUser");
            dao.createpreferenceUserTable();
            dao.insert(new PreferenceUser(0, "Marche", "Dormir", "Sport"));
        }
        
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public PreferenceUserDto createPreferenceUser(PreferenceUserDto dto) {
    	dto.setidUser(dao.maxId());
    	PreferenceUser preferenceUser = new PreferenceUser();
    	preferenceUser.initFromDto(dto);
        int id = dao.insert(preferenceUser);
        return dto;
    }

    @GET
    @Path("/{PreferenceUser}")
    public PreferenceUserDto getUser(@PathParam("IdUser") int IdUser) {
        PreferenceUser pref = dao.findById(IdUser);
        if (IdUser < 0) {
            throw new WebApplicationException(404);
        }
        return pref.convertToDto();
    }


    @GET
    public List<PreferenceUserDto> getAllPreferenceUser(@QueryParam("q") String query) {
        List<PreferenceUser> preferenceUsers;
        if (query == null) {
            preferenceUsers = dao.all();
        } else {
            logger.debug("Search PreferenceUser with query: " + query);
            preferenceUsers = dao.search("%" + query + "%");
        }
        return preferenceUsers.stream().map(PreferenceUser::convertToDto).collect(Collectors.toList());
    }

    @DELETE
    @Path("/{IdUser}")
    public void deletePreferenceUser(@PathParam("IdUser") int IdUser) {
        dao.delete(IdUser);
    }
    
	@PUT
    @Path("/{IdUser}")
    public Response modifyUser(@PathParam("IdUser") int IdUser, PreferenceUser preferenceUser) {
        // Si l'utilisateur est inconnu, on renvoie 404
        if (dao.findById(IdUser) == null) {
	    throw new NotFoundException();
        }
        else {
        	dao.update(IdUser, preferenceUser);
	    return Response.status(Response.Status.NO_CONTENT).build();
        }
    }

}
