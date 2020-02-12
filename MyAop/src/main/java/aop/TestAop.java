package aop;
/*
 * @Author  Wrial
 * @Date Created in 22:53 2019/12/9
 * @Description Aop测试类
 */

import aop.config.AopConfiguration;
import aop.dao.AopDao;
import aop.dao.Dao;
import aop.dao.DefaultDao;
import aop.dao.OrderDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAop {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext
				= new AnnotationConfigApplicationContext(AopConfiguration.class);
//		annotationConfigApplicationContext.getBean(AopDao.class).query("s");
		Dao orderDao =(Dao) annotationConfigApplicationContext.getBean("orderDao");
		orderDao.query();
	}

}
