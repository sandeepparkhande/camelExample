package com.bny.camel.routebuilder;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TimerRouterBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("timer://timerRouter?fixedRate=true&period=6000").to("log://executed");
	}

}
