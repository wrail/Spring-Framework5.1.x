package mybatis.config;
/*
 * @Author  Wrial
 * @Date Created in 14:42 2020/2/25
 * @Description
 */

import mybatis.anno.MyMapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("mybatis")
//可以将下面放在注解里
//@Import(MyImportDefinitionRegistrar.class)
@MyMapperScan
public class MyConfig {
}
