package com.cs.service;

import java.util.List;

import com.cs.entity.CitizenPlan;
import com.cs.request.SearchRequest;

import jakarta.servlet.http.HttpServletResponse;

public interface IReportService {
	public List<String> getPlanNames();
	public List<String> getplanStatuses();
	public List<CitizenPlan> search(SearchRequest request);
	public boolean ExportExcel(HttpServletResponse response) throws Exception;
	public boolean ExportPdf(HttpServletResponse response) throws Exception;
}
