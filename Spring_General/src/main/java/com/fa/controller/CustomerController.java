package com.fa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.entities.KhachHang;
import com.fa.service.CustService;
import com.fa.validation.HandelValidator;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustService service;

	@Autowired
	HandelValidator validator;

	Sort sort = Sort.by(Sort.Direction.ASC, "maKH");
	int pageSize = 4;

	@GetMapping("/index")
	public String showscreen(Model model, @RequestParam(defaultValue = "1") int page) {
		Pageable pageRequest = PageRequest.of(page - 1, pageSize, sort);
		Page<KhachHang> pageComp = service.getAllData(pageRequest);
		model.addAttribute("soPhanTu1Trang", pageComp.getNumberOfElements());
		model.addAttribute("tongSoBangGhi", pageComp.getTotalElements());
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", pageComp.getTotalPages());

		model.addAttribute("customers", pageComp.getContent());

		String pa = "";
		model.addAttribute("searchKey", pa);

		return "customer/Customer";
	}

	@GetMapping("/search") // required = false tham số truy vấn ko bắt buộc
	public String search(@RequestParam(name = "searchKey", required = false) String searchKey, Model model,
			@RequestParam(defaultValue = "1") int page) {
		Pageable pageRequest = PageRequest.of(page - 1, pageSize, sort);
		Page<KhachHang> searchResults = service.search(searchKey, pageRequest);

		model.addAttribute("soPhanTu1Trang", searchResults.getNumberOfElements());
		model.addAttribute("tongSoBangGhi", searchResults.getTotalElements());
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", searchResults.getTotalPages());

		model.addAttribute("customers", searchResults.getContent());

		model.addAttribute("searchKey", searchKey);
		return "customer/Customer";
	}
//==========================================DELETE=====================================================

	@GetMapping("/delete/{index}")
	public String dalete(@PathVariable(name = "index") String id) {
		service.deleteById(id);
		return "redirect:/customer/index";
	}

	@GetMapping("/closeAdd")
	public String closeAdd(Model model) {
		return "redirect:/customer/index";
	}

//==========================================ADD=====================================================

	@GetMapping("/add")
	public String addIndex(Model model) {
		model.addAttribute("customer-Form", new KhachHang());
		return "customer/AddCustomer";
	}

	@PostMapping("/addNew")
	public String addComputer(Model model, @Valid @ModelAttribute(name = "customer-Form") KhachHang obj,
			BindingResult result) {

		validator.validate(obj, result);

		if (result.hasErrors()) {
			return "customer/AddCustomer";
		}

		service.saveOrUpdate(obj);
		return "redirect:/customer/index";
	}

//==========================================EDIT=====================================================
	@GetMapping("/edit/{id}")
	public String editIndex(@PathVariable String id, Model model) {
		KhachHang obj = service.findByID(id);

		model.addAttribute("customer-Form", obj);

		return "customer/EditCustomer";
	}

	@PostMapping("/edit/update")
	public String editComputer(Model model, @Valid @ModelAttribute(name = "customer-Form") KhachHang obj,
			BindingResult result) {

		if (result.hasErrors()) {
			return "customer/EditCustomer";
		}

		service.saveOrUpdate(obj);
		return "redirect:/customer/index";
	}

}
