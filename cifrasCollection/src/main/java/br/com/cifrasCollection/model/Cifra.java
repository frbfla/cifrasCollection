package br.com.cifrasCollection.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="cifra")
public class Cifra {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	private String tom;
	
	private String cantor;
	
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

	public String getTom() {
		return tom;
	}

	public void setTom(String tom) {
		this.tom = tom;
	}

	public String getCantor() {
		return cantor;
	}

	public void setCantor(String cantor) {
		this.cantor = cantor;
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
		result = prime * result + ((cantor == null) ? 0 : cantor.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tom == null) ? 0 : tom.hashCode());
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
		if (cantor == null) {
			if (other.cantor != null)
				return false;
		} else if (!cantor.equals(other.cantor))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tom == null) {
			if (other.tom != null)
				return false;
		} else if (!tom.equals(other.tom))
			return false;
		return true;
	} 
	
	
	
}
