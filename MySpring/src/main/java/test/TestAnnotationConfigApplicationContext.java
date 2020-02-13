package test;
/*
 * @Author  Wrial
 * @Date Created in 21:27 2020/2/13
 * @Description
 */

import org.spring.utils.AnnotationConfigApplicationContext;

public class TestAnnotationConfigApplicationContext {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.wrial.service");
	}
}
