package com.vtw.oracle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vtw.domain.Information;

@Mapper
public interface ORCLInfoMapper {
	
	// 테이블 논리명(tableComment)
	String ORCLTableComment(Information information);
	
	// 테이블 컬럼 정보
	List<Information> ORCLInfoList(Information information);
}
