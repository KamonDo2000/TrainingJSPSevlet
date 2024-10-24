package com.fa.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ma_May")
    private int maMay;

    @NotBlank(message = "Khong de trong vi tri")
    @Column(name = "Vi_Tri", columnDefinition = "NVARCHAR(50)")
    private String viTri;

    @NotNull(message = "Khong de trong Trang Thai")
    @Column(name = "Trang_Thai")
    private String trangThai;

    @OneToMany(mappedBy = "computer", cascade = CascadeType.ALL)
    private Set<SuDungMay> suDungMayList;

    public Computer() {
	super();
    }

    public int getMaMay() {
	return maMay;
    }

    public void setMaMay(int maMay) {
	this.maMay = maMay;
    }

    public String getViTri() {
	return viTri;
    }

    public void setViTri(String viTri) {
	this.viTri = viTri;
    }

    public String getTrangThai() {
	return trangThai;
    }

    public void setTrangThai(String trangThai) {
	this.trangThai = trangThai;
    }

    public Set<SuDungMay> getSuDungMayList() {
	return suDungMayList;
    }

    public void setSuDungMayList(Set<SuDungMay> suDungMayList) {
	this.suDungMayList = suDungMayList;
    }

}
