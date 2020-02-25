package mybatis.anno;
/*
 * @Author  Wrial
 * @Date Created in 14:34 2020/2/25
 * @Description 自定义的MapperScan
 */

import mybatis.config.MyImportDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MyImportDefinitionRegistrar.class)
public @interface MyMapperScan {
}
