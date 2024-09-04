package com.cs.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.cs.entity.CitizenPlan;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelGenerator {
	
	public void generateExcel(List<CitizenPlan> records, HttpServletResponse response, File file) throws IOException
	{
		//WorkBook workbook = new XSSFWorkbook;
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("plans-data");
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Citizen Name");
		headerRow.createCell(2).setCellValue("Citizen Gender");
		headerRow.createCell(3).setCellValue("Plan Name");
		headerRow.createCell(4).setCellValue("Plane Status");
		headerRow.createCell(5).setCellValue("PlanStart Date");
		headerRow.createCell(6).setCellValue("Plan End Date");
		headerRow.createCell(7).setCellValue("Benifited Amount");
		int dataRowIndex=1;
		for(CitizenPlan plan : records)
		{
			Row dataRow = sheet.createRow(dataRowIndex++);
			dataRow.createCell(0).setCellValue(plan.getCitizenId());
			dataRow.createCell(1).setCellValue(plan.getCitizenName());
			dataRow.createCell(2).setCellValue(plan.getCitizenGender());
			dataRow.createCell(3).setCellValue(plan.getPlanName());
			dataRow.createCell(4).setCellValue(plan.getPlanStatus());
			dataRow.createCell(5).setCellValue(plan.getPlanStartDate());
			dataRow.createCell(6).setCellValue(plan.getPlanEndDate());
			if(null != plan.getBenifitAmt()) {
				dataRow.createCell(7).setCellValue(plan.getBenifitAmt());
			}else {
				dataRow.createCell(7).setCellValue("N/A");
			}
			
		}
		
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		fos.close();
//		workbook.close();
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		
	}
}
