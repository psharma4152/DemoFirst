package com.example.SpringBootA.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootA.model.City;
import com.example.SpringBootA.service.CityService;
import com.example.SpringBootA.service.IcityService;

@RestController
public class MyController {
	
	@Autowired
	private IcityService cityService;

	/**
	 * To get the details of all the Cities.
	 * @return returns the list of cities.
	 */
	@GetMapping("/cities")
	public List<City> getAllCities() {
		return cityService.findAll();
	}

	/**
	 *
	 * @param id
	 * @return the specific cities returned by this call.
	 */
	@GetMapping("/cities/{id}")
	public City getCity(@PathVariable Long id) {
		return cityService.findById(id);
	}
	
	@PostMapping("/addCity")
	@ResponseStatus(HttpStatus.CREATED)
	public City createCity(@RequestBody @Validated City city) {
		return cityService.save(city);
	}
	
	@GetMapping("/cities/city")
	public List<City> fetchCityByName(@RequestParam(value="name") String name){
		return cityService.fetchByName(name);
	}
	
	
	
	@GetMapping("/cities/population")
	public List<City> fetchCitiesByPopulation(@RequestParam(value="from") int from, 
											  @RequestParam(value="upto") int upto){
		return cityService.fetchByPopulationRange(from, upto);
	}

}
