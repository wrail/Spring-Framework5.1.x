package anno;
/*
 * @Author  Wrial
 * @Date Created in 21:10 2020/2/13
 * @Description 自定义注解
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//生命周期为运行时
@Retention(RetentionPolicy.RUNTIME)
public @interface Wa {
	public String value();
}
