package com.vtw.utils.excel;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.vtw.domain.Information;

@Component
public class ChoiceExcelDownloadUtil {

	public void createFile(Information info, List<Information> infoList, List<String> choiceInfoName) throws Exception {
		
		List<Information> choiceInfoList = new ArrayList<>();
		
		for(Information in : infoList) {
			Information infoChoice = new Information();
			
			infoChoice.setOwner(in.getOwner());
			infoChoice.setTableName(in.getTableName());
			infoChoice.setTableComment(in.getTableComment());
			
			if(choiceInfoName.contains("num")) {
				infoChoice.setNum(in.getNum());
				choiceInfoName.remove("num");
				choiceInfoName.add("번호");
			}
			
			if(choiceInfoName.contains("columnComment")) {
				infoChoice.setColumnComment(in.getColumnComment());
				choiceInfoName.remove("columnComment");
				choiceInfoName.add("속성명");
			}
			
			if(choiceInfoName.contains("columnName")) {
				infoChoice.setColumnName(in.getColumnName());
				choiceInfoName.remove("columnName");
				choiceInfoName.add("컬럼명");
			}
			
			if(choiceInfoName.contains("dataType")) {
				infoChoice.setDataType(in.getDataType());
				choiceInfoName.remove("dataType");
				choiceInfoName.add("타입");
			}
			
			if(choiceInfoName.contains("dataLength")) {
				infoChoice.setDataLength(in.getDataLength());
				choiceInfoName.remove("dataLength");
				choiceInfoName.add("길이");
			}
			
			if(choiceInfoName.contains("notNull")) {
				infoChoice.setNotNull(in.getNotNull());
				choiceInfoName.remove("notNull");
				choiceInfoName.add("Not Null");
			}
			
			if(choiceInfoName.contains("pk")) {
				infoChoice.setPk(in.getPk());
				choiceInfoName.remove("pk");
				choiceInfoName.add("PK");
			}
			
			if(choiceInfoName.contains("fk")) {
				infoChoice.setFk(in.getFk());
				choiceInfoName.remove("fk");
				choiceInfoName.add("FK");
			}
			
			if(choiceInfoName.contains("dataDefault")) {
				infoChoice.setDataDefault(in.getDataDefault());
				choiceInfoName.remove("dataDefault");
				choiceInfoName.add("기본값");
			}
			
			choiceInfoList.add(infoChoice);
		}
		
		int total = choiceInfoName.size();
		
		Workbook wb = new XSSFWorkbook();
		
		String owner = info.getOwner();
		String tableComment = info.getTableComment();
		String tableName = info.getTableName();
		
		Date date = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyMMddhhmmss");
		String simpleDate = simple.format(date);
		
		String fileName = owner + "." + tableName + "-" + simpleDate;
		info.setFileName(fileName);
		
		Sheet sheet = wb.createSheet(tableComment != null ? tableComment : tableName);
		
		/*
		 * STYLE
		 */
		// 0-1번째 행 style (mainTitle)
		CellStyle titleStyle = wb.createCellStyle();
		titleStyle.setAlignment(HorizontalAlignment.CENTER);
		titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		titleStyle.setBorderTop(BorderStyle.THIN);
		titleStyle.setBorderBottom(BorderStyle.THIN);
		titleStyle.setBorderLeft(BorderStyle.THIN);
		titleStyle.setBorderRight(BorderStyle.THIN);
		Font titleFont =  wb.createFont();
		titleFont.setFontName("Calibri");
		titleFont.setFontHeightInPoints((short)16);
		titleFont.setBold(true);
		titleStyle.setFont(titleFont);
		
		// 2번째 행 style (tableTitle)
		CellStyle tableKeyStyle = wb.createCellStyle();
		tableKeyStyle.setAlignment(HorizontalAlignment.CENTER);
		tableKeyStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		tableKeyStyle.setBorderTop(BorderStyle.THIN);
		tableKeyStyle.setBorderBottom(BorderStyle.THIN);
		tableKeyStyle.setBorderLeft(BorderStyle.THIN);
		tableKeyStyle.setBorderRight(BorderStyle.THIN);
		tableKeyStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		tableKeyStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		Font tableKeyFont = wb.createFont();
		tableKeyFont.setFontName("Calibri");
		tableKeyFont.setFontHeightInPoints((short)11);
		tableKeyFont.setBold(true);
		tableKeyStyle.setFont(tableKeyFont);
		
		// 2번째 행 내용 style (tableInfo)
		CellStyle tableValueStyle = wb.createCellStyle();
		tableValueStyle.setAlignment(HorizontalAlignment.CENTER);
		tableValueStyle.setBorderTop(BorderStyle.THIN);
		tableValueStyle.setBorderBottom(BorderStyle.THIN);
		tableValueStyle.setBorderLeft(BorderStyle.THIN);
		tableValueStyle.setBorderRight(BorderStyle.THIN);
		Font tableValueFont = wb.createFont();
		tableValueFont.setFontName("Calibri");
		tableValueFont.setFontHeightInPoints((short)11);
		tableValueStyle.setFont(tableValueFont);
		
		// 3번째 행 내용 style
		CellStyle valueStyle = wb.createCellStyle();
		valueStyle.setAlignment(HorizontalAlignment.CENTER);
		valueStyle.setBorderTop(BorderStyle.THIN);
		valueStyle.setBorderBottom(BorderStyle.THIN);
		valueStyle.setBorderLeft(BorderStyle.THIN);
		valueStyle.setBorderRight(BorderStyle.THIN);
		Font valueFont = wb.createFont();
		valueFont.setFontName("Calibri");
		valueFont.setFontHeightInPoints((short)11);
		valueStyle.setFont(valueFont);
		
		// 셀 병합
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 8));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 1));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 2, 3));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 4, 5));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 6, 8));
		
		/*
		 * information
		 */
		// 0-1번째 행 (mainTitle)
		Row rowTitle0 = sheet.createRow(0);
		Row rowTitle1 = sheet.createRow(1);
		
		rowTitle0.createCell(0).setCellValue("DB 테이블 정보");
		for(int i = 0; i < 9; i++) {
			if(i+1 != 9) rowTitle0.createCell(i+1);
			rowTitle0.getCell(i).setCellStyle(titleStyle);
			
			rowTitle1.createCell(i);
			rowTitle1.getCell(i).setCellStyle(titleStyle);
		}
		
		// 2번째 행 (tableTitle)
		Row rowTable = sheet.createRow(2);
		rowTable.createCell(0).setCellValue("테이블명");
		rowTable.createCell(1);
		rowTable.createCell(2).setCellValue(tableName);
		rowTable.createCell(3);
		rowTable.createCell(4).setCellValue("엔티티명");
		rowTable.createCell(5);
		rowTable.createCell(6).setCellValue(tableComment);
		rowTable.createCell(7);
		rowTable.createCell(8);
		for(int i = 0; i <= 8; i++) {
			if(i == 0 || i == 1 || i == 4 || i == 5) {
				rowTable.getCell(i).setCellStyle(tableKeyStyle);
			} else {
				rowTable.getCell(i).setCellStyle(tableValueStyle);
			}
			sheet.autoSizeColumn(i);
		}
		
		// 3번째 행 (infoName)
		Row rowValue = sheet.createRow(3);
		
		for(int i = 0; i < total; i++) {
			rowValue.createCell(i).setCellValue(choiceInfoName.get(i));
			rowValue.getCell(i).setCellStyle(tableKeyStyle);
		}
		
		// 4번째 행부터 마지막 행까지 (테이블 컬럼 정보)
		int rownum = 4;
		if(infoList != null) {
			for(Information in : infoList) {
				Row row = sheet.createRow(rownum++);
	
				for(int i = 0; i < total; i++) {
					if(choiceInfoName.get(i).equals("번호")) {
						row.createCell(i).setCellValue(in.getNum());
					} 
					
					else if(choiceInfoName.get(i).equals("속성명")) {
						row.createCell(i).setCellValue(in.getColumnComment());
					} 
					
					else if(choiceInfoName.get(i).equals("컬럼명")) {
						row.createCell(i).setCellValue(in.getColumnName());
					} 
					
					else if(choiceInfoName.get(i).equals("타입")) {
						row.createCell(i).setCellValue(in.getDataType());
					} 
					
					else if(choiceInfoName.get(i).equals("길이")) {
						row.createCell(i).setCellValue(in.getDataLength());
					} 
					
					else if(choiceInfoName.get(i).equals("Not Null")) {
						row.createCell(i).setCellValue(in.getNotNull());
					} 
					
					else if(choiceInfoName.get(i).equals("PK")) {
						row.createCell(i).setCellValue(in.getPk());
					} 
					
					else if(choiceInfoName.get(i).equals("FK")) {
						row.createCell(i).setCellValue(in.getFk());
					} 
					
					else if(choiceInfoName.get(i).equals("기본값")) {
						row.createCell(i).setCellValue(in.getDataDefault());
					} 
					
					row.getCell(i).setCellStyle(valueStyle);
					sheet.autoSizeColumn(total);
				}
			}
		}
		
		// Excel 다운로드
		final String path = System.getProperty("user.home") + "/Downloads/";
		
		try (OutputStream fileOut = new FileOutputStream(path + fileName + ".xlsx")) {
			wb.write(fileOut);
		}
		
		wb.close();
	}
}
