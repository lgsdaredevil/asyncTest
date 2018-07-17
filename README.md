# asyncTest
spring boot的异步调用例子



## 异步方法没有执行

AsyncTestService类中写的异步方法没有被执行，当将异步方法单独写在一个类中去引用就可以执行异步方法。

spring对@Transactional注解时也有类似问题，spring扫描时具有@Transactional注解方法的类时，是生成一个代理类，由代理类去开启关闭事务，而在同一个类中，方法调用是在类体内执行的，spring无法截获这个方法调用。 

具体参见：[Spring Boot使用@Async实现异步调用](https://www.cnblogs.com/shihaiming/p/7825204.html)