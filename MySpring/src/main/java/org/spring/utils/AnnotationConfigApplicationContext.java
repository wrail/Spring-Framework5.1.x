package org.spring.utils;
/*
 * @Author  Wrial
 * @Date Created in 22:24 2020/2/12
 * @Description 模拟注解版的
 */

public class AnnotationConfigApplicationContext {

	public void scan(String basePackage){
		basePackage = basePackage.replace("\\.","\\/");
	}
}
