//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.03.09 at 11:42:52 PM MST 
//


package generated.video;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 The Annotation complexType is the container for comments on the educational use of this learning object, 
 * and information on when and by whom the comments were created.  This category enables educators to share their
 * assessements of learning objects suggestions for use, etc.
 *             
 * 
 * <p>Java class for Annotation.Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Annotation.Type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element name="entity" type="{http://ltsc.ieee.org/xsd/LOM}CharacterString.Type" minOccurs="0"/&gt;
 *         &lt;element name="date" type="{http://ltsc.ieee.org/xsd/LOM}DateTime.Type" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{http://ltsc.ieee.org/xsd/LOM}LangString.Type" minOccurs="0"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Annotation.Type", propOrder = {
    "entityOrDateOrDescription"
})
public class AnnotationType implements Serializable
{

    private final static long serialVersionUID = 12343L;
    @XmlElements({
        @XmlElement(name = "entity", type = String.class),
        @XmlElement(name = "date", type = DateTimeType.class),
        @XmlElement(name = "description", type = LangStringType.class)
    })
    protected List<Serializable> entityOrDateOrDescription;

    /**
     * Gets the value of the entityOrDateOrDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entityOrDateOrDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntityOrDateOrDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * {@link DateTimeType }
     * {@link LangStringType }
     * 
     * 
     */
    public List<Serializable> getEntityOrDateOrDescription() {
        if (entityOrDateOrDescription == null) {
            entityOrDateOrDescription = new ArrayList<Serializable>();
        }
        return this.entityOrDateOrDescription;
    }

}
