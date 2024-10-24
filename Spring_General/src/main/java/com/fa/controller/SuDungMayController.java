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

import com.fa.entities.Computer;
import com.fa.entities.KhachHang;
import com.fa.entities.SuDungMay;
import com.fa.service.CompService;
import com.fa.service.CustService;
import com.fa.service.SuDungMayService;
import com.fa.validation.HandelValidator;

@Controller
@RequestMapping("/dangkymay")
public class SuDungMayController {

	@Autowired
	SuDungMayService service;

	@Autowired
	CustService custService;

	@Autowired
	CompService compService;
	
	@Autowired
	HandelValidator validator;
	
	private void redirectData(Model model) {
		List<String> listMaKH = custService.findAllMaKH();
		List<String> listMaMay = compService.findAllMaMay();

		model.addAttribute("listMaKH", listMaKH);
		model.addAttribute("listMaMay", listMaMay);
	}

	@GetMapping("/index")
	public String showscreen(Model model) {
		redirectData(model);
		model.addAttribute("may-Form", new SuDungMay());
		return "suDungMay/DangKyMay";
	}

	@PostMapping("/add")
	public String add(Model model,@Valid @ModelAttribute(name = "may-Form") SuDungMay obj, BindingResult result) {
		
		validator.validate(obj, result);
		
		if (result.hasErrors()) {
			redirectData(model);
			return "suDungMay/DangKyMay";
		}

		KhachHang kh = custService.findByID(obj.getId().getMaKH());
		Computer conp = compService.findByID(obj.getId().getMaMay());
		obj.setKhachHang(kh);
		obj.setComputer(conp);

		service.saveOrUpdate(obj);
		return "redirect:/home/index";
	}

}
