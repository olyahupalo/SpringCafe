package ua.service;

import ua.model.request.UserCommentRequest;

public interface UserCommentService {
	
	void save(UserCommentRequest request, Integer id);

}
