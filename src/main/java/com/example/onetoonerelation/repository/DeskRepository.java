package com.example.onetoonerelation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onetoonerelation.model.Desk;

public interface DeskRepository extends JpaRepository<Desk, Long>{

}
