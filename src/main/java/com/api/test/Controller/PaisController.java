package com.api.test.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.api.test.Models.Pais;
import com.api.test.Repository.PaisRepository;

@RestController
@RequestMapping("/pais")
public class PaisController {

	
	
	private final PaisRepository dao;
	@Autowired
	public PaisController(PaisRepository dao) {
		this.dao = dao;
	}
//LIST ALL	
	@GetMapping
	public ResponseEntity<?> listar(Pageable pageble){
		return new ResponseEntity<>(dao.findAll(pageble), HttpStatus.OK);
	}
//LIST BY NAME
	@GetMapping(path = "/findByName/{name}" )
	public ResponseEntity<?> findStudentByName(@PathVariable String name){
		return new ResponseEntity<>(dao.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
	}
//LIST BY ID		
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<?> getpaisById(@PathVariable("id") Long id){
		Optional<Pais> pais = dao.findById(id);
		
		return new ResponseEntity<>(pais, HttpStatus.OK);
	}
//SAVE	
	@PostMapping
	public Pais adicionar(@RequestBody Pais pais) {
			return dao.save(pais);
			}
		
//DELETE	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
	dao.deleteById(id);
	return new ResponseEntity<>( HttpStatus.OK);
		
	}
//UPDATE	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Pais pais){
	dao.save(pais);
	return new ResponseEntity<>( HttpStatus.OK);
		
	}

}
