package com.bny.camel.routebuilder;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DirectMQRouterBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("direct:messageRoute").to("log:Direct Messaage executed");
		
	}

}
