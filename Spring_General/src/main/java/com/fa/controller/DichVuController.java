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

import com.fa.entities.DichVu;
import com.fa.service.DichVuService;
import com.fa.validation.HandelValidator;

@Controller
@RequestMapping("/dichvu")
public class DichVuController {

	@Autowired
	DichVuService service;
	
	@Autowired
	HandelValidator validator;
	
	Sort sort = Sort.by(Sort.Direction.ASC, "maDV");
	int pageSize = 4;
	
	@GetMapping("/index")
	public String showscreen(Model model, @RequestParam(defaultValue = "1") int page) {
		Pageable pageRequest = PageRequest.of(page - 1, pageSize, sort);
		Page<DichVu> pageComp = service.getAllData(pageRequest);
		model.addAttribute("soPhanTu1Trang", pageComp.getNumberOfElements());
		model.addAttribute("tongSoBangGhi", pageComp.getTotalElements());
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", pageComp.getTotalPages());

		model.addAttribute("DataDichVu", pageComp.getContent());
		
		String pa="";
		model.addAttribute("searchKey", pa);
		
		return "dichVu/DichVu";
	}
	
	@GetMapping("/search") // required = false tham số truy vấn ko bắt buộc
	public String search(@RequestParam(name = "searchKey", required = false)String searchKey, Model model,  @RequestParam(defaultValue = "1") int page) {
		Pageable  pageRequest = PageRequest.of(page - 1, pageSize, sort);
		Page<DichVu> searchResults = service.search(searchKey, pageRequest);
				
		model.addAttribute("soPhanTu1Trang", searchResults.getNumberOfElements());
		model.addAttribute("tongSoBangGhi", searchResults.getTotalElements());
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", searchResults.getTotalPages());
		
		model.addAttribute("DataDichVu", searchResults.getContent());

		model.addAttribute("searchKey", searchKey);
		return "dichVu/DichVu";
	}
	
//==========================================DELETE=====================================================

	@GetMapping("/delete/{index}")
	public String dalete(@PathVariable(name = "index") String id) {
		service.deleteById(id);
		return "redirect:/dichvu/index";
	}
	
	@GetMapping("/closeAdd")
	public String closeAdd(Model model) {
		return "redirect:/dichvu/index";
	}
	
//==========================================ADD=====================================================

	@GetMapping("/add")
	public String addIndex(Model model) {
		model.addAttribute("dichVu-Form", new DichVu());
		return "dichVu/AddDichVu";
	}
	@PostMapping("/addNew")
	public String add(Model model, @Valid @ModelAttribute(name = "dichVu-Form") DichVu obj, BindingResult result) {

		validator.validate(obj, result);
		
		if (result.hasErrors()) {
			return "dichVu/AddDichVu";
		}

		service.saveOrUpdate(obj);
		return "redirect:/dichvu/index";
	}

//==========================================EDIT=====================================================
	@GetMapping("/edit/{id}")
	public String editIndex(@PathVariable String id, Model model) {
		DichVu obj = service.findByID(id);
		
		model.addAttribute("dichVu-Form", obj);
		
		return "dichVu/EditDichVu";
	}
	@PostMapping("/edit/update")
	public String edit(Model model,@Valid @ModelAttribute(name = "dichVu-Form") DichVu obj, BindingResult result) {
		
		if (result.hasErrors()) {
			return "dichVu/EditDichVu";
		}
		
		service.saveOrUpdate(obj);
		return "redirect:/dichvu/index";
	}
	
	
}
