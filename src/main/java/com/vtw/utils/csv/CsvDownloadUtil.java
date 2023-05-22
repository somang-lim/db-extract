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
public class CsvDownloadUtil {

	public void createCsv(Information info, List<Information> infoList) throws Exception {
		
		String owner = info.getOwner();
		String tableName = info.getTableName();
		
		Date date = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyMMddhhmmss");
		String simpleDate = simple.format(date);
		
		String fileName = owner + "." + tableName + "-" + simpleDate;
		info.setFileName(fileName);
		
		List<String[]> infoStringList = new ArrayList<>();
		
		final String path = System.getProperty("user.home") + "/Downloads/";
		
		File file = new File(path, fileName + ".csv");
		
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "MS949"));
		
		CSVWriter csvWriter = new CSVWriter(bufferedWriter, ','
											, CSVWriter.NO_QUOTE_CHARACTER
											, CSVWriter.DEFAULT_ESCAPE_CHARACTER
											, CSVWriter.DEFAULT_LINE_END);
		
		String[] header = {"num", "owner", "tableName", "tableComment", "columnComment", "columnName", "dataType", "dataLength", "NotNUll", "PK", "FK", "dataDefault"};
		csvWriter.writeNext(header);
		
		for(Information in : infoList) {
			String[] infoString = new String[12];
			
			infoString[0] = String.valueOf(in.getNum());
			
			if(in.getOwner() != null) {
				infoString[1] = in.getOwner();
			}
			
			if(in.getTableName() != null) {
				infoString[2] = in.getTableName();
			}
			
			if(in.getTableComment() != null) {
				infoString[3] = in.getTableComment();
			}
			
			if(in.getColumnComment() != null) {
				infoString[4] = in.getColumnComment();
			}
			
			if(in.getColumnName() != null) {
				infoString[5] = in.getColumnName();
			}
	
			if(in.getDataType() != null) {
				infoString[6] = in.getDataType();
			}
			
			if(in.getDataLength() != null) {
				infoString[7] = String.valueOf(in.getDataLength());
			}
			
			if(in.getNotNull() != null) {
				infoString[8] = in.getNotNull();
			}
			
			if(in.getPk() != null) {
				infoString[9] = in.getPk();
			}
			
			if(in.getFk() != null) {
				infoString[10] = in.getFk();
			}
			
			if(in.getDataDefault() != null) {
				infoString[11] = in.getDataDefault();
			}
			
			infoStringList.add(infoString);
		}
		
		csvWriter.writeAll(infoStringList);
		csvWriter.close();
		bufferedWriter.close();
	}
}
