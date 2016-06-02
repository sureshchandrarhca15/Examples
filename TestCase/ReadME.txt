Steps to Deploy

Run "mvn clean install":


Step 1>>>Install Following Bundles:
-----------------------------------
	features:install jndi
	osgi:install -s mvn:org.apache.servicemix.bundles/org.apache.servicemix.bundles.commons-dbcp/1.4_3

Step 2>>>Install the driver(I have used mariadb, require to download the driver jar)
-----------------------------------
         osgi:install -s wrap:file:///Downloads/Jars/mariadb-java-client-1.1.9.jar 

Step 3>>>Install datasource bundle
-----------------------------------
         osgi:install -s mvn:demo.datasource/mariadb-datasource/1.0


