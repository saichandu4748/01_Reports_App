package com.cs.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cs.entity.CitizenPlan;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfGenerator {
	
	public void generate(HttpServletResponse response, List<CitizenPlan> records, File file) throws Exception
	{
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(file));
		document.open();
		Paragraph p = new Paragraph("Citizen plans info : "); 
		p.setAlignment(p.ALIGN_CENTER);
		document.add(p);
		PdfPTable table = new PdfPTable(8);
		table.addCell("Id");
		table.addCell("Citizen Name");
		table.addCell("Citizen Gender");
		table.addCell("Plan Name");
		table.addCell("Plane Status");
		table.addCell("Start Date");
		table.addCell("End Date");
		table.addCell("Benifit Amt");
		for(CitizenPlan plan :records)
		{
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getCitizenGender());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			table.addCell(plan.getPlanStartDate()+"");
			table.addCell(plan.getPlanEndDate()+"");
			table.addCell(String.valueOf(plan.getBenifitAmt()));
		}
		table.setHorizontalAlignment(table.ALIGN_CENTER);
		table.setSpacingBefore(5);
		document.add(table);
		document.close();
	}
}
