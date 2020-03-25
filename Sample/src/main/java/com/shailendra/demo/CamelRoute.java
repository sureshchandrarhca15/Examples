package com.shailendra.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRoute extends RouteBuilder {
 
   @Override
   public void configure() throws Exception {
           from("undertow:http://0.0.0.0:8080/test")
          .setBody(constant("{{env:CAMEL_SETBODY}}"))
          .log("Hello Camel-K");
   }
}
