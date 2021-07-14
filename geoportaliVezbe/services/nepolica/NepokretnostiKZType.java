
package nepolica;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NepokretnostiKZType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NepokretnostiKZType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="parcele" type="{http://www.gitis.com/schema/Nepolica}ParceleZType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="posjednici" type="{http://www.gitis.com/schema/Nepolica}PosjedniciType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="tereti" type="{http://www.gitis.com/schema/Nepolica}TeretiZType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NepokretnostiKZType", propOrder = {
    "parcele",
    "posjednici",
    "tereti"
})
public class NepokretnostiKZType {

    protected List<ParceleZType> parcele;
    protected List<PosjedniciType> posjednici;
    protected List<TeretiZType> tereti;

    /**
     * Gets the value of the parcele property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parcele property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParcele().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParceleZType }
     * 
     * 
     */
    public List<ParceleZType> getParcele() {
        if (parcele == null) {
            parcele = new ArrayList<ParceleZType>();
        }
        return this.parcele;
    }

    /**
     * Gets the value of the posjednici property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the posjednici property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPosjednici().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PosjedniciType }
     * 
     * 
     */
    public List<PosjedniciType> getPosjednici() {
        if (posjednici == null) {
            posjednici = new ArrayList<PosjedniciType>();
        }
        return this.posjednici;
    }

    /**
     * Gets the value of the tereti property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tereti property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTereti().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TeretiZType }
     * 
     * 
     */
    public List<TeretiZType> getTereti() {
        if (tereti == null) {
            tereti = new ArrayList<TeretiZType>();
        }
        return this.tereti;
    }

}
