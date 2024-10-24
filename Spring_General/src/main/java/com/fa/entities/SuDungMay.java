package com.fa.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;

@Entity
public class SuDungMay implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Valid
	@EmbeddedId
	private SuDungMayID id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ma_May", insertable = false, updatable = false)
	private Computer computer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ma_KH", insertable = false, updatable = false)
	private KhachHang khachHang;

	@Min(value = 1, message = "Thời gian sử dụng lớn hơn 1 phút")
	@Column(name = "thoi_Gian_Su_Dung")
	private int thoiGianSuDung;

	public SuDungMayID getId() {
		return id;
	}

	public void setId(SuDungMayID id) {
		this.id = id;
	}

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public int getThoiGianSuDung() {
		return thoiGianSuDung;
	}

	public void setThoiGianSuDung(int thoiGianSuDung) {
		this.thoiGianSuDung = thoiGianSuDung;
	}

	public SuDungMay() {
		super();
	}

}
