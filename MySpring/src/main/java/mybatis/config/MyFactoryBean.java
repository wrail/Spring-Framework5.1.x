package mybatis.config;
/*
 * @Author  Wrial
 * @Date Created in 14:45 2020/2/25
 * @Description
 */

import mybatis.anno.Select;
import mybatis.dao.IndexDao;
import org.springframework.beans.factory.FactoryBean;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class MyFactoryBean implements FactoryBean<Object>, InvocationHandler {

	Class<?> clazz;
	public MyFactoryBean(Class<?> clazz){
		this.clazz = clazz;
	}

	@Override
	public Object getObject(){

		Class<?>[] classes = new Class<?>[]{clazz};
		IndexDao object = (IndexDao)Proxy.newProxyInstance(clazz.getClassLoader(),classes,this);
		return object;
	}

	@Override
	public Class<?> getObjectType() {
		return clazz;
	}

	/**
	 * 动态代理需要实现的方法
	 * @param proxy
	 * @param method
	 * @param args
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Proxy————————————————————————————————————————");
		Method method1 = proxy.getClass().getInterfaces()[0].getMethod(method.getName(), String.class);
		Select select = method1.getDeclaredAnnotation(Select.class);
		System.out.println(select.value());
		return null;
	}

}
