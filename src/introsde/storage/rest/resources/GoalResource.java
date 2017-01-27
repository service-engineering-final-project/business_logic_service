package introsde.storage.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import introsde.storage.soap.ws.*;


/***
 * The resource class that implements our service endpoints for the Goal.
 * 
 * @author alan
 *
 */

//@Stateless
//@LocalBean
@Path("/goal")
public class GoalResource {
	@Context UriInfo uriInfo;	// allows to insert contextual objects (uriInfo) into the class
	@Context Request request;	// allows to insert contextual objects (request) into the class
	
	static People_Service service = null;
	static People people = null;
	
	public GoalResource() {
		service = new People_Service();
		people = service.getPeopleImplementationPort();
	}
	
	/***
	 * A method that lists all the goals in the database.
	 * @return all the goals in the database
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getGoalsList() {
		try {
			return Response.ok(people.readGoalList()).build();
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that gives all the information of a goal identified by {id}.
	 * @param id: the identifier
	 * @return the goal identified by {id}
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}")
	public Response getGoal(@PathParam("id") Long id) {
		try {
			Goal result = people.readGoal(id);
			
			if (result!=null) {
				return Response.ok(result).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}