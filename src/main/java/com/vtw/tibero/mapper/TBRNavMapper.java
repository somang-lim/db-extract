package com.vtw.tibero.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vtw.domain.Nav;

@Mapper
public interface TBRNavMapper {

	// 스키마리스트
	List<Nav> TBROwnerList();
	
	// 테이블리스트
	List<Nav> TBRTableNameList(String owner);
	
}
