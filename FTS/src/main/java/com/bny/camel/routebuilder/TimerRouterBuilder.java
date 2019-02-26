package com.bny.camel.routebuilder;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bny.domain.User;
import com.bny.domain.UserMapper;

@Component
public class TimerRouterBuilder extends RouteBuilder{
	@Autowired
	private UserMapper userMapper;

	@Override
	public void configure() throws Exception {
		from("timer://timerRouter?fixedRate=true&period=6000").process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
		        List<User> users = userMapper.findAllUsers();
		        System.out.println(" Users List "+users.size());
	
			}
		}).to("log://executed");
	}

}
