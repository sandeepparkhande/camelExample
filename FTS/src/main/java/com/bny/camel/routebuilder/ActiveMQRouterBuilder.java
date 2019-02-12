package com.bny.camel.routebuilder;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQRouterBuilder extends RouteBuilder{

	@Autowired
	private MQRequestProcessor mqRequestProcessor;

	// This Route Builder takes data from with jms end point orderQueue and passed
	// to Processor and passed to direct:messageRoute in DirectMQRouterBuilder.java
	// Here we can demonstrate How we can use other end point defined ( jms)
	// which can be ACTIVE MQ as well defined in JMSConfig.java

	@Override
	public void configure() throws Exception {
		from("jms:orderQueue").process(mqRequestProcessor).to("direct:messageRoute");
	}

}
