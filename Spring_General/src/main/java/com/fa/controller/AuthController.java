package com.fa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.entities.Authent;
import com.fa.service.AuthenService;

@Controller
public class AuthController {

	@Autowired
	private AuthenService service;

	@PostMapping("/Login")
	public String LoginApp(Model model, @RequestParam("user") String userName, @RequestParam("pass") String passWorld) {

		Authent auth = new Authent(userName, passWorld);
		if (service.checkAuthent(auth)) {
			return "redirect:/home/index";
		} else {
			System.out.println("Errrr");
			return "redirect:/";
//			return "redirect:/home/index";
//			return "adapterERR/ErrPage";
		}
	}

}
