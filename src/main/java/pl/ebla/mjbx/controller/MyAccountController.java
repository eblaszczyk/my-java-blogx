package pl.ebla.mjbx.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pl.ebla.mjbx.entity.User;
import pl.ebla.mjbx.service.CategoryService;
import pl.ebla.mjbx.service.UserService;
import pl.ebla.mjbx.wapper.PasswordChangeWrapper;

@Controller
public class MyAccountController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	
	private User currentLoggedUser;
	
	private ModelAndView createModel(String viewName){
		
		ModelAndView model = new ModelAndView(viewName);	
		model.addObject("categories", categoryService.findAll() );
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		currentLoggedUser = userService.findOneByName(userName);
		model.addObject("currentLoggedUserName", currentLoggedUser.getName());
		
		return model;
	}	

	@RequestMapping("/myaccount/isOldPasswordCorrect")
	@ResponseBody
	public String isOldPasswordCorrect(@RequestParam String oldPassword){
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		Boolean available = encoder.matches(oldPassword, currentLoggedUser.getPassword());
				
		return available.toString();
		
	}	
	
	@RequestMapping("/myaccount/change/password")
	public ModelAndView changePassword(){
		
		ModelAndView model = createModel("change_password");
		model.addObject("passwordChangeWrapper", new PasswordChangeWrapper());

		return model;
	}
	
	@RequestMapping(value = "/myaccount/changed/password", method = RequestMethod.POST)
	public ModelAndView changePassword(@Valid 
			@ModelAttribute("passwordChangeWrapper") PasswordChangeWrapper passwordChangeWrapper, 
			BindingResult result){
		
		if(result.hasErrors()){
			return changePassword();
		}
		ModelAndView model = createModel("password_changed");
		currentLoggedUser.setPassword(passwordChangeWrapper.getNewPassword());
		
		userService.changePassword(currentLoggedUser);
		
		return model;
	}
	
	@RequestMapping("/myaccount/view")
	public ModelAndView viewAccount(){
		
		ModelAndView model = createModel("view_account");
		model.addObject("user", currentLoggedUser);

		return model;
	}	
	
	@RequestMapping(value="/myaccount/changed/account", method = RequestMethod.POST)
	public ModelAndView changeMyAccount(@Valid @ModelAttribute("user") User user, BindingResult result){
		
		if(result.hasErrors()){
			return viewAccount();
		}
		
		currentLoggedUser.copy(user);
		userService.changeUser(currentLoggedUser);
		
		return viewAccount();
	}
}
