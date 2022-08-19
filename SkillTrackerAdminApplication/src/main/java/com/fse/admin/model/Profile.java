package com.fse.admin.model;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "profile")
public class Profile {
	
	@Id
	private int id ;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="AssociateId")
	private String associateId;

	@Column(name="MobileNum")
	private String mobileNum;
		
	@Column(name="EmailID")
	private String emailId;
		
	//@OneToMany(targetEntity = TechnicalSkill.class,cascade=CascadeType.ALL)
	//@OneToMany(mappedBy="profile",cascade=CascadeType.ALL)
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="profile_id",referencedColumnName="id")
	private List<TechnicalSkill> techSkills;
	
	//@OneToMany(targetEntity = NonTechSkill.class,cascade=CascadeType.ALL)
	//@OneToMany(mappedBy="profile",cascade=CascadeType.ALL)
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="profile_id",referencedColumnName="id")
	private List<NonTechSkill> nonTechSkills;
	
	@Column(name="CreateOrLastUpdate")
	private LocalDate createOrLastUpdate;
		
}
			
