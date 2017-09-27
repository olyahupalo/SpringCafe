package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.ReservationTable;
import ua.entity.Table;

public interface ReservationTableRepository extends JpaRepository<ReservationTable, Integer>{

	@Query("SELECT t FROM Table t JOIN FETCH t.cafe c WHERE t.isFree = True and c.id =?1")
	List<Table> findTablesByCafeId(Integer id);
	
}
