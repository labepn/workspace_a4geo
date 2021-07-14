package eterrapn.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;
import java.util.List;


/**
 * The persistent class for the Cl_namenaobj database table.
 * 
 */
@Entity
@Table(name = "Cl_namenaobj")
@NamedQuery(name="Cl_namenaobj.findAll", query="SELECT h FROM Cl_namenaobj h ")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Cl_namenaobj implements Serializable {
	private static final long serialVersionUID = 1L;


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