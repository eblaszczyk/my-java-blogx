package pl.ebla.mjbx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.ebla.mjbx.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	Category findByCategoryName(String nameCategory);
	
	Category findById(Integer id);

}
