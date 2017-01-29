package introsde.logic.rest.rules;

import java.awt.geom.Point2D;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	 * A function that takes the last measurement date relative to a particular goal
	 * @param id: the person's identifier
	 * @param goalName: the name of the goal
	 * @return the last measurement date relative to that very goal
	 */
	public String getActualGoalTime(int id, String goalName) {
		String actualDate = null;
		
		Response response = webTarget.path("person").path(String.valueOf(id)).path(goalName)
				.request().accept(MediaType.APPLICATION_JSON).get(Response.class);
		int statusCode = response.getStatus();
		
		if (statusCode==200) {
			try {
				JsonNode root = mapper.readTree(response.readEntity(String.class));
				
				actualDate = root.get(root.size()-1).path("created").asText();
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new WebApplicationException(statusCode);
		}
		
		return actualDate;
	}
	
	/***
	 * A function that gets the deadline/created relative to a particular goal
	 * @param id: the person's identifier
	 * @param time: the kind of time we are looking for
	 * @return the parsed time
	 */
	public String getGoalTime(int id, String time) {
		String timeValue = null;
		
		Response response = webTarget.path("person").path(String.valueOf(id)).path("goal")
				.request().accept(MediaType.APPLICATION_JSON).get(Response.class);
		int statusCode = response.getStatus();
		
		if (statusCode==200) {
			try {
				JsonNode root = mapper.readTree(response.readEntity(String.class));
				
				for (int i=0; i<root.size(); i++) {
					if (root.get(i).path("title").asText().equals("weight")) {
						timeValue = root.get(i).path(time).asText();
					}
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new WebApplicationException(statusCode);
		}
		
		return timeValue;
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
	 * A function that checks if the person achieved that particular goal
	 * @param id: the person's identifier
	 * @param goalName: the name of the goal
	 * @return a boolean value that indicates if the goal is achieved
	 */
	public boolean isAchieved(int id, String goalName) {
		boolean isAchieved = false;
		
		double actualValue = getActualGoalValue(id, goalName);
		double targetValue = getFinalGoalValue(id, goalName);
		
		if (goalName.equals("sodium")||goalName.equals("weight")) {
			if (actualValue<=targetValue) {
				isAchieved = true;
			}
		} else if (goalName.equals("steps")) {
			if (actualValue>=targetValue) {
				isAchieved = true;
			}
		} else if (goalName.equals("sleep_hours")) {
			if ((actualValue>=6)&&(actualValue<=targetValue)) {
				isAchieved = true;
			}
		} else if (goalName.equals("proteins")||goalName.equals("carbohydrates")||
				goalName.equals("lipids")||goalName.equals("calories")) {
			double targetValueMinRange = targetValue - (targetValue*10.0)/100.0;
			double targetValueMaxRange = targetValue + (targetValue*10.0)/100.0;

			if ((actualValue>=targetValueMinRange)&&(actualValue<=targetValueMaxRange)) {
				isAchieved = true;
			}
		} else {
			System.out.println("There is no business logic for that goal!");
		}
		
		return isAchieved;
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
			isOnTheTrack = computeWeightTrend(id);
			if (isOnTheTrack) {
				System.out.println("\tGood job!");
			}
		} else {
			System.out.println("There is no business logic for that goal!");
		}
		
		return isOnTheTrack;
	}
	
	/***
	 * A function that determines if the weight measure value is on the right track.
	 * @param id: the person's identifier
	 * @return a boolean value that indicates the status
	 */
	public boolean computeWeightTrend(int id) {
		boolean isOnTheTrack = false;
		double startTime = 0;
		double endTime = 0;
		double currentTime = 0;
		Point2D.Double start = null;
		Point2D.Double end = null;
		Point2D.Double actual = null;
		
		Response response = webTarget.path("person").path(String.valueOf(id)).path("weight")
				.request().accept(MediaType.APPLICATION_JSON).get(Response.class);
		int statusCode = response.getStatus();
		
		if (statusCode==200) {
			try {
				String created = getGoalTime(id, "created");
				String deadline = getGoalTime(id, "deadline");
				
				endTime = (double) getTimePointDifference(created, deadline);
				currentTime = getTimePointDifference(created, this.getActualGoalTime(id, "weight"));
				
				start = new Point2D.Double(startTime, getInitGoalValue(id, "weight"));
				end = new Point2D.Double(endTime, getFinalGoalValue(id, "weight"));
				actual = new Point2D.Double(currentTime, getActualGoalValue(id, "weight"));
				
				isOnTheTrack = isBelowTheLine(start, end, actual);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new WebApplicationException(statusCode);
		}
		
		return isOnTheTrack;
	}
	
	/***
	 * A function that determines in terms of determinants and cross products if a point
	 * lies on the bottom part of a given segment.
	 * @param a: the starting point of the segment
	 * @param b: the ending point of the segment
	 * @param c: the test point
	 * @return a boolean value that indicates if the point falls below the segment
	 */
	public boolean isBelowTheLine(Point2D.Double a,Point2D.Double b, Point2D.Double c) {
		System.out.println(a + " " + b + " " + c);
		
		return ((b.x - a.x)*(c.y - a.y) - (b.y - a.y)*(c.x - a.x)) < 0.0;
	}
	
	/***
	 * A function that computes the difference between two dates in terms of days.
	 * @param created: the start date
	 * @param deadline: the end date
	 * @return the difference between input dates in terms of days
	 * @throws ParseException if an error in parsing occours
	 */
	public Long getTimePointDifference(String created, String deadline) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
		Long daysInBetween = (long) -1;
		
		Date dateStart = sdf.parse(created);
	    Date dateEnd = sdf.parse(deadline);

	    daysInBetween = Math.round((dateEnd.getTime()-dateStart.getTime()) / (double) 86400000);
	    
	    if (daysInBetween<0) {
	    	System.out.println("\tWARNING! The deadline is before the creation date!");
	    }
		
		return Math.abs(daysInBetween);
	}
}