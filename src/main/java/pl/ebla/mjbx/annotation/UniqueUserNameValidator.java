package pl.ebla.mjbx.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import pl.ebla.mjbx.repository.UserRepository;

public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String>{

	private UserRepository userRepository;
	
	@Override
	public void initialize(UniqueUserName constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String name, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(userRepository == null){
			return true;
		}
		
		return userRepository.findOneByName(name) == null;
	}

}
