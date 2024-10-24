package com.fa.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class SuDungMayID implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "ma_KH")
	private String maKH;

	@Column(name = "ma_May")
	@Min(value = 1, message = "Giá trị phải lớn hơn hoặc bằng 1")
	private int maMay;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngay_Bat_Dau")
	private LocalDate ngayBatDau;

	@DateTimeFormat(pattern = "HH:mm")
	@Column(name = "gio_Bat_Dau")
	private LocalTime gioBatDau;

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public int getMaMay() {
		return maMay;
	}

	public void setMaMay(int maMay) {
		this.maMay = maMay;
	}

	public LocalDate getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(LocalDate ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public LocalTime getGioBatDau() {
		return gioBatDau;
	}

	public void setGioBatDau(LocalTime gioBatDau) {
		this.gioBatDau = gioBatDau;
	}

	public SuDungMayID() {
		super();
	}

}
