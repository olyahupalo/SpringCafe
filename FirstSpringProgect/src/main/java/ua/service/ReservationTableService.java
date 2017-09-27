package ua.service;

import java.util.List;

import ua.entity.Table;
import ua.model.request.ReservationTableRequest;

public interface ReservationTableService {

	void save(ReservationTableRequest request);
	
	List<Table> findTablesByCafeId(Integer id);
}
