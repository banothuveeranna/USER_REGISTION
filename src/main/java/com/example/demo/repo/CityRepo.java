package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.CityEntity;

public interface CityRepo extends JpaRepository<CityEntity, Integer>{

	public List<CityEntity> findByCityId(Integer cityId);
}
