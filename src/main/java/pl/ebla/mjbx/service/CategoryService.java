package pl.ebla.mjbx.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.ebla.mjbx.entity.Category;
import pl.ebla.mjbx.repository.CategoryRepository;
import pl.ebla.mjbx.repository.PostRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	public List<Category> findAll()
	{
		return categoryRepository.findAll();
	}

	public Category findOne(int id) {
		
		return categoryRepository.findOne(id);
	}

	
	public Category findByCategoryName(String categoryName){
		
		return categoryRepository.findByCategoryName(categoryName);
	}
	
	public Category findById(Integer id){
		return categoryRepository.findById(id);
	}

	public List<Category> findByListNames(List<String> categoryNamesList){
		
		List <Category> categoriesList = new ArrayList<Category>();	
		for( String categoryName : categoryNamesList )
			categoriesList.add( categoryRepository.findByCategoryName(categoryName));
		
		return categoriesList;
	}

	public void save(Category category) {
		
		categoryRepository.save(category);
	}

}
