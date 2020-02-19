package lifecycle;
/*
 * @Author  Wrial
 * @Date Created in 22:37 2019/12/8
 * @Description
 */


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext
				= new AnnotationConfigApplicationContext();

		applicationContext.register(Config.class);

		//Spring初始会注册七个bean给Map

		//加入自定义的BeanFactory后置处理器   有这个可以省略@Component注解
		applicationContext.addBeanFactoryPostProcessor(new TestBeanFactoryPostProcessor());
		applicationContext.refresh();
		IndexDao bean = applicationContext.getBean(IndexDaoImpl1.class);
		IndexDao bean1 = applicationContext.getBean(IndexDaoImpl1.class);
		System.out.println(bean.hashCode()==bean1.hashCode());


	}
}
