package aop.config;

import aop.dao.Dao;
import aop.dao.DefaultDao;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/*
 * @Author  Wrial
 * @Date Created in 23:00 2019/12/9
 * @Description
 */
@Component
@Aspect
public class DeclareAspect {


	/**
	 * 切点 扫aop包下包括子包的所有方法
	 *
	 * execution最强大可以筛选特性访问控制符，包，特定方法名，参数等
	 * within最小的作用粒度是类
	 */
	@Pointcut("execution(* aop..*.*(..))")
	public void pointCut(){
	}

	/**
	 * aop包下的类
	 */
	@Pointcut("within(aop.*)")
	public void within(){
	}

	/**
	 * 如果参数是String就生效
	 */
	@Pointcut("args(java.lang.String))")
	public void args(){
	}

	/**
	 * 通知到那个切点去  可以使用 || && ! 连接
	 */
	@Before("pointCut() && !args()")
	public void BeforeAdvice(){
		System.out.println("Before");
	}

	@After("pointCut()")
	public void AfterAdvice(){
		System.out.println("After");
	}



	//默认父类实现
//	@DeclareParents(value = "aop.dao.OrderDao", defaultImpl = DefaultDao.class)
//	public static Dao dao;

}
