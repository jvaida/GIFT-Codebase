//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.03.09 at 11:43:00 PM MST 
//


package generated.gateway;

import java.io.Serializable;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
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
 *         &lt;element name="available" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element ref="{}impl"/&gt;
 *         &lt;element ref="{}name"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element ref="{}AdaptiveLearningServiceBus"/&gt;
 *           &lt;element ref="{}DIS"/&gt;
 *           &lt;element ref="{}VBS"/&gt;
 *           &lt;element ref="{}PPT"/&gt;
 *           &lt;element ref="{}TC3"/&gt;
 *           &lt;element ref="{}SCATT"/&gt;
 *           &lt;element ref="{}XML-RPC"/&gt;
 *           &lt;element ref="{}My-Plugin-XML-RPC"/&gt;
 *           &lt;element ref="{}REST"/&gt;
 *           &lt;element ref="{}ARES"/&gt;
 *           &lt;element ref="{}AMQP"/&gt;
 *           &lt;element ref="{}VR-Engage"/&gt;
 *           &lt;element ref="{}Unity"/&gt;
 *           &lt;element ref="{}SESandbox"/&gt;
 *           &lt;element ref="{}RIDE"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="refID" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "available",
    "impl",
    "name",
    "input"
})
@XmlRootElement(name = "InteropInterfaceConfig")
public class InteropInterfaceConfig
    implements Serializable
{

    private final static long serialVersionUID = 123435L;
    @XmlElement(defaultValue = "true")
    protected Boolean available;
    @XmlElement(required = true)
    protected String impl;
    @XmlElement(required = true)
    protected String name;
    @XmlElements({
        @XmlElement(name = "AdaptiveLearningServiceBus", type = AdaptiveLearningServiceBus.class),
        @XmlElement(name = "DIS", type = DIS.class),
        @XmlElement(name = "VBS", type = VBS.class),
        @XmlElement(name = "PPT", type = PPT.class),
        @XmlElement(name = "TC3", type = TC3 .class),
        @XmlElement(name = "SCATT", type = SCATT.class),
        @XmlElement(name = "XML-RPC", type = XMLRPC.class),
        @XmlElement(name = "My-Plugin-XML-RPC", type = MyPluginXMLRPC.class),
        @XmlElement(name = "REST", type = REST.class),
        @XmlElement(name = "ARES", type = ARES.class),
        @XmlElement(name = "AMQP", type = AMQP.class),
        @XmlElement(name = "VR-Engage", type = VREngage.class),
        @XmlElement(name = "Unity", type = Unity.class),
        @XmlElement(name = "SESandbox", type = SESandbox.class),
        @XmlElement(name = "RIDE", type = RIDE.class)
    })
    protected Serializable input;
    @XmlAttribute(name = "refID", required = true)
    protected BigInteger refID;

    /**
     * Gets the value of the available property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAvailable() {
        return available;
    }

    /**
     * Sets the value of the available property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAvailable(Boolean value) {
        this.available = value;
    }

    /**
     * Gets the value of the impl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImpl() {
        return impl;
    }

    /**
     * Sets the value of the impl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImpl(String value) {
        this.impl = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the input property.
     * 
     * @return
     *     possible object is
     *     {@link AdaptiveLearningServiceBus }
     *     {@link DIS }
     *     {@link VBS }
     *     {@link PPT }
     *     {@link TC3 }
     *     {@link SCATT }
     *     {@link XMLRPC }
     *     {@link MyPluginXMLRPC }
     *     {@link REST }
     *     {@link ARES }
     *     {@link AMQP }
     *     {@link VREngage }
     *     {@link Unity }
     *     {@link SESandbox }
     *     {@link RIDE }
     *     
     */
    public Serializable getInput() {
        return input;
    }

    /**
     * Sets the value of the input property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdaptiveLearningServiceBus }
     *     {@link DIS }
     *     {@link VBS }
     *     {@link PPT }
     *     {@link TC3 }
     *     {@link SCATT }
     *     {@link XMLRPC }
     *     {@link MyPluginXMLRPC }
     *     {@link REST }
     *     {@link ARES }
     *     {@link AMQP }
     *     {@link VREngage }
     *     {@link Unity }
     *     {@link SESandbox }
     *     {@link RIDE }
     *     
     */
    public void setInput(Serializable value) {
        this.input = value;
    }

    /**
     * Gets the value of the refID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRefID() {
        return refID;
    }

    /**
     * Sets the value of the refID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRefID(BigInteger value) {
        this.refID = value;
    }

}