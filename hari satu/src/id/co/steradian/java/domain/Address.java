package id.co.steradian.java.domain;

public class Address {
	
	private String nomor;
	private String jalan;
	private String kota;
	private Integer kodePos;
	
	public String getNomor() {
		return nomor;
	}
	public void setNomor(String nomor) {
		this.nomor = nomor;
	}
	public String getJalan() {
		return jalan;
	}
	public void setJalan(String jalan) {
		this.jalan = jalan;
	}
	public String getKota() {
		return kota;
	}
	public void setKota(String kota) {
		this.kota = kota;
	}
	public Integer getKodePos() {
		return kodePos;
	}
	public void setKodePos(Integer kodePos) {
		this.kodePos = kodePos;
	}

}
