package lifecycle;
/*
 * @Author  Wrial
 * @Date Created in 22:37 2019/12/8
 * @Description
 */

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext
				= new AnnotationConfigApplicationContext();

		applicationContext.register(Config.class);
		applicationContext.refresh();

		//加入自定义的BeanFactory后置处理器
		applicationContext.addBeanFactoryPostProcessor(new TestBeanFactoryPostProcessor());

		IndexDao bean = applicationContext.getBean(IndexDaoImpl1.class);
		IndexDao bean1 = applicationContext.getBean(IndexDaoImpl1.class);
		System.out.println(bean.hashCode()==bean1.hashCode());


	}
}
