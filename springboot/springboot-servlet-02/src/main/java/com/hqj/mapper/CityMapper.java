package com.hqj.mapper;

import java.util.List;

import com.hqj.pojo.City;

public interface CityMapper {

	void insterCity(City city);

	List<City> findCityAll();

	City findCityById(Integer id);

	void updateCityById(City cityUpdate);
	
	void deleteCityById(Integer id);
}
