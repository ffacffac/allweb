package com.hqj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hqj.mapper.CityMapper;
import com.hqj.pojo.City;
import com.hqj.service.CityService;

@Service
@Transactional
public class CityServiceImpl implements CityService {

	@Autowired
	private CityMapper cityMapper;

	@Override
	public void addCity(City city) {
		cityMapper.insterCity(city);
	}

	@Override
	public List<City> findCityAll() {
		return cityMapper.findCityAll();
	}

	@Override
	public City findCityById(Integer id) {
		return cityMapper.findCityById(id);
	}

	@Override
	public void updateCityById(City city) {
		cityMapper.updateCityById(city);
	}

	@Override
	public void deleteCityById(Integer id) {
		cityMapper.deleteCityById(id);
	}
}
