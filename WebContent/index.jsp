<%@ page language="java" contentType="text/html; charset=Utf-8"
    pageEncoding="Utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
监听器只是初始化和销毁时起作用<br>
过滤器在容器初始化和销毁时起作用<br>
拦截器和过滤器每一次请求都起作用<br>
<a href="control/only"><b>
拦截特殊单一请求：过滤器、拦截器生效；使用监听器初始化生成的dbcp</b>
</a><br>
<a href="http://localhost:8082/tech39SpringFilter/control/get"><b>
拦截全局：过滤器、全局拦截器生效</b><br>
</a>
查看后台输出
<br>
监听器：主要作用是： 做一些初始化的内容添加工作、设置一些基本的内容、比如一些参数或者是一些固定的对象等等。
<br>
过滤器和拦截器的区别：
<br>①拦截器是基于java的反射机制的，而过滤器是基于函数回调。
<br>②拦截器不依赖与servlet容器，过滤器依赖与servlet容器。
<br>③拦截器只能对action请求起作用，而过滤器则可以对几乎所有的请求起作用。
<br>④拦截器可以访问action上下文、值栈里的对象，而过滤器不能访问。
<br>⑤在action的生命周期中，拦截器可以多次被调用，而过滤器只能在容器初始化时被调用一次。
<br>⑥拦截器可以获取IOC容器中的各个bean，而过滤器就不行，这点很重要，在拦截器里注入一个service，可以调用业务逻辑。
</body>
</html>