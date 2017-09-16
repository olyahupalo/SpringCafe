 package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.UserComment;
import ua.repository.UserCommentRepository;
import ua.service.UserCommentService;
@Service
public class UserCommentServiceImpl extends CrudServiceImpl<UserComment, Integer> implements UserCommentService{

	@Autowired
	public UserCommentServiceImpl(UserCommentRepository repository) {
		super(repository);
	}

}
