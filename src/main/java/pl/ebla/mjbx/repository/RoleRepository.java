package pl.ebla.mjbx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.ebla.mjbx.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String string);

}
