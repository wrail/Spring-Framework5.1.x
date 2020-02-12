package lifecycle;
/*
 * @Author  Wrial
 * @Date Created in 22:34 2019/12/8
 * @Description
 */

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/*
Bean的回调
1.实现InitializingBean, DisposableBean接口
2.xml中配置init-method="init"  在Bean的方法中写一个名为init的方法
3.注解配置，在方法上加上@PostConstruct,@PreDestroy
 */

/*
@Lazy 懒加载 ，用的时候才进行加载
 */

@Repository

public class IndexDaoImpl implements IndexDao {

	public IndexDaoImpl(){
		System.out.println("IndexDaoImpl无参构造");
	}

	@PostConstruct
	public void init(){
		System.out.println("init");
	}

}
