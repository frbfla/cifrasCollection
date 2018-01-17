package br.com.cifrasCollection.enumeration;

public enum TipoVisibilidade {
	
	SoPraMim(1, "Só para mim"),
	Todos(2, "Para todos");
	
	private Integer id;
	private String descricao;
	
	private TipoVisibilidade(Integer id, String descricao) {
		this.id= id;
		this.descricao = descricao;
	}
	
	public TipoVisibilidade getDefault() {
		return TipoVisibilidade.SoPraMim;
	}
	
	public TipoVisibilidade getEnumById(Integer id) {
		for (TipoVisibilidade tipo  : TipoVisibilidade.values()) {
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
