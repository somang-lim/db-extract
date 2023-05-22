package com.vtw.oracle.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vtw.domain.Information;
import com.vtw.oracle.mapper.ORCLInfoMapper;
import com.vtw.utils.csv.ChoiceCsvDownloadUtil;
import com.vtw.utils.csv.CsvDownloadUtil;
import com.vtw.utils.excel.ChoiceExcelDownloadUtil;
import com.vtw.utils.excel.ExcelDownloadUtil;
import com.vtw.utils.json.ChoiceJsonDownloadUtil;
import com.vtw.utils.json.JsonDownloadUtil;
import com.vtw.utils.xml.ChoiceXmlDownloadUtil;
import com.vtw.utils.xml.XmlDownloadUtil;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ORCLInfoService {

	private final ORCLInfoMapper infoMapper;
	
	private final ExcelDownloadUtil excelDownload;
	private final ChoiceExcelDownloadUtil choiceExcelDownload;
	
	private final CsvDownloadUtil csvDownload;
	private final ChoiceCsvDownloadUtil choiceCsvDownload;
	
	private final JsonDownloadUtil jsonDownload;
	private final ChoiceJsonDownloadUtil choiceJsonDownload;
	
	private final XmlDownloadUtil xmlDownload;
	private final ChoiceXmlDownloadUtil choiceXmlDownload;
	
	
	// 테이블 논리명
	public String tableComment(Information info) throws Exception {
		return infoMapper.ORCLTableComment(info);
	}
	
	// 테이블 전체 컬럼 정보
	public List<Information> infoList(Information info) throws Exception {
		return infoMapper.ORCLInfoList(info);
	}
	
	// 테이블 전체 컬럼 정보 Excel 추출
	public String excelDownload(Information info) throws Exception {
		List<Information> infoList = infoMapper.ORCLInfoList(info);
		
		excelDownload.createFile(info, infoList);
		
		return info.getFileName();
	}
	
	// 테이블 선택 컬럼 정보 Excel 출력
	public String choiceExcelDownload(String owner, String tableName, List<String> choiceInfoName) throws Exception {
		Information info = new Information();
		info.setOwner(owner);
		info.setTableName(tableName);
		
		String tableComment = infoMapper.ORCLTableComment(info);
		info.setTableComment(tableComment);
		
		List<Information> infoList = infoMapper.ORCLInfoList(info);

		choiceExcelDownload.createFile(info, infoList, choiceInfoName);
		
		return info.getFileName();
	}
	
	// 테이블 전체 컬럼 정보 CSV 추출
	public String csvDownload(Information info) throws Exception {
		List<Information> infoList = infoMapper.ORCLInfoList(info);
		
		csvDownload.createCsv(info, infoList);
		
		return info.getFileName();
	}
	
	// 테이블 선택 컬럼 정보 CSV 추출
	public String choiceCsvDownload(String owner, String tableName, List<String> choiceInfoName) throws Exception {
		Information info = new Information();
		info.setOwner(owner);
		info.setTableName(tableName);
		
		String tableComment = infoMapper.ORCLTableComment(info);
		info.setTableComment(tableComment);
		
		List<Information> infoList = infoMapper.ORCLInfoList(info);
		
		choiceCsvDownload.createCsv(info, infoList, choiceInfoName);
		
		return info.getFileName();
	}
	
	// 테이블 전체 컬럼 정보 JSON 추출
	public String jsonDownload(Information info) throws Exception {
		List<Information> infoList = infoMapper.ORCLInfoList(info);
		
		jsonDownload.createJson(info, infoList);
		
		return info.getFileName();
	}
	
	// 테이블 선택 컬럼 정보 JSON 추출
	public String choiceJsonDownload(String owner, String tableName, List<String> choiceInfoName) throws Exception {
		Information info = new Information();
		info.setOwner(owner);
		info.setTableName(tableName);
		
		String tableComment = infoMapper.ORCLTableComment(info);
		info.setTableComment(tableComment);

		List<Information> infoList = infoMapper.ORCLInfoList(info);
		
		choiceJsonDownload.createJson(info, infoList, choiceInfoName);
		
		return info.getFileName();
	}
	
	// 테이블 전체 컬럼 정보 XML 추출
	public String xmlDownload(Information info) throws Exception {
		List<Information> infoList = infoMapper.ORCLInfoList(info);

		xmlDownload.createXml(info, infoList);
		
		return info.getFileName();
	}

	// 테이블 선택 컬럼 정보 XML 추출
	public String choiceXmlDownload(String owner, String tableName, List<String> choiceInfoName) throws Exception {
		Information info = new Information();
		info.setOwner(owner);
		info.setTableName(tableName);
		
		String tableComment = infoMapper.ORCLTableComment(info);
		info.setTableComment(tableComment);
		
		List<Information> infoList = infoMapper.ORCLInfoList(info);
		
		choiceXmlDownload.createXml(info, infoList, choiceInfoName);

		return info.getFileName();
	}
}
