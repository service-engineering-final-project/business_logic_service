package introsde.logic.rest.rules;

import java.util.ArrayList;
import java.util.List;

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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


/***
 * The logic class that handles decisions and computation.
 * 
 * @author alan
 *
 */

public class Algorithms {
	@Context UriInfo uriInfo;	// allows to insert contextual objects (uriInfo) into the class
	@Context Request request;	// allows to insert contextual objects (request) into the class
	
	DocumentBuilder docBuilder;
	WebTarget webTarget;
	ObjectMapper mapper = new ObjectMapper();
	
	// Definition of some useful constants
	final String baseUrl = "http://storage-data-service-ar.herokuapp.com/rest";
	
	public Algorithms() {
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
	 * A function that takes the initial value imposed on the goal
	 * @param id: the person's identifier
	 * @param goalName: the name of the goal
	 * @return the initial value of that very goal
	 */
	public double getInitGoalValue(int id, String goalName) {
		double startingValue = 0;
		
		Response response = webTarget.path("person").path(String.valueOf(id)).path("goal")
				.request().accept(MediaType.APPLICATION_JSON).get(Response.class);
		int statusCode = response.getStatus();
		
		if (statusCode==200) {
			try {
				JsonNode root = mapper.readTree(response.readEntity(String.class));
				
				for (int i=0; i<root.size(); i++) {
					if (root.get(i).path("title").asText().equals(goalName)) {
						startingValue = root.get(i).path("init_value").asDouble();
					}
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new WebApplicationException(statusCode);
		}
		
		return startingValue;
	}
	
	/***
	 * A function that takes the final value imposed on the goal
	 * @param id: the person's identifier
	 * @param goalName: the name of the goal
	 * @return the final value of that very goal
	 */
	public double getFinalGoalValue(int id, String goalName) {
		double finalValue = 0;
		
		Response response = webTarget.path("person").path(String.valueOf(id)).path("goal")
				.request().accept(MediaType.APPLICATION_JSON).get(Response.class);
		int statusCode = response.getStatus();
		
		if (statusCode==200) {
			try {
				JsonNode root = mapper.readTree(response.readEntity(String.class));
				
				for (int i=0; i<root.size(); i++) {
					if (root.get(i).path("title").asText().equals(goalName)) {
						finalValue = root.get(i).path("final_value").asDouble();
					}
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new WebApplicationException(statusCode);
		}
		
		return finalValue;
	}
	
	/***
	 * A function that takes the actual value relative to a particular goal
	 * @param id: the person's identifier
	 * @param goalName: the name of the goal
	 * @return the actual value relative to that very goal
	 */
	public double getActualGoalValue(int id, String goalName) {
		double actualValue = 0;
		
		Response response = webTarget.path("person").path(String.valueOf(id)).path(goalName)
				.request().accept(MediaType.APPLICATION_JSON).get(Response.class);
		int statusCode = response.getStatus();
		
		if (statusCode==200) {
			try {
				JsonNode root = mapper.readTree(response.readEntity(String.class));
				
				actualValue = root.get(root.size()-1).path("value").asDouble();
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new WebApplicationException(statusCode);
		}
		
		return actualValue;
	}
	
	/***
	 * A function that stores on a list all the goals supported by the system in order to process
	 * them correctly.
	 * @param id: the person's identifier
	 * @return a list of supported goals associated with the person
	 */
	public List<String> getGoalNames(int id) {
		String goalName = null;
		List<String> goalNames = null;
		
		Response response = webTarget.path("person").path(String.valueOf(id)).path("goal")
				.request().accept(MediaType.APPLICATION_JSON).get(Response.class);
		int statusCode = response.getStatus();
		
		if (statusCode==200) {
			try {
				goalNames = new ArrayList<String>();
				
				JsonNode root = mapper.readTree(response.readEntity(String.class));
				
				for (int i=0; i<root.size(); i++) {
					goalName = root.get(i).path("title").asText();
					
					if (goalName.equals("weight")||goalName.equals("steps")||goalName.equals("sleep_hours")
						||goalName.equals("proteins")||goalName.equals("carbohydrates")
						||goalName.equals("lipids")||goalName.equals("calories")||goalName.equals("sodium")) {
						goalNames.add(root.get(i).path("title").asText());
					}
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new WebApplicationException(statusCode);
		}
		
		return goalNames;
	}
	
	/***
	 * A function that checks if the person is on the track with that particular goal
	 * @param id: the person's identifier
	 * @param goalName: the name of the goal
	 * @return the status of the progress
	 */
	public boolean isOnTheTrack(int id, String goalName) {
		boolean isOnTheTrack = false;
		
		double actualValue = getActualGoalValue(id, goalName);
		double targetValue = getFinalGoalValue(id, goalName);
		
		System.out.println(goalName + " actual value: " + actualValue);
		
		if (goalName.equals("sodium")) {
			System.out.println(goalName + " target: <=" + targetValue);
			if (actualValue<=targetValue) {
				System.out.println("\tGood job!");
				isOnTheTrack = true;
			}
		} else if (goalName.equals("steps")) {
			System.out.println(goalName + " target: >=" + targetValue);
			if (actualValue>=targetValue) {
				System.out.println("\tGood job!");
				isOnTheTrack = true;
			}
		} else if (goalName.equals("sleep_hours")) {
			System.out.println(goalName + " target: 6 <= " + goalName + " <= " + targetValue);
			if ((actualValue>=6)&&(actualValue<=targetValue)) {
				System.out.println("\tGood job!");
				isOnTheTrack = true;
			}
		} else if (goalName.equals("proteins")||goalName.equals("carbohydrates")||
				goalName.equals("lipids")||goalName.equals("calories")) {
			double targetValueMinRange = targetValue - (targetValue*10.0)/100.0;
			double targetValueMaxRange = targetValue + (targetValue*10.0)/100.0;
			
			System.out.println(goalName + " target: [" + targetValueMinRange + " " + targetValueMaxRange + "]");
			
			if ((actualValue>=targetValueMinRange)&&(actualValue<=targetValueMaxRange)) {
				System.out.println("\tGood job!");
				isOnTheTrack = true;
			}
		} else if (goalName.equals("weight")) {
			isOnTheTrack = computeWeightTrend(goalName);
		} else {
			System.out.println("There is no business logic for that goal!");
		}
		
		// è in linea con quanto stabilito
		return isOnTheTrack;
	}
	
	public boolean computeWeightTrend(String goalName) {
		boolean isOnTheTrack = false;
		List<Double> weightList = new ArrayList<>();
		
		double initValue = this.getInitGoalValue(1, goalName);
		double finalValue = this.getFinalGoalValue(1, goalName);
		double slope = 0;
		
		// compute the slope using the weightList
		
		if(slope==0) {
			// se lo slope intercetta x prima della x del final value, yo!
		}
		
		// è in linea?
		return isOnTheTrack;
	}
	
	public boolean computeGeneralTrend(int goalsNumber, int goalsOnTheTrack) {
		boolean isOnTheTrack = false;
		
		if (goalsOnTheTrack>=(goalsNumber/2)) {
			isOnTheTrack = true;
		}
		
		return isOnTheTrack;
	}
}