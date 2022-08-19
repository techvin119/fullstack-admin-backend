package com.fse.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


import com.fse.admin.model.Profile;
import com.fse.admin.repository.AdminRepository;

@Component
public class ProfileListener {
	
	@Autowired
	private AdminRepository adminRepository;

	@KafkaListener(topics= "profiledata", groupId = "group_id")
	public void consume(Profile profileValue) {
			this.adminRepository.save(profileValue);
	}

}
