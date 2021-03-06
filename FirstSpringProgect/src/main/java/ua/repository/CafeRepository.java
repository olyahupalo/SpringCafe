package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import ua.entity.Cafe;
import ua.entity.UserComment;
import ua.model.view.CafeView;

public interface CafeRepository extends JpaNameRepository<Cafe>{

	@Query("SELECT o.time FROM OpenClose o")
	List<String> findAllTimes();
	
	@Query("SELECT m.title FROM Meal m")
	List<String> findAllMeals();
	
	@Query("SELECT t.countOfPeople FROM Table t")
	List<Integer> findAllTables();
	
	@Query("SELECT new ua.model.view.CafeView(c.id, c.rate, c.name, c.photoUrl, c.version, c.address, c.fullDescription, c.type, c.phone, c.email, open.time, close.time) FROM Cafe c JOIN c.open open JOIN c.close close JOIN c.user user WHERE user.email=?1") 
	List<CafeView> findAllViews(String email);
	
//	@Query("SELECT new ua.model.view.CafeView(c.id, c.rate, c.name, c.photoUrl, c.version, c.address, c.fullDescription, c.type, c.phone, c.email, open.time, close.time) FROM Cafe c JOIN c.open open JOIN c.close close") 
//	List<CafeView> findAllViews();
	
	@Query("SELECT m.title FROM Meal m JOIN m.cafe c WHERE c.id=?1")
	List<String> findAllMealsByCafeId(Integer id);
	
	@Query("SELECT t.countOfPeople FROM Table t JOIN t.cafe c WHERE c.id=?1")
	List<Integer> findAllTablesByCafeId(Integer id);
	
	@Query("SELECT DISTINCT c FROM Cafe c JOIN FETCH c.open JOIN FETCH c.close WHERE c.id=?1")
	Cafe findOneRequest(Integer id);
	
	@Query("SELECT DISTINCT uc FROM UserComment uc WHERE uc.cafeId=?1")
	List<UserComment> findAllCommentsByCafeId(Integer id);
}
 