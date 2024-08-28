package com.cs.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.cs.entity.CitizenPlan;
import com.cs.repo.CitizenPlanRepository;

@Component
public class DataLoader implements ApplicationRunner {
	
	@Autowired
	private CitizenPlanRepository repo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		/*
		 * repo.deleteAll();
		 * 
		 * //cash plan data CitizenPlan c1 = new CitizenPlan();
		 * c1.setCitizenName("John"); c1.setCitizenGender("Male");
		 * c1.setPlanName("Cash"); c1.setPlanStatus("Approved");
		 * c1.setPlanStartDate(LocalDate.now());
		 * c1.setPlanEndDate(LocalDate.now().plusMonths(6)); c1.setBenifitAmt(5000.0);
		 * 
		 * CitizenPlan c2 = new CitizenPlan(); c2.setCitizenName("Smith");
		 * c2.setCitizenGender("Male"); c2.setPlanName("Cash");
		 * c2.setPlanStatus("Denied"); c2.setDenialreason("rental income");
		 * 
		 * CitizenPlan c3 = new CitizenPlan(); c3.setCitizenName("Cathy");
		 * c3.setCitizenGender("Fe-Male"); c3.setPlanName("Cash");
		 * c3.setPlanStatus("Terminated");
		 * c3.setPlanStartDate(LocalDate.now().minusMonths(4));
		 * c3.setPlanEndDate(LocalDate.now().plusMonths(2)); c3.setBenifitAmt(5000.0);
		 * c3.setTerminationDate(LocalDate.now()); c3.setTerminationRsn("Employeed");
		 * 
		 * //Food plan data CitizenPlan c4 = new CitizenPlan();
		 * c4.setCitizenName("David"); c4.setCitizenGender("Male");
		 * c4.setPlanName("Food"); c4.setPlanStatus("Approved");
		 * c4.setPlanStartDate(LocalDate.now());
		 * c4.setPlanEndDate(LocalDate.now().plusMonths(6)); c4.setBenifitAmt(4000.0);
		 * 
		 * CitizenPlan c5 = new CitizenPlan(); c5.setCitizenName("Robert");
		 * c5.setCitizenGender("Male"); c5.setPlanName("Food");
		 * c5.setPlanStatus("Denied"); c5.setDenialreason("Property income");
		 * 
		 * CitizenPlan c6 = new CitizenPlan(); c6.setCitizenName("Orlen");
		 * c6.setCitizenGender("Fe-Male"); c6.setPlanName("Food");
		 * c6.setPlanStatus("Terminated");
		 * c6.setPlanStartDate(LocalDate.now().minusMonths(4));
		 * c6.setPlanEndDate(LocalDate.now().plusMonths(2)); c6.setBenifitAmt(5000.0);
		 * c6.setTerminationDate(LocalDate.now()); c6.setTerminationRsn("Employeed");
		 * 
		 * 
		 * //Medical plan data CitizenPlan c7 = new CitizenPlan();
		 * c7.setCitizenName("Charles"); c7.setCitizenGender("Male");
		 * c7.setPlanName("Medical"); c7.setPlanStatus("Approved");
		 * c7.setPlanStartDate(LocalDate.now());
		 * c7.setPlanEndDate(LocalDate.now().plusMonths(6)); c7.setBenifitAmt(4000.0);
		 * 
		 * CitizenPlan c8 = new CitizenPlan(); c8.setCitizenName("Buttler");
		 * c8.setCitizenGender("Male"); c8.setPlanName("Medical");
		 * c8.setPlanStatus("Denied"); c8.setDenialreason("Property income");
		 * 
		 * CitizenPlan c9 = new CitizenPlan(); c9.setCitizenName("Neel");
		 * c9.setCitizenGender("Fe-Male"); c9.setPlanName("Medical");
		 * c9.setPlanStatus("Terminated");
		 * c9.setPlanStartDate(LocalDate.now().minusMonths(4));
		 * c9.setPlanEndDate(LocalDate.now().plusMonths(2)); c9.setBenifitAmt(5000.0);
		 * c9.setTerminationDate(LocalDate.now()); c9.setTerminationRsn("Govt Job");
		 * 
		 * 
		 * //Employment plan data CitizenPlan c10 = new CitizenPlan();
		 * c10.setCitizenName("Steve"); c10.setCitizenGender("Male");
		 * c10.setPlanName("Employment"); c10.setPlanStatus("Approved");
		 * c10.setPlanStartDate(LocalDate.now());
		 * c10.setPlanEndDate(LocalDate.now().plusMonths(6)); c10.setBenifitAmt(4000.0);
		 * 
		 * CitizenPlan c11 = new CitizenPlan(); c11.setCitizenName("Moris");
		 * c11.setCitizenGender("Male"); c11.setPlanName("Employment");
		 * c11.setPlanStatus("Denied"); c11.setDenialreason("Property income");
		 * 
		 * CitizenPlan c12 = new CitizenPlan(); c12.setCitizenName("Gibs");
		 * c12.setCitizenGender("Fe-Male"); c12.setPlanName("Employment");
		 * c12.setPlanStatus("Terminated");
		 * c12.setPlanStartDate(LocalDate.now().minusMonths(4));
		 * c12.setPlanEndDate(LocalDate.now().plusMonths(2)); c12.setBenifitAmt(5000.0);
		 * c12.setTerminationDate(LocalDate.now()); c12.setTerminationRsn("Govt Job");
		 * 
		 * 
		 * List<CitizenPlan> list =
		 * Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12); repo.saveAll(list);
		 */
	}

}
