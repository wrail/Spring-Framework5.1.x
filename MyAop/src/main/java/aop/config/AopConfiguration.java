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
@EnableAspectJAutoProxy
@ComponentScan("aop")
public class AopConfiguration {
}
