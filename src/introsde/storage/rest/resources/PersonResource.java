package introsde.storage.rest.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import introsde.storage.soap.ws.*;


/***
 * The resource class that implements our service endpoints for the Person.
 * 
 * @author alan
 *
 */

//@Stateless
//@LocalBean
@Path("/person")
public class PersonResource {
	@Context UriInfo uriInfo;	// allows to insert contextual objects (uriInfo) into the class
	@Context Request request;	// allows to insert contextual objects (request) into the class
	
	static People_Service service = null;
	static People people = null;
	
	public PersonResource() {
		service = new People_Service();
		people = service.getPeopleImplementationPort();
	}
	
	/***
	 * A method that lists all the people in the database.
	 * @return all the people in the database
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getPeopleList() {
		try {
			return Response.ok(people.readPersonList()).build();
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that gives all the information of a person identified by {id}.
	 * @param id: the identifier
	 * @return the person identified by {id}
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}")
	public Response getPerson(@PathParam("id") Long id) {
		try {
			Person result = people.readPerson(id);
			
			if (result!=null) {
				return Response.ok(result).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that updates the information of a person identified by {id}
	 * (i.e. only the person's information, not the measures of the health profile).
	 * @param p: the person to update
	 * @param id: the identifier of the person to update
	 * @return the person updated
	 */
	@PUT
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}")
	public Response updatePerson(Person p, @PathParam("id") int id) {
		try {
			p.setId(id);
			
			if (people.readPerson(Long.valueOf(id))!=null) {
				Person result = people.updatePerson(p);
				return Response.ok(result).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
		} catch(Exception e) {
			System.out.println(e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that creates a new person and returns it with its assigned id
	 * (i.e. if a health profile is included, also its measurements will be created).
	 * @param p: the person to create
	 * @return the person created
	 */
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response createPerson(Person p) {
		try {
			Person result = people.createPerson(p);
			
			if (result!=null) {
				return Response.status(Response.Status.CREATED).entity(result).build();
			} else {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			}
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that deletes the person identified by {id} from the system.
	 * @param id: the identifier of the person to delete
	 */
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}")
	public Response deletePerson(@PathParam("id") Long id) {
		try {
			if (people.readPerson(id)!=null) {
				people.deletePerson(id);
				return Response.status(Response.Status.NO_CONTENT).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that returns the list of values (the history) of {measureType}
	 * (e.g. weight) for a person identified by {id}.
	 * @param id: the identifier of the person
	 * @param measureType: the measure of interest
	 * @return the list of all the measurements of a particular measure relative to a person
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}/{measure_type}")
	public Response readPersonHistory(
			@PathParam("id") Long id,
			@PathParam("measure_type") String measureType
	) {
		try {
			return Response.ok(people.readPersonHistory(id, measureType)).build();
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that returns the value of {measureType} (e.g. weight)
	 * identified by {mid} for a person identified by {id}.
	 * @param id: the identifier of the person
	 * @param measureType: the measure of interest
	 * @param mid: the measure identifier
	 * @return the value of the measure with a particular identifier relative to a person
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}/{measure_type}/{mid}")
	public Response readPersonMeasure(
			@PathParam("id") Long id,
			@PathParam("measure_type") String measureType,
			@PathParam("mid") Long mid
	) {
		try {
			MeasurementHistory result = people.readPersonMeasure(id, measureType, mid);
			
			if (result!=null) {
				return Response.ok(result).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that saves a new measure object {m} (e.g. weight)
	 * for a person identified by {id} and archives the old value in the history.
	 * @param m: the measurement of interest
	 * @param id: the identifier of the person
	 * @param name: the name of the measure of interest
	 * @return the saved measurement
	 */
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}/{measure_type}")
	public Response savePersonMeasure(
			Measurement m,
			@PathParam("id") Long id,
			@PathParam("measure_type") String name
	) {
		try {
			m.setMeasure(name);
			
			Measurement result = people.savePersonMeasure(id, m);
			
			if (result!=null) {
				return Response.status(Response.Status.CREATED).entity(result).build();
			} else {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			}
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that updates the measure (e.g. weight) identified
	 * with {m.mid} for a person identified by {id}.
	 * @param m: the measurement history of interest
	 * @param id: the identifier of the person
	 * @param mid: the identifier of the measurement
	 * @param name: the name of the measure of interest
	 * @return the saved measurement
	 */
	@PUT
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}/{measure_type}/{mid}")
	public Response updatePersonMeasure(
			MeasurementHistory m,
			@PathParam("id") Long id,
			@PathParam("mid") int mid,
			@PathParam("measure_type") String name
	) {
		try {
			m.setMeasure(name);
			m.setMid(mid);
			
			if (people.readPersonMeasure(id, name, Long.valueOf(mid))!=null) {
				Long result = people.updatePersonMeasure(id, m);
				String jsonResult = "{\"mid\": " + result + ", \"measure\": \"" + m.getMeasure() + "\"}";
				return Response.ok(jsonResult).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that gives all the information of a goal identified by {gId} for a particular person {id}.
	 * @param id: the identifier of the person
	 * @param gId: the identifier of the goal
	 * @return the goal identified by {id}
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}/goal/{gId}")
	public Response getPersonGoalById(
			@PathParam("id") Long id,
			@PathParam("gId") Long gId) {
		try {
			Goal result = people.readPersonGoalById(id, gId);
			
			if (people.readGoal(gId)!=null) {
				if (result!=null) {
					return Response.ok(result).build();
				} else {
					return Response.status(Response.Status.FORBIDDEN).build();
				}
			} else {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that creates a goal identified by {gId} for a particular person {id}.
	 * @param id: the identifier of the person
	 * @return the created goal identified by {id}
	 */
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}/goal")
	public Response createPersonGoal(
			Goal g,
			@PathParam("id") Long id) {
		try {
			Goal result = people.createGoal(id, g);
			
			if (result!=null) {
				return Response.status(Response.Status.CREATED).entity(result).build();
			} else {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			}
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that updates the information of a goal identified by {gId} for a particular person {id}.
	 * @param id: the identifier of the person
	 * @param gId: the identifier of the goal
	 * @return the updated goal identified by {id}
	 */
	@PUT
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}/goal/{gId}")
	public Response updatePersonGoal(
			Goal g,
			@PathParam("id") Long id,
			@PathParam("gId") Long gId) {
		try {
			g.setId(gId.intValue());
			
			if (people.readGoal(gId)!=null) {
				if (people.readPersonGoalById(id, gId)==null) {
					Goal result = people.updateGoal(id, g);
					return Response.ok(result).build();
				} else {
					return Response.status(Response.Status.FORBIDDEN).build();
				}
			} else {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that deletes the goal identified by {id} from the system.
	 * @param id: the identifier of the person
	 * @param gId: the identifier of the goal to delete
	 */
	@DELETE
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{id}/goal/{gId}")
	public Response deletePersonGoal(
			@PathParam("id") Long id,
			@PathParam("gId") Long gId) {
		try {
			if (people.readGoal(gId)!=null) {
				people.deleteGoal(gId);
				return Response.status(Response.Status.NO_CONTENT).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that gives all the goals for a particular person {id}.
	 * @param id: the identifier of the person
	 * @return the list of goals for the person identified by {id}
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}/goal")
	public Response getPersonGoals(@PathParam("id") Long id) {
		try {
			List<Goal> result = people.readPersonGoalList(id);
			
			if (result!=null) {
				return Response.ok(result).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/***
	 * A method that gives all the information of a goal identified by {title} for a particular person {id}.
	 * @param id: the identifier of the person
	 * @param title: the title of the goal
	 * @return the goal identified by {title}
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}/goal/find")
	public Response getPersonGoalFiltered(
			@PathParam("id") Long id,
			@QueryParam("title") String title,
			@QueryParam("status") String status) {
		try {
			List<Goal> result = new ArrayList<Goal>();
			
			if ((title!=null)&&(status!=null)) {
				result.add(people.readPersonGoalByNameAndStatus(id, title, status));
				if (result.get(0)!=null) {
					return Response.ok(result.get(0)).build();
				} else {
					return Response.status(Response.Status.NOT_FOUND).build();
				}
			} else {
				if ((title!=null)&&(status==null)) {
					result.add(people.readPersonGoalByName(id, title));
					if (result.get(0)!=null) {
						return Response.ok(result.get(0)).build();
					} else {
						return Response.status(Response.Status.NOT_FOUND).build();
					}
				} else if ((title==null)&&(status!=null)) {
					result = people.readPersonGoalByStatus(id, status);
					if (result!=null) {
						return Response.ok(result).build();
					} else {
						return Response.status(Response.Status.NOT_FOUND).build();
					}
				} else {
					result = people.readPersonGoalList(id);
					return Response.ok(result).build();
				}
			}
		} catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}