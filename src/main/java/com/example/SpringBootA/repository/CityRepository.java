package com.example.SpringBootA.repository;

import com.example.SpringBootA.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	
	@Query(value = "select c.* from city c where c.name = ?1", nativeQuery = true)
	List<City> fetchByName(String name);
	
	// "select c from city c where c.population >=?1 and c.population <=?2" : JPQL
	// "select c.* from city c where c.population >= ?1 and c.population <= ?2" : SQL
	@Query(value = "select c from City c where c.population >=?1 and c.population <=?2")
	List<City> fetchByPopulationRange(int from, int upto);
	

}
