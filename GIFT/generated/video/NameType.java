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
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 The Name complexType is the container for the name of the required technology to use this
 * learning object.  The value for this element may be derived from the 'technical.format' automatically
 * e.g. 'video/mpeg' implies 'multi-os'.  Also, this vocabulary includes most values in common use at the
 * time the LOM Standard was created.
 *             
 * 
 * <p>Java class for Name.Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Name.Type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element name="source" type="{http://ltsc.ieee.org/xsd/LOM}CharacterString.Type" minOccurs="0"/&gt;
 *         &lt;element name="value" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="pc-dos"/&gt;
 *               &lt;enumeration value="ms-windows"/&gt;
 *               &lt;enumeration value="macos"/&gt;
 *               &lt;enumeration value="unix"/&gt;
 *               &lt;enumeration value="multi-os"/&gt;
 *               &lt;enumeration value="none"/&gt;
 *               &lt;enumeration value="any"/&gt;
 *               &lt;enumeration value="netscape communicator"/&gt;
 *               &lt;enumeration value="ms-internet explorer"/&gt;
 *               &lt;enumeration value="opera"/&gt;
 *               &lt;enumeration value="amaya"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Name.Type", propOrder = {
    "sourceOrValue"
})
public class NameType implements Serializable
{

    private final static long serialVersionUID = 12343L;
    @XmlElementRefs({
        @XmlElementRef(name = "source", namespace = "http://ltsc.ieee.org/xsd/LOM", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "value", namespace = "http://ltsc.ieee.org/xsd/LOM", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<String>> sourceOrValue;

    /**
     * Gets the value of the sourceOrValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sourceOrValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSourceOrValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<String>> getSourceOrValue() {
        if (sourceOrValue == null) {
            sourceOrValue = new ArrayList<JAXBElement<String>>();
        }
        return this.sourceOrValue;
    }

}
