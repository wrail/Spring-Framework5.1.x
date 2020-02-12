package anno;
/*
 * @Author  Wrial
 * @Date Created in 13:43 2019/12/9
 * @Description 自定义注解
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/*
ElementType.TYPE 代表可以出现在类上
@Retention()可以定义注解的生命周期
RetentionPolicy.SOURCE --只存在源文件中，编译后就消失
RetentionPolicy.CLASS --可以存活到Class文件中，但是在代码运行时还是会消失
RetentionPolicy.RUNTIME -- 可以存活到执行时期

 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {

	//如果没有default那么在类上使用此注解的话必须要value=xx
	String value() default "";

}
