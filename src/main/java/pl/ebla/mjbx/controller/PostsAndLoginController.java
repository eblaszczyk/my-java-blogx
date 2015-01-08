package pl.ebla.mjbx.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.ebla.mjbx.date.CurrentMonth;
import pl.ebla.mjbx.entity.Category;
import pl.ebla.mjbx.entity.Month;
import pl.ebla.mjbx.entity.Post;
import pl.ebla.mjbx.entity.User;
import pl.ebla.mjbx.service.CategoryService;
import pl.ebla.mjbx.service.MonthService;
import pl.ebla.mjbx.service.PostService;
import pl.ebla.mjbx.service.UserService;
import pl.ebla.mjbx.wapper.PostAndCategoriesWrapper;


/**
 * Handles requests for the application home page.
 */
@Controller
public class PostsAndLoginController {
	
	private static int MAX_POSTS_NR_ON_PAGE = 5;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private PostService postService; 
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MonthService monthService;
	
	private User currentLoggedUser;
	
	private ModelAndView createModel(String viewName){
		
		ModelAndView model = new ModelAndView(viewName);	
		model.addObject("categories", categoryService.findAll() );
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		currentLoggedUser = userService.findOneByName(userName);
		model.addObject("currentLoggedUserName", currentLoggedUser.getName());
		
		return model;
	}	
	
	@RequestMapping("/login")
	public ModelAndView login() {
		
		ModelAndView model = new ModelAndView("login");
		
		return model;
	}
	
	@RequestMapping( "/posts")
	public ModelAndView posts() {
		
		ModelAndView model = createModel("posts");	
		return model;
	}		
	
	
	@RequestMapping( value = "/posts/add/post", method = RequestMethod.GET)
	public ModelAndView newPost() {
		
		ModelAndView model = createModel("add_post");

		
		model.addObject("postAndCategoriesWrapper", new PostAndCategoriesWrapper());
		
		List<String> categoryNameList = new ArrayList<String>();
		for(Category category:categoryService.findAll())
			categoryNameList.add(category.getCategoryName());
		
		model.addObject("categoryNames", categoryNameList);
		
		
		return model;
	}
	
	@RequestMapping( value = "/posts/added/post", method = RequestMethod.POST)
	public ModelAndView newPostSave(@Valid @ModelAttribute PostAndCategoriesWrapper postAndCategoriesWrapper, 
			BindingResult result) {
		
		if( result.hasErrors()){
			return newPost();
		}
		
		ModelAndView model = createModel("post_added");	
		
		Month month = new Month();
		CurrentMonth currMonth = new CurrentMonth();
		month.setCurrentMonth(currMonth);
		monthService.saveIfNotExists(month);
		
		Post post = postAndCategoriesWrapper.getPost();			
		post.setUp(categoryService.findByListNames(postAndCategoriesWrapper.getCategoriesList()),
				currentLoggedUser, monthService.findByName(month.getName()));
		
		model.addObject("post", post);
		model.addObject("months", monthService.findAllSortDesc());
		
		postService.save(post);
		
		return model;
	}
	
	@RequestMapping( value = {"/posts/myPosts", "/posts/myPosts/?page"})
	public ModelAndView myPost(
			@RequestParam(defaultValue="0", value="page", required=false) Integer page) {
		
		ModelAndView model = createModel("view_posts");	
		
		Page<Post> pages = postService.findAllByUser(currentLoggedUser, page, MAX_POSTS_NR_ON_PAGE);
		int nrOfPages = pages.getTotalPages();
		
		model.addObject("actualPage", page);
		model.addObject("maxPage", nrOfPages);
		model.addObject("posts", pages.getContent() );
		model.addObject("fromLink", "myPosts");
		
		return model;
	}	
	
	@RequestMapping( value={ "/posts/allPosts","/posts/allPosts?page="})
	public ModelAndView allPost(
			@RequestParam(defaultValue="0", value="page", required=false) Integer page) {
		
		ModelAndView model = createModel("view_posts");
				
		Page<Post> pages = postService.findAll(page, MAX_POSTS_NR_ON_PAGE);
		int nrOfPages = pages.getTotalPages();
		
		model.addObject("actualPage", page);
		model.addObject("maxPage", nrOfPages);
		model.addObject("posts", pages.getContent() );
		model.addObject("fromLink", "allPosts");
		
		return model;		
	}	
	
	@RequestMapping("/posts/allPosts/remove/post{id}")
	public String removePostfromAllPosts(@PathVariable int id){
		
		postService.delete(id);
		
		return "redirect:/posts/allPosts";
	}
	
	@RequestMapping("/posts/myPosts/remove/post{id}")
	public String removePostfromMyPosts(@PathVariable int id){
		
		postService.delete(id);
		
		return "redirect:/posts/myPosts";
	}
	
	@RequestMapping(value={"/posts/post{postId}"})
	public ModelAndView postDetails(@PathVariable Integer postId){
		
		ModelAndView model = createModel("view_post"); 

		Post post = postService.findOneById(postId);
		
		model.addObject("post", post ); 
		model.addObject("months", monthService.findAllSortDesc());
		model.addObject("returnBtn","true");
		
		return model;
	}	
	
	@RequestMapping( value = "/posts/change/post{id}", method = RequestMethod.GET)
	public ModelAndView changePost(@PathVariable int id) {
		
		ModelAndView model = createModel("change_post");
		
		Post post = postService.findOneById(id);
		PostAndCategoriesWrapper postAndCategoriesWrapper = new PostAndCategoriesWrapper();
		
		postAndCategoriesWrapper.setPost(post);
		postAndCategoriesWrapper.setCategoriesList(post.getCategoriesName());
		
		model.addObject("postAndCategoriesWrapper", postAndCategoriesWrapper );
		
		List<String> categoryNameList = new ArrayList<String>();
		for(Category category:categoryService.findAll())
			categoryNameList.add(category.getCategoryName());
		
		model.addObject("categoryNames", categoryNameList);
		
		
		return model;
	}
	
/*	private ModelAndView createModelChangePost(int id){
		
		ModelAndView model = createModel("change_post");
		
		Post post = postService.findOneById(id);
		PostAndCategoriesWrapper postAndCategoriesWrapper = new PostAndCategoriesWrapper();
		
		postAndCategoriesWrapper.setPost(post);
		postAndCategoriesWrapper.setCategoriesList(post.getCategoriesName());
		
		model.addObject("postAndCategoriesWrapper", postAndCategoriesWrapper );
		
		List<String> categoryNameList = new ArrayList<String>();
		for(Category category:categoryService.findAll())
			categoryNameList.add(category.getCategoryName());
		
		model.addObject("categoryNames", categoryNameList);
		
		
		return model;
	}*/
	
	@RequestMapping( value = "/posts/changed/post{id}", method = RequestMethod.POST)
	public ModelAndView postChanged(@PathVariable int id,
			@Valid @ModelAttribute PostAndCategoriesWrapper postAndCategoriesWrapper,
			BindingResult result) {
		
		if(result.hasErrors()){
			
			return changePost(id);
		}
		
		ModelAndView model = createModel("post_changed");	
		
		Post post = postAndCategoriesWrapper.getPost();	
		Post postToChange = postService.findOneById(post.getId());	
		postToChange.changePost(post,
				categoryService.findByListNames(postAndCategoriesWrapper.getCategoriesList()));
		
		model.addObject("post", postToChange);
		
		postService.save(postToChange);

		
		return model;
	}	

}