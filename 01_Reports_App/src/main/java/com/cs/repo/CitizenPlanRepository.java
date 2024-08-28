package com.cs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cs.entity.CitizenPlan;

public interface CitizenPlanRepository extends JpaRepository<CitizenPlan, Integer> {
	
	@Query("select distinct(planName) from CitizenPlan")
	public List<String> getPlanNames(); 
	
	@Query("select distinct(planStatus) from CitizenPlan")
	public List<String> getPlanStatus(); 
	
	/*according to sir's plan we do not need this instead we can use Example.of(CitizenPlan)
	 * as tool for Dynamic Search
	 * 
	 * public List<CitizenPlan> findByPlanName(String planName);
	 * 
	 * public List<CitizenPlan> findByPlanStatus(String planStatus);
	 * 
	 * public List<CitizenPlan> findByCitizenGender(String gender);
	 */
}
