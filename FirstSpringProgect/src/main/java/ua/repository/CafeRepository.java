package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Cafe;
import ua.model.view.CafeView;

public interface CafeRepository extends JpaRepository<Cafe, Integer>{

	@Query("SELECT o.time FROM OpenClose o")
	List<String> findAllTimes();
	
	@Query("SELECT new ua.model.view.CafeView(c.id, c.rate, c.name, c.photoUrl, c.version, c.address, c.fullDescription, c.type, c.phone, c.email, open.time, close.time) FROM Cafe c JOIN c.open open JOIN c.close close") 
	List<CafeView> findAllViews();
	
	@Query("SELECT DISTINCT c FROM Cafe c JOIN FETCH c.open JOIN FETCH c.close WHERE c.id=?1")
	Cafe findOneRequest(Integer id);
}
 