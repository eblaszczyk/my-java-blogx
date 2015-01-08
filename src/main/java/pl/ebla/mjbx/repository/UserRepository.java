package pl.ebla.mjbx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.ebla.mjbx.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findOneByName(String name);
	
	List<User> findByNameNotLike(String name);
}
