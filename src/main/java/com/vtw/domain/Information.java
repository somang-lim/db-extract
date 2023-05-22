package com.vtw.domain;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name="information")
@XmlType(propOrder = {"num", "owner", "tableName", "tableComment", "columnComment", "columnName", "dataType", "dataLength", "notNull", "pk", "fk", "dataDefault", "fileName"})
public class Information {

	// 번호
	private Integer num;
	
	// 스키마명
	private String owner;
	
	// 테이블명
	private String tableName;
	
	// 엔티티명
	private String tableComment;
	
	// 속성명
	private String columnComment;
	
	// 컬럼명
	private String columnName;
	
	// 타입
	private String dataType;
	
	// 길이
	private Integer dataLength;
	
	// NOT NULL
	private String notNull;
	
	// PK
	private String pk;
	
	// FK
	private String fk;
	
	// 기본값
	private String dataDefault;
	
	// 파일 이름
	private String fileName;
}
