package com.kruthi.demo.rest.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kruthi.demo.entities.City;
import com.kruthi.demo.service.CityInfoService;

@RestController
public class CityRestController {

	@Autowired
	private CityInfoService service;

	@GetMapping("/cities")
	public List<City> list() {
		return service.ListAll();
	}

	@GetMapping("/cities/{id}")
	public ResponseEntity<City> get(@PathVariable Integer id) {
		try {
			City city = service.get(id);
			return new ResponseEntity<City>(city, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<City>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/cities")
	public void add(@RequestBody City city) {
		service.save(city);

	}

	@PutMapping("/cities/{id}")
	public ResponseEntity<City> update(@RequestBody City city, @PathVariable Integer id) {
		try {
			City existCity = service.get(id);
			service.save(city);
			return new ResponseEntity<City>(city, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<City>(HttpStatus.NOT_FOUND);
		}

	}
}
