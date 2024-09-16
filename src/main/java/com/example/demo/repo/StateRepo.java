package com.example.demo.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.StateEntity;

public interface StateRepo extends JpaRepository<StateEntity, Integer> {

	public List<StateEntity>  findByCountryId(Integer countryId);
}
