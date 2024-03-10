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
 *                 The LifeCycle complexType is the container for the history and current state of this
 * learning object and those entities that have affected this learning object during its evolution.
 *             
 * 
 * <p>Java class for LifeCycle.Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LifeCycle.Type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element name="version" type="{http://ltsc.ieee.org/xsd/LOM}LangString.Type" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://ltsc.ieee.org/xsd/LOM}Status.Type" minOccurs="0"/&gt;
 *         &lt;element name="contribute" type="{http://ltsc.ieee.org/xsd/LOM}ContributeLifeCycle.Type" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LifeCycle.Type", propOrder = {
    "versionOrStatusOrContribute"
})
public class LifeCycleType implements Serializable
{

    private final static long serialVersionUID = 12343L;
    @XmlElements({
        @XmlElement(name = "version", type = LangStringType.class),
        @XmlElement(name = "status", type = StatusType.class),
        @XmlElement(name = "contribute", type = ContributeLifeCycleType.class)
    })
    protected List<Serializable> versionOrStatusOrContribute;

    /**
     * Gets the value of the versionOrStatusOrContribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the versionOrStatusOrContribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVersionOrStatusOrContribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LangStringType }
     * {@link StatusType }
     * {@link ContributeLifeCycleType }
     * 
     * 
     */
    public List<Serializable> getVersionOrStatusOrContribute() {
        if (versionOrStatusOrContribute == null) {
            versionOrStatusOrContribute = new ArrayList<Serializable>();
        }
        return this.versionOrStatusOrContribute;
    }

}