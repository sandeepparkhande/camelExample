package com.bny.camel.routebuilder;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class IBMMQRouterBuilder extends RouteBuilder{

	// This Route Builder takes data from with jmsOther end point orderJMSQueue to log
	// Here we can demonstrate How we can use other end point defined ( jmsOther)
	// which can be IBM MQ as well defined in JMSConfig.java
	
	@Override
	public void configure() throws Exception {
		from("jmsOther:orderJMSQueue").to("log://executed other JMS QUEUE ");	
	}

}
