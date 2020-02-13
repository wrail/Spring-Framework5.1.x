package org.spring.utils;
/*
 * @Author  Wrial
 * @Date Created in 22:24 2020/2/12
 * @Description 模拟注解版的
 */

import anno.Wa;

import java.io.File;

public class AnnotationConfigApplicationContext {


	/**
	 * 容器扫描方法
	 *
	 * @param basePackage 包名
	 */
	public void scan(String basePackage) {

		//得到类的根路径，作为ClassPath随生产环境而变
		String rootClassPath = this.getClass().getResource("/").getPath();
		//转换所有的点为   \\
		String basePackagePath = basePackage.replaceAll("\\.", "\\\\");
		File file = new File(rootClassPath + "//" + basePackagePath);
		String[] names = file.list();
		try {
			for (String name : names) {
				name = name.replaceAll(".class", "");
				Class<?> clazz = Class.forName(basePackage + "." + name);
				if (clazz.isAnnotationPresent(Wa.class)) {
					Wa wa = clazz.getAnnotation(Wa.class);
					System.out.println(wa.value());
					System.out.println(clazz.newInstance());
				}else {
					System.out.println("没有要扫描的类");
				}

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}


	}
}
