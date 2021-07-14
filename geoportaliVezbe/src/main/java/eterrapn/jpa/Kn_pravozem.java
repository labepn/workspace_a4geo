package eterrapn.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Kn_pravozem")
@NamedQuery(name="Kn_pravozem.findAll", query="SELECT h FROM Kn_pravozem h ")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Kn_pravozem {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pnid;
	@ManyToOne
	@JoinColumn(name="idzem")
	private Kn_zemljiste idzem;
	@ManyToOne
	@JoinColumn(name="idnosilac")
	private Kn_Nosilacprava idnosilac;
	@ManyToOne
	@JoinColumn(name="idvp")
	private Cl_vrstaprava idvp;
	private Integer deo1;
	private Integer deo2;
	
	public Integer getPnid() {
		return pnid;
	}
	public void setPnid(Integer pnid) {
		this.pnid = pnid;
	}
	public Kn_zemljiste getIdzem() {
		return idzem;
	}
	public void setIdzem(Kn_zemljiste idzem) {
		this.idzem = idzem;
	}
	public Kn_Nosilacprava getIdnosilac() {
		return idnosilac;
	}
	public void setIdnosilac(Kn_Nosilacprava idnosilac) {
		this.idnosilac = idnosilac;
	}
	public Cl_vrstaprava getIdvp() {
		return idvp;
	}
	public void setIdvp(Cl_vrstaprava idvp) {
		this.idvp = idvp;
	}
	public Integer getDeo1() {
		return deo1;
	}
	public void setDeo1(Integer deo1) {
		this.deo1 = deo1;
	}
	public Integer getDeo2() {
		return deo2;
	}
	public void setDeo2(Integer deo2) {
		this.deo2 = deo2;
	}
	
	
	

}
