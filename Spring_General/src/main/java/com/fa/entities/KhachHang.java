package com.fa.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class KhachHang {
    @Id
    @Column(name = "ma_KH")
    @NotBlank(message = "Khong duoc rong MaKH")
    private String maKH;

    @NotBlank(message = "Khong duoc rong tenKH")
    @Column(name = "ten_KH", columnDefinition = "NVARCHAR(50)")
    private String tenKH;

    @NotBlank(message = "Khong duoc rong diaChi")
    @Column(name = "dia_Chi", columnDefinition = "NVARCHAR(50)")
    private String diaChi;

    @NotBlank(message = "Khong duoc rong SoDT")
    @Column(name = "so_Dien_Thoai")
    private String soDienThoai;

    @NotBlank(message = "Khong duoc rong email")
    @Column(name = "dia_Chi_Email")
    private String diaChiEmail;

    @OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL)
    private Set<SuDungMay> suDungMayList;

    @OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL)
    private Set<SuDungDichVu> suDungDichVu;

    public String getMaKH() {
	return maKH;
    }

    public void setMaKH(String maKH) {
	this.maKH = maKH;
    }

    public String getTenKH() {
	return tenKH;
    }

    public void setTenKH(String tenKH) {
	this.tenKH = tenKH;
    }

    public String getDiaChi() {
	return diaChi;
    }

    public void setDiaChi(String diaChi) {
	this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
	return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
	this.soDienThoai = soDienThoai;
    }

    public String getDiaChiEmail() {
	return diaChiEmail;
    }

    public void setDiaChiEmail(String diaChiEmail) {
	this.diaChiEmail = diaChiEmail;
    }

    public Set<SuDungMay> getSuDungMayList() {
	return suDungMayList;
    }

    public void setSuDungMayList(Set<SuDungMay> suDungMayList) {
	this.suDungMayList = suDungMayList;
    }

    public KhachHang() {
	super();
    }

}
