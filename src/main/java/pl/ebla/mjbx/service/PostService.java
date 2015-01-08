package pl.ebla.mjbx.service;


import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import pl.ebla.mjbx.entity.Category;
import pl.ebla.mjbx.entity.Post;
import pl.ebla.mjbx.entity.User;
import pl.ebla.mjbx.repository.PostRepository;
import pl.ebla.mjbx.repository.UserRepository;

@Service
@Transactional
public class PostService {
	
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Page<Post> findAll( int pageIndex, int postsNumber){
		return postRepository.findAll(
				new PageRequest(pageIndex, postsNumber, Direction.DESC, "createdAt"));
	}
	
	public Page<Post> findAllByPublishedTrue( int pageIndex, int postsNumber){
		return postRepository.findAllByPublishedTrue(
				new PageRequest(pageIndex, postsNumber, Direction.DESC, "publishedAt"));
	}	
	
	public Page<Post> findAllByCategoryAndPublishedTrue(Category category, int pageIndex, int postsNumber){
		return postRepository.findAllByCategoriesAndPublishedTrue(category,
				new PageRequest(pageIndex, postsNumber, Direction.DESC, "publishedAt"));
	}
	
	public Page<Post> findAllByCategory(Category category, int pageIndex, int postsNumber){
		return postRepository.findAllByCategories(category,
				new PageRequest(pageIndex, postsNumber, Direction.DESC, "createdAt"));
	}

	public Page<Post> findAllByPublishedTrueAndPublishedAtBetween(Date startDate, Date endDate, int pageIndex, int postsNumber){
		
		 return postRepository.findAllByPublishedTrueAndPublishedAtBetween(startDate, endDate,
				 new PageRequest(pageIndex, postsNumber, Direction.DESC, "publishedAt"));
	}	
	
	public void save(Post post) {
		
		postRepository.save(post);
	}
	
	public Post findOneById(Integer id){
		
		return postRepository.findOneById(id);
	}
	
	public Page<Post> findAllByUser(User user, int pageIndex, int postsNumber){
		
		return postRepository.findAllByUser(user,
				new PageRequest(pageIndex, postsNumber, Direction.DESC, "createdAt"));
	}
	
	public Post findTopByPublishedTrueAndPublishedAtBeforeOrderByPublishedAtDesc(Date date){
		
		return postRepository.findTopByPublishedTrueAndPublishedAtBeforeOrderByPublishedAtDesc(date);
	}
	
	public Post findTopByPublishedTrueAndPublishedAtAfterOrderByPublishedAtAsc(Date date){
		
		return postRepository.findTopByPublishedTrueAndPublishedAtAfterOrderByPublishedAtAsc(date);
	}
	
	
	public void delete(int id) {
		
		postRepository.delete(id);
	}
	
	
	
}
