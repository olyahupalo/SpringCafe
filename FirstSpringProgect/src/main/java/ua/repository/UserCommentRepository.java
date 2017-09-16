package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.UserComment;

public interface UserCommentRepository extends JpaRepository<UserComment, Integer>{

}
