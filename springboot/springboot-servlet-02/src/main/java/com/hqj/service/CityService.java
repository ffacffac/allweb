package com.hqj.service;

import java.util.List;

import com.hqj.pojo.City;

public interface CityService {

	void addCity(City city);

	List<City> findCityAll();

	City findCityById(Integer id);

	void updateCityById(City city);
	
	void deleteCityById(Integer id);
}
