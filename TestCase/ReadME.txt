Steps to Deploy

Run "mvn clean install":


# Step 1>>>Install Following Bundles:
-----------------------------------
	features:install jndi jpa hibernate
	osgi:install -s mvn:org.apache.servicemix.bundles/org.apache.servicemix.bundles.commons-dbcp/1.4_3

# Step 2>>>Install the driver(I have used mariadb)
-----------------------------------
         osgi:install -s wrap:file:///Downloads/Jars/mariadb-java-client-1.1.9.jar 

# Step 3>>>Install TestCase bundle
-----------------------------------
         osgi:install -s mvn:com.test/DataSource/0.0.1
         osgi:install -s mvn:com.test/Hibernate-JPA/0.0.1
         osgi:install -s mvn:com.test/Hibernate-Client/0.0.1


