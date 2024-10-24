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

import com.fa.entities.Computer;
import com.fa.service.CompService;

@Controller
@RequestMapping("/computer")
public class ComputerController {

	@Autowired
	CompService service;

	Sort sort = Sort.by(Sort.Direction.ASC, "maMay");
	int pageSize = 4;

	@GetMapping("/index")
	public String showscreen(Model model, @RequestParam(defaultValue = "1") int page) {

		Pageable pageRequest = PageRequest.of(page - 1, pageSize, sort);
		Page<Computer> pageComp = service.getAllData(pageRequest);

		model.addAttribute("soPhanTu1Trang", pageComp.getNumberOfElements());
		model.addAttribute("tongSoBangGhi", pageComp.getTotalElements());

		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", pageComp.getTotalPages());
		model.addAttribute("computers", pageComp.getContent());

		String pa = "";
		model.addAttribute("searchKey", pa);

		return "computer/Computer";
	}

	@GetMapping("/search") // required = false tham số truy vấn ko bắt buộc
	public String searchMay(Model model, @RequestParam(name = "searchKey", required = false) String searchKey,
			@RequestParam(defaultValue = "1") int page) {

		Pageable pageRequest = PageRequest.of(page - 1, pageSize, sort);
		Page<Computer> searchResults = service.search(searchKey, pageRequest);

		model.addAttribute("soPhanTu1Trang", searchResults.getNumberOfElements());
		model.addAttribute("tongSoBangGhi", searchResults.getTotalElements());

		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", searchResults.getTotalPages());
		model.addAttribute("computers", searchResults.getContent());

		model.addAttribute("searchKey", searchKey);
		return "computer/Computer";
	}
//==========================================DELETE=====================================================
	@GetMapping("/deleteComp/{index}")
	public String daleteComputer(@PathVariable(name = "index") int id) {
		service.deleteById(id);
		return "redirect:/computer/index";
	}
	
	@GetMapping("/closeAdd")
	public String closeAdd(Model model) {
		return "redirect:/computer/index";
	}
//==========================================ADD=====================================================
	@GetMapping("/AddIndex")
	public String addIndex(Model model) {
		model.addAttribute("computer-Form", new Computer());
		return "computer/AddComputer";
	}
	@PostMapping("/AddOrUpdate")
	public String addComputer(Model model,@Valid @ModelAttribute(name = "computer-Form") Computer comp, BindingResult result) {

		if (result.hasErrors()) {
			return "computer/AddComputer";
		}

		service.saveComp(comp);
		return "redirect:/computer/index";
	}
	
//==========================================EDIT=====================================================
	@GetMapping("/EditIndex/{id}")
	public String editIndex(@PathVariable int id, Model model) {
		Computer computer = service.findByID(id);
		
		model.addAttribute("computer-Form", computer);
		model.addAttribute("atributeTT", computer.getTrangThai());
		return "computer/EditComputer";
	}
	@PostMapping("/EditIndex/AddOrUpdate")
	public String editComputer(Model model,@Valid @ModelAttribute(name = "computer-Form") Computer comp, BindingResult result) {
		if (result.hasErrors()) {
			return "computer/EditComputer";
		}
		service.saveComp(comp);
		return "redirect:/computer/index";
	}

}
