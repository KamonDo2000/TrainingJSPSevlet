package com.fa.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class DichVu {

    @Id
    @Column(name = "ma_DV")
    @NotBlank(message = "Khong duoc rong maDV")
    private String maDV;

    @Column(name = "ten_DV", columnDefinition = "NVARCHAR(50)")
    @NotBlank(message = "Khong duoc rong tenDV")
    private String tenDV;

    @Column(name = "don_Vi_Tinh", columnDefinition = "NVARCHAR(50)")
    @NotBlank(message = "Khong duoc rong donViTinh")
    private String donViTinh;

    @Column(name = "don_Gia")
    @NotBlank(message = "Khong duoc rong donGia")
    private String donGia;

    @OneToMany(mappedBy = "dichVu", cascade = CascadeType.ALL)
    private Set<SuDungDichVu> suDungDichVu;

    public String getMaDV() {
	return maDV;
    }

    public void setMaDV(String maDV) {
	this.maDV = maDV;
    }

    public String getTenDV() {
	return tenDV;
    }

    public void setTenDV(String tenDV) {
	this.tenDV = tenDV;
    }

    public String getDonViTinh() {
	return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
	this.donViTinh = donViTinh;
    }

    public String getDonGia() {
	return donGia;
    }

    public void setDonGia(String donGia) {
	this.donGia = donGia;
    }

    public DichVu() {
	super();
    }

}
