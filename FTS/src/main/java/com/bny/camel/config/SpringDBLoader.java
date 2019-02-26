package com.bny.camel.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.bny.domain.User;

public class SpringDBLoader {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
				SpringDBConfig.class);
		DataSource dataSource = annotationConfigApplicationContext.getBean(DataSource.class);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		printUsers(jdbcTemplate);		
		updateUsers(dataSource);
		printUsers(jdbcTemplate);
		annotationConfigApplicationContext.close();

	}

	private static void updateUsers(DataSource dataSource) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> batchValues=new HashMap<String,Object>();
		batchValues.put("ID",4);
		batchValues.put("NAME", "AAYU");
		batchValues.put("EMAIL", "AAYU@email.com");
		namedParameterJdbcTemplate.update("INSERT INTO USERS VALUES(:ID,:NAME,:EMAIL)", batchValues);
	}

	private static void printUsers(JdbcTemplate jdbcTemplate) {
		RowMapper<User> mapper = (rs, row) -> {
			return new User(rs.getInt("ID"), rs.getString("NAME"), rs.getString("EMAIL"));
		};
		List<User> users = jdbcTemplate.query("select *from USERS", mapper);
		users.stream().forEach((user) -> {
			System.out.println(" " + user.toString());
		});
	}
}