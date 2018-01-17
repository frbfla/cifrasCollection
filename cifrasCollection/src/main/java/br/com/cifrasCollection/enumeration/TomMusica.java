package br.com.cifrasCollection.enumeration;

public enum TomMusica {
	
	Do(1, "C - D� Maior"),
	Re(2, "D - R� Maior"),
	Mi(3, "E - Mi Maior"),
	Fa(4, "F - F� Maior"),
    Sol(5, "G - Sol Maior"),
	La(6, "A - L� Maior"),
	Si(7, "B - Si Maior"),
	
	DoS(8, "C# - D� Sustenido Maior"),  
	ReS(9, "D# - R� Sustenido Maior"),  
	FaS(10, "F# - F� Sustenido Maior"),  
	SolS(11, "G# - Sol Sustenido Maior"),  
	LaS(12, "A# - L� Sustenido Maior"),
	           
	ReB(13, "Db - D� Bemol Maior"),
	MiB(14, "Eb - R� Bemol Maior"),
    SolB(15, "Gb - Mi Bemol Maior"),
	LaB(16, "Ab - F� Bemol Maior"),
	SiB(17,"Bb - Sol Bemol Maior"),
	            
	DoM(1, "Cm - D� Menor"),
	ReM(2, "Dm - R� Menor"),
	MiM(3, "Em - Mi Menor"),
	FaM(4, "Fm - F� Menor"),
	SolM(5, "Gm - Sol Menor"),
	LaM(6, "Am - L� Menor"),
	SiM(7, "Bm - Si Menor"),
	
	DoSM(8, "C#m - D� Sustenido Menor"),
	ReSM(9, "D#m - R� Sustenido Menor"),
	FaSM(10, "F#m - F� Sustenido Menor"),
	SolSM(11, "G#m - Sol Sustenido Menor"),
	LaSM(12, "A#m - L� Sustenido Menor"),
	
	ReBM(13, "Dbm - R� Bemol Menor"),
	MiBM(14, "Ebm - Mi Bemol Menor"),
	SolBM(15, "Gbm - Sol Bemol Menor"),
	LaBM(16, "Abm - L� Bemol Menor"),
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
