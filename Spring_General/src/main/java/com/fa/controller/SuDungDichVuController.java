package com.fa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fa.entities.DichVu;
import com.fa.entities.KhachHang;
import com.fa.entities.SuDungDichVu;
import com.fa.service.CustService;
import com.fa.service.DichVuService;
import com.fa.service.SuDungDichVuService;
import com.fa.validation.HandelValidator;

@Controller
@RequestMapping("/dangkydichvu")
public class SuDungDichVuController {

	@Autowired
	SuDungDichVuService service;

	@Autowired
	CustService custService;

	@Autowired
	DichVuService dichVuService;
	
	@Autowired
	HandelValidator validator;

	private void redirectData(Model model) {
		List<String> listMaKH = custService.findAllMaKHDungMay();
		List<String> listMaDV = dichVuService.findAllMaDV();

		model.addAttribute("listMaKH", listMaKH);
		model.addAttribute("listMaDV", listMaDV);
	}

	@GetMapping("/index")
	public String showscreen(Model model) {
		redirectData(model);
		model.addAttribute("dichVu-Form", new SuDungDichVu());
		return "suDungDichVu/DangKyDichVu";
	}

	@PostMapping("/add")
	public String add(Model model,@Valid @ModelAttribute(name = "dichVu-Form") SuDungDichVu obj,
			BindingResult result) {
		
		try {
			validator.validate(obj, result);
		} catch (Exception e) {
			System.out.println("co loi");
		}
		
		if (result.hasErrors()) {
			redirectData(model);
			return "suDungDichVu/DangKyDichVu";
		}

		KhachHang kh = custService.findByID(obj.getId().getMaKH());
		DichVu dv = dichVuService.findByID(obj.getId().getMaDV());
		obj.setKhachHang(kh);
		obj.setDichVu(dv);

		service.saveOrUpdate(obj);
		return "redirect:/home/index";
	}

}
