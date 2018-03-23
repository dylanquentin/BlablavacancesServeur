package fr.iutinfo.skeleton.api;


import fr.iutinfo.skeleton.common.dto.PreferenceDto;

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

@Path("/preference")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PreferenceResource {
    final static Logger logger = LoggerFactory.getLogger(PreferenceResource.class);
    private static PreferenceDao dao = getDbi().open(PreferenceDao.class);

    public PreferenceResource() throws SQLException {
        if (!tableExist("preference")) {
            logger.debug("Create table preference");
            dao.createPreferenceTable();
            dao.insert(new Preference(0, "Marche", "Dormir", "Sport"));
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public PreferenceDto createPreference(PreferenceDto dto) {
    	Preference preference = new Preference();
    	preference.initFromDto(dto);
        int id = dao.insert(preference);
        dto.setIdVoyage(id);
        return dto;
    }

    @GET
    @Path("/{preference}")
    public PreferenceDto getUser(@PathParam("idVoyage") int idVoyage) {
        Preference pref = dao.findById(idVoyage);
        if (idVoyage < 0) {
            throw new WebApplicationException(404);
        }
        return pref.convertToDto();
    }


    @GET
    public List<PreferenceDto> getAllPreference(@QueryParam("q") String query) {
        List<Preference> preferences;
        if (query == null) {
            preferences = dao.all();
        } else {
            logger.debug("Search preference with query: " + query);
            preferences = dao.search("%" + query + "%");
        }
        return preferences.stream().map(Preference::convertToDto).collect(Collectors.toList());
    }

    @DELETE
    @Path("/{idVoyage}")
    public void deletePreference(@PathParam("idVoyage") int idVoyage) {
        dao.delete(idVoyage);
    }
    
	@PUT
    @Path("/{idVoyage}")
    public Response modifyUser(@PathParam("idVoyage") int idVoyage, Preference preference) {
        // Si l'utilisateur est inconnu, on renvoie 404
        if (dao.findById(idVoyage) == null) {
	    throw new NotFoundException();
        }
        else {
        	dao.update(idVoyage, preference);
	    return Response.status(Response.Status.NO_CONTENT).build();
        }
    }

}
