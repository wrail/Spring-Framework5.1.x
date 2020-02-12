package util;
/*
 * @Author  Wrial
 * @Date Created in 13:49 2019/12/9
 * @Description
 */

import anno.MyAnno;

public class CommonUtil {

	public static void parseAnno(Object o){
		Class<?> aClass = o.getClass();

		//1.判断当前对象是否存在此注解
		if (aClass.isAnnotationPresent(MyAnno.class)){

			//2.如果存在就得到这个注解类
			MyAnno annotation = aClass.getAnnotation(MyAnno.class);
			//3.取出注解里的值
			System.out.println(annotation.value());
		}else {
			System.out.println("不存在注解");
		}

	}


}
