package imports;
/*
 * @Author  Wrial
 * @Date Created in 22:19 2020/2/26
 * @Description
 */


import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(Config.class);
		//context.getBean(MyIndexDao.class).query();


		Enhancer enhancer = new Enhancer();
		//增强父类，给代理类设置父类为当前配置类并进行增强（由此可见Cglib是基于继承而来的）
		//要代理谁就设置为谁
		enhancer.setSuperclass(MyIndexDao.class);

		enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);

		enhancer.setCallback(new MyMethodCallback());

		IndexDao indexDao = (IndexDao) enhancer.create();
		//对子类所有方法进行拦截打印
		indexDao.query();



	}
}
