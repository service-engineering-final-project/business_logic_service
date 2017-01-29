package introsde.logic.rest.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.glassfish.jersey.client.ClientConfig;

import com.fasterxml.jackson.databind.ObjectMapper;

import introsde.logic.rest.model.Progress;
import introsde.logic.rest.rules.Algorithms;


/***
 * The resource class that implements our service endpoints for the Progress.
 * 
 * @author alan
 *
 */

//@Stateless
//@LocalBean
@Path("/person")
public class ProgressResource {
	@Context UriInfo uriInfo;	// allows to insert contextual objects (uriInfo) into the class
	@Context Request request;	// allows to insert contextual objects (request) into the class
	
	DocumentBuilder docBuilder;
	WebTarget webTarget;
	ObjectMapper mapper = new ObjectMapper();
	
	// Definition of some useful constants
	final String baseUrl = "http://storage-data-service-ar.herokuapp.com/rest/person";
	
	public ProgressResource() {
		try {
			docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		webTarget = ClientBuilder.newClient(
				new ClientConfig()).target(UriBuilder.fromUri(baseUrl).build()
		);
	}
	
	/***
	 * A method that gives the status for each supported goal.
	 * @param id: the identifier
	 * @return a list of statuses representing the achievement of goals
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}/goal/progress")
	public List<Progress> getProgress(
			@PathParam("id") int id
		) {
		Algorithms logic = null;
		Progress progress = null;
		List<Progress> pList = null;
		List<String> goalsList = null;
		
		// Send the request and get the relative response
		Response response = webTarget.request().accept(MediaType.APPLICATION_JSON).get(Response.class);
		int statusCode = response.getStatus();
		
		if (statusCode==200) {
			try {
				logic = new Algorithms();
				pList = new ArrayList<Progress>();
				goalsList = logic.getGoalNames(id);
				
				for (int i=0; i<goalsList.size(); i++) {
					progress = new Progress();
					progress.setName(goalsList.get(i));
					progress.setProgress(String.valueOf(logic.isOnTheTrack(id, goalsList.get(i))));
					progress.setStatus(String.valueOf(logic.isAchieved(id, goalsList.get(i))));
					pList.add(progress);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new WebApplicationException(statusCode);
		}
		
		return pList;
	}
}