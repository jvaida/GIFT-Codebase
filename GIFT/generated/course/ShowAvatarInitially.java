//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.03.09 at 11:42:49 PM MST 
//


package generated.course;

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
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="mediaSemantics"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element name="Avatar"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                           &lt;minLength value="6"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
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
    "avatarChoice"
})
@XmlRootElement(name = "showAvatarInitially")
public class ShowAvatarInitially
    implements Serializable
{

    private final static long serialVersionUID = 12343L;
    @XmlElement(name = "mediaSemantics")
    protected ShowAvatarInitially.MediaSemantics avatarChoice;

    /**
     * Gets the value of the avatarChoice property.
     * 
     * @return
     *     possible object is
     *     {@link ShowAvatarInitially.MediaSemantics }
     *     
     */
    public ShowAvatarInitially.MediaSemantics getAvatarChoice() {
        return avatarChoice;
    }

    /**
     * Sets the value of the avatarChoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShowAvatarInitially.MediaSemantics }
     *     
     */
    public void setAvatarChoice(ShowAvatarInitially.MediaSemantics value) {
        this.avatarChoice = value;
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
     *         &lt;element name="Avatar"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;minLength value="6"/&gt;
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
        "avatar"
    })
    public static class MediaSemantics
        implements Serializable
    {

        private final static long serialVersionUID = 12343L;
        @XmlElement(name = "Avatar", required = true)
        protected String avatar;

        /**
         * Gets the value of the avatar property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAvatar() {
            return avatar;
        }

        /**
         * Sets the value of the avatar property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAvatar(String value) {
            this.avatar = value;
        }

    }

}
