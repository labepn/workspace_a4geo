
package nepolica;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NepokretnostiKNType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NepokretnostiKNType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="parcele" type="{http://www.gitis.com/schema/Nepolica}ParceleType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="vlasniciParcele" type="{http://www.gitis.com/schema/Nepolica}VlasniciPType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="objektiPosDel" type="{http://www.gitis.com/schema/Nepolica}ObjektiPosDelType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="vlasniciObjektiPosDel" type="{http://www.gitis.com/schema/Nepolica}VlasniciOType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="tereti" type="{http://www.gitis.com/schema/Nepolica}TeretiType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NepokretnostiKNType", propOrder = {
    "parcele",
    "vlasniciParcele",
    "objektiPosDel",
    "vlasniciObjektiPosDel",
    "tereti"
})
public class NepokretnostiKNType {

    protected List<ParceleType> parcele;
    protected List<VlasniciPType> vlasniciParcele;
    protected List<ObjektiPosDelType> objektiPosDel;
    protected List<VlasniciOType> vlasniciObjektiPosDel;
    protected List<TeretiType> tereti;

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
     * {@link ParceleType }
     * 
     * 
     */
    public List<ParceleType> getParcele() {
        if (parcele == null) {
            parcele = new ArrayList<ParceleType>();
        }
        return this.parcele;
    }

    /**
     * Gets the value of the vlasniciParcele property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vlasniciParcele property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVlasniciParcele().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VlasniciPType }
     * 
     * 
     */
    public List<VlasniciPType> getVlasniciParcele() {
        if (vlasniciParcele == null) {
            vlasniciParcele = new ArrayList<VlasniciPType>();
        }
        return this.vlasniciParcele;
    }

    /**
     * Gets the value of the objektiPosDel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the objektiPosDel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObjektiPosDel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ObjektiPosDelType }
     * 
     * 
     */
    public List<ObjektiPosDelType> getObjektiPosDel() {
        if (objektiPosDel == null) {
            objektiPosDel = new ArrayList<ObjektiPosDelType>();
        }
        return this.objektiPosDel;
    }

    /**
     * Gets the value of the vlasniciObjektiPosDel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vlasniciObjektiPosDel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVlasniciObjektiPosDel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VlasniciOType }
     * 
     * 
     */
    public List<VlasniciOType> getVlasniciObjektiPosDel() {
        if (vlasniciObjektiPosDel == null) {
            vlasniciObjektiPosDel = new ArrayList<VlasniciOType>();
        }
        return this.vlasniciObjektiPosDel;
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
     * {@link TeretiType }
     * 
     * 
     */
    public List<TeretiType> getTereti() {
        if (tereti == null) {
            tereti = new ArrayList<TeretiType>();
        }
        return this.tereti;
    }

}
