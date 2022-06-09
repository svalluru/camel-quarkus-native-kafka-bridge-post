package org.factory.floor;

import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public class MyReactiveMessagingApplication extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// produces messages to kafka
		from("timer:foo?period=50s")
		.setHeader(Exchange.HTTP_METHOD, constant(org.apache.camel.component.http.HttpMethods.POST))
		.setHeader(Exchange.CONTENT_TYPE, constant("application/vnd.kafka.json.v2+json"))
		.setBody(simple("{\"records\": [ { \"key\": \"key-1\", \"value\": \"value-1\" } ] }"))
		.log("${body}")
		.to("http://localhost/topics/devices")
		;


	}

}