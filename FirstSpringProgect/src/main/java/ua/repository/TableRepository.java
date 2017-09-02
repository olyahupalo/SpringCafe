package ua.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Table;

public interface TableRepository extends JpaRepository<Table, Integer>{
//
//	@Query("SELECT t FROM Table JOIN t.cafe")
//	List<Table> findAllTables();
//	
	
}
