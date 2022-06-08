# Rabiit mq
*** 

RabbitMQ is a message broker: it accepts and forwards messages.

* **Producing** means nothing more than **sending**. A program that sends messages is a producer
* A **queue** is the name for a post box which lives inside RabbitMQ. Although messages flow through RabbitMQ and your applications, they can only be stored inside a queue. A queue is only bound by the host's memory & disk limits, it's essentially a large message buffer. Many producers can send messages that go to one queue, and many consumers can try to receive data from one queue. 
* **Consuming** has a similar meaning to receiving. A consumer is a program that mostly waits to receive messages:

