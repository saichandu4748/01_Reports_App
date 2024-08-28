package com.cs.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.cs.entity.CitizenPlan;
import com.cs.repo.CitizenPlanRepository;
import com.cs.request.SearchRequest;

@Service
public class ReportServiceImpl implements IReportService {
	
	@Autowired
	private CitizenPlanRepository planRepo;

	@Override
	public List<String> getPlanNames() {
		//getting plan names list from repository
		return planRepo.getPlanNames();
	}

	@Override
	public List<String> getplanStatuses() {
		//getting plan statuses list from repository
		return planRepo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		/* my way of search method
		 * //creating a new list for citizens report List<CitizenPlan> citpln = new
		 * ArrayList<>(); //checking searchRequest obj is null or not if(request ==
		 * null) { //if null giving the all results citpln.addAll(planRepo.findAll()); }
		 * //if not null creating the dynamic search option else { //for plan names
		 * if(request.getPlanName() != null) {
		 * citpln.addAll(planRepo.findByPlanName(request.getPlanName())); } //for plan
		 * statuses if(request.getPlanStatus() != null) {
		 * citpln.addAll(planRepo.findByPlanStatus(request.getPlanStatus())); } //for
		 * citizen gender if(request.getPlanStatus() != null) {
		 * citpln.addAll(planRepo.findByPlanStatus(request.getPlanStatus())); } //to get
		 * distinct records of citizen Set<CitizenPlan> set = new LinkedHashSet<>();
		 * set.addAll(citpln); citpln.clear(); citpln.addAll(set); } return citpln;
		 */
		//sir's way
		CitizenPlan entity = new CitizenPlan();
		if(null !=request.getPlanName() && !"".equals(request.getPlanName()))
		{
			entity.setPlanName(request.getPlanName());
		}
		if(null !=request.getPlanStatus() && !"".equals(request.getPlanStatus()))
		{
			entity.setPlanStatus(request.getPlanStatus());
		}
		if(null !=request.getGender() && !"".equals(request.getGender()))
		{
			entity.setCitizenGender(request.getGender());
		}
		if(null != request.getStartDate())
		{
			entity.setPlanStartDate(request.getStartDate());
		}
		if(null != request.getEndDate())
		{
			entity.setPlanEndDate(request.getEndDate());
		}
		return planRepo.findAll(Example.of(entity));
	}

	@Override
	public boolean ExportExcel() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ExportPdf() {
		// TODO Auto-generated method stub
		return false;
	}

}
