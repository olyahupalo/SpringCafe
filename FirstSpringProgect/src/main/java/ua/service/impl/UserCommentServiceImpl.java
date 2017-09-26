 package ua.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import ua.entity.UserComment;
import ua.model.request.UserCommentRequest;
import ua.repository.UserCommentRepository;
import ua.service.UserCommentService;
@Service
public class UserCommentServiceImpl  implements UserCommentService{
	
	private final UserCommentRepository repository;
	
	public UserCommentServiceImpl(UserCommentRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public void save(UserCommentRequest request) {
		UserComment userComment= new UserComment();
		userComment.setCafeId(request.getCafeId());
		userComment.setCommentTxt(request.getCommentTxt());
		userComment.setEmail(request.getEmail());
		userComment.setReplyId(request.getReplyId());
		userComment.setTime(LocalDateTime.now());
		repository.save(userComment);
	}

	

}
