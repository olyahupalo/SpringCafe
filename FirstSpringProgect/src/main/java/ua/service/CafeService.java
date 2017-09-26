package ua.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ua.model.view.CafeView;
import ua.entity.UserComment;
import ua.model.request.CafeRequest;
import ua.model.request.FileRequest;

public interface CafeService{
	
	List<String> findAllTimes();
	
	List<String> findAllMeals();
	
	List<Integer> findAllTables();

//	List<CafeView> findAllViews();
	List<CafeView> findAllViews(String email);

	void save(CafeRequest request);
	
	void delete(Integer id);
	
	CafeRequest findOne(Integer id);
	
	List<UserComment> findAllCommentsByCafeId(Integer id);

//	String writte(MultipartFile file);
	
	}
