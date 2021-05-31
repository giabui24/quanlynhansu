package com.buihoanggia.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


	@Entity(name ="phongban")
	public class PhongBan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idPhongBan;
	String tenPhongBan;
	String maPhongBan;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="phongban")
	 Set<NhanVien> nhanviens;


	public Set<NhanVien> getNhanviens() {
		return nhanviens;
	}


	public void setNhanviens(Set<NhanVien> nhanviens) {
		this.nhanviens = nhanviens;
	}


	public int getIdPhongBan() {
		return idPhongBan;
	}


	public void setIdPhongBan(int idPhongBan) {
		this.idPhongBan = idPhongBan;
	}


	public String getTenPhongBan() {
		return tenPhongBan;
	}


	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}


	public String getMaPhongBan() {
		return maPhongBan;
	}


	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}




	public PhongBan(){}

	
	}


