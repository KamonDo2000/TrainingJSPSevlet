package com.fa.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class SuDungDichVuID implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "ma_KH")
	private String maKH;

	@Column(name = "ma_DichVu")
	private String maDV;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ngay_Su_Dung")
	private LocalDate ngaySuDung;

	@DateTimeFormat(pattern = "HH:mm")
	@Column(name = "gio_Su_Dung")
	private LocalTime gioSuDung;

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getMaDV() {
		return maDV;
	}

	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}

	public LocalDate getNgaySuDung() {
		return ngaySuDung;
	}

	public void setNgaySuDung(LocalDate ngaySuDung) {
		this.ngaySuDung = ngaySuDung;
	}

	public LocalTime getGioSuDung() {
		return gioSuDung;
	}

	public void setGioSuDung(LocalTime gioSuDung) {
		this.gioSuDung = gioSuDung;
	}

	public SuDungDichVuID() {
		super();
	}

}
