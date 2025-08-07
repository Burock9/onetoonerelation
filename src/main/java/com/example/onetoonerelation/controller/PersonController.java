package com.example.onetoonerelation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.onetoonerelation.model.Person;
import com.example.onetoonerelation.repository.PersonRepository;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
	private final PersonRepository personRepository;
	
	@Autowired
	public PersonController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	@PostMapping
	public Person createPerson(@RequestBody Person person) {
		return personRepository.save(person);
	}
	
	@GetMapping
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Person> getPersonById(@PathVariable Long id){
		return personRepository.findById(id);
	}
	
	@PutMapping("/{id}")
	public Person updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson) {
		return personRepository.findById(id)
				.map(person -> {
					person.setName(updatedPerson.getName());
					person.setPassport(updatedPerson.getPassport());
					return personRepository.save(person);
				})
				.orElseThrow(() -> new RuntimeException(id+"ID'li Kişi Bulunamadı"));
	}
	
	@DeleteMapping("/{id}")
	public void deletePerson(@PathVariable Long id) {
		personRepository.deleteById(id);
	}
}
