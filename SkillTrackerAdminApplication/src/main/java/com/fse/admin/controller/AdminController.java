package com.fse.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fse.admin.model.Profile;
import com.fse.admin.service.AdminService;

@RestController
@CrossOrigin
@RequestMapping("/skill-tracker/api/v1/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
		
	@GetMapping("{criteria}/{criteriaValue}")
	public  ResponseEntity<List<Profile>> getProfilesByCriteria( @PathVariable String criteria, @PathVariable String criteriaValue) {
		
		List<Profile> profileData =  this.adminService.getProfilesByCriteria(criteria, criteriaValue);
		return new ResponseEntity<>(profileData,HttpStatus.OK);
	}
	
}
	

