package br.com.cifrasCollection.enumeration;

public enum TomMusica {
	
	Do(1, "C"),
	Re(2, "D"),
	Mi(3, "E"),
	Fa(4, "F"),
	Sol(5, "G"),
	La(6, "A"),
	Si(7, "B"),
	
	DoS(8, "C#"),
	ReS(9, "D#"),
	FaS(10, "F#"),
	SolS(11, "G#"),
	LaS(12, "A#"),
	
	ReB(13, "Db"),
	MiB(14, "Eb"),
	SolB(15, "Gb"),
	LaB(16, "Ab"),
	SiB(17,"Bb"),
	
	DoM(1, "Cm"),
	ReM(2, "Dm"),
	MiM(3, "Em"),
	FaM(4, "Fm"),
	SolM(5, "Gm"),
	LaM(6, "Am"),
	SiM(7, "Bm"),
	
	DoSM(8, "C#m"),
	ReSM(9, "D#m"),
	FaSM(10, "F#m"),
	SolSM(11, "G#m"),
	LaSM(12, "A#m"),
	
	ReBM(13, "Dbm"),
	MiBM(14, "Ebm"),
	SolBM(15, "Gbm"),
	LaBM(16, "Abm"),
	SiBM(17,"Bbm");
	
	
	
	private Integer id;
	private String descricao;
	
	private TomMusica(Integer id, String descricao) {
		this.id= id;
		this.descricao = descricao;
	}
		
	public TomMusica getEnumByDescricao(Integer id) {
		for (TomMusica tipo  : TomMusica.values()) {
			if (tipo.getId().equals(id)) {
				return tipo;
			}
		}
		return null;
	}
	
	public static TomMusica getEnumByDescricao(String tom) {
		for (TomMusica tipo  : TomMusica.values()) {
			if (tipo.getDescricao().equals(tom)) {
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
