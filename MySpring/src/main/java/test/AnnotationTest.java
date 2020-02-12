package test;
/*
 * @Author  Wrial
 * @Date Created in 14:59 2019/12/2
 * @Description
 */

import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AnnotationTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(AppConfig.class);
		applicationContext.scan();
		System.out.println(applicationContext.getBean(AppConfig.class));

//
//		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
//		rootBeanDefinition.setParentName("xxx");
//		rootBeanDefinition.setScope("Prototype");

//		ClassPathXmlApplicationContext
//		FileSystemXmlApplicationContext

	}
}
