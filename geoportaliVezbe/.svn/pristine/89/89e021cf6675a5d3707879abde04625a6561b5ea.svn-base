package eterrapn.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;
import java.util.List;


/**
 * The persistent class for the pn_tip_obveznika database table.
 * 
 */
@Entity
@NamedQuery(name="Kn_Nosilacprava.findAll", query="SELECT t FROM Kn_Nosilacprava t ORDER BY t.matbr")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Kn_Nosilacprava implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer pnid;

	private Long matbr;
	
	@ManyToOne
	@JoinColumn(name="idtipnosioca")
	private Cl_tipnosiocaprava idtipnosioca;
	
	private String ime;
	private String imeoca;
	private String prezime;
	private String adresa;
	private String grad;
	private String drzava;
	

	public Kn_Nosilacprava() {
	}


	public Integer getPnid() {
		return pnid;
	}


	public void setPnid(Integer pnid) {
		this.pnid = pnid;
	}



	public Long getMatbr() {
		return matbr;
	}


	public void setMatbr(Long matbr) {
		this.matbr = matbr;
	}


	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public String getImeoca() {
		return imeoca;
	}


	public void setImeoca(String imeoca) {
		this.imeoca = imeoca;
	}


	public String getPrezime() {
		return prezime;
	}


	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}


	public String getAdresa() {
		return adresa;
	}


	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}


	public String getGrad() {
		return grad;
	}


	public void setGrad(String grad) {
		this.grad = grad;
	}


	public String getDrzava() {
		return drzava;
	}


	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public Cl_tipnosiocaprava getTipnosiocaprava() {
		return idtipnosioca;
	}


	public void setTipnosiocaprava(Cl_tipnosiocaprava tipnosioca) {
		this.idtipnosioca = tipnosioca;
	}

	

}