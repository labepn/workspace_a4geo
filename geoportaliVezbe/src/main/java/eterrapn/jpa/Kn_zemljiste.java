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
@Table(name = "Kn_zemljiste")
@NamedQuery(name="Kn_zemljiste.findAll", query="SELECT h FROM Kn_zemljiste h ")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Kn_zemljiste {
	private static final long serialVersionUID = 1L;
	
	@Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pnid;
	private Double povrsina;
	@ManyToOne
	@JoinColumn(name="idnamenaz")
	private Cl_namenazem idnamenaz;
	private Integer srez;
	private Integer ko;
	private Integer broj;
	private Integer podbroj;
	private Integer kultura;
	private Integer klasa;
	
	public Integer getPnid() {
		return pnid;
	}
	public void setPnid(Integer pnid) {
		this.pnid = pnid;
	}
	
	public Cl_namenazem getIdnamenaz() {
		return idnamenaz;
	}
	public void setIdnamenaz(Cl_namenazem idnamenaz) {
		this.idnamenaz = idnamenaz;
	}
	public Double getPovrsina() {
		return povrsina;
	}
	public void setPovrsina(Double povrsina) {
		this.povrsina = povrsina;
	}
	public Integer getSrez() {
		return srez;
	}
	public void setSrez(Integer srez) {
		this.srez = srez;
	}
	public Integer getKo() {
		return ko;
	}
	public void setKo(Integer ko) {
		this.ko = ko;
	}
	public Integer getBroj() {
		return broj;
	}
	public void setBroj(Integer broj) {
		this.broj = broj;
	}
	public Integer getPodbroj() {
		return podbroj;
	}
	public void setPodbroj(Integer podbroj) {
		this.podbroj = podbroj;
	}
	public Integer getKultura() {
		return kultura;
	}
	public void setKultura(Integer kultura) {
		this.kultura = kultura;
	}
	public Integer getKlasa() {
		return klasa;
	}
	public void setKlasa(Integer klasa) {
		this.klasa = klasa;
	}

}
