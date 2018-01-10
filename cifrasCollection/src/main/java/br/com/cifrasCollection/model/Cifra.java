package br.com.cifrasCollection.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import br.com.cifrasCollection.enumeration.TomMusica;

@Entity(name="cifra")
public class Cifra {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	@Enumerated
	private TomMusica tom;
	
	private String cantor;
	
	private String linkYoutube;
	
	@Lob
	private byte[] fotoCifra;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TomMusica getTom() {
		return tom;
	}

	public void setTom(TomMusica tom) {
		this.tom = tom;
	}

	public String getCantor() {
		return cantor;
	}

	public void setCantor(String cantor) {
		this.cantor = cantor;
	}

	public String getLinkYoutube() {
		return linkYoutube;
	}

	public void setLinkYoutube(String linkYoutube) {
		this.linkYoutube = linkYoutube;
	}

	public byte[] getFotoCifra() {
		return fotoCifra;
	}

	public void setFotoCifra(byte[] fotoCifra) {
		this.fotoCifra = fotoCifra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cifra other = (Cifra) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
}
