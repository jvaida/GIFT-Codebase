//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.03.09 at 11:42:46 PM MST 
//


package generated.dkf;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}PlacesOfInterest" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "placesOfInterest"
})
@XmlRootElement(name = "objects")
public class Objects
    implements Serializable
{

    private final static long serialVersionUID = 12343L;
    @XmlElement(name = "PlacesOfInterest")
    protected PlacesOfInterest placesOfInterest;

    /**
     * Gets the value of the placesOfInterest property.
     * 
     * @return
     *     possible object is
     *     {@link PlacesOfInterest }
     *     
     */
    public PlacesOfInterest getPlacesOfInterest() {
        return placesOfInterest;
    }

    /**
     * Sets the value of the placesOfInterest property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlacesOfInterest }
     *     
     */
    public void setPlacesOfInterest(PlacesOfInterest value) {
        this.placesOfInterest = value;
    }

}
