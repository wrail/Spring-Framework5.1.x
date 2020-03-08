package aop;
/*
 * @Author  Wrial
 * @Date Created in 22:53 2019/12/9
 * @Description Aop测试类
 */

import aop.config.AopConfiguration;
import aop.dao.Dao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * spring 用aop或cglib是动态代理，动态织入的
 * aspectJ是编译时织入的，静态代理
 */
public class TestAop {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext
				= new AnnotationConfigApplicationContext(AopConfiguration.class);
//		annotationConfigApplicationContext.getBean(AopDao.class).query("s");
		Dao orderDao =(Dao) annotationConfigApplicationContext.getBean("orderDao");
		orderDao.query();
	}

}
