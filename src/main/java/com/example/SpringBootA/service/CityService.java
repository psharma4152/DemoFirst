package com.example.SpringBootA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootA.exception.CityNotFoundException;
import com.example.SpringBootA.exception.NoDataFoundException;
import com.example.SpringBootA.model.City;
import com.example.SpringBootA.repository.CityRepository;

@Service
public class CityService implements IcityService{
	
    @Autowired
    private CityRepository cityRepository;

	@Override
	public City findById(Long id) {
		return cityRepository.findById(id).orElseThrow(() -> new CityNotFoundException(id));
		
	}

	@Override
	public City save(City city) {
		return cityRepository.save(city);
	}

	@Override
	public List<City> findAll() {
		List<City> listCity = (List<City>) cityRepository.findAll();
		if(listCity.isEmpty() && listCity.size() == 0) {
			throw new NoDataFoundException();
		}
		return listCity;
	}
	
	@Override
	public List<City> fetchByName(String name){
		return cityRepository.fetchByName(name);	
	}

	@Override
	public List<City> fetchByPopulationRange(int from, int upto) {
		return cityRepository.fetchByPopulationRange(from, upto);
	}

}
