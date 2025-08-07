package com.example.onetoonerelation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.onetoonerelation.model.Desk;
import com.example.onetoonerelation.repository.DeskRepository;

@Service
public class DeskService {
	private final DeskRepository deskRepository;
	
	public DeskService(DeskRepository deskRepository) {
		this.deskRepository = deskRepository;
	}
	
	public Desk createDesk(Desk desk) {
		return deskRepository.save(desk);
	}
	
	public List<Desk> getAllDesks() {
		return deskRepository.findAll();
	}
	
	public Optional<Desk> GetDeskById(Long id) {
		return deskRepository.findById(id);
	}
	
	public Desk updateDesk(Long id, Desk updatedDesk) {
		Optional<Desk> optionalDesk = deskRepository.findById(id);
		if (optionalDesk.isPresent()) {
			Desk desk = optionalDesk.get();
			desk.setCode(updatedDesk.getCode());
			return deskRepository.save(desk);
		}
		return null;
	}
	
	public void deleteDesks(Long id) {
		deskRepository.deleteById(id);
	}
}
