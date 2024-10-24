package com.fa.validation;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.fa.entities.DichVu;
import com.fa.entities.KhachHang;
import com.fa.entities.SuDungDichVu;
import com.fa.entities.SuDungMay;
import com.fa.service.CustService;
import com.fa.service.DichVuService;

@Component
public class HandelValidator implements Validator {

	@Autowired
	CustService serviceCus;
	
	@Autowired
	DichVuService serviceDV;

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {

//		Sử Dụng Dịch Vụ validate
		if (target instanceof SuDungDichVu) {
			SuDungDichVu obj = (SuDungDichVu) target;

			LocalDate inputDate = obj.getId().getNgaySuDung();
			LocalDate nowDate = LocalDate.now();

			if (obj.getId().getMaKH() == null) {
				errors.rejectValue("id.maKH", null, "Ma KH not null");
			}
			if (obj.getId().getMaDV() == null) {
				errors.rejectValue("id.maDV", null, "Dich Vu not null");
			}
			
			if (inputDate == null) {
				errors.rejectValue("id.ngaySuDung", null, "Ngày not null");
			} else if (inputDate.toEpochDay() > nowDate.toEpochDay()) {
				errors.rejectValue("id.ngaySuDung", null, "Ngày phải trước hôm nay");
			}

			if (obj.getId().getGioSuDung() == null) {
				errors.rejectValue("id.gioSuDung", null, "Giờ not null");
			} else if (obj.getId().getGioSuDung().isBefore(LocalTime.of(8, 00))
					|| obj.getId().getGioSuDung().isAfter(LocalTime.of(22, 00))) {
				errors.rejectValue("id.gioSuDung", null, "Quán chỉ mở từ 8:00 đến 22:00");
			}

			return;
		}

//		Sử dụng Máy Validate
		if (target instanceof SuDungMay) {
			SuDungMay obj = (SuDungMay) target;

			LocalDate inputDate = obj.getId().getNgayBatDau();
			LocalDate nowDate = LocalDate.now();

			if (obj.getId().getMaKH() == null) {
				errors.rejectValue("id.maKH", null, "Ma KH not null");
			}
			
			if (inputDate == null) {
				errors.rejectValue("id.ngayBatDau", null, "Ngày not null");
			} else if (inputDate.toEpochDay() > nowDate.toEpochDay()) {
				errors.rejectValue("id.ngayBatDau", null, "Ngày phải trước hôm nay");
			}

			if (obj.getId().getGioBatDau() == null) {
				errors.rejectValue("id.gioBatDau", null, "Giờ not null");
			} else if (obj.getId().getGioBatDau().isBefore(LocalTime.of(8, 00))
					|| obj.getId().getGioBatDau().isAfter(LocalTime.of(22, 00))) {
				errors.rejectValue("id.gioBatDau", null, "Quán chỉ mở từ 8:00 đến 22:00");
			}

			return;
		}
		
//		Khach Hang Validate
		if (target instanceof KhachHang) {
			KhachHang obj = (KhachHang) target;
			if (obj.getMaKH() == null) {
				errors.rejectValue("maKH", null, "Ma KH not null");
			} else if (serviceCus.checkDuplicate(obj.getMaKH())) {
				errors.rejectValue("maKH", null, "Da Co Khach Hang");
			}
			return;
		}
		
//		Dich Vu Validate
		if (target instanceof DichVu) {
			DichVu obj = (DichVu) target;
			if (obj.getMaDV() == null) {
				errors.rejectValue("maDV", null, "Dich Vu not null");
			} else if (serviceDV.checkDuplicate(obj.getMaDV())) {
				errors.rejectValue("maDV", null, "Da Co Dich Vu nay");
			}
			return;
		}

	}

}
