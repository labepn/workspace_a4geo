package eterrapn.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Cl_vrstaprava")
@NamedQuery(name="Cl_vrstaprava.findAll", query="SELECT h FROM Cl_vrstaprava h ")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Cl_vrstaprava {

	@Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pnid;
	private Integer oznaka;
	private String naziv;
	
	public Integer getPnid() {
		return pnid;
	}
	public void setPnid(Integer pnid) {
		this.pnid = pnid;
	}
	public Integer getOznaka() {
		return oznaka;
	}
	public void setOznaka(Integer oznaka) {
		this.oznaka = oznaka;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
}
