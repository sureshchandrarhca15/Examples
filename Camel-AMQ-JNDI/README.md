# Description

A Camel demo that shows how to route messages from a JBoss A-MQ 6.3 to Artemis. Artimis is embedded in JBoss EAP 7


# Initial setup

Update the userName and Password in the camelContext.xml.

#EAP 7

1. Start EAP 7 server with standalone-full*.xml
2. Create a test.EAP7 queue:
 
        [standalone@localhost:9990 /] /subsystem=messaging-activemq/server=default/jms-queue=test.EAP7:add(entries=["java:jboss/exported/jms/test"])

3. Create Application user jms/jms@1234
4. Install jboss-client(taken from JBoss EAP bin/client) into the maven repo:
        
        mvn install:install-file -DgroupId=com.redhat -DartifactId=jboss-client -Dversion=1.0.0 -Dfile=/<path>/jboss-eap-7.0/bin/client/jboss-client.jar -DgeneratePom=true -Dpackaging=jar

#AMQ

1. COMPILING

	    mvn clean install

2. Deploying

		features:addurl mvn:com.test/Camel-AMQ-JNDI/0.0.1/xml/features
		features:install AMQ-EAP7

