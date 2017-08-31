package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import ua.entity.Cafe;
import ua.model.view.CafeIndexView;

public interface CafeIndexRepository extends JpaNameRepository<Cafe>{

	@Query("SELECT new ua.model.view.CafeIndexView(c.id, c.rate, c.name, c.photoUrl, c.version, c.address, c.shortDescription, c.type) FROM Cafe c")
	List<CafeIndexView> findAllViews();
	
	@Query("SELECT new ua.model.view.CafeIndexView(c.id, c.rate, c.name, c.photoUrl, c.version, c.address, c.shortDescription, c.type) FROM Cafe c JOIN c.user user WHERE user.email=?1")
	List<CafeIndexView> findAllViewsbyLogin(String login);
	
//
//	@Query("SELECT DISTINCT c FROM Cafe c JOIN FETCH c.open JOIN FETCH c.close WHERE c.id=?1")
//	Cafe findOneRequest(Integer id);
}
