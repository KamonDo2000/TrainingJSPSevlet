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
public class SuDungDichVu implements Serializable {

	private static final long serialVersionUID = 1L;

	@Valid
	@EmbeddedId
	private SuDungDichVuID id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ma_DichVu", insertable = false, updatable = false)
	private DichVu dichVu;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ma_KH", insertable = false, updatable = false)
	private KhachHang khachHang;

	@Min(value = 1, message = "Số lượng phải lớn hơn 0")
	@Column(name = "so_Luong")
	private int soLuong;

	public SuDungDichVuID getId() {
		return id;
	}

	public void setId(SuDungDichVuID id) {
		this.id = id;
	}

	public DichVu getDichVu() {
		return dichVu;
	}

	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public SuDungDichVu() {
		super();
	}

}
