package com.cs.service;

import java.util.List;

import com.cs.entity.CitizenPlan;
import com.cs.request.SearchRequest;

public interface IReportService {
	public List<String> getPlanNames();
	public List<String> getplanStatuses();
	public List<CitizenPlan> search(SearchRequest request);
	public boolean ExportExcel();
	public boolean ExportPdf();
}
