package br.com.cifrasCollection.enumeration;

public enum TipoPerfil {
	
	Usuario(1, "Usuario"),
	Administrador(2, "Administrador");
	
	private Integer id;
	private String descricao;
	
	private TipoPerfil(Integer id, String descricao) {
		this.id= id;
		this.descricao = descricao;
	}
	
	public TipoPerfil getDefault() {
		return Usuario;
	}
	
	public TipoPerfil getEnumById(Integer id) {
		for (TipoPerfil tipo  : TipoPerfil.values()) {
			if (tipo.getId().equals(id)) {
				return tipo;
			}
		}
		return null;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
