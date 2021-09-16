package com.example.SpringBootA.service;

import java.util.List;
import java.util.Optional;

import com.example.SpringBootA.model.City;

public interface IcityService {
	
	City findById(Long id);
	City save(City city);
	List<City> findAll();
	List<City> fetchByName(String name);
	List<City> fetchByPopulationRange(int from, int upto);

}
