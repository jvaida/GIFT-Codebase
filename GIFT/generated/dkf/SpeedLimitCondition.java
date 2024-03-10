//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.03.09 at 11:42:46 PM MST 
//


package generated.dkf;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
 *         &lt;element name="speedLimit"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;minExclusive value="0.0"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="minSpeedLimit" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;minInclusive value="0.0"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="minDurationBeforeViolation"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;minExclusive value="0"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{}teamMemberRef" minOccurs="0"/&gt;
 *         &lt;element ref="{}RealTimeAssessmentRules" minOccurs="0"/&gt;
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
    "speedLimit",
    "minSpeedLimit",
    "minDurationBeforeViolation",
    "teamMemberRef",
    "realTimeAssessmentRules"
})
@XmlRootElement(name = "SpeedLimitCondition")
public class SpeedLimitCondition implements Serializable
{

    private final static long serialVersionUID = 12343L;
    @XmlElement(required = true)
    protected BigDecimal speedLimit;
    protected BigDecimal minSpeedLimit;
    @XmlElement(required = true)
    protected BigInteger minDurationBeforeViolation;
    protected String teamMemberRef;
    @XmlElement(name = "RealTimeAssessmentRules")
    protected RealTimeAssessmentRules realTimeAssessmentRules;

    /**
     * Gets the value of the speedLimit property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSpeedLimit() {
        return speedLimit;
    }

    /**
     * Sets the value of the speedLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSpeedLimit(BigDecimal value) {
        this.speedLimit = value;
    }

    /**
     * Gets the value of the minSpeedLimit property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMinSpeedLimit() {
        return minSpeedLimit;
    }

    /**
     * Sets the value of the minSpeedLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMinSpeedLimit(BigDecimal value) {
        this.minSpeedLimit = value;
    }

    /**
     * Gets the value of the minDurationBeforeViolation property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMinDurationBeforeViolation() {
        return minDurationBeforeViolation;
    }

    /**
     * Sets the value of the minDurationBeforeViolation property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMinDurationBeforeViolation(BigInteger value) {
        this.minDurationBeforeViolation = value;
    }

    /**
     * Gets the value of the teamMemberRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeamMemberRef() {
        return teamMemberRef;
    }

    /**
     * Sets the value of the teamMemberRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeamMemberRef(String value) {
        this.teamMemberRef = value;
    }

    /**
     * Gets the value of the realTimeAssessmentRules property.
     * 
     * @return
     *     possible object is
     *     {@link RealTimeAssessmentRules }
     *     
     */
    public RealTimeAssessmentRules getRealTimeAssessmentRules() {
        return realTimeAssessmentRules;
    }

    /**
     * Sets the value of the realTimeAssessmentRules property.
     * 
     * @param value
     *     allowed object is
     *     {@link RealTimeAssessmentRules }
     *     
     */
    public void setRealTimeAssessmentRules(RealTimeAssessmentRules value) {
        this.realTimeAssessmentRules = value;
    }

}