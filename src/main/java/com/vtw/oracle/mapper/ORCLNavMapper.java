package com.vtw.oracle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vtw.domain.Nav;

@Mapper
public interface ORCLNavMapper {

	// 스키마리스트
	List<Nav> ORCLOwnerList();
	
	// 테이블리스트
	List<Nav> ORCLTableNameList(String owner);
	
}
