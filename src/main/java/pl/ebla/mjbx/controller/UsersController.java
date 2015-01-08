package pl.ebla.mjbx.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pl.ebla.mjbx.entity.User;
import pl.ebla.mjbx.service.CategoryService;
import pl.ebla.mjbx.service.UserService;

@Controller
public class UsersController {
 
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
	
	@RequestMapping("/users")
	public ModelAndView users() {
		
		ModelAndView model = createModel("users");
		model.addObject("users", userService.findByNameNotLike("admin"));
		
		return model;
	}
	
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("user") User user, BindingResult result){
		
		if(result.hasErrors())
			return "redirect:/users";
		
		userService.save(user);
		
		return "redirect:/users";
	}
	
	@ModelAttribute("user")
	public User constractUser(){
		return new User();
	}
	
	@RequestMapping("/users/remove/user{id}")
	public String removeUser(@PathVariable int id){
		
		userService.delete(id);
		
		return "redirect:/users";
	}
	
	@RequestMapping("/users/isUserExists")
	@ResponseBody
	public String isUserExists(@RequestParam String username){
		
		Boolean available = userService.findOneByName(username) == null;
		
		return available.toString();
		
	}
	


}