默认scope是singleton。

无状态的bean使用该scope。

有状态的bean使用prototype。

有状态和无状态会话bean的本质区别是它们的生命期。


singleton: 在Spring的IoC容器中只存在一个对象实例，所有该对象的引用都共享这个实例。Spring 容器只会创建该bean定义的唯一实例，这个实例会被保存到缓存中，并且对该bean的所有后续请求和引用都将返回该缓存中的对象实例，一般情况下，无状态的bean使用该scope。

prototype:每次对该bean的请求都会创建一个新的实例，一般情况下，有状态的bean使用该scope。
request：每次http请求将会有各自的bean实例，类似于prototype。
session：在一个http session中，一个bean定义对应一个bean实例。
global session：在一个全局的http session中，一个bean定义对应一个bean实例。典型情况下，仅在使用portlet context的时候有效。