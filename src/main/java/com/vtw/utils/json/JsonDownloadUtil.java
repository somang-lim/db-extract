package com.vtw.utils.json;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vtw.domain.Information;

@Component
public class JsonDownloadUtil {

	public void createJson(Information info, List<Information> infoList) throws Exception {
		
		String owner = info.getOwner();
		String tableName =info.getTableName();

		Date date = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyMMddhhmmss");
		String simpleDate = simple.format(date);
		
		String fileName = owner + "." + tableName + "-" + simpleDate;
		info.setFileName(fileName);
		
		// JSON 다운로드
		final String path = System.getProperty("user.home") + "/Downloads/";
		File file = new File(path, fileName + ".json");
		
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String jsonList = gson.toJson(infoList);
		
		bufferedWriter.write(jsonList);
		bufferedWriter.close();
	}
}
