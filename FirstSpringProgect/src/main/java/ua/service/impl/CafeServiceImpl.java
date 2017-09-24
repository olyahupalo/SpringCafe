package ua.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ua.entity.Cafe;
import ua.entity.Type;
import ua.model.view.CafeView;
import ua.repository.CafeRepository;
import ua.service.CafeService;
import ua.service.FileWritter;
import ua.model.request.CafeRequest;
import ua.model.request.FileRequest;

@Service
public class CafeServiceImpl implements CafeService {

	private final CafeRepository repository;
	
	private final FileWritter writer;

	public CafeServiceImpl(CafeRepository repository, FileWritter writer) {
		super();
		this.repository = repository;
		this.writer = writer;
	}

//	@Override
//	@Transactional(readOnly=true)
//	public List<CafeView> findAllViews() {
//		return repository.findAllViews();
//	}

	@Override
	@Transactional(readOnly=true)
	public List<CafeView> findAllViews(String email) {
		List<CafeView> views = repository.findAllViews(email);
		views.forEach(this::loadMeals);
		views.forEach(this::loadTables);
		return views;
	}
	
	private void loadMeals(CafeView view) {
		view.setMeals(repository.findAllMealsByCafeId(view.getId()));
	}
	
	private void loadTables(CafeView view) {
		view.setTables(repository.findAllTablesByCafeId(view.getId()));
	}
	
	@Override
	public void save(CafeRequest request) {
		Cafe cafe = new Cafe();
		cafe.setAddress(request.getAddress());
		cafe.setClose(request.getClose());
		cafe.setEmail(request.getEmail().toUpperCase());
		cafe.setFullDescription(request.getFullDescription());
		cafe.setShortDescription(request.getShortDescription());
		cafe.setId(request.getId());
		cafe.setName(request.getName());
		cafe.setOpen(request.getOpen());
		cafe.setPhone(request.getPhone());
		cafe.setPhotoUrl(writer.writte(request.getFile()));
		cafe.setRate(new BigDecimal(request.getRate()));
		cafe.setVersion(request.getVersion());
		cafe.setType(Type.valueOf(request.getType().toUpperCase()));
		cafe.setUser(request.getUser());
		repository.save(cafe);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

	@Override
	public CafeRequest findOne(Integer id) {
		Cafe cafe = repository.findOne(id);
		CafeRequest request = new CafeRequest();
		request.setAddress(cafe.getAddress());
		request.setClose(cafe.getClose());
		request.setEmail(cafe.getEmail());
		request.setFullDescription(cafe.getFullDescription());
		request.setShortDescription(cafe.getShortDescription());
		request.setId(cafe.getId());
		request.setName(cafe.getName());
		request.setOpen(cafe.getOpen());
		request.setPhone(cafe.getPhone());
		request.setPhotoUrl(cafe.getPhotoUrl());
		request.setRate(String.valueOf(cafe.getRate()));
		request.setVersion(request.getVersion());
		request.setType(cafe.getType().toString());
		request.setUser(cafe.getUser());
		request.setMeals(cafe.getMeals());
		request.setTables(cafe.getTables());
		return request;
	}

	@Override
	public List<String> findAllTimes() {
		return repository.findAllTimes();
	}

	@Override
	public List<String> findAllMeals() {
		return repository.findAllMeals();
	}

	@Override
	public List<Integer> findAllTables() {
		return repository.findAllTables();
	}



	
	
}