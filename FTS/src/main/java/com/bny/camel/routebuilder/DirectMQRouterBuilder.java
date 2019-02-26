package com.bny.camel.routebuilder;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.bny.domain.User;
import com.bny.domain.UserMapper;

@Component
public class DirectMQRouterBuilder extends RouteBuilder{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public void configure() throws Exception {
		from("direct:messageRoute").process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {

				System.out.println("Direct Message Router Start");
				RowMapper<User> mapper = (rs, row) -> {
					return new User(rs.getInt("ID"), rs.getString("NAME"), rs.getString("EMAIL"));
				};
				List<User> users = jdbcTemplate.query("select *from USERS", mapper);
				users.stream().forEach((user) -> {
					System.out.println(" Record " + user.toString());
				});
				System.out.println("Direct Message Router END");
			}
		}).to("log:Direct Messaage executed");
		
	}

}
