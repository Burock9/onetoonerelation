package com.example.onetoonerelation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onetoonerelation.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
}
