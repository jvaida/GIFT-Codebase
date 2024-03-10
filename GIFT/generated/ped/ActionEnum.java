//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.03.09 at 11:43:07 PM MST 
//


package generated.ped;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActionEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActionEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString"&gt;
 *     &lt;enumeration value="Interactive"/&gt;
 *     &lt;enumeration value="Constructive"/&gt;
 *     &lt;enumeration value="Active"/&gt;
 *     &lt;enumeration value="Passive"/&gt;
 *     &lt;enumeration value="None"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ActionEnum")
@XmlEnum
public enum ActionEnum {

    @XmlEnumValue("Interactive")
    INTERACTIVE("Interactive"),
    @XmlEnumValue("Constructive")
    CONSTRUCTIVE("Constructive"),
    @XmlEnumValue("Active")
    ACTIVE("Active"),
    @XmlEnumValue("Passive")
    PASSIVE("Passive"),
    @XmlEnumValue("None")
    NONE("None");
    private final String value;

    ActionEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ActionEnum fromValue(String v) {
        for (ActionEnum c: ActionEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
