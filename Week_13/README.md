# 学习笔记

## 课上相关
https://kimmking.blog.csdn.net/article/details/6577021

动态改变Kafka分区，会造成系统抖动

3副本5副本7副本

topic 分多少个 partition，单机不建议大量partition


> 单个机器上，不建议有大量的partition，，，，也不建议有大量的topic，，，，，因为他们对应着一个数据文件。。。====> 单个机器上，数据文件大了，就意味着，随机io读写了。

partition 10个左右，太多会造成随机读写

https://www.zhihu.com/question/300144434


> 全局有序，一个topic一个partition

topic理解成数据库的数据库名吗？
> topic --> table
> message -->  row
> partition --> sharding/partition

拉消息的间隔可以设成0吗？

> 一般是上一个批次消费完，就去拉取下一批次，但是会设置一个等待时间，比如等n个毫秒, 如果此partition没有消息，则会阻塞等待n毫秒看看有没有消息到来。

> 多节点、多副本、多确认

如何防止重复消费

>  1、业务处理幂等，，，2、业务处理之前做去重，roaring bitmap

MapStruct

### 忏悔

连续一个月没有跟上做作业的进度，这期间都忙什么了呢？公司上的事情，用jhispter搞了个小项目，学习了一下angular，以及d3、echart。倒是把redis的锁用在了公司的一个项目的手机登录验证上面，为了做这个登录学习了spring security相关的东西。MapStruct这个东西在jhipster里有用到，但是对idea支持不好，至少jhipster6.10版本还没有把MapStruct更新到适配idea的版本，需要手动升级一下。