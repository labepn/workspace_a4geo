
package nepolica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParceleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ParceleType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="brojParcele" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="podbrojParcele" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="zgrada" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="plan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="skica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="potes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ulica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nacinKoriscenja" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="bonitet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="povrsina" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="namena" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="statistickiKrug" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="osnov" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="datumUpisa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParceleType", propOrder = {
    "brojParcele",
    "podbrojParcele",
    "zgrada",
    "plan",
    "skica",
    "potes",
    "ulica",
    "nacinKoriscenja",
    "bonitet",
    "povrsina",
    "namena",
    "statistickiKrug",
    "osnov",
    "datumUpisa"
})
public class ParceleType {

    protected int brojParcele;
    protected int podbrojParcele;
    protected int zgrada;
    protected String plan;
    protected String skica;
    protected String potes;
    protected String ulica;
    protected String nacinKoriscenja;
    protected String bonitet;
    protected String povrsina;
    protected String namena;
    protected String statistickiKrug;
    protected String osnov;
    protected String datumUpisa;

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
     * Gets the value of the zgrada property.
     * 
     */
    public int getZgrada() {
        return zgrada;
    }

    /**
     * Sets the value of the zgrada property.
     * 
     */
    public void setZgrada(int value) {
        this.zgrada = value;
    }

    /**
     * Gets the value of the plan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlan() {
        return plan;
    }

    /**
     * Sets the value of the plan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlan(String value) {
        this.plan = value;
    }

    /**
     * Gets the value of the skica property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkica() {
        return skica;
    }

    /**
     * Sets the value of the skica property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkica(String value) {
        this.skica = value;
    }

    /**
     * Gets the value of the potes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPotes() {
        return potes;
    }

    /**
     * Sets the value of the potes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPotes(String value) {
        this.potes = value;
    }

    /**
     * Gets the value of the ulica property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUlica() {
        return ulica;
    }

    /**
     * Sets the value of the ulica property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUlica(String value) {
        this.ulica = value;
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
     * Gets the value of the bonitet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBonitet() {
        return bonitet;
    }

    /**
     * Sets the value of the bonitet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBonitet(String value) {
        this.bonitet = value;
    }

    /**
     * Gets the value of the povrsina property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPovrsina() {
        return povrsina;
    }

    /**
     * Sets the value of the povrsina property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPovrsina(String value) {
        this.povrsina = value;
    }

    /**
     * Gets the value of the namena property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamena() {
        return namena;
    }

    /**
     * Sets the value of the namena property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamena(String value) {
        this.namena = value;
    }

    /**
     * Gets the value of the statistickiKrug property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatistickiKrug() {
        return statistickiKrug;
    }

    /**
     * Sets the value of the statistickiKrug property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatistickiKrug(String value) {
        this.statistickiKrug = value;
    }

    /**
     * Gets the value of the osnov property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOsnov() {
        return osnov;
    }

    /**
     * Sets the value of the osnov property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOsnov(String value) {
        this.osnov = value;
    }

    /**
     * Gets the value of the datumUpisa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatumUpisa() {
        return datumUpisa;
    }

    /**
     * Sets the value of the datumUpisa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatumUpisa(String value) {
        this.datumUpisa = value;
    }

}
