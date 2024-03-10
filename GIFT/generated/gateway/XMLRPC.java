//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.03.09 at 11:43:00 PM MST 
//


package generated.gateway;

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
 *         &lt;element name="ExternalServerNetworkAddress"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ExternalServerNetworkPort"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;minInclusive value="1"/&gt;
 *               &lt;maxInclusive value="65535"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ServerNetworkPort"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;minInclusive value="1"/&gt;
 *               &lt;maxInclusive value="65535"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
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
    "externalServerNetworkAddress",
    "externalServerNetworkPort",
    "serverNetworkPort"
})
@XmlRootElement(name = "XML-RPC")
public class XMLRPC implements Serializable
{

    private final static long serialVersionUID = 123435L;
    @XmlElement(name = "ExternalServerNetworkAddress", required = true)
    protected String externalServerNetworkAddress;
    @XmlElement(name = "ExternalServerNetworkPort")
    protected int externalServerNetworkPort;
    @XmlElement(name = "ServerNetworkPort")
    protected int serverNetworkPort;

    /**
     * Gets the value of the externalServerNetworkAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalServerNetworkAddress() {
        return externalServerNetworkAddress;
    }

    /**
     * Sets the value of the externalServerNetworkAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalServerNetworkAddress(String value) {
        this.externalServerNetworkAddress = value;
    }

    /**
     * Gets the value of the externalServerNetworkPort property.
     * 
     */
    public int getExternalServerNetworkPort() {
        return externalServerNetworkPort;
    }

    /**
     * Sets the value of the externalServerNetworkPort property.
     * 
     */
    public void setExternalServerNetworkPort(int value) {
        this.externalServerNetworkPort = value;
    }

    /**
     * Gets the value of the serverNetworkPort property.
     * 
     */
    public int getServerNetworkPort() {
        return serverNetworkPort;
    }

    /**
     * Sets the value of the serverNetworkPort property.
     * 
     */
    public void setServerNetworkPort(int value) {
        this.serverNetworkPort = value;
    }

}
