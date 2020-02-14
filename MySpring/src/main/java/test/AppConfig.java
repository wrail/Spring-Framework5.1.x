package test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component("app")
@ComponentScan("test")
public class AppConfig {
	public void print(){
		System.out.println("测试成功~！");
	}
}