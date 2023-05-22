package com.vtw.tibero.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.vtw.domain.Information;

@Mapper
public interface TBRInfoMapper {
	
	// 테이블 논리명(tableComment)
	String TBRTableComment(Information information);
	
	// 테이블 컬럼 정보
	List<Information> TBRInfoList(Information information);
}
