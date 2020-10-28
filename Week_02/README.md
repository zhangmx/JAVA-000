学习笔记

这周讲了NIO，之前一直学各种偏业务方面的东西，这种物件还真没用过，或者用过，也是在不知情的情况下。

---

## 周作业

1. [使用 GCLogAnalysis.java 自己演练一遍串行/并行/CMS/G1的案例。](homework_1)
2. [使用压测工具（wrk或sb），演练gateway-server-0.0.1-SNAPSHOT.jar 示例。](homework_2)[总结](homework_2&1_summary/readme.md)
3. [(选做)如果自己本地有可以运行的项目，可以按照2的方式进行演练。](homework_3)
4. [(可选)运行课上的例子，以及Netty的例子，分析相关现象。](homework_4)
5. [写一段代码，使用HttpClient或OkHttp访问 http://localhost:8801](homework_5)

## Windows

1.管理员身份打开powershell

2.运行
Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))

3.执行choco install superbenchmarker

4.输入 sb

执行 sb -u http://localhost:8088/api/hello -c 20 -N 60

## Mac

1.执行brew install wrk
如果显式brew update很慢，可以ctrl+C打断更新

2.输入 wrk

执行 wrk -t8 -c40 -d60s http://localhost:8088/api/hello
