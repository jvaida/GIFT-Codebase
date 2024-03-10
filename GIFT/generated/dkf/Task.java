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
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element name="externalSourceId" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;minLength value="1"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{}startTriggers" minOccurs="0"/&gt;
 *         &lt;element ref="{}endTriggers"/&gt;
 *         &lt;element ref="{}performanceMetric" minOccurs="0"/&gt;
 *         &lt;element ref="{}confidenceMetric" minOccurs="0"/&gt;
 *         &lt;element ref="{}competenceMetric" minOccurs="0"/&gt;
 *         &lt;element ref="{}trendMetric" minOccurs="0"/&gt;
 *         &lt;element ref="{}priorityMetric" minOccurs="0"/&gt;
 *         &lt;element ref="{}concepts"/&gt;
 *         &lt;element ref="{}assessments" minOccurs="0"/&gt;
 *         &lt;element name="DifficultyMetric" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="DifficultyMetricImpl" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="value"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                         &lt;minInclusive value="1"/&gt;
 *                         &lt;maxInclusive value="3"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="StressMetric" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="StressMetricImpl" minOccurs="0"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;minLength value="1"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="value"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                         &lt;minInclusive value="0"/&gt;
 *                         &lt;maxInclusive value="1"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="name" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;minLength value="1"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="nodeId" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *             &lt;minInclusive value="0"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="scenarioSupport" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "externalSourceId",
    "startTriggers",
    "endTriggers",
    "performanceMetric",
    "confidenceMetric",
    "competenceMetric",
    "trendMetric",
    "priorityMetric",
    "concepts",
    "assessments",
    "difficultyMetric",
    "stressMetric"
})
@XmlRootElement(name = "task")
public class Task
    implements Serializable
{

    private final static long serialVersionUID = 12343L;
    protected String externalSourceId;
    protected StartTriggers startTriggers;
    @XmlElement(required = true)
    protected EndTriggers endTriggers;
    protected PerformanceMetric performanceMetric;
    protected ConfidenceMetric confidenceMetric;
    protected CompetenceMetric competenceMetric;
    protected TrendMetric trendMetric;
    protected PriorityMetric priorityMetric;
    @XmlElement(required = true)
    protected Concepts concepts;
    protected Assessments assessments;
    @XmlElement(name = "DifficultyMetric")
    protected Task.DifficultyMetric difficultyMetric;
    @XmlElement(name = "StressMetric")
    protected Task.StressMetric stressMetric;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "nodeId", required = true)
    protected BigInteger nodeId;
    @XmlAttribute(name = "scenarioSupport")
    protected Boolean scenarioSupport;

    /**
     * Gets the value of the externalSourceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalSourceId() {
        return externalSourceId;
    }

    /**
     * Sets the value of the externalSourceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalSourceId(String value) {
        this.externalSourceId = value;
    }

    /**
     * Gets the value of the startTriggers property.
     * 
     * @return
     *     possible object is
     *     {@link StartTriggers }
     *     
     */
    public StartTriggers getStartTriggers() {
        return startTriggers;
    }

    /**
     * Sets the value of the startTriggers property.
     * 
     * @param value
     *     allowed object is
     *     {@link StartTriggers }
     *     
     */
    public void setStartTriggers(StartTriggers value) {
        this.startTriggers = value;
    }

    /**
     * Gets the value of the endTriggers property.
     * 
     * @return
     *     possible object is
     *     {@link EndTriggers }
     *     
     */
    public EndTriggers getEndTriggers() {
        return endTriggers;
    }

    /**
     * Sets the value of the endTriggers property.
     * 
     * @param value
     *     allowed object is
     *     {@link EndTriggers }
     *     
     */
    public void setEndTriggers(EndTriggers value) {
        this.endTriggers = value;
    }

    /**
     * Gets the value of the performanceMetric property.
     * 
     * @return
     *     possible object is
     *     {@link PerformanceMetric }
     *     
     */
    public PerformanceMetric getPerformanceMetric() {
        return performanceMetric;
    }

    /**
     * Sets the value of the performanceMetric property.
     * 
     * @param value
     *     allowed object is
     *     {@link PerformanceMetric }
     *     
     */
    public void setPerformanceMetric(PerformanceMetric value) {
        this.performanceMetric = value;
    }

    /**
     * Gets the value of the confidenceMetric property.
     * 
     * @return
     *     possible object is
     *     {@link ConfidenceMetric }
     *     
     */
    public ConfidenceMetric getConfidenceMetric() {
        return confidenceMetric;
    }

    /**
     * Sets the value of the confidenceMetric property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfidenceMetric }
     *     
     */
    public void setConfidenceMetric(ConfidenceMetric value) {
        this.confidenceMetric = value;
    }

    /**
     * Gets the value of the competenceMetric property.
     * 
     * @return
     *     possible object is
     *     {@link CompetenceMetric }
     *     
     */
    public CompetenceMetric getCompetenceMetric() {
        return competenceMetric;
    }

    /**
     * Sets the value of the competenceMetric property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompetenceMetric }
     *     
     */
    public void setCompetenceMetric(CompetenceMetric value) {
        this.competenceMetric = value;
    }

    /**
     * Gets the value of the trendMetric property.
     * 
     * @return
     *     possible object is
     *     {@link TrendMetric }
     *     
     */
    public TrendMetric getTrendMetric() {
        return trendMetric;
    }

    /**
     * Sets the value of the trendMetric property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrendMetric }
     *     
     */
    public void setTrendMetric(TrendMetric value) {
        this.trendMetric = value;
    }

    /**
     * Gets the value of the priorityMetric property.
     * 
     * @return
     *     possible object is
     *     {@link PriorityMetric }
     *     
     */
    public PriorityMetric getPriorityMetric() {
        return priorityMetric;
    }

    /**
     * Sets the value of the priorityMetric property.
     * 
     * @param value
     *     allowed object is
     *     {@link PriorityMetric }
     *     
     */
    public void setPriorityMetric(PriorityMetric value) {
        this.priorityMetric = value;
    }

    /**
     * Gets the value of the concepts property.
     * 
     * @return
     *     possible object is
     *     {@link Concepts }
     *     
     */
    public Concepts getConcepts() {
        return concepts;
    }

    /**
     * Sets the value of the concepts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Concepts }
     *     
     */
    public void setConcepts(Concepts value) {
        this.concepts = value;
    }

    /**
     * Gets the value of the assessments property.
     * 
     * @return
     *     possible object is
     *     {@link Assessments }
     *     
     */
    public Assessments getAssessments() {
        return assessments;
    }

    /**
     * Sets the value of the assessments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Assessments }
     *     
     */
    public void setAssessments(Assessments value) {
        this.assessments = value;
    }

    /**
     * Gets the value of the difficultyMetric property.
     * 
     * @return
     *     possible object is
     *     {@link Task.DifficultyMetric }
     *     
     */
    public Task.DifficultyMetric getDifficultyMetric() {
        return difficultyMetric;
    }

    /**
     * Sets the value of the difficultyMetric property.
     * 
     * @param value
     *     allowed object is
     *     {@link Task.DifficultyMetric }
     *     
     */
    public void setDifficultyMetric(Task.DifficultyMetric value) {
        this.difficultyMetric = value;
    }

    /**
     * Gets the value of the stressMetric property.
     * 
     * @return
     *     possible object is
     *     {@link Task.StressMetric }
     *     
     */
    public Task.StressMetric getStressMetric() {
        return stressMetric;
    }

    /**
     * Sets the value of the stressMetric property.
     * 
     * @param value
     *     allowed object is
     *     {@link Task.StressMetric }
     *     
     */
    public void setStressMetric(Task.StressMetric value) {
        this.stressMetric = value;
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
     * Gets the value of the nodeId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNodeId() {
        return nodeId;
    }

    /**
     * Sets the value of the nodeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNodeId(BigInteger value) {
        this.nodeId = value;
    }

    /**
     * Gets the value of the scenarioSupport property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isScenarioSupport() {
        if (scenarioSupport == null) {
            return false;
        } else {
            return scenarioSupport;
        }
    }

    /**
     * Sets the value of the scenarioSupport property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setScenarioSupport(Boolean value) {
        this.scenarioSupport = value;
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
     *         &lt;element name="DifficultyMetricImpl" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;minLength value="1"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="value"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *               &lt;minInclusive value="1"/&gt;
     *               &lt;maxInclusive value="3"/&gt;
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
        "difficultyMetricImpl",
        "value"
    })
    public static class DifficultyMetric
        implements Serializable
    {

        private final static long serialVersionUID = 12343L;
        @XmlElement(name = "DifficultyMetricImpl")
        protected String difficultyMetricImpl;
        @XmlElement(required = true)
        protected BigDecimal value;

        /**
         * Gets the value of the difficultyMetricImpl property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDifficultyMetricImpl() {
            return difficultyMetricImpl;
        }

        /**
         * Sets the value of the difficultyMetricImpl property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDifficultyMetricImpl(String value) {
            this.difficultyMetricImpl = value;
        }

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setValue(BigDecimal value) {
            this.value = value;
        }

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
     *         &lt;element name="StressMetricImpl" minOccurs="0"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;minLength value="1"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="value"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *               &lt;minInclusive value="0"/&gt;
     *               &lt;maxInclusive value="1"/&gt;
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
        "stressMetricImpl",
        "value"
    })
    public static class StressMetric
        implements Serializable
    {

        private final static long serialVersionUID = 12343L;
        @XmlElement(name = "StressMetricImpl")
        protected String stressMetricImpl;
        @XmlElement(required = true)
        protected BigDecimal value;

        /**
         * Gets the value of the stressMetricImpl property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStressMetricImpl() {
            return stressMetricImpl;
        }

        /**
         * Sets the value of the stressMetricImpl property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStressMetricImpl(String value) {
            this.stressMetricImpl = value;
        }

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setValue(BigDecimal value) {
            this.value = value;
        }

    }

}
