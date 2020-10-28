# 使用 GCLogAnalysis.java 自己演练一遍串行/并行/CMS/G1的案例。

## 操作记录

```
javac .\GCLogAnalysis.java
```
报错：
![编译错误](images/compiler_error.png)

```
javac -encoding UTF8 .\GCLogAnalysis.java
```
1. 显示GC详情
```
java -XX:+PrintGCDetails GCLogAnalysis
```
![](images/gcdetail_1.png)
2. 记录到日志
```
java -Xloggc:gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
```
3. 模拟OOM
```
java -Xmx128M -XX:+PrintGCDetails GCLogAnalysis
```
MetaSpace基本没有变化![内存分配小了之后，频繁GC直到oom](images/gcdetail_2.png)
4. 512m,1024m,2048m,4086m

```
java -Xmx512M -XX:+PrintGCDetails GCLogAnalysis
java -Xmx1G -XX:+PrintGCDetails GCLogAnalysis
java -Xmx2G -XX:+PrintGCDetails GCLogAnalysis
java -Xmx4G -XX:+PrintGCDetails GCLogAnalysis
```
Xmx 超过一定值后，情况不再变化

![](images/gcdetail_3_512.png)
![](images/gcdetail_4_1G.png)
![](images/gcdetail_5_2G.png)
![](images/gcdetail_6_4G.png)
5. 串行GC
```
java -XX:+UseSerialGC -Xms512m -Xmx512m -Xloggc:gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
java -XX:+UseSerialGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
java -XX:+UseSerialGC -Xms512m -Xmx512m -XX:+PrintGC GCLogAnalysis
```
![](images/gcdetail_7.png)
6. 并行
```
java -XX:+UseParallelGC -Xms512m -Xmx512m -Xloggc:gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
java -XX:+UseParallelGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
java -XX:+UseParallelGC -Xms512m -Xmx512m -XX:+PrintGC GCLogAnalysis
```
![](images/gcdetail_8.png)
7. UseConcMarkSweepGC CMS

```
java -XX:+UseConcMarkSweepGC -Xms512m -Xmx512m -Xloggc:gc.demo.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

java -XX:+UseConcMarkSweepGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
java -XX:+UseConcMarkSweepGC -Xms512m -Xmx512m -XX:+PrintGC GCLogAnalysis
```
![](images/gcdetail_9.png)
8. UseG1GC

```
java -XX:+UseG1GC -Xms512m -Xmx512m -XX:+PrintGC GCLogAnalysis
```
![](images/gcdetail10.png)
4G
```
java -XX:+UseG1GC -Xms4G -Xmx4G -XX:+PrintGC GCLogAnalysis
```
![](images/gcdetail11.png)

## 其他工具

- https://gceasy.io/