
package nepolica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TeretiZType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TeretiZType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="blok" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="brojParcele" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="podbrojParcele" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="rb" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nacinKoriscenja" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="klasa" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="rbr" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="sat" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="minut" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="povrsina" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="vrstaOgranicenja" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="opisOgranicenja" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TeretiZType", propOrder = {
    "blok",
    "brojParcele",
    "podbrojParcele",
    "rb",
    "nacinKoriscenja",
    "klasa",
    "rbr",
    "datum",
    "sat",
    "minut",
    "povrsina",
    "vrstaOgranicenja",
    "opisOgranicenja"
})
public class TeretiZType {

    protected int blok;
    protected int brojParcele;
    protected int podbrojParcele;
    protected int rb;
    @XmlElement(required = true)
    protected String nacinKoriscenja;
    protected int klasa;
    @XmlElement(required = true)
    protected String rbr;
    @XmlElement(required = true)
    protected String datum;
    @XmlElement(required = true)
    protected String sat;
    @XmlElement(required = true)
    protected String minut;
    protected int povrsina;
    @XmlElement(required = true)
    protected String vrstaOgranicenja;
    @XmlElement(required = true)
    protected String opisOgranicenja;

    /**
     * Gets the value of the blok property.
     * 
     */
    public int getBlok() {
        return blok;
    }

    /**
     * Sets the value of the blok property.
     * 
     */
    public void setBlok(int value) {
        this.blok = value;
    }

    /**
     * Gets the value of the brojParcele property.
     * 
     */
    public int getBrojParcele() {
        return brojParcele;
    }

    /**
     * Sets the value of the brojParcele property.
     * 
     */
    public void setBrojParcele(int value) {
        this.brojParcele = value;
    }

    /**
     * Gets the value of the podbrojParcele property.
     * 
     */
    public int getPodbrojParcele() {
        return podbrojParcele;
    }

    /**
     * Sets the value of the podbrojParcele property.
     * 
     */
    public void setPodbrojParcele(int value) {
        this.podbrojParcele = value;
    }

    /**
     * Gets the value of the rb property.
     * 
     */
    public int getRb() {
        return rb;
    }

    /**
     * Sets the value of the rb property.
     * 
     */
    public void setRb(int value) {
        this.rb = value;
    }

    /**
     * Gets the value of the nacinKoriscenja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNacinKoriscenja() {
        return nacinKoriscenja;
    }

    /**
     * Sets the value of the nacinKoriscenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNacinKoriscenja(String value) {
        this.nacinKoriscenja = value;
    }

    /**
     * Gets the value of the klasa property.
     * 
     */
    public int getKlasa() {
        return klasa;
    }

    /**
     * Sets the value of the klasa property.
     * 
     */
    public void setKlasa(int value) {
        this.klasa = value;
    }

    /**
     * Gets the value of the rbr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRbr() {
        return rbr;
    }

    /**
     * Sets the value of the rbr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRbr(String value) {
        this.rbr = value;
    }

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatum(String value) {
        this.datum = value;
    }

    /**
     * Gets the value of the sat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSat() {
        return sat;
    }

    /**
     * Sets the value of the sat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSat(String value) {
        this.sat = value;
    }

    /**
     * Gets the value of the minut property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinut() {
        return minut;
    }

    /**
     * Sets the value of the minut property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinut(String value) {
        this.minut = value;
    }

    /**
     * Gets the value of the povrsina property.
     * 
     */
    public int getPovrsina() {
        return povrsina;
    }

    /**
     * Sets the value of the povrsina property.
     * 
     */
    public void setPovrsina(int value) {
        this.povrsina = value;
    }

    /**
     * Gets the value of the vrstaOgranicenja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVrstaOgranicenja() {
        return vrstaOgranicenja;
    }

    /**
     * Sets the value of the vrstaOgranicenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVrstaOgranicenja(String value) {
        this.vrstaOgranicenja = value;
    }

    /**
     * Gets the value of the opisOgranicenja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpisOgranicenja() {
        return opisOgranicenja;
    }

    /**
     * Sets the value of the opisOgranicenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpisOgranicenja(String value) {
        this.opisOgranicenja = value;
    }

}
