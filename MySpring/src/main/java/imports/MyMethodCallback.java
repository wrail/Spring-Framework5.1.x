package imports;
/*
 * @Author  Wrial
 * @Date Created in 15:40 2020/3/3
 * @Description
 */

import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用Cglib进行代理
 * 为什么源码中给Configuration不用JDK动态代理，因为JDK动态代理是基于接口的，配置类不一定实现接口
 */
public class MyMethodCallback implements MethodInterceptor {

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("Before MethodInterceptor__________");
		//调用父类方法
		o =  methodProxy.invokeSuper(o, objects);
		System.out.println("After MethodInterceptor__________");
		return o;

	}
}
