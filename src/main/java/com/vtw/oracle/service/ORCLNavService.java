package com.vtw.oracle.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vtw.domain.Nav;
import com.vtw.oracle.mapper.ORCLNavMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ORCLNavService {

	private final ORCLNavMapper navMapper;


	// 스키마리스트
	public List<Nav> ownerList() throws Exception {
		return navMapper.ORCLOwnerList();
	}
	
	// 테이블리스트
	public List<Nav> tableNameList(String owner) throws Exception {
		return navMapper.ORCLTableNameList(owner);
	}
	
}
