package id.co.steradian.java.domain;

import java.util.Date;

public class Person extends BaseEntity {
	
	private String nama;
	private String status;
	private Date tanggalLahir;
	//private Address alamat;
	
	public Person(String nama, String status, Date tanggalLahir) {
		this.nama = nama;
		this.status = status;
		this.tanggalLahir = tanggalLahir;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getTanggalLahir() {
		return tanggalLahir;
	}
	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}

}
