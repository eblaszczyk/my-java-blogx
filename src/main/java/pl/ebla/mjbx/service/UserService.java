package pl.ebla.mjbx.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pl.ebla.mjbx.entity.Role;
import pl.ebla.mjbx.entity.User;
import pl.ebla.mjbx.repository.RoleRepository;
import pl.ebla.mjbx.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;	
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findOneByName(String name){
		
		return userRepository.findOneByName(name);
	}

	public void save(User user) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));		

		Role rolePublisher = roleRepository.findByName("PUBLISHER");
		List<Role> roles = new ArrayList<Role>();
		roles.add(rolePublisher);
		user.setRoles(roles);
		user.setEnabled(true);		
		userRepository.save(user);
		
	}
	
	public void changePassword(User user){
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));		
		
		userRepository.save(user);
	}

	public void changeUser(User user){
		
		userRepository.save(user);
	}
	
	public void delete(int id) {
		
		if(userRepository.findOne(id).getName().equals("admin"))
			return;
		
		userRepository.delete(id);
	}
	
	public List<User> findByNameNotLike(String name){
		
		return userRepository.findByNameNotLike(name);
	}

}
