package introsde.storage.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import introsde.storage.soap.ws.*;


/***
 * The resource class that implements our service endpoints for the Measure.
 * 
 * @author alan
 *
 */

//@Stateless
//@LocalBean
@Path("/measure")
public class MeasureResource {
	@Context UriInfo uriInfo;	// allows to insert contextual objects (uriInfo) into the class
	@Context Request request;	// allows to insert contextual objects (request) into the class
	
	static People_Service service = null;
	static People people = null;
	
	public MeasureResource() {
		service = new People_Service();
		people = service.getPeopleImplementationPort();
	}
	
	/***
	 * A method that returns the list of all the measures supported by the service.
	 * @return the list of all the measures supported by the service
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response readMeasureTypes() {
		try {
			return Response.ok(people.readMeasureTypes()).build();
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}