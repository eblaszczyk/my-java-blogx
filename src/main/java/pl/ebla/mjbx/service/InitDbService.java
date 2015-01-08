package pl.ebla.mjbx.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pl.ebla.mjbx.date.CurrentMonth;
import pl.ebla.mjbx.entity.Category;
import pl.ebla.mjbx.entity.Month;
import pl.ebla.mjbx.entity.Post;
import pl.ebla.mjbx.entity.Role;
import pl.ebla.mjbx.entity.User;
import pl.ebla.mjbx.repository.CategoryRepository;
import pl.ebla.mjbx.repository.CommentRepository;
import pl.ebla.mjbx.repository.MonthRepository;
import pl.ebla.mjbx.repository.PostRepository;
import pl.ebla.mjbx.repository.RoleRepository;
import pl.ebla.mjbx.repository.UserRepository;

@Transactional
@Service
public class InitDbService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private MonthRepository monthRepository;
	
	@PostConstruct
	public void init(){
		
		if( roleRepository.findByName("ADMIN") == null ){
		
			Role writerRole = new Role();
			writerRole.setName("PUBLISHER");
			roleRepository.save(writerRole);
			
			Role adminRole = new Role();
			adminRole.setName("ADMIN");
			roleRepository.save(adminRole);
			 
			User adminUser = new User();
			adminUser.setName("admin");
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			adminUser.setPassword(encoder.encode("admin"));
			List<Role> roles = new ArrayList<Role>();
			roles.add(writerRole);
			roles.add(adminRole);
			adminUser.setEnabled(true);
			adminUser.setRoles(roles);
			userRepository.save(adminUser);
			
			User user1 = new User();
			user1.setName("ewa");
			user1.setPassword(encoder.encode("ewa"));
			List<Role> roles1 = new ArrayList<Role>();
			roles1.add(writerRole);
			user1.setRoles(roles1);
			user1.setEnabled(true);
			userRepository.save(user1);
			
			Category testCategory = new Category();
			testCategory.setCategoryName("Test");
			categoryRepository.save(testCategory);
			
			Category testCategory1 = new Category();
			testCategory1.setCategoryName("Test1");
			categoryRepository.save(testCategory1);
			
			Category testCategory2 = new Category();
			testCategory2.setCategoryName("Test2");
			categoryRepository.save(testCategory2);
			
			Date now = new Date();
			
			Month month = new Month();
			CurrentMonth currMonth = new CurrentMonth();
			month.setCurrentMonth(currMonth);
			monthRepository.save(month);			
			
			Post post = new Post();
			post.setMonth(month);
			post.setTitle("Test post ¹êæœ¿Ÿó³ñ");
			post.setShortCut("Pierwszy testowy post na blogu.Pierwszy testowy post na blogu");
			post.setBody("Pierwszy testowy post na blogu.Pierwszy testowy post na blogu. Pierwszy testowy post na blogu. Pierwszy testowy post na blogu .Pierwszy testowy post na blogu .Pierwszy testowy post na blogu.");
			post.setUser(user1);
			post.setCreatedAt(now);
			post.setPublishedAt(new Date( (now.getTime()+1*60*1000)));
			post.setUpdatedAt(now);
			post.setPublished(true);
			List<Category> categories = new ArrayList<Category>();
			categories.add(testCategory);
			categories.add(testCategory1);
			post.setCategories(categories);
			postRepository.save(post);
			
			Post post1 = new Post();
			post1.setMonth(month);
			post1.setTitle("Test post 1");
			post1.setShortCut("Kolejny testowy post na blogu.Pierwszy testowy post na blogu");
			post1.setBody("Kolejny testowy post na blogu.Pierwszy testowy post na blogu. Pierwszy testowy post na blogu. Pierwszy testowy post na blogu .Pierwszy testowy post na blogu .Pierwszy testowy post na blogu.");
			post1.setUser(user1);
			post1.setCreatedAt(now);
			post1.setPublishedAt(new Date( (now.getTime()+2*60*1000)));
			post1.setUpdatedAt(now);
			post1.setCategories(categories);
			post1.setPublished(true);
			postRepository.save(post1);
			
			Post post2 = new Post();
			post2.setMonth(month);
			post2.setTitle("Test post 1,5");
			post2.setShortCut("Kolejny testowy post na blogu.Pierwszy testowy post na blogu");
			post2.setBody("Kolejny testowy post na blogu.Pierwszy testowy post na blogu. Pierwszy testowy post na blogu. Pierwszy testowy post na blogu .Pierwszy testowy post na blogu .Pierwszy testowy post na blogu.");
			post2.setUser(user1);
			post2.setCreatedAt(now);
			post2.setPublishedAt(new Date( (now.getTime()+3*60*1000)));
			post2.setUpdatedAt(now);
			post2.setPublished(true);
			post2.setCategories(categories);
			postRepository.save(post2);
			
			Post post3 = new Post();
			post3.setMonth(month);
			post3.setTitle("Test post 2");
			post3.setShortCut("Kolejny testowy post na blogu.Pierwszy testowy post na blogu");
			post3.setBody("Kolejny testowy post na blogu.Pierwszy testowy post na blogu. Pierwszy testowy post na blogu. Pierwszy testowy post na blogu .Pierwszy testowy post na blogu .Pierwszy testowy post na blogu.");
			post3.setUser(user1);
			post3.setCreatedAt(now);
			post3.setPublishedAt(new Date( (now.getTime()+4*60*1000)));
			post3.setUpdatedAt(now);
			post3.setPublished(true);
			post3.setCategories(categories);
			postRepository.save(post3);
			
			Post post4 = new Post();
			post4.setMonth(month);
			post4.setTitle("Test post 3");
			post4.setShortCut("Kolejny testowy post na blogu.Pierwszy testowy post na blogu");
			post4.setBody("Kolejny testowy post na blogu.Pierwszy testowy post na blogu. Pierwszy testowy post na blogu. Pierwszy testowy post na blogu .Pierwszy testowy post na blogu .Pierwszy testowy post na blogu.");
			post4.setUser(user1);
			post4.setCreatedAt(now);
			post4.setPublishedAt(new Date( (now.getTime()+5*60*1000)));
			post4.setUpdatedAt(now);
			post4.setPublished(true);
			post4.setCategories(categories);
			postRepository.save(post4);
			
			Post post45 = new Post();
			post45.setMonth(month);
			post45.setTitle("Test post 4");
			post45.setShortCut("Kolejny testowy post na blogu.Pierwszy testowy post na blogu");
			post45.setBody("Kolejny testowy post na blogu.Pierwszy testowy post na blogu. Pierwszy testowy post na blogu. Pierwszy testowy post na blogu .Pierwszy testowy post na blogu .Pierwszy testowy post na blogu.");
			post45.setUser(user1);
			post45.setCreatedAt(now);
			post45.setPublishedAt(new Date( (now.getTime()+6*60*1000)));
			post45.setUpdatedAt(now);
			post45.setPublished(true);
			post45.setCategories(categories);
			postRepository.save(post45);
			
			Post post5 = new Post();
			post5.setMonth(month);
			post5.setTitle("Test post 5");
			post5.setShortCut("Kolejny testowy post na blogu.Pierwszy testowy post na blogu");
			post5.setBody("Kolejny testowy post na blogu.Pierwszy testowy post na blogu. Pierwszy testowy post na blogu. Pierwszy testowy post na blogu .Pierwszy testowy post na blogu .Pierwszy testowy post na blogu.");
			post5.setUser(user1);
			post5.setCreatedAt(now);
			post5.setPublishedAt(new Date( (now.getTime()+7*60*1000)));
			post5.setUpdatedAt(now);
			post5.setPublished(true);
			post5.setCategories(categories);
			postRepository.save(post5);
			
			Post post6 = new Post();
			post6.setMonth(month);
			post6.setTitle("Test post 6");
			post6.setShortCut("Kolejny testowy post na blogu.Pierwszy testowy post na blogu");
			post6.setBody("Kolejny testowy post na blogu.Pierwszy testowy post na blogu. Pierwszy testowy post na blogu. Pierwszy testowy post na blogu .Pierwszy testowy post na blogu .Pierwszy testowy post na blogu.");
			post6.setUser(user1);
			post6.setCreatedAt(now);
			post6.setPublishedAt(new Date( (now.getTime()+8*60*1000)));
			post6.setUpdatedAt(now);
			post6.setPublished(true);
			post6.setCategories(categories);
			postRepository.save(post6);
			
			Post post7 = new Post();
			post7.setMonth(month);
			post7.setTitle("Test post 7");
			post7.setShortCut("Kolejny testowy post na blogu.Pierwszy testowy post na blogu");
			post7.setBody("Kolejny testowy post na blogu.Pierwszy testowy post na blogu. Pierwszy testowy post na blogu. Pierwszy testowy post na blogu .Pierwszy testowy post na blogu .Pierwszy testowy post na blogu.");
			post7.setUser(user1);
			post7.setCreatedAt(now);
			post7.setPublishedAt(new Date( (now.getTime()+9*60*1000)));
			post7.setUpdatedAt(now);
			post7.setPublished(true);
			post7.setCategories(categories);
			postRepository.save(post7);
			
			Post post8 = new Post();
			post8.setMonth(month);
			post8.setTitle("Test post 8");
			post8.setShortCut("Kolejny testowy post na blogu.Pierwszy testowy post na blogu");
			post8.setBody("Kolejny testowy post na blogu.Pierwszy testowy post na blogu. Pierwszy testowy post na blogu. Pierwszy testowy post na blogu .Pierwszy testowy post na blogu .Pierwszy testowy post na blogu.");
			post8.setUser(user1);
			post8.setCreatedAt(now);
			post8.setPublishedAt(new Date( (now.getTime()+10*60*1000)));
			post8.setUpdatedAt(now);
			post8.setPublished(true);
			post8.setCategories(categories);
			postRepository.save(post8);
			
			Post post9 = new Post();
			post9.setMonth(month);
			post9.setTitle("Test post 9");
			post9.setShortCut("Kolejny testowy post na blogu.Pierwszy testowy post na blogu");
			post9.setBody("Kolejny testowy post na blogu.Pierwszy testowy post na blogu. Pierwszy testowy post na blogu. Pierwszy testowy post na blogu .Pierwszy testowy post na blogu .Pierwszy testowy post na blogu.");
			post9.setUser(user1);
			post9.setCreatedAt(now);
			post9.setPublishedAt(new Date( (now.getTime()+11*60*1000)));
			post9.setUpdatedAt(now);
			post9.setPublished(true);
			post9.setCategories(categories);
			postRepository.save(post9);
			
			Post post10 = new Post();
			post10.setMonth(month);
			post10.setTitle("Test post 10");
			post10.setShortCut("Kolejny testowy post na blogu.Pierwszy testowy post na blogu");
			post10.setBody("Kolejny testowy post na blogu.Pierwszy testowy post na blogu. Pierwszy testowy post na blogu. Pierwszy testowy post na blogu .Pierwszy testowy post na blogu .Pierwszy testowy post na blogu.");
			post10.setUser(user1);
			post10.setCreatedAt(now);
			post10.setPublishedAt(new Date( (now.getTime()+12*60*1000)));
			post10.setUpdatedAt(now);
			post10.setPublished(true);
			post10.setCategories(categories);
			postRepository.save(post10);
			
			Post post11 = new Post();
			post11.setMonth(month);
			post11.setTitle("Test post 11");
			post11.setShortCut("Kolejny testowy post na blogu.Pierwszy testowy post na blogu");
			post11.setBody("Kolejny testowy post na blogu.Pierwszy testowy post na blogu. Pierwszy testowy post na blogu. Pierwszy testowy post na blogu .Pierwszy testowy post na blogu .Pierwszy testowy post na blogu.");
			post11.setUser(user1);
			post11.setCreatedAt(now);
			post11.setPublishedAt(new Date( (now.getTime()+13*60*1000)));
			post11.setUpdatedAt(now);
			post11.setPublished(true);
			List<Category> categories1 = new ArrayList<Category>();
			categories1.add(testCategory2);
			post11.setCategories(categories1);
			postRepository.save(post11);
			
			Post post12 = new Post();
			post12.setMonth(month);
			post12.setTitle("Test post 12 ¹êæœ¿Ÿó³ñ");
			post12.setShortCut("¹êæœ¿Ÿó³ñ Kolejny testowy post na blogu.Pierwszy testowy post na blogu");
			post12.setBody("¹êæœ¿Ÿó³ñ Kolejny testowy post na blogu.Pierwszy testowy post na blogu. Pierwszy testowy post na blogu. Pierwszy testowy post na blogu .Pierwszy testowy post na blogu .Pierwszy testowy post na blogu.");
			post12.setUser(user1);
			post12.setCreatedAt(now);
			post12.setPublishedAt(new Date( (now.getTime()+14*60*1000)));
			post12.setUpdatedAt(now);
			post12.setPublished(true);
			post12.setCategories(categories1);
			postRepository.save(post12);
			

		}
		
	}

}
