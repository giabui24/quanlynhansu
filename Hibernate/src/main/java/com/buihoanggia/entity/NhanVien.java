package com.buihoanggia.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "nhanvien")
public class NhanVien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idNhanVien;
	String tenNhanVien;
	int tuoi;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPhongBan")
	PhongBan phongban;

	public NhanVien() {}



	public PhongBan getPhongban() {
		return phongban;
	}



	public void setPhongban(PhongBan phongban) {
		this.phongban = phongban;
	}



	public int getIdNhanVien() {
		return idNhanVien;
	}

	public void setIdNhanVien(int idNhanVien) {
		this.idNhanVien = idNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	
	
}