package com.example.demo2.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.core.style.ToStringCreator;

@Entity
public class Klient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5791939930388135586L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 128)
	private String imie;
	@Column(length = 128)
	private String nazwisko;
//	@Column(nullable=false)
	private Date dataUtworzenia;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public Date getDataUtworzenia() {
		return dataUtworzenia;
	}
	public void setDataUtworzenia(Date dataUtworzenia) {
		this.dataUtworzenia = dataUtworzenia;
	}


	@Override
	public String toString() {
		ToStringCreator tsc = new ToStringCreator(this);
		tsc.append("id", this.id);
		tsc.append("imie", this.imie);
		tsc.append("nazwisko", this.nazwisko);
		tsc.append("dataUtworzenia", this.dataUtworzenia);
		return tsc.toString();
	}


}
