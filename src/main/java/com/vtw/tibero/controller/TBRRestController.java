package com.vtw.tibero.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vtw.domain.Information;
import com.vtw.domain.Nav;
import com.vtw.tibero.service.TBRInfoService;
import com.vtw.tibero.service.TBRNavService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tibero")
public class TBRRestController {
	
	private final TBRInfoService infoService;
	private final TBRNavService navService;
	
	
	// DB 테이블 정보
	@GetMapping("/info")
	public List<Information> showTable(Information info) throws Exception {
		return infoService.infoList(info);
	}
	
	// 메뉴 => 사용자리스트(스키마리스트)
	@GetMapping("/ownerList")
	public List<Nav> ownerList() throws Exception {
		return navService.ownerList();
	}

	// 메뉴 => 선택한 스키마가 가지는 테이블리스트
	@GetMapping("/tableList")
	public List<Nav> tableNameList(String owner) throws Exception {
			return navService.tableNameList(owner);
	}
	
	// View의 테이블 전체 컬럼 정보 Excel 추출
	@GetMapping("/excelDownload")
	public String excelDownload(Information info) throws Exception {
		return infoService.excelDownload(info);
	}
	
	// View의 테이블 선택 컬럼 정보 Excel 추출
	@GetMapping("/choiceExcelDownload/{owner}/{tableName}")
	public String choiceExcelDownload(@PathVariable("owner") String owner, @PathVariable("tableName") String tableName
			, @RequestParam("choiceInfoName") List<String> choiceInfoName) throws Exception {
		return infoService.choiceExcelDownload(owner, tableName, choiceInfoName);
	}
	
	// View의 테이블 전체 컬럼 정보 CSV 추출
	@GetMapping("/csvDownload")
	public String csvDownload(Information info) throws Exception {
		return infoService.csvDownload(info);
	}
	
	// View의 테이블 선택 컬럼 정보 CSV 추출
	@GetMapping("/choiceCsvDownload/{owner}/{tableName}")
	public String choiceCsvDownload(@PathVariable("owner") String owner, @PathVariable("tableName") String tableName
			, @RequestParam("choiceInfoName") List<String> choiceInfoName) throws Exception {
		return infoService.choiceCsvDownload(owner, tableName, choiceInfoName);
	}
	
	// View의 테이블 전체 컬럼 정보 JSON 추출 
	@GetMapping("/jsonDownload")
	public String jsonDownload(Information info) throws Exception {
		return infoService.jsonDownload(info);
	}
	
	// View의 테이블 선택 컬럼 정보 JSON 추출
	@GetMapping("/choiceJsonDownload/{owner}/{tableName}")
	public String choiceJsonDownload(@PathVariable("owner") String owner, @PathVariable("tableName") String tableName
			, @RequestParam("choiceInfoName") List<String> choiceInfoName) throws Exception {
		return infoService.choiceJsonDownload(owner, tableName, choiceInfoName);
	}
	
	// View의 테이블 전체 컬럼 정보 XML 추출
	@GetMapping("/xmlDownload")
	public String xmlDownload(Information info) throws Exception {
		return infoService.xmlDownload(info);
	}
	
	// View의 테이블 선택 컬럼 정보 XML 추출
	@GetMapping("/choiceXmlDownload/{owner}/{tableName}")
	public String choiceXmlDownload(@PathVariable("owner") String owner, @PathVariable("tableName") String tableName
			, @RequestParam("choiceInfoName") List<String> choiceInfoName) throws Exception {
		return infoService.choiceXmlDownload(owner, tableName, choiceInfoName);
	}
}
