## 题目

检查一下自己维护的业务系统的JVM参数配置，用jstat和jstack、jmap查看一下详情，并且自己独立分析一下大概情况，思考有没有不合理的地方，如何改进。

注意：如果没有线上系统，可以自己 run 一个 web/java 项目。

## 工具说明

项目地址： https://github.com/bonigarcia/mastering-junit5 

java -jar -XX:+UseG1GC -XX:MaxGCPauseMillis=50 target/junit5-spring-boot-web-1.0.0.jar


