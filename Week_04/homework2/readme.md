# （必做）思考有多少种方式，在main函数启动一个新线程，运行一个方法，拿到这个方法的返回值后，退出主线程？

1. 硬等待(干等):Thread.sleep\CountDownLatch\CyclicBarrier
2. 回调 Future\FutureTask\CompletableFuture
3. 锁  ReentrantLock\synchronized 好像都要等wait