package com.vtw.config.dataSource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import lombok.RequiredArgsConstructor;

// @Configuration
@RequiredArgsConstructor
@MapperScan(value="com.vtw.tibero.mapper", sqlSessionFactoryRef="tiberoSSF")
public class TiberoConfig {

	private final ApplicationContext applicationContext;


	@Bean(name="tiberoDS")
	@Primary
	@ConfigurationProperties(prefix="spring.datasource.tibero")
	public DataSource dataSurce() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name="tiberoSSF")
	@Primary
	public SqlSessionFactory sqlSessinoFactory(@Qualifier("tiberoDS") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/tibero/*.xml"));
		
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean(name="tiberoSST")
	@Primary
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
