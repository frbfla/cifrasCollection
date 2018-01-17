package br.com.cifrasCollection.enumeration;

public enum TomMusica {
	
	Do(1, "C - Dó Maior"),
	Re(2, "D - Ré Maior"),
	Mi(3, "E - Mi Maior"),
	Fa(4, "F - Fá Maior"),
    Sol(5, "G - Sol Maior"),
	La(6, "A - Lá Maior"),
	Si(7, "B - Si Maior"),
	
	DoS(8, "C# - Dó Sustenido Maior"),  
	ReS(9, "D# - Ré Sustenido Maior"),  
	FaS(10, "F# - Fá Sustenido Maior"),  
	SolS(11, "G# - Sol Sustenido Maior"),  
	LaS(12, "A# - Lá Sustenido Maior"),
	           
	ReB(13, "Db - Dó Bemol Maior"),
	MiB(14, "Eb - Ré Bemol Maior"),
    SolB(15, "Gb - Mi Bemol Maior"),
	LaB(16, "Ab - Fá Bemol Maior"),
	SiB(17,"Bb - Sol Bemol Maior"),
	            
	DoM(1, "Cm - Dó Menor"),
	ReM(2, "Dm - Ré Menor"),
	MiM(3, "Em - Mi Menor"),
	FaM(4, "Fm - Fá Menor"),
	SolM(5, "Gm - Sol Menor"),
	LaM(6, "Am - Lá Menor"),
	SiM(7, "Bm - Si Menor"),
	
	DoSM(8, "C#m - Dó Sustenido Menor"),
	ReSM(9, "D#m - Ré Sustenido Menor"),
	FaSM(10, "F#m - Fá Sustenido Menor"),
	SolSM(11, "G#m - Sol Sustenido Menor"),
	LaSM(12, "A#m - Lá Sustenido Menor"),
	
	ReBM(13, "Dbm - Ré Bemol Menor"),
	MiBM(14, "Ebm - Mi Bemol Menor"),
	SolBM(15, "Gbm - Sol Bemol Menor"),
	LaBM(16, "Abm - Lá Bemol Menor"),
	SiBM(17,"Bbm - Si Bemol Menor");
	
	
	
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
