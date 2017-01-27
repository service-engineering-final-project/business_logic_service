package introsde.storage.rest.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * The JAVA class for the "quote" model.
 * 
 * @author alan
 *
 */


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement			// make it the root element

// The content order in the generated schema type
@XmlType(propOrder={"text","author"})

public class Quote implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/********************************************************************************
	 * DEFINITION OF ALL THE PRIVATE ATTRIBUTES OF THE CLASS						*
	 ********************************************************************************/
	
	@XmlElement private String text;
	@XmlElement private String author;
	
	
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param name the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
}