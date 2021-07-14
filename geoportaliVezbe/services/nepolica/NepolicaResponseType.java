
package nepolica;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NepolicaResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NepolicaResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="jmbgmatbr" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="listoviOpstine" type="{http://www.gitis.com/schema/Nepolica}ListoviOpstineType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="greska" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NepolicaResponseType", propOrder = {
    "jmbgmatbr",
    "listoviOpstine",
    "greska"
})
public class NepolicaResponseType {

    @XmlElement(required = true)
    protected String jmbgmatbr;
    protected List<ListoviOpstineType> listoviOpstine;
    @XmlElement(required = true)
    protected String greska;

    /**
     * Gets the value of the jmbgmatbr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJmbgmatbr() {
        return jmbgmatbr;
    }

    /**
     * Sets the value of the jmbgmatbr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJmbgmatbr(String value) {
        this.jmbgmatbr = value;
    }

    /**
     * Gets the value of the listoviOpstine property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listoviOpstine property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListoviOpstine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListoviOpstineType }
     * 
     * 
     */
    public List<ListoviOpstineType> getListoviOpstine() {
        if (listoviOpstine == null) {
            listoviOpstine = new ArrayList<ListoviOpstineType>();
        }
        return this.listoviOpstine;
    }

    /**
     * Gets the value of the greska property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGreska() {
        return greska;
    }

    /**
     * Sets the value of the greska property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGreska(String value) {
        this.greska = value;
    }

}
