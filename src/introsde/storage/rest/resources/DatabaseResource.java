package introsde.storage.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import introsde.storage.soap.ws.People;
import introsde.storage.soap.ws.People_Service;


/***
 * The resource class that implements our service endpoints for the database initialization.
 * 
 * @author alan
 *
 */

//@Stateless
//@LocalBean
@Path("/init")
public class DatabaseResource {
	@Context UriInfo uriInfo;	// allows to insert contextual objects (uriInfo) into the class
	@Context Request request;	// allows to insert contextual objects (request) into the class
	
	static People_Service service = null;
	static People people = null;
	
	public DatabaseResource() {
		service = new People_Service();
		people = service.getPeopleImplementationPort();
	}
	
	/***
	 * A method that initialize the database.
	 * @return all the people in the database
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response databaseInitialization() {
		try {
			System.out.println("Initialization of the database...");
			people.initializeDatabase();
			System.out.println("\tInitialization of the database succeeded!");
			return Response.status(Response.Status.OK).build();
		} catch(Exception e) {
			System.out.println("ERROR! The initialization of the database didn't succeed!");
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}