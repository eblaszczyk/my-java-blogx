package pl.ebla.mjbx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.ebla.mjbx.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
