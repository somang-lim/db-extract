package com.vtw.utils.csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.opencsv.CSVWriter;
import com.vtw.domain.Information;

@Component
public class ChoiceCsvDownloadUtil {
	
	public void createCsv(Information info, List<Information> infoList, List<String> choiceInfoName) throws Exception {
		
		String owner = info.getOwner();
		String tableName = info.getTableName();
		
		Date date = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyMMddhhmmss");
		String simpleDate = simple.format(date);
		
		String fileName = owner + "." + tableName + "-" + simpleDate;
		info.setFileName(fileName);
		
		
		choiceInfoName.add(1, "owner");
		choiceInfoName.add(2, "tableName");
		choiceInfoName.add(3, "tableComment");
		
		List<Information> choiceInfoList = new ArrayList<>();

		for(Information in : infoList) {
			Information infoChoice = new Information();
			
			infoChoice.setOwner(in.getOwner());
			infoChoice.setTableName(in.getTableName());
			infoChoice.setTableComment(in.getTableComment());
			
			if(choiceInfoName.contains("num")) {
				infoChoice.setNum(in.getNum());
			}

			if(choiceInfoName.contains("columnComment")) {
				infoChoice.setColumnComment(in.getColumnComment());
			}
			
			if(choiceInfoName.contains("columnName")) {
				infoChoice.setColumnName(in.getColumnName());
			}
			
			if(choiceInfoName.contains("dataType")) {
				infoChoice.setDataType(in.getDataType());
			}
			
			if(choiceInfoName.contains("dataLength")) {
				infoChoice.setDataLength(in.getDataLength());
			}
			
			if(choiceInfoName.contains("notNull")) {
				infoChoice.setNotNull(in.getNotNull());
			}
			
			if(choiceInfoName.contains("pk")) {
				infoChoice.setPk(in.getPk());
			}
			
			if(choiceInfoName.contains("fk")) {
				infoChoice.setFk(in.getFk());
			}
			
			if(choiceInfoName.contains("dataDefault")) {
				infoChoice.setDataDefault(in.getDataDefault());
			}
			
			choiceInfoList.add(infoChoice);
		}
		
		List<String[]> infoStringList = new ArrayList<>();
		
		int total = choiceInfoName.size();
		
		String[] header = new String[total];
		for(int i = 0; i < total; i++) {
			header[i] = choiceInfoName.get(i);
		}
		
		for(Information in : choiceInfoList) {
			String[] infoString = new String[total];
			
			for(int i = 0; i < total; i++) {
				if(header[i].equals("num")) {
					infoString[i] = String.valueOf(in.getNum());
				} 
				
				if(in.getOwner() != null && header[i].equals("owner")) {
					infoString[i] = in.getOwner();
				} 
				
				if(in.getTableName() != null && header[i].equals("tableName")) {
					infoString[i] = in.getTableName();
				} 
				
				if(in.getTableComment() != null && header[i].equals("tableComment")) {
					infoString[i] = in.getTableComment();
				} 
				
				if(in.getColumnComment() != null && header[i].equals("columnComment")) {
					infoString[i] = in.getColumnComment();
				} 
				
				if(in.getColumnName() != null && header[i].equals("columnName")) {
					infoString[i] = in.getColumnName();
				} 
				
				if(in.getDataType() != null && header[i].equals("dataType")) {
					infoString[i] = in.getDataType();
				} 
				
				if(in.getDataLength() != null && header[i].equals("dataLength")) {
					infoString[i] = String.valueOf(in.getDataLength());
				} 
				
				if(in.getNotNull() != null && header[i].equals("notNull")) {
					infoString[i] = in.getNotNull();
				} 
				
				if(in.getPk() != null && header[i].equals("pk")) {
					infoString[i] = in.getPk();
				} 
				
				if(in.getFk() != null && header[i].equals("fk")) {
					infoString[i] = in.getFk();
				} 
				
				if(in.getDataDefault() != null && header[i].equals("dataDefault")) {
					infoString[i] = in.getDataDefault();
				}
			}
			
			infoStringList.add(infoString);
		}
		
		// CSV 다운로드
		final String path = System.getProperty("user.home") + "/Downloads/";
		File file = new File(path, fileName + ".csv");
		
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "MS949"));
		
		CSVWriter csvWriter = new CSVWriter(bufferedWriter, ','
				, CSVWriter.NO_QUOTE_CHARACTER
				, CSVWriter.DEFAULT_ESCAPE_CHARACTER
				, CSVWriter.DEFAULT_LINE_END);
		
		csvWriter.writeNext(header);
		csvWriter.writeAll(infoStringList);
		csvWriter.close();
		bufferedWriter.close();
	}
	

}
