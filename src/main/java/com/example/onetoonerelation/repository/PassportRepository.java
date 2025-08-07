package com.example.onetoonerelation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onetoonerelation.model.Passport;

public interface PassportRepository extends JpaRepository<Passport, Long>{
}
