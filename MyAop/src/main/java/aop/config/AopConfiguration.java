package aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/*
 * @Author  Wrial
 * @Date Created in 22:54 2019/12/9
 * @Description
 */

/*
开启AspectJ自动代理
 */
@Configuration
@EnableAspectJAutoProxy   //这个注解核心就是给spring添加一个可以处理aop的后置处理器
@ComponentScan("aop")

public class AopConfiguration {
}
