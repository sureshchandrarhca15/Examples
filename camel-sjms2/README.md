Camel-Sjms2 example with delivery delay.

1. Start AMQ 7.x/ Artemis 
2. Run the exmaple with mvn clean install camel:run

#Camel logs
~~~~~
[text1) thread #2 - timer://foo] amqp-consumer                  INFO  Sending message with delay
~~~~~~

#Queue stat
~~~~~
|NAME                     |ADDRESS                  |CONSUMER_COUNT |MESSAGE_COUNT |MESSAGES_ADDED |DELIVERING_COUNT |MESSAGES_ACKED |SCHEDULED_COUNT |ROUTING_TYPE |
|Queue1                   |Queue1                   |0              |1             |1              |0                |0              |1               |ANYCAST      |
~~~~~~
