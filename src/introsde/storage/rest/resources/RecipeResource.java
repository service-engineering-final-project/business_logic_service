package introsde.storage.rest.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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

import introsde.storage.rest.model.Recipe;
import introsde.storage.rest.model.RecipeNutritionFacts;


/***
 * The resource class that implements our service endpoints for the Recipe.
 * 
 * @author alan
 *
 */

//@Stateless
//@LocalBean
@Path("/recipe")
public class RecipeResource {
	@Context UriInfo uriInfo;	// allows to insert contextual objects (uriInfo) into the class
	@Context Request request;	// allows to insert contextual objects (request) into the class
	
	DocumentBuilder docBuilder;
	WebTarget webTarget;
	ObjectMapper mapper = new ObjectMapper();
	
	// Definition of some useful constants
	final String baseUrl = "http://recipe-adapter-service.herokuapp.com/rest/yummly";
	
	public RecipeResource() {
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
	 * A method that returns a recipe (from the external adapter service) 
	 * with a particular ID given as parameter.
	 * @param id: the univocal identifier of the recipe
	 * @return the recipe having that very identifier
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{id}")
	public RecipeNutritionFacts getRecipe(@PathParam("id") String id) {
		RecipeNutritionFacts recipe = null;
		
		// Send the request and get the relative response
		Response response = webTarget.path(id).request().accept(MediaType.APPLICATION_JSON).get(Response.class);
		int statusCode = response.getStatus();
		
		// Check the HTTP status code
		if (statusCode==200) {
			try {
				JsonNode root = mapper.readTree(response.readEntity(String.class));
				
				// Set the attributes of the recipe
				recipe = new RecipeNutritionFacts();
				recipe.setId(root.path("id").asText());
				recipe.setName(root.path("name").asText());
				recipe.setImage(root.path("image").asText());
				recipe.setWebsiteUrl(root.path("websiteUrl").asText());
				recipe.setProteins(root.path("proteins").asDouble());
				recipe.setCarbohydrates(root.path("carbohydrates").asDouble());
				recipe.setLipids(root.path("lipids").asDouble());
				recipe.setSaturatedLipids(root.path("saturatedLipids").asDouble());
				recipe.setCalories(root.path("calories").asDouble());
				recipe.setSodium(root.path("sodium").asDouble());
				recipe.setPotassium(root.path("potassium").asDouble());
				recipe.setCalcium(root.path("calcium").asDouble());
				recipe.setStarch(root.path("starch").asDouble());
				recipe.setFiber(root.path("fiber").asDouble());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			throw new WebApplicationException(statusCode);
		}
		
		return recipe;
	}
	
	/***
	 * A method that returns a list of recipes according to some input parameters.
	 * @param keyword: a keyword to filter results
	 * @param minKcal: the minimum amount of kilocalories
	 * @param maxKcal: the maximum amount of kilocalories
	 * @param course: the kind of plate
	 * @param allergy: a (non-mandatory) allergy
	 * @return a list of recipes respecting the input conditions
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Recipe> getRecipesList(
			@QueryParam("keyword") String keyword,
			@QueryParam("minKcal") int minKcal,
			@QueryParam("maxKcal") int maxKcal,
			@QueryParam("course") String course,
			@QueryParam("allergy") String allergy
	) {
		Recipe recipe = null;
		List<Recipe> recipesList = null;
		
		// Extend the base target with parameters given as input
		if (keyword != null) webTarget = webTarget.queryParam("keyword", keyword);
		if (minKcal != 0) webTarget = webTarget.queryParam("minKcal", minKcal);
		if (maxKcal != 0) webTarget = webTarget.queryParam("maxKcal", maxKcal);
		if (course != null) webTarget = webTarget.queryParam("course", course);
		if (allergy != null) webTarget = webTarget.queryParam("allergy", allergy);
				
		// Print the complete path performed on Yummly API
		// System.out.println(fullWebTarget.toString());
		
		// Send the request and get the relative response
		Response response = webTarget.request().accept(MediaType.APPLICATION_JSON).get(Response.class);
		int statusCode = response.getStatus();
		
		// Check the HTTP status code
		if (statusCode==200) {
			try {
				JsonNode root = mapper.readTree(response.readEntity(String.class));
				recipesList = new ArrayList<Recipe>();
				
				for (int i=0; i<root.size(); i++) {
					// Set the attributes of the recipe
					recipe = new Recipe();
					recipe.setId(root.get(i).path("id").asText());
					recipe.setName(root.get(i).path("name").asText());
					recipe.setImage(root.get(i).path("image").asText());
					recipe.setDetails("https://storage-data-service-ar.herokuapp.com/rest/recipe/" + root.get(i).path("id").asText());
					recipesList.add(recipe);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			throw new WebApplicationException(statusCode);
		}
		
		return recipesList;
	}
	
	/***
	 * A method that returns a random recipe (from the external adapter service) 
	 * from a list of recipes according to some input parameters.
	 * @param keyword: a keyword to filter results
	 * @param minKcal: the minimum amount of kilocalories
	 * @param maxKcal: the maximum amount of kilocalories
	 * @param course: the kind of plate
	 * @param allergy: a (non-mandatory) allergy
	 * @return a random recipe from a list of recipes respecting the input conditions
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/random")
	public Recipe getRandomRecipe(
			@QueryParam("keyword") String keyword,
			@QueryParam("minKcal") int minKcal,
			@QueryParam("maxKcal") int maxKcal,
			@QueryParam("course") String course,
			@QueryParam("allergy") String allergy
	) {
		Recipe recipe = null;
		
		// Set the base target with the static values
		WebTarget fullWebTarget = webTarget.path("random");
		
		// Extend the base target with parameters given as input
		if (keyword != null) fullWebTarget = fullWebTarget.queryParam("keyword", keyword);
		if (minKcal != 0) fullWebTarget = fullWebTarget.queryParam("minKcal", minKcal);
		if (maxKcal != 0) fullWebTarget = fullWebTarget.queryParam("maxKcal", maxKcal);
		if (course != null) fullWebTarget = fullWebTarget.queryParam("course", course);
		if (allergy != null) fullWebTarget = fullWebTarget.queryParam("allergy", allergy);
				
		// Print the complete path performed on Yummly API
		// System.out.println(fullWebTarget.toString());
		
		// Send the request and get the relative response
		Response response = fullWebTarget.request().accept(MediaType.APPLICATION_JSON).get(Response.class);
		int statusCode = response.getStatus();
		
		// Check the HTTP status code
		if (statusCode==200) {
			try {
				JsonNode root = mapper.readTree(response.readEntity(String.class));
				
				// Set the attributes of the recipe
				recipe = new Recipe();
				recipe.setId(root.path("id").asText());
				recipe.setName(root.path("name").asText());
				recipe.setImage(root.path("image").asText());
				recipe.setDetails("https://storage-data-service-ar.herokuapp.com/rest/recipe/" + root.path("id").asText());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			throw new WebApplicationException(statusCode);
		}
		
		return recipe;
	}
}