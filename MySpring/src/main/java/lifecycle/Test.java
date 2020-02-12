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
		AnnotationConfigApplicationContext context
				= new AnnotationConfigApplicationContext(Config.class);



	}
}
