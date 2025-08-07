package com.example.onetoonerelation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.onetoonerelation.model.Desk;
import com.example.onetoonerelation.service.DeskService;

@RestController
@RequestMapping("/api/desks")
public class DeskController {
	private final DeskService deskService;
	
	public DeskController(DeskService deskService) {
		this.deskService = deskService;
	}
	
	@PostMapping
	public ResponseEntity<Desk> createDesk(@RequestBody Desk desk) {
		return ResponseEntity.ok(deskService.createDesk(desk));
	}
	
	@GetMapping
	public ResponseEntity<List<Desk>> getAllDesks() {
		return ResponseEntity.ok(deskService.getAllDesks());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Desk>> GetDeskById(Long id) {
		return ResponseEntity.ok(deskService.GetDeskById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDesk(@PathVariable Long id) {
		deskService.deleteDesks(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Desk> updateDesk(@PathVariable Long id, @RequestBody Desk updateddesk){
		return ResponseEntity.ok(deskService.updateDesk(id, updateddesk));
	}
}
