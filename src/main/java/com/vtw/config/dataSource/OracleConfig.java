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

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@MapperScan(value="com.vtw.oracle.mapper", sqlSessionFactoryRef="oracleSSF")
public class OracleConfig {

	private final ApplicationContext applicationContext;


	@Bean(name="oracleDS")
	@ConfigurationProperties(prefix="spring.datasource.oracle")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name="oracleSSF")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("oracleDS") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/oracle/*.xml"));
		
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean(name="oracleSST")
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
