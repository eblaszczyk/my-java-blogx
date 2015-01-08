package pl.ebla.mjbx.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import pl.ebla.mjbx.entity.Category;
import pl.ebla.mjbx.entity.Post;
import pl.ebla.mjbx.entity.User;

public interface PostRepository extends JpaRepository<Post, Integer> {
	
	//List<Post> findByCategory(Category category, Pageable pageable);
	
	Page<Post> findAll(Pageable pageable);
	
	Page<Post> findAllByPublishedTrue(Pageable pageable);
	
	//Page<Post> findAllByCategory(Category category, Pageable pageable);
	
	Page<Post> findAllByCategories(Category category, Pageable pageable);
	
	Page<Post> findAllByCategoriesAndPublishedTrue(Category category, Pageable pageable);
	
	Post findOneById(Integer id);
	
	Post findTopByPublishedTrueAndPublishedAtBeforeOrderByPublishedAtDesc(Date date);
	
	Post findTopByPublishedTrueAndPublishedAtAfterOrderByPublishedAtAsc(Date date);
	
	Page<Post> findAllByUser(User user, Pageable pageable);
	
	Page<Post> findAllByPublishedTrueAndPublishedAtBetween(Date startDate, Date endDate, Pageable pageable);
}