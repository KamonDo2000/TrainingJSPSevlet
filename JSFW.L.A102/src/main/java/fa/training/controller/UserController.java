package fa.training.controller;

import java.security.Principal;
import java.util.Arrays;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import fa.training.dto.UserDetailsDTO;
import fa.training.model.Authorities;
import fa.training.model.User;
import fa.training.service.CommentService;
import fa.training.service.UserService;
import fa.training.validator.UserValidator;

/**
 * This Class User Controller Consist of many mapping process functions.
 * 
 * @author VuPH7
 *
 */
@SessionAttributes({ "currentUser" })

@Controller
public class UserController {

	// Declare Comment Service
	@Autowired
	private CommentService commentService;

	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	private int error = 0;

	// Declare User validator
	@Autowired
	private UserValidator userValidator;

	// Declare User service
	@Autowired
	private UserService userService;

	/**
	 * function to BCrypt encode password
	 * 
	 * @param password
	 * @return String
	 */
	public String passwordEncoder(String password) {
		return new BCryptPasswordEncoder().encode(password);
	}

	/**
	 * function Get Mapping with direct: /LoginPage
	 * 
	 * @param principal
	 * @return
	 */
	@GetMapping("/LoginPage")
	public String loginPage(Principal principal, Model result) {
		System.out.println(error);
		if (error == 1) {
			result.addAttribute("Result", "fail_create");
		} else if (error == 2) {
			result.addAttribute("Result", "success_create");
		} else if (error == 3) {
			result.addAttribute("Result", "fail_login");
		}
		error = 0;
		return principal == null ? "LoginPage" : "redirect:/";
	}

	/**
	 * function Post Mapping with direct: /postLogin
	 * 
	 * @param model
	 * @param session
	 * @return String "redirect:/index"
	 */
	@PostMapping("postLogin")
	public String postLogin(Model model, HttpSession session) {

		log.info("postLogin()");

		// declare Authentication
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		// cast Authentication to UsernamePasswordAuthenticationToken
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) (authentication);

		// call function validatePrinciple
		validatePrinciple(token.getPrincipal());

		// cast UsernamePasswordAuthenticationToken to User
		User loggedInUser = ((UserDetailsDTO) token.getPrincipal()).getUserDetails();

		model.addAttribute("currentUser", loggedInUser.getUsername());

		session.setAttribute("userId", loggedInUser.getId());
		session.setAttribute("userName", loggedInUser.getUsername());
		session.setAttribute("userEmail", loggedInUser.getEmail());
		session.setAttribute("totalComment",
				commentService.countAllCommentByUserId((int) session.getAttribute("userId")));
		return "redirect:/index";
	}

	/**
	 * function to validate principal
	 * 
	 * @param principal
	 */
	private void validatePrinciple(Object principal) {
		if (!(principal instanceof UserDetailsDTO)) {
			throw new IllegalArgumentException("Principal can not be null!");
		}
	}

	/**
	 * function Get Mapping with direct: /loginFailed
	 * 
	 * @param model
	 * @return String "LoginPage"
	 */
	@RequestMapping(value = "loginFailed", method = RequestMethod.GET)
	public String loginError(Model model) {
		log.info("Login attempt failed");
		error = 3;
		model.addAttribute("error", "true");
		return "redirect:/LoginPage";
	}

	/**
	 * function Get Mapping with direct: /Logout logout this user
	 * 
	 * @param session
	 * @param session2
	 * @return new ModelAndView
	 */
	@GetMapping("Logout")
	public ModelAndView logoutPage(SessionStatus session, HttpSession session2) {
		SecurityContextHolder.getContext().setAuthentication(null);
		error = 0;
		session.setComplete();
		session2.invalidate();
		return new ModelAndView("redirect:/LoginPage");
	}

	/**
	 * function Post Mapping with direct: /createUser
	 * 
	 * @param user
	 * @param theBindingResult
	 * @return String "redirect:/LoginPage"
	 */
	@PostMapping("createUser")
	public String createUser(@Valid @ModelAttribute("User") User user, BindingResult theBindingResult) {
		userValidator.validate(user, theBindingResult);
		if (theBindingResult.hasErrors()) {
			error = 1;
			return "redirect:/LoginPage";
		} else {
			user.setPassword(passwordEncoder(user.getPassword()));

			// Create authority
			Authorities authority = new Authorities("ROLE_USER");
			authority.setUser(user);

			user.setAuthorities(Arrays.asList(authority));

			userService.createUser(user);
			error = 2;
			return "redirect:/LoginPage";
		}
	}

}
