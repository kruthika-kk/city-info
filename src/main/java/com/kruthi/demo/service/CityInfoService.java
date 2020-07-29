package com.kruthi.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kruthi.demo.entities.City;
import com.kruthi.demo.repo.CityInfoRepository;

@Service
public class CityInfoService {

	@Autowired
	private CityInfoRepository repo;

	public List<City> ListAll() {
		return repo.findAll();

	}

	public void save(City city) {
		repo.save(city);
	}

	public City get(Integer id) {
		return repo.findById(id).get();

	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
