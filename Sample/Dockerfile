FROM jboss/base-jdk:8

ENV CAMEL_SETBODY Hello World!!

USER jboss

COPY target/Sample-0.0.1.jar /opt/jboss/test.jar


# Expose the ports we're interested in
EXPOSE 8080


CMD ["java", "-jar", "/opt/jboss/test.jar"]
