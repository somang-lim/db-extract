package com.vtw.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name="DBTableInfo")
public class DBTableInfo {
	
	// List를 XML형식에 맞게 치환
	private List<Information> dbList;
}
