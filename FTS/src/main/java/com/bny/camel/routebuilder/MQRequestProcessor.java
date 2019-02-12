package com.bny.camel.routebuilder;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class MQRequestProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println(" INSIDE MQRequestProcessor ");
		System.out.println(" BODY : " + exchange.getIn().getBody());
		System.out.println(" END MQRequestProcessor ");
	}

}
