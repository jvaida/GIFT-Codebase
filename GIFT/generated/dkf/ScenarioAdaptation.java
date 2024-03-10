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
 *         &lt;element ref="{http://GIFT.com/pedagogicalStrategy}strategyHandler"/&gt;
 *         &lt;element ref="{http://GIFT.com/pedagogicalStrategy}delayAfterStrategy" minOccurs="0"/&gt;
 *         &lt;element ref="{http://GIFT.com/pedagogicalStrategy}environmentAdaptation"/&gt;
 *         &lt;element name="description" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="0"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="mandatory" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}boolean"&gt;
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
    "strategyHandler",
    "delayAfterStrategy",
    "environmentAdaptation",
    "description",
    "mandatory"
})
@XmlRootElement(name = "scenarioAdaptation", namespace = "http://GIFT.com/pedagogicalStrategy")
public class ScenarioAdaptation implements Serializable
{

    private final static long serialVersionUID = 12343L;
    @XmlElement(namespace = "http://GIFT.com/pedagogicalStrategy", required = true)
    protected StrategyHandler strategyHandler;
    @XmlElement(namespace = "http://GIFT.com/pedagogicalStrategy")
    protected DelayAfterStrategy delayAfterStrategy;
    @XmlElement(namespace = "http://GIFT.com/pedagogicalStrategy", required = true)
    protected EnvironmentAdaptation environmentAdaptation;
    @XmlElement(namespace = "http://GIFT.com/pedagogicalStrategy")
    protected String description;
    @XmlElement(namespace = "http://GIFT.com/pedagogicalStrategy", defaultValue = "false")
    protected Boolean mandatory;

    /**
     * Gets the value of the strategyHandler property.
     * 
     * @return
     *     possible object is
     *     {@link StrategyHandler }
     *     
     */
    public StrategyHandler getStrategyHandler() {
        return strategyHandler;
    }

    /**
     * Sets the value of the strategyHandler property.
     * 
     * @param value
     *     allowed object is
     *     {@link StrategyHandler }
     *     
     */
    public void setStrategyHandler(StrategyHandler value) {
        this.strategyHandler = value;
    }

    /**
     * Gets the value of the delayAfterStrategy property.
     * 
     * @return
     *     possible object is
     *     {@link DelayAfterStrategy }
     *     
     */
    public DelayAfterStrategy getDelayAfterStrategy() {
        return delayAfterStrategy;
    }

    /**
     * Sets the value of the delayAfterStrategy property.
     * 
     * @param value
     *     allowed object is
     *     {@link DelayAfterStrategy }
     *     
     */
    public void setDelayAfterStrategy(DelayAfterStrategy value) {
        this.delayAfterStrategy = value;
    }

    /**
     * Gets the value of the environmentAdaptation property.
     * 
     * @return
     *     possible object is
     *     {@link EnvironmentAdaptation }
     *     
     */
    public EnvironmentAdaptation getEnvironmentAdaptation() {
        return environmentAdaptation;
    }

    /**
     * Sets the value of the environmentAdaptation property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnvironmentAdaptation }
     *     
     */
    public void setEnvironmentAdaptation(EnvironmentAdaptation value) {
        this.environmentAdaptation = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the mandatory property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMandatory() {
        return mandatory;
    }

    /**
     * Sets the value of the mandatory property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMandatory(Boolean value) {
        this.mandatory = value;
    }

}
