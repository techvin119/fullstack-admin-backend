package com.fse.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fse.admin.model.Profile;

public interface AdminRepository extends JpaRepository<Profile,Integer> {
	
	List<Profile> findByNameStartingWith(String prefix);
	
	List<Profile> findByAssociateId(String AssociateId);
	
	@Query("FROM Profile p join p.techSkills t WHERE t.skillName = ?1 AND "
			+ "t.skillRange > 10 ORDER BY t.skillRange DESC" )
	List<Profile> findByTechSkillName(String skill);
	
	@Query("FROM Profile p join p.nonTechSkills n WHERE n.skillName = ?1 AND "
			+ "n.skillRange > 10 ORDER BY n.skillRange DESC" )
	List<Profile> findByNonTechSkillName(String skill);
	
}
