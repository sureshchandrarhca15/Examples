# Steps to Build the image.


1. mvn clean install

2. Build the image using podman
~~~
podman build -t quay.io/<user_ID>/sample:v0.1 . 

#output 
STEP 1: FROM jboss/base-jdk:8
STEP 2: ENV CAMEL_SETBODY Hello World!!
--> 939e471df9a65b4a41c222809a8f934fd38636864b87cb52adab66185ed406fe
STEP 3: FROM 939e471df9a65b4a41c222809a8f934fd38636864b87cb52adab66185ed406fe
STEP 4: USER jboss
--> 695df58fac3ccc1f0867384109a9ed9699dd3e233a5be7b0ab64e75ccdc645a7
STEP 5: FROM 695df58fac3ccc1f0867384109a9ed9699dd3e233a5be7b0ab64e75ccdc645a7
STEP 6: COPY target/Sample-0.0.1.jar /opt/jboss/test.jar
--> b18c90db8898bac1643a2d65cf9aef1822ef3aade358c4ede04cd15571d049f7
STEP 7: FROM b18c90db8898bac1643a2d65cf9aef1822ef3aade358c4ede04cd15571d049f7
STEP 8: EXPOSE 8080
--> 5d547a55e869cd7838b19a1677c172fdb09cf711248d4e1f50d4508bf1b3b9e2
STEP 9: FROM 5d547a55e869cd7838b19a1677c172fdb09cf711248d4e1f50d4508bf1b3b9e2
STEP 10: CMD ["java", "-jar", "/opt/jboss/test.jar"]
--> 183a56357f0bd6c9bcb96cb824b70894bfbc6bc85a0b36acc72a18eb3143fada
STEP 11: COMMIT quay.io/shailendra14k/sample:v0.1
~~~

3. Run the build image
~~~
podman run --rm --name sample -it -p 8080:8080 -e CAMEL_SETBODY="Response received from Conatiner : {{env:HOSTNAME}}"  quay.io/<user_ID>/sample:v0.1

#output
2020-03-25 08:16:01.359  INFO 1 --- [           main] o.a.camel.spring.SpringCamelContext      : Total 1 routes, of which 1 are started
2020-03-25 08:16:01.362  INFO 1 --- [           main] o.a.camel.spring.SpringCamelContext      : Apache Camel 2.21.5 (CamelContext: camel-1) started in 0.391 seconds
2020-03-25 08:16:01.366  INFO 1 --- [           main] com.shailendra.demo.DemoApplication      : Started DemoApplication in 2.247 seconds (JVM running for 2.587)
~~~

4. Test the application
~~~
curl localhost:8080/test
Response received from Conatiner : 9c958ec27743
~~~

5. Push the image to the quay repo.
~~~
podman push quay.io/<user_ID>/sample:v0.1 
~~~
