package fr.iutinfo.skeleton.api;

import static fr.iutinfo.skeleton.api.Helper.createUserWithName;
import static fr.iutinfo.skeleton.api.Helper.createVoyageWithName;
import static fr.iutinfo.skeleton.api.Helper.listVoyageResponseType;
import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.iutinfo.skeleton.common.dto.VoyageDto;

public class VoyageResourceTest extends JerseyTest {
    private static final String PATH = "/voyage";
    private VoyageDao dao = BDDFactory.getDbi().open(VoyageDao.class);

    @Override
    protected Application configure() {
        return new Api();
    }

    @Before
    public void init() {
        Helper.initDb();
    }
/*
   @Test
    public void read_should_return_a_Voyage_as_object() {
        createVoyageWithName("test", "Lille");
        VoyageDto voyage = target(PATH + "/test").request().get(VoyageDto.class);
        assertEquals("test", voyage.getName());
    }


    @Test
    public void create_should_return_the_voyage_with_valid_id() {
        Voyage voyage = new Voyage(0, 1,"test","Lille");
        Entity<Voyage> voyageEntity = Entity.entity(voyage, MediaType.APPLICATION_JSON);
        String json = target(PATH).request().post(voyageEntity).readEntity(String.class);
        assertEquals("{\"id\":1,\"name\":\"test\"", json.substring(0, 45));
    }

    @Test
    public void list_should_return_all_voyages() {
        createVoyageWithName("test", "Lille");
        createVoyageWithName("done", "Paris");
        List<VoyageDto> voyages = target(PATH + "/").request().get(listVoyageResponseType);
        assertEquals(2, voyages.size());
    }

    @Test
    public void list_all_must_be_ordered() {
        createVoyageWithName("test", "Lille");
        createVoyageWithName("done", "Paris");
        List<VoyageDto> voyages = target(PATH + "/").request().get(listVoyageResponseType);
        assertEquals("test", voyages.get(0).getName());
    }

    @Test
    public void after_delete_read_user_sould_return_204() {
        User u = createUserWithName("toto");
        int status = target(PATH + "/" + u.getId()).request().delete().getStatus();
        assertEquals(204, status);
    }

    @Test
    public void should_delete_voyage() {
        Voyage v = createVoyageWithName("test", "Lille");
        target(PATH + "/" + v.getId()).request().delete();
        Voyage voyage = dao.findById(v.getId());
        Assert.assertEquals(null, voyage);
    }

    @Test
    public void delete_unexisting_should_return_404() {
        int status = target(PATH + "/unexisting").request().delete().getStatus();
        assertEquals(404, status);
    }

    @Test
    public void list_should_search_in_name_field() {
        createVoyageWithName("test", "Lille");
        createVoyageWithName("done", "Paris");

        List<VoyageDto> voyages = target(PATH + "/").queryParam("q", "do").request().get(listVoyageResponseType);
        assertEquals("done", voyages.get(0).getName());
    }


    
    @Test
	public void testModifyInexistantVoyage() {
        createVoyageWithName("test", "Lille");
    	VoyageDto voyage = target(PATH + "/test").request().get(VoyageDto.class);
        Entity<VoyageDto> voyageEntity = Entity.entity(voyage, MediaType.APPLICATION_JSON);
		int notFound = target(PATH +"/test").request().put(voyageEntity).getStatus();
		assertEquals(404, notFound);
	}

	/**
	 *
	 * Vérifie que la modification d'une ressource est effective
	 */
/*	@Test
	public void testModifyUSer() {
        createUserWithName("foo");
        UserDto utilisateur = target(PATH + "/foo").request().get(UserDto.class);
        Entity<UserDto> userEntity = Entity.entity(utilisateur, MediaType.APPLICATION_JSON);
		target(PATH + "/foo").request().post(userEntity);

        createUserWithName("mod");
        UserDto modified = target(PATH + "/mod").request().get(UserDto.class);
        userEntity = Entity.entity(modified, MediaType.APPLICATION_JSON);

		int noContent = target(PATH + "/foo").request().put(userEntity).getStatus();
		assertEquals(204, noContent);

		UserDto retrieved = target(PATH + "/mod").request().get(UserDto.class);
		assertEquals(modified, retrieved);
	} */
}
