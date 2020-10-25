# 根据上述自己对于1和2的演示，写一段对于不同 GC 的总结

## 总结

JVM的内存有很多控制参数，不同的`场景`会有不同的控制方式。以及各种GC，有的在内存比较大的情况下表现好，有的适合内存较小的情况，比如G1和并行GC。不知道这样理解有没有问题。

老师还有很多话没记住

## 参考和工具：
- https://dzone.com/articles/java-memory-management
- https://github.com/micrometer-metrics/micrometer
- [Eclipse MAT](https://www.eclipse.org/mat/)
- https://blog.gceasy.io/2015/08/14/how-to-capture-heap-dump-jmap/
- [jhat](https://blog.gceasy.io/2015/08/28/jhat-heap-dump-analysis/)

> jmap -dump:live,file=<file-path> <pid>
> 
> where
> pid: is the Java Process Id, whose heap dump should be captured
> file-path: is the file path where heap dump will be written in to.
直接输出
```
jmap -dump:live,file=test.bin <pid>
```
用在程序启动：
```
-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/logs/heapdump
```

> jhat -J-Xmx -port  
> where
> memory-size: JVM argument. memory size with which JVM needs to be launched
> port-number: Port in which jhat web application can be accessed 
> file-path: Location of Heap dump file

```
jhat -J-Xmx2g -port 7001 /opt/workspace/tier1app/artifacts/LeakingMap/heapDump-2.bin
```

- http://localhost:7001/histo/
- http://localhost:7001/histo/size