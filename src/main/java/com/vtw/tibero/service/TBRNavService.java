package com.vtw.tibero.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vtw.domain.Nav;
import com.vtw.tibero.mapper.TBRNavMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TBRNavService {

	private final TBRNavMapper navMapper;
	
	// 스키마리스트
	public List<Nav> ownerList() throws Exception {
		return navMapper.TBROwnerList();
	}
	
	// 테이블리스트
	public List<Nav> tableNameList(String owner) throws Exception {
		return navMapper.TBRTableNameList(owner);
	}
	
}
