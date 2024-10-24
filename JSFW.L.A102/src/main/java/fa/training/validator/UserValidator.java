package fa.training.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fa.training.model.User;
import fa.training.service.UserService;

/**
 * Class UserValidator implements Validator consist of 2 function 1. supports 2.
 * validate
 * 
 * @author ASUS
 *
 */
@Component("userValidator")
public class UserValidator implements Validator {

	// Declare UserService
	@Autowired
	private UserService userService;

	/**
	 * function supports
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.equals(clazz);
	}

	/**
	 * function validate
	 */
	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		User user = (User) target;
		if (userService.findUserByUsername(user.getUsername()) != null) {
			errors.rejectValue("username", "username.exist");
		}

	}

}
