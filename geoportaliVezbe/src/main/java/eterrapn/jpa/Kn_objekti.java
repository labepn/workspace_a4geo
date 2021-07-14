package eterrapn.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@NamedQuery(name="Kn_objekti.findAll", query="SELECT t FROM Kn_objekti t")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Kn_objekti {

	
	@Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pnid;
	private Double povrsina;
	@ManyToOne
	@JoinColumn(name="idspratnost")
	private Cl_spratnost idspratnost;
	@ManyToOne
	@JoinColumn(name="idnamena")
	private Cl_namenaobj idnamena;
	private Integer srez;
	private Integer ko;
	private Integer broj;
	private Integer podbroj;
	private Integer kultura;
	private Integer zgrada;
	
	
	
	public Integer getPnid() {
		return pnid;
	}
	public void setPnid(Integer pnid) {
		this.pnid = pnid;
	}
	public Double getPovrsina() {
		return povrsina;
	}
	public void setPovrsina(Double povrsina) {
		this.povrsina = povrsina;
	}
	public Cl_spratnost getIdspratnost() {
		return idspratnost;
	}
	public void setIdspratnost(Cl_spratnost idspratnost) {
		this.idspratnost = idspratnost;
	}
	public Cl_namenaobj getIdnamena() {
		return idnamena;
	}
	public void setIdnamena(Cl_namenaobj idnamena) {
		this.idnamena = idnamena;
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
	public Integer getZgrada() {
		return zgrada;
	}
	public void setZgrada(Integer zgrada) {
		this.zgrada = zgrada;
	}
}
