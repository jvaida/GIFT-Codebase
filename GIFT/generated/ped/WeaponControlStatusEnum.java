//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.03.09 at 11:43:05 PM MST 
//


package generated.ped;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WeaponControlStatusEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WeaponControlStatusEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString"&gt;
 *     &lt;enumeration value="Tight"/&gt;
 *     &lt;enumeration value="Hold"/&gt;
 *     &lt;enumeration value="Free"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "WeaponControlStatusEnum", namespace = "http://GIFT.com/common")
@XmlEnum
public enum WeaponControlStatusEnum {

    @XmlEnumValue("Tight")
    TIGHT("Tight"),
    @XmlEnumValue("Hold")
    HOLD("Hold"),
    @XmlEnumValue("Free")
    FREE("Free");
    private final String value;

    WeaponControlStatusEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WeaponControlStatusEnum fromValue(String v) {
        for (WeaponControlStatusEnum c: WeaponControlStatusEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
