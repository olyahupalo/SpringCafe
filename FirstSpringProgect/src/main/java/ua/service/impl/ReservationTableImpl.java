
package ua.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import ua.entity.ReservationTable;
import ua.entity.Table;
import ua.model.request.ReservationTableRequest;
import ua.repository.ReservationTableRepository;
import ua.service.ReservationTableService;

@Service
public class ReservationTableImpl implements ReservationTableService{

	private final ReservationTableRepository repository;
	
	public ReservationTableImpl(ReservationTableRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public void save(ReservationTableRequest request) {
		ReservationTable reservationTable = new ReservationTable();
		reservationTable.setEmail(request.getEmail());
		reservationTable.setName(request.getName());
		reservationTable.setPhone(request.getPhone());
		request.getTable().setIsFree(false);
		reservationTable.setTable(request.getTable());
		reservationTable.setTime(LocalDateTime.now());
		repository.save(reservationTable);
		
	}

	@Override
	public List<Table> findTablesByCafeId(Integer id) {
		return repository.findTablesByCafeId(id);
	}

}
