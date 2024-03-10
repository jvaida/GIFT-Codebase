//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.03.09 at 11:42:46 PM MST 
//


package generated.dkf;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{}teamMemberRefs"/&gt;
 *         &lt;element name="targetsToAvoid" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;sequence&gt;
 *                     &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *                       &lt;element ref="{}teamMemberRef"/&gt;
 *                       &lt;element ref="{}pointRef"/&gt;
 *                     &lt;/choice&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="weaponConeAngle"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;minInclusive value="1"/&gt;
 *               &lt;maxInclusive value="360"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="weaponConeMaxDistance" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *               &lt;minInclusive value="1"/&gt;
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
    "targetsToAvoid",
    "weaponConeAngle",
    "weaponConeMaxDistance",
    "realTimeAssessmentRules"
})
@XmlRootElement(name = "NegligentDischargeCondition")
public class NegligentDischargeCondition implements Serializable
{

    private final static long serialVersionUID = 12343L;
    @XmlElement(required = true)
    protected TeamMemberRefs teamMemberRefs;
    protected NegligentDischargeCondition.TargetsToAvoid targetsToAvoid;
    @XmlElement(defaultValue = "30")
    protected int weaponConeAngle;
    @XmlElement(defaultValue = "300")
    protected BigInteger weaponConeMaxDistance;
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
     * Gets the value of the targetsToAvoid property.
     * 
     * @return
     *     possible object is
     *     {@link NegligentDischargeCondition.TargetsToAvoid }
     *     
     */
    public NegligentDischargeCondition.TargetsToAvoid getTargetsToAvoid() {
        return targetsToAvoid;
    }

    /**
     * Sets the value of the targetsToAvoid property.
     * 
     * @param value
     *     allowed object is
     *     {@link NegligentDischargeCondition.TargetsToAvoid }
     *     
     */
    public void setTargetsToAvoid(NegligentDischargeCondition.TargetsToAvoid value) {
        this.targetsToAvoid = value;
    }

    /**
     * Gets the value of the weaponConeAngle property.
     * 
     */
    public int getWeaponConeAngle() {
        return weaponConeAngle;
    }

    /**
     * Sets the value of the weaponConeAngle property.
     * 
     */
    public void setWeaponConeAngle(int value) {
        this.weaponConeAngle = value;
    }

    /**
     * Gets the value of the weaponConeMaxDistance property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getWeaponConeMaxDistance() {
        return weaponConeMaxDistance;
    }

    /**
     * Sets the value of the weaponConeMaxDistance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setWeaponConeMaxDistance(BigInteger value) {
        this.weaponConeMaxDistance = value;
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;sequence&gt;
     *           &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
     *             &lt;element ref="{}teamMemberRef"/&gt;
     *             &lt;element ref="{}pointRef"/&gt;
     *           &lt;/choice&gt;
     *         &lt;/sequence&gt;
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
        "teamMemberRefOrPointRef"
    })
    public static class TargetsToAvoid
        implements Serializable
    {

        private final static long serialVersionUID = 12343L;
        @XmlElements({
            @XmlElement(name = "teamMemberRef", type = String.class),
            @XmlElement(name = "pointRef", type = PointRef.class)
        })
        protected List<Serializable> teamMemberRefOrPointRef;

        /**
         * Gets the value of the teamMemberRefOrPointRef property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the teamMemberRefOrPointRef property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTeamMemberRefOrPointRef().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * {@link PointRef }
         * 
         * 
         */
        public List<Serializable> getTeamMemberRefOrPointRef() {
            if (teamMemberRefOrPointRef == null) {
                teamMemberRefOrPointRef = new ArrayList<Serializable>();
            }
            return this.teamMemberRefOrPointRef;
        }

    }

}