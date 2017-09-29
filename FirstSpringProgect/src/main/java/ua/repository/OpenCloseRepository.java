package ua.repository;

import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.entity.OpenClose;

public interface OpenCloseRepository extends JpaRepository<OpenClose, Integer>{
	
	OpenClose findByTime(LocalTime time);
	
	
	
}
