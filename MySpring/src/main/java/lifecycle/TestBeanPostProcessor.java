package lifecycle;
/*
 * @Author  Wrial
 * @Date Created in 22:40 2020/2/14
 * @Description 照此来看还是很重要的一个接口，比如AOP就是通过这个接口完成的，在方法中加入代理然后返回代理对象
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

//@Component
public class TestBeanPostProcessor implements BeanPostProcessor, PriorityOrdered {

	/**
	 * 初始化前
	 * @param bean the new bean instance
	 * @param beanName the name of the bean
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("indexDaoImpl")){
			System.out.println("postProcessBeforeInitialization");
		}

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("indexDaoImpl")){
			System.out.println("postProcessAfterInitialization");
		}
		return bean;
	}

	/**
	 * 控制这些BeanPostProcessor的优先顺序，值越小越优先
	 * @return
	 */
	@Override
	public int getOrder() {
		return 0;
	}
}
