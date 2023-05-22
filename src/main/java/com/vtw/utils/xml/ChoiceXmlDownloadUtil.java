package com.vtw.utils.xml;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.springframework.stereotype.Component;

import com.vtw.domain.DBTableInfo;
import com.vtw.domain.Information;

@Component
public class ChoiceXmlDownloadUtil {
	
	public void createXml(Information info, List<Information> infoList, List<String> choiceInfoName) throws Exception {
		
		String owner = info.getOwner();
		String tableName = info.getTableName();
		
		Date date = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyMMddhhmmss");
		String simpleDate = simple.format(date);
		
		String fileName = owner + "." + tableName + "-" + simpleDate;
		info.setFileName(fileName);
		
		DBTableInfo dbList = new DBTableInfo();

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
		
		// List를 XML형식에 맞게 치환
		dbList.setDbList(choiceInfoList);
		
		
		// XML 다운로드
		final String path = System.getProperty("user.home") + "/Downloads/";
		File file = new File(path, fileName + ".xml");
		
		JAXBContext context = JAXBContext.newInstance(DBTableInfo.class);
		Marshaller marshaller = context.createMarshaller();
		
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		marshaller.marshal(dbList, file);
	}

}
