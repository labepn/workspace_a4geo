
package nepolica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ObjektiPosDelType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ObjektiPosDelType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="brojParcele" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="podbrojParcele" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="zgrada" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="pd" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="oznakaStana" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="podulozak" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nacinKoriscenja" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="povrsina" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adresa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ulaz" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="godIzgradnje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="osnov" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sobnost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sprat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="spratnost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="kuhinja" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="kupatila" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="wc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="poslovne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ostalo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "ObjektiPosDelType", propOrder = {
    "brojParcele",
    "podbrojParcele",
    "zgrada",
    "pd",
    "oznakaStana",
    "podulozak",
    "nacinKoriscenja",
    "povrsina",
    "adresa",
    "ulaz",
    "godIzgradnje",
    "osnov",
    "sobnost",
    "sprat",
    "spratnost",
    "kuhinja",
    "kupatila",
    "wc",
    "poslovne",
    "ostalo",
    "datumUpisa"
})
public class ObjektiPosDelType {

    protected int brojParcele;
    protected int podbrojParcele;
    protected int zgrada;
    protected Integer pd;
    protected String oznakaStana;
    protected String podulozak;
    protected String nacinKoriscenja;
    protected String povrsina;
    protected String adresa;
    protected String ulaz;
    protected String godIzgradnje;
    protected String osnov;
    protected String sobnost;
    protected String sprat;
    protected String spratnost;
    protected String kuhinja;
    protected String kupatila;
    protected String wc;
    protected String poslovne;
    protected String ostalo;
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
     * Gets the value of the pd property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPd() {
        return pd;
    }

    /**
     * Sets the value of the pd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPd(Integer value) {
        this.pd = value;
    }

    /**
     * Gets the value of the oznakaStana property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOznakaStana() {
        return oznakaStana;
    }

    /**
     * Sets the value of the oznakaStana property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOznakaStana(String value) {
        this.oznakaStana = value;
    }

    /**
     * Gets the value of the podulozak property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPodulozak() {
        return podulozak;
    }

    /**
     * Sets the value of the podulozak property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPodulozak(String value) {
        this.podulozak = value;
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
     * Gets the value of the adresa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * Sets the value of the adresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresa(String value) {
        this.adresa = value;
    }

    /**
     * Gets the value of the ulaz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUlaz() {
        return ulaz;
    }

    /**
     * Sets the value of the ulaz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUlaz(String value) {
        this.ulaz = value;
    }

    /**
     * Gets the value of the godIzgradnje property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGodIzgradnje() {
        return godIzgradnje;
    }

    /**
     * Sets the value of the godIzgradnje property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGodIzgradnje(String value) {
        this.godIzgradnje = value;
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
     * Gets the value of the sobnost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSobnost() {
        return sobnost;
    }

    /**
     * Sets the value of the sobnost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSobnost(String value) {
        this.sobnost = value;
    }

    /**
     * Gets the value of the sprat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSprat() {
        return sprat;
    }

    /**
     * Sets the value of the sprat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSprat(String value) {
        this.sprat = value;
    }

    /**
     * Gets the value of the spratnost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpratnost() {
        return spratnost;
    }

    /**
     * Sets the value of the spratnost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpratnost(String value) {
        this.spratnost = value;
    }

    /**
     * Gets the value of the kuhinja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKuhinja() {
        return kuhinja;
    }

    /**
     * Sets the value of the kuhinja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKuhinja(String value) {
        this.kuhinja = value;
    }

    /**
     * Gets the value of the kupatila property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKupatila() {
        return kupatila;
    }

    /**
     * Sets the value of the kupatila property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKupatila(String value) {
        this.kupatila = value;
    }

    /**
     * Gets the value of the wc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWc() {
        return wc;
    }

    /**
     * Sets the value of the wc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWc(String value) {
        this.wc = value;
    }

    /**
     * Gets the value of the poslovne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoslovne() {
        return poslovne;
    }

    /**
     * Sets the value of the poslovne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoslovne(String value) {
        this.poslovne = value;
    }

    /**
     * Gets the value of the ostalo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOstalo() {
        return ostalo;
    }

    /**
     * Sets the value of the ostalo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOstalo(String value) {
        this.ostalo = value;
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
