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
 *         &lt;element ref="{}wcs"/&gt;
 *         &lt;element ref="{}RealTimeAssessmentRules" minOccurs="0"/&gt;
 *         &lt;element ref="{}teamMemberRefs" minOccurs="0"/&gt;
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
    "wcs",
    "realTimeAssessmentRules",
    "teamMemberRefs"
})
@XmlRootElement(name = "RulesOfEngagementCondition")
public class RulesOfEngagementCondition implements Serializable
{

    private final static long serialVersionUID = 12343L;
    @XmlElement(required = true)
    protected Wcs wcs;
    @XmlElement(name = "RealTimeAssessmentRules")
    protected RealTimeAssessmentRules realTimeAssessmentRules;
    protected TeamMemberRefs teamMemberRefs;

    /**
     * Gets the value of the wcs property.
     * 
     * @return
     *     possible object is
     *     {@link Wcs }
     *     
     */
    public Wcs getWcs() {
        return wcs;
    }

    /**
     * Sets the value of the wcs property.
     * 
     * @param value
     *     allowed object is
     *     {@link Wcs }
     *     
     */
    public void setWcs(Wcs value) {
        this.wcs = value;
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

}
