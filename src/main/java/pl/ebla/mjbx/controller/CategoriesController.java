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

import pl.ebla.mjbx.entity.Category;
import pl.ebla.mjbx.entity.User;
import pl.ebla.mjbx.service.CategoryService;
import pl.ebla.mjbx.service.UserService;


@Controller
public class CategoriesController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;
	
	private User currentLoggedUser;
	
	private ModelAndView createModel(String viewName){
		
		ModelAndView model = new ModelAndView(viewName);	
		model.addObject("categories", categoryService.findAll() );
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		currentLoggedUser = userService.findOneByName(userName);
		model.addObject("currentLoggedUserName", currentLoggedUser.getName());
		
		return model;
	}		
	
	@RequestMapping("/categories")
	public ModelAndView categories(){
		
		ModelAndView model = createModel("categories");
		
		return model;
	}
	
	@ModelAttribute("category")
	public Category constractCategory(){
		return new Category();
	}	
	
	@RequestMapping(value="/categories", method=RequestMethod.POST)
	public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result){
		
		if(result.hasErrors())
			return "redirect:/categories";
		
		categoryService.save(category);
		
		return "redirect:/categories";
	}
	
	@RequestMapping(value="/categories/change/category{id}" )
	public ModelAndView changeCategory(@PathVariable int id){
		
		ModelAndView model = createModel("change_category");
		
		model.addObject("category", categoryService.findOne(id));
		
		return model;
	}
	
	@RequestMapping("/categories/isCategoryExists")
	@ResponseBody
	public String isCategoryExists(@RequestParam String categoryName){
		
		Boolean available = categoryService.findByCategoryName(categoryName) == null;
		
		return available.toString();
		
	}	

}
