package introsde.logic.rest.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The JAVA class for the "progress" model.
 * 
 * @author alan
 *
 */


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement			// make it the root element

public class Progress implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/********************************************************************************
	 * DEFINITION OF ALL THE PRIVATE ATTRIBUTES OF THE CLASS						*
	 ********************************************************************************/
	
	@XmlElement private String name;
	@XmlElement private String progress;
	@XmlElement private String status;
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the progress
	 */
	public String getProgress() {
		return progress;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param progress the progress to set
	 */
	public void setProgress(String progress) {
		this.progress = progress;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}