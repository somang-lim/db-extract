package com.vtw.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Nav {

	// 스키마명
	private String owner;
	
	// 테이블명
	private String tableName;
}
