package com.cs.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.cs.entity.CitizenPlan;
import com.cs.repo.CitizenPlanRepository;
import com.cs.request.SearchRequest;
import com.cs.util.EmailUtils;
import com.cs.util.ExcelGenerator;
import com.cs.util.PdfGenerator;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements IReportService {
	
	@Autowired
	private CitizenPlanRepository planRepo;
	
	@Autowired
	private ExcelGenerator excelGenerator;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private EmailUtils emailUtils;
	
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
	public boolean ExportExcel(HttpServletResponse response) throws Exception {
		List<CitizenPlan> list = planRepo.findAll();
		File f = new File("plans.xls");
		excelGenerator.generateExcel(list, response,f);
		emailUtils.sendEmail("Test Mail Subject", "<h1>hello sai we're looking for you</h1>", "20985a0277@raghuenggcollege.in",f);
		f.delete();
		return true;
	}

	@Override
	public boolean ExportPdf(HttpServletResponse response) throws Exception {
		List<CitizenPlan> list = planRepo.findAll();
		File file = new File("plans.pdf");
		pdfGenerator.generate(response, list,file);
		emailUtils.sendPDFEmail("Test Mail subject", "<h1>hurray! we're successful", "20985a0277@raghuenggcollege.in", file);
		file.delete();
		return true;
	}


}
