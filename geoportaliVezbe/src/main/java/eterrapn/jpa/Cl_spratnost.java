package eterrapn.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Cl_spratnost")
@NamedQuery(name="Cl_spratnost.findAll", query="SELECT h FROM Cl_spratnost h ")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Cl_spratnost {
	private static final long serialVersionUID = 1L;
	
	@Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pnid;
	private String oznaka;
	private String naziv;
	
	public Integer getPnid() {
		return pnid;
	}
	public void setPnid(Integer pnid) {
		this.pnid = pnid;
	}
	public String getOznaka() {
		return oznaka;
	}
	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

}
