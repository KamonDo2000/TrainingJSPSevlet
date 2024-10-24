package fa.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Class Controller
 * 
 * @author LinhLH7
 *
 */
@Controller
public class DemoController {

	/**
	 * function handle /ContactPage
	 * 
	 * @return ContactPage
	 */
	@GetMapping("/ContactPage")
	public String contacPage() {
		return "ContactPage";
	}

	/**
	 * function handle /AboutPage
	 * 
	 * @return AboutPage
	 */
	@GetMapping("/AboutPage")
	public String aboutPage() {
		return "AboutPage";
	}
}
