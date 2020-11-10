# （选做）请思考：什么是并发？什么是高并发？实现高并发高可用系统需要考虑哪些因素，对于这些你是怎么理解的？

并发就是多个事情同时发生，就像一个故事里同时有多条主线，主人公处在事件的漩涡中，难以自拔，观众看的欲罢不能。

高并发就是普通的故事是2-3条主线，多了4-5条也可以，但是偏偏导演一下子搞了20几条‘主线’，观众不仅看不懂故事，连演员的脸都分不清了，好多观众只看了开始就弃剧了。

实现高并发高可用，我猜（真没经历过这种场景）要分解业务，故事要一点一点讲，并且各个子业务之间要形成一个顺路，不能产生闭环。各个业务是可以同时处理，但是基本的顺序还是不能出现错误的。

个人觉得，高并发主要需要解决‘量’的问题，也是处理能力的问题，必须可以通过‘加机器’解决突发的大流量。同时，还要保证防止出现业务上的‘争抢’、‘超发’问题。比如红包和秒杀场景。

关于原子性问题，函数式编程大多都是强调‘值’传递，不知道Java可不可以搞纯值传递的方式，对于目前看到的各种锁，貌似都是在处理多个线程同时修改或访问同一处的引用的问题。还是说老师说的那个传递参数都要求用final就是这种值传递的思路？对于之前学的内容的理解，如果程序全部都改成用final类型的参数和属性，是会产生大量的垃圾吗？