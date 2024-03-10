//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.03.09 at 11:42:49 PM MST 
//


package generated.course;

import java.io.Serializable;
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
 *         &lt;choice maxOccurs="unbounded"&gt;
 *           &lt;element ref="{}AAR"/&gt;
 *           &lt;element ref="{}AuthoredBranch"/&gt;
 *           &lt;element ref="{}Guidance"/&gt;
 *           &lt;element ref="{}LessonMaterial"/&gt;
 *           &lt;element ref="{}MerrillsBranchPoint"/&gt;
 *           &lt;element ref="{}PresentSurvey"/&gt;
 *           &lt;element ref="{}TrainingApplication"/&gt;
 *         &lt;/choice&gt;
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
    "transitionType"
})
@XmlRootElement(name = "transitions")
public class Transitions implements Serializable
{

    private final static long serialVersionUID = 12343L;
    @XmlElements({
        @XmlElement(name = "AAR", type = AAR.class),
        @XmlElement(name = "AuthoredBranch", type = AuthoredBranch.class),
        @XmlElement(name = "Guidance", type = Guidance.class),
        @XmlElement(name = "LessonMaterial", type = LessonMaterial.class),
        @XmlElement(name = "MerrillsBranchPoint", type = MerrillsBranchPoint.class),
        @XmlElement(name = "PresentSurvey", type = PresentSurvey.class),
        @XmlElement(name = "TrainingApplication", type = TrainingApplication.class)
    })
    protected List<Serializable> transitionType;

    /**
     * Gets the value of the transitionType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transitionType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransitionType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AAR }
     * {@link AuthoredBranch }
     * {@link Guidance }
     * {@link LessonMaterial }
     * {@link MerrillsBranchPoint }
     * {@link PresentSurvey }
     * {@link TrainingApplication }
     * 
     * 
     */
    public List<Serializable> getTransitionType() {
        if (transitionType == null) {
            transitionType = new ArrayList<Serializable>();
        }
        return this.transitionType;
    }

}
