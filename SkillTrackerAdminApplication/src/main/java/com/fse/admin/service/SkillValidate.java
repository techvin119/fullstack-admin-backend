package com.fse.admin.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class SkillValidate {
	
	public static boolean identifySkillType(List<String> skill, String criteriaValue) {
		
		return skill.stream().anyMatch(s -> Objects.equals(criteriaValue.toUpperCase(), s));
	}

}
