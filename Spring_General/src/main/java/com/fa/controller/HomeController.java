package com.fa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.service.HomeService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	HomeService service;

	Sort sort = Sort.by(Sort.Direction.ASC, "kh.ma_KH");
	int pageSize = 4;

	@GetMapping("/index")
	public String showscreen(Model model, @RequestParam(defaultValue = "1") int page) {

		Pageable pageRequest = PageRequest.of(page - 1, pageSize, sort);
		Page<Object[]> pageResult = service.getAllData(pageRequest);

		model.addAttribute("soPhanTu1Trang", pageResult.getNumberOfElements());
		model.addAttribute("tongSoBangGhi", pageResult.getTotalElements());

		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", pageResult.getTotalPages());
		model.addAttribute("arrObject", pageResult.getContent());

		return "Home";
	}

}
