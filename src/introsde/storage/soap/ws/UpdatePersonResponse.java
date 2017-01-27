
package introsde.storage.soap.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updatePersonResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updatePersonResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="updatedPerson" type="{http://ws.soap.health.introsde/}person" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updatePersonResponse", propOrder = {
    "updatedPerson"
})
public class UpdatePersonResponse {

    protected Person updatedPerson;

    /**
     * Gets the value of the updatedPerson property.
     * 
     * @return
     *     possible object is
     *     {@link Person }
     *     
     */
    public Person getUpdatedPerson() {
        return updatedPerson;
    }

    /**
     * Sets the value of the updatedPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link Person }
     *     
     */
    public void setUpdatedPerson(Person value) {
        this.updatedPerson = value;
    }

}
