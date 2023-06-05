package com.report.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.report.entity.Report;
import com.report.exception.ResourceNotFoundException;
import com.report.repository.ReportRepository;

@RestController
@RequestMapping("/api/report")
public class ReportController {
	
	@Autowired
	private ReportRepository reportRepository;
	
//	Welcoming message
	@GetMapping("/welcome")
	public String welcome() {
		
		return "Welcome to Park & Pick users";
	}
	
	// get all users
	@GetMapping("/all")
	public List<Report> getAllProducts(){
    	System.out.println("All Report are listed here");
		return this.reportRepository.findAll();
    }
	// get user by id
	@GetMapping("/{id}")
	public Report getUseById(@PathVariable(value = "id") long report_id) {
		
		return this.reportRepository.findById(report_id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: "+ report_id));
	
	}
	// create user 
	
	@PostMapping("/register")
	
	public Report createUser(@RequestBody Report report) {
		
		return this.reportRepository.save(report);
	}
	
	// update user
	@PutMapping("/{id}")
	public Report updateUser(@RequestBody Report report, @PathVariable("id") long report_id) {
		Report existing = this.reportRepository.findById(report_id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: "+ report_id));
		existing.setReport_id(report.getReport_id());
		existing.setOwner_id(report.getOwner_id());
		existing.setDate(report.getDate());
				
		this.reportRepository.save(existing);
		return existing;
	}
	//delete user by id
    
	@DeleteMapping("/{id}")
	public ResponseEntity<Report> deleteUser(@PathVariable("id") long id){
		Report existing = this.reportRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: "+ id));
	    this.reportRepository.delete(existing);
	    return ResponseEntity.ok().build();
	}
}

