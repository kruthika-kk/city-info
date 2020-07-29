package com.kruthi.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kruthi.demo.entities.City;

public interface CityInfoRepository extends JpaRepository<City, Integer> {

}
