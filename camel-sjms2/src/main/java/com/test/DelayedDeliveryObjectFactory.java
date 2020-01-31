package com.test;

import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.camel.component.sjms2.Sjms2Endpoint;
import org.apache.camel.component.sjms2.jms.Jms2ObjectFactory;

public class DelayedDeliveryObjectFactory extends Jms2ObjectFactory {
	
	@Override
	public MessageProducer createMessageProducer(Session session, Destination destination, boolean persistent, long ttl)
			throws Exception {
		
		MessageProducer ret = super.createMessageProducer(session, destination, persistent, ttl);
   		ret.setDeliveryDelay(500000);
		return ret;
	}
}
