package introsde.storage.rest.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import introsde.storage.rest.model.Quote;


/***
 * The resource class that implements our service endpoints for the Quote.
 * 
 * @author alan
 *
 */

//@Stateless
//@LocalBean
@Path("/quote")
public class QuoteResource {
	@Context UriInfo uriInfo;	// allows to insert contextual objects (uriInfo) into the class
	@Context Request request;	// allows to insert contextual objects (request) into the class
	
	DocumentBuilder docBuilder;
	WebTarget webTarget;
	ObjectMapper mapper = new ObjectMapper();
	
	// Definition of some useful constants
	final String baseUrl = "http://quote-adapter-service.herokuapp.com/rest/quotelicious";
	
	public QuoteResource() {
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
	 * A method that returns the whole list of motivational quotes from Quotelicious
	 * @return a list of quotes
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Quote> getQuotesList() {
		Quote quote = null;
		List <Quote> quotesList = null;
		
		// Send the request and get the relative response
		Response response = webTarget.request().accept(MediaType.APPLICATION_JSON).get(Response.class);
		int statusCode = response.getStatus();
		
		// Check the HTTP status code
		if (statusCode==200) {
			try {
				JsonNode root = mapper.readTree(response.readEntity(String.class));
				quotesList = new ArrayList<Quote>();
				
				for (int i=0; i<root.size(); i++) {
					// Set the attributes of the quote
					quote = new Quote();
					quote.setText(root.get(i).path("text").asText());
					quote.setAuthor(root.get(i).path("author").asText());
					quotesList.add(quote);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			throw new WebApplicationException(statusCode);
		}
		
		return quotesList;
	}
	
	/***
	 * A method that returns a random motivational quote from the external adapter service.
	 * @return a random quote
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/random")
	public Quote getQuote() {
		Quote quote = null;
		
		// Send the request and get the relative response
		Response response = webTarget.path("random").request().accept(MediaType.APPLICATION_JSON).get(Response.class);
		int statusCode = response.getStatus();
		
		// Check the HTTP status code
		if (statusCode==200) {
			try {
				JsonNode root = mapper.readTree(response.readEntity(String.class));
				
				// Set the attributes of the quote
				quote = new Quote();
				quote.setText(root.path("text").asText());
				quote.setAuthor(root.path("author").asText());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			throw new WebApplicationException(statusCode);
		}
		
		return quote;
	}
}