package mybatis.test;
/*
 * @Author  Wrial
 * @Date Created in 14:32 2020/2/25
 * @Description  模拟Mybatis
 */

import mybatis.config.MyConfig;
import mybatis.dao.IndexDao;
import mybatis.dao.IndexDaoImpl;
import mybatis.service.IndexService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		// 加载自定义的配置类
		AnnotationConfigApplicationContext applicationContext
				= new AnnotationConfigApplicationContext(MyConfig.class);
	/*	IndexDao dao = (IndexDao) applicationContext.getBean("indexDao");
		dao.list();*/
	applicationContext.getBean(IndexService.class).printIndexDao();
	}
}
