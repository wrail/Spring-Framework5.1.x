package imports;
/*
 * @Author  Wrial
 * @Date Created in 22:18 2020/2/26
 * @Description
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("imports")
@Import(MyImportSelector.class)
public class Config {

	@Bean
	public MyIndexDao1 myIndexDao1(){
		return new MyIndexDao1();
	}

	//如果不加Configuration注解，MyIndexDao1就会初始化两次
	//加注解会产生cglib代理，会通过beanAware获取BeanF，然后getBean，不过不加就不会这样，会根据方法来进行注册
	//但是如果把myIndexDao1方法设置为static，那么又会去调用两次了
	@Bean
	public MyIndexDao indexDao(){
		myIndexDao1();
		return new MyIndexDao();
	}
}
