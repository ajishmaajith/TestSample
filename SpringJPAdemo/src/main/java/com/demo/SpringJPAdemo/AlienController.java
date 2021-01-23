package com.demo.SpringJPAdemo;

import java.util.List;
import java.util.Optional;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlienController {

	@Autowired
	AlienRepository repo;

	@GetMapping("Aliens")

	public List<Alien> getListOfAliens() {
		List<Alien> aliens = (List<Alien>) repo.findAll();

		return aliens;
	}

	@GetMapping("Aliens/{id}")

	public Optional<Alien> getAlien(@PathVariable("id") int id) {

		Optional<Alien> a = repo.findById(id);

		return a;

	}

	@PostMapping("save")
	public ResponseEntity<String> createAlien(@RequestBody Alien a) {

		
		repo.save(new Alien(a.getId(), a.getName(), a.getScore()));
		
		return new ResponseEntity<String>("saved", HttpStatus.CREATED);

	}

}
