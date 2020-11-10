# （选做）列举常用的并发操作 API 和工具类，简单分析其使用场景和优缺点。

因为没怎么做过底层框架的工作，以及涉及到类似‘高’并发的业务场景。对API和工具类了解不多。包括volatile和synchronized关键字也都是跟了课程才知道的。

虽然我可以通过搜索找到一些答案，但最大的希望就是不要被要求把这些东西都‘背’下来。

虽然很希望老师能带着做几个例子，但是深知手撸示例有多么耗时间，特别是学员还是那种能力比较差的情况。

线程的启动使用工厂或线程池，或者直接用stream里的，这里就有一个疑问了，大公司正常的项目有直接使用Thread而不用线程池的吗？

线程交互，各种锁。

Java concurrency API
The Java programming language has a very rich concurrency API. It contains classes to manage the basic elements of concurrency, such as Thread, Lock, and Semaphore, and classes that implement very high-level synchronization mechanisms, such as the executor framework or the new parallel Stream API.

In this section, we will cover the basic classes that form the concurrency API.

Basic concurrency classes
The basic classes of the Java concurrency API are:

The Thread class: This class represents all the threads that execute a concurrent Java application

The Runnable interface: This is another way to create concurrent applications in Java

The ThreadLocal class: This is a class to store variables locally to a thread

The ThreadFactory interface: This is the base of the Factory design pattern that you can use to create customized threads

Synchronization mechanisms
The Java concurrency API includes different synchronization mechanisms that allow you to:

Define a critical section to access a shared resource

Synchronize different tasks in a common point

The following mechanisms are considered to be the most important synchronization mechanisms:

The synchronized keyword: The synchronized keyword allows you to define a critical section in a block of code or in an entire method.

The Lock interface: Lock provides a more flexible synchronization operation than the synchronized keyword. There are different kinds of Locks: ReentrantLock, to implement a Lock that can be associated with a condition; ReentrantReadWriteLock, which separates read and write operations; and StampedLock, a new feature of Java 8 that includes three modes for controlling read/write access.

The Semaphore class: The class that implements the classical semaphore to implement synchronization. Java supports binary and general semaphores.

The CountDownLatch class: A class that allows a task to wait for the finalization of multiple operations.

The CyclicBarrier class: A class that allows the synchronization of multiple threads in a common point.

The Phaser class: A class that allows you to control the execution of tasks divided into phases. None of the tasks advance to the next phase until all of the tasks have finished the current phase.

Executors
The executor framework is a mechanism that allows you to separate thread creation and management for the implementation of concurrent tasks. You don't have to worry about the creation and management of threads, only about creating tasks and sending them to the executor. The main classes involved in this framework are:

The Executor and ExecutorService interface: They include methods common to all executors.

ThreadPoolExecutor: This is a class that allows you to get an executor with a pool of threads and optionally define a maximum number of parallel tasks

ScheduledThreadPoolExecutor: This is a special kind of executor to allow you to execute tasks after a delay or periodically

Executors: This is a class that facilitates the creation of executors

The Callable interface: This is an alternative to the Runnable interface—a separate task that can return a value

The Future interface: This is an interface that includes the methods to obtain the value returned by a Callable interface and to control its status

The Fork/Join framework
The Fork/Join framework defines a special kind of executor specialized in the resolution of problems with the divide and conquer technique. It includes a mechanism to optimize the execution of the concurrent tasks that solve these kinds of problems. Fork/Join is specially tailored for fine-grained parallelism as it has a very low overhead in order to place the new tasks into the queue and take queued tasks for execution. The main classes and interfaces involved in this framework are:

ForkJoinPool: This is a class that implements the executor that is going to run the tasks

ForkJoinTask: This is a task that can be executed in the ForkJoinPool class

ForkJoinWorkerThread: This is a thread that is going to execute tasks in the ForkJoinPool class

Parallel streams
Streams and Lambda expressions are maybe the two most important new features of the Java 8 version. Streams have been added as a method in the Collection interface and other data sources and allow processing all elements of a data structure, generating new structures, filtering data and implementing algorithms using the map and reduce technique.

A special kind of stream is a parallel stream which realizes its operations in a parallel way. The most important elements involved in the use of parallel streams are:

The Stream interface: This is an interface that defines all the operations that you can perform on a stream.

Optional: This is a container object that may or may not contain a non-null value.

Collectors: This is a class that implements reduction operations that can be used as part of a stream sequence of operations.

Lambda expressions: Streams has been thought to work with Lambda expressions. Most stream methods accept a lambda expression as a parameter. This allows you to implement a more compact version of the operations.

Concurrent data structures
Normal data structures of the Java API (ArrayList, Hashtable, and so on) are not ready to work in a concurrent application unless you use an external synchronization mechanism. If you use it, you will be adding a lot of extra computing time to your application. If you don't use it, it's probable that you will have race conditions in your application. If you modify them from several threads and a race condition occurs, you may experience various exceptions thrown (such as, ConcurrentModificationException and ArrayIndexOutOfBoundsException), there may be silent data loss or your program may even stuck in an endless loop.

The Java concurrency API includes a lot of data structures that can be used in concurrent applications without risk. We can classify them in two groups:

Blocking data structures: These include methods that block the calling task when, for example, the data structure is empty and you want to get a value.

Non-blocking data structures: If the operation can be made immediately, it won't block the calling tasks. Otherwise, it returns the null value or throws an exception.

These are some of the data structures:

ConcurrentLinkedDeque: This is a non-blocking list

ConcurrentLinkedQueue: This is a non-blocking queue

LinkedBlockingDeque: This is a blocking list

LinkedBlockingQueue: This is a blocking queue

PriorityBlockingQueue: This is a blocking queue that orders its elements based on its priority

ConcurrentSkipListMap: This is a non-blocking navigable map

ConcurrentHashMap: This is a non-blocking hash map

AtomicBoolean, AtomicInteger, AtomicLong, and AtomicReference: These are atomic implementations of the basic Java data types

## 参考资料

- https://subscription.packtpub.com/book/application_development/9781785886126/1/ch01lvl1sec11/java-concurrency-api
- http://tutorials.jenkov.com/java-concurrency/index.html
- https://www.vogella.com/tutorials/JavaConcurrency/article.html