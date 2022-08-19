package com.fse.admin.service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fse.admin.exception.InvalidCriteriaException;
import com.fse.admin.exception.InvalidSkillTypeException;
import com.fse.admin.exception.ProfileNotFoundException;
import com.fse.admin.model.Profile;
import com.fse.admin.repository.AdminRepository;

@Service
public class AdminService {
	
	public static final List<String> techSkill = Arrays.asList("HTML-CSS-JAVASCRIPT","ANGULAR",
			"REACT", "AWS","GIT","SPRING","RESTFUL","HIBERNATE","DOCKER","JENKINS");
	
	public static final List<String> nonTechSkill = Arrays.asList("SPOKEN","COMMUNICATION","APTITUDE");
	

	@Autowired 
	private AdminRepository adminRepository;

	public List<Profile> getProfilesByCriteria(String criteria, String criteriaValue) {
			
		List<Profile> profileData = null;
		
		switch(criteria.toLowerCase()) {
		
		case "prefix":
			
			profileData = adminRepository.findByNameStartingWith(criteriaValue);
			break;
			
		case "associateid" :
			
			profileData = this.adminRepository.findByAssociateId(criteriaValue);
			break;
			
		case "skill" :
			
			boolean isTechSkill = SkillValidate.identifySkillType(techSkill, criteriaValue);
			boolean isNonTechSkill = SkillValidate.identifySkillType(nonTechSkill, criteriaValue);
					
			if(isTechSkill) {
				profileData = adminRepository.findByTechSkillName(criteriaValue);
			}
			else if(isNonTechSkill) {
				profileData = adminRepository.findByNonTechSkillName(criteriaValue);
			}
			else {
				throw new InvalidSkillTypeException();
			}
			
			break;
			
		default:
			
			throw new InvalidCriteriaException();
		
		}
		
		
			return profileData;
		}
		

	}
			


