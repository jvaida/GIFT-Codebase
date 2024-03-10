//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.03.09 at 11:42:46 PM MST 
//


package generated.dkf;

import java.io.Serializable;
import java.math.BigDecimal;
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
 *         &lt;element ref="{}teamMemberRefs"/&gt;
 *         &lt;element ref="{}pointRef"/&gt;
 *         &lt;element name="maxAngleFromCenter"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;minExclusive value="0"/&gt;
 *               &lt;maxExclusive value="180"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="freeLookDuration" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;minInclusive value="0.0"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
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
    "teamMemberRefs",
    "pointRef",
    "maxAngleFromCenter",
    "freeLookDuration",
    "realTimeAssessmentRules"
})
@XmlRootElement(name = "AssignedSectorCondition")
public class AssignedSectorCondition implements Serializable
{

    private final static long serialVersionUID = 12343L;
    @XmlElement(required = true)
    protected TeamMemberRefs teamMemberRefs;
    @XmlElement(required = true)
    protected PointRef pointRef;
    @XmlElement(required = true)
    protected BigDecimal maxAngleFromCenter;
    protected BigDecimal freeLookDuration;
    @XmlElement(name = "RealTimeAssessmentRules")
    protected RealTimeAssessmentRules realTimeAssessmentRules;

    /**
     * Gets the value of the teamMemberRefs property.
     * 
     * @return
     *     possible object is
     *     {@link TeamMemberRefs }
     *     
     */
    public TeamMemberRefs getTeamMemberRefs() {
        return teamMemberRefs;
    }

    /**
     * Sets the value of the teamMemberRefs property.
     * 
     * @param value
     *     allowed object is
     *     {@link TeamMemberRefs }
     *     
     */
    public void setTeamMemberRefs(TeamMemberRefs value) {
        this.teamMemberRefs = value;
    }

    /**
     * Gets the value of the pointRef property.
     * 
     * @return
     *     possible object is
     *     {@link PointRef }
     *     
     */
    public PointRef getPointRef() {
        return pointRef;
    }

    /**
     * Sets the value of the pointRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link PointRef }
     *     
     */
    public void setPointRef(PointRef value) {
        this.pointRef = value;
    }

    /**
     * Gets the value of the maxAngleFromCenter property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaxAngleFromCenter() {
        return maxAngleFromCenter;
    }

    /**
     * Sets the value of the maxAngleFromCenter property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaxAngleFromCenter(BigDecimal value) {
        this.maxAngleFromCenter = value;
    }

    /**
     * Gets the value of the freeLookDuration property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFreeLookDuration() {
        return freeLookDuration;
    }

    /**
     * Sets the value of the freeLookDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFreeLookDuration(BigDecimal value) {
        this.freeLookDuration = value;
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