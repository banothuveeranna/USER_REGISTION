package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.CountyEntity;

public interface CountryRepo extends JpaRepository<CountyEntity, Integer>{

}
