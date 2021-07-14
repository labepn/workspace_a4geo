
package nepolica;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListoviOpstineType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListoviOpstineType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nazivSeme" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="listovi" type="{http://www.gitis.com/schema/Nepolica}ListoviType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListoviOpstineType", propOrder = {
    "nazivSeme",
    "listovi",
    "naziv"
})
public class ListoviOpstineType {

    @XmlElement(required = true)
    protected String nazivSeme;
    protected List<ListoviType> listovi;
    @XmlElement(required = true)
    protected String naziv;

    /**
     * Gets the value of the nazivSeme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazivSeme() {
        return nazivSeme;
    }

    /**
     * Sets the value of the nazivSeme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazivSeme(String value) {
        this.nazivSeme = value;
    }

    /**
     * Gets the value of the listovi property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listovi property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListovi().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListoviType }
     * 
     * 
     */
    public List<ListoviType> getListovi() {
        if (listovi == null) {
            listovi = new ArrayList<ListoviType>();
        }
        return this.listovi;
    }

    /**
     * Gets the value of the naziv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Sets the value of the naziv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaziv(String value) {
        this.naziv = value;
    }

}
