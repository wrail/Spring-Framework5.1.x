package imports;
/*
 * @Author  Wrial
 * @Date Created in 22:19 2020/2/26
 * @Description
 */


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(Config.class);
		context.getBean(MyIndexDao.class).query();

	}
}
