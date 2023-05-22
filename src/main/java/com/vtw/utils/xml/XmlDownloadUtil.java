package com.vtw.utils.xml;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.springframework.stereotype.Component;

import com.vtw.domain.Information;
import com.vtw.domain.DBTableInfo;

@Component
public class XmlDownloadUtil {

	public void createXml(Information info, List<Information> infoList) throws Exception {
		
		String owner = info.getOwner();
		String tableName = info.getTableName();

		Date date = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyMMddhhmmss");
		String simpleDate = simple.format(date);
		
		String fileName = owner + "." + tableName + "-" + simpleDate;
		info.setFileName(fileName);

		DBTableInfo dbList = new DBTableInfo();
		
		// List를 XML형식에 맞게 치환
		dbList.setDbList(infoList);
		
		
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
