package pl.ebla.mjbx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.ebla.mjbx.date.CurrentMonth;
import pl.ebla.mjbx.date.Period;
import pl.ebla.mjbx.entity.Category;
import pl.ebla.mjbx.entity.Post;
import pl.ebla.mjbx.entity.User;
import pl.ebla.mjbx.service.CategoryService;
import pl.ebla.mjbx.service.MonthService;
import pl.ebla.mjbx.service.PostService;
import pl.ebla.mjbx.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	static final int MAX_POSTS_NR_ON_PAGE = 9;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private MonthService monthService;
	
	@Autowired
	private UserService userService;
	
	private User currentLoggedUser;
	
	
	private ModelAndView createModel(String viewName){
		
		ModelAndView model = new ModelAndView(viewName);	
		model.addObject("categories", categoryService.findAll() );
		
		
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		currentLoggedUser = userService.findOneByName(userName);
	
		if( currentLoggedUser != null ){	
			model.addObject("currentLoggedUserName", currentLoggedUser.getName());
		}
		
		return model;
	}	
	
	@RequestMapping(value = {"/","/?page="})
	public ModelAndView home(@RequestParam(defaultValue="0", value="page", required=false) Integer page,
			@RequestParam(defaultValue="null", value="category", required=false) String categoryName) {
		
		ModelAndView model = createModel("home");
		
		Page<Post> pages = postService.findAllByPublishedTrue(page, MAX_POSTS_NR_ON_PAGE);
		int nrOfPages = pages.getTotalPages();
		
		model.addObject("actualPage", page);
		model.addObject("maxPage", nrOfPages);
		model.addObject("posts", pages.getContent() );
		
		return model;
	}
	
	@RequestMapping( value= {"/category/{id}", "/category/{id}?page="})
	public ModelAndView postsByCategory(@PathVariable int id,
			@RequestParam(defaultValue="0", value="page", required=false) Integer page) {
		
		ModelAndView model = createModel("category_details");
		
		Category category = categoryService.findById(id);
		
		if(category == null){
			model.addObject("title","Brak kategorii");
			
			return model;
		}
		
		Page<Post> pages = postService.findAllByCategoryAndPublishedTrue(category, page, MAX_POSTS_NR_ON_PAGE);
		int nrOfPages = pages.getTotalPages();		
		
		model.addObject("title", "posty z kategorii: " + category.getCategoryName());
		model.addObject("category", category);
		model.addObject("actualPage", page);
		model.addObject("maxPage", nrOfPages);
		model.addObject("posts", pages.getContent() );
		
		return model;
	}	
	
	@RequestMapping( value= {"/{year}", "/{year}?page="})
	public ModelAndView postByYear(@PathVariable Integer year,
			@RequestParam(defaultValue="0", value="page", required=false) Integer page) {
		
		ModelAndView model = createModel("home");
		Period period = new Period(year);
		
		Page<Post> pages = postService.findAllByPublishedTrueAndPublishedAtBetween(
				period.getStartDate(), period.getEndDate(), page, MAX_POSTS_NR_ON_PAGE);
		int nrOfPages = pages.getTotalPages();
		
		model.addObject("title", "posty z roku: "+ year);
		model.addObject("actualPage", page);
		model.addObject("maxPage", nrOfPages);
		model.addObject("posts", pages.getContent() );
		
		return model;
	}	
	
	@RequestMapping( value= {"/{year}/{month}", "/{year}/{month}?page="})
	public ModelAndView postByMonth(@PathVariable Integer year, @PathVariable Integer month,
			@RequestParam(defaultValue="0", value="page", required=false) Integer page) {
		
		ModelAndView model = createModel("home");
		Period period = new Period(year,month-1);
		
		Page<Post> pages = postService.findAllByPublishedTrueAndPublishedAtBetween(
				period.getStartDate(), period.getEndDate(), page, MAX_POSTS_NR_ON_PAGE);
		int nrOfPages = pages.getTotalPages();
		
		model.addObject("title", (new CurrentMonth(year,month-1)).getMonthName());
		model.addObject("actualPage", page);
		model.addObject("maxPage", nrOfPages);
		model.addObject("posts", pages.getContent() );
		
		return model;
	}		
	
	@RequestMapping(value={"/{year}/{month}/{postId}","/{year}/{month}/{postId}/?page="})
	public ModelAndView postDetails(@RequestParam(defaultValue="0", value="page", required=false) Integer page,
			@PathVariable Integer year, @PathVariable Integer month, @PathVariable Integer postId){
		
		
		
		Post post = postService.findOneById(postId);
		
		if( post == null){
			return createModel("view_post_error"); 
		}
		
		ModelAndView model = createModel("view_post"); 
		
		Post postBefore = postService.findTopByPublishedTrueAndPublishedAtBeforeOrderByPublishedAtDesc(post.getPublishedAt());
		Post postAfter = postService.findTopByPublishedTrueAndPublishedAtAfterOrderByPublishedAtAsc(post.getPublishedAt());
		
		model.addObject("post", post ); 
		model.addObject("postBefore", postBefore);
		model.addObject("postAfter", postAfter);
		model.addObject("months", monthService.findAllSortDesc());
		
		return model;
	}
	
	
	@RequestMapping( "/contact")
	public ModelAndView contact() {
		
		ModelAndView model = createModel("contact");	
		
		return model;
	}
	 
	
	@RequestMapping( "/about")
	public ModelAndView about() {
		
		ModelAndView model = createModel("about");	
		return model;
	}
	
}
