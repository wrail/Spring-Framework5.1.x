package test;
/*
 * @Author  Wrial
 * @Date Created in 22:47 2019/12/2
 * @Description
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

@Component("bfpp")
public class TestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("自定义BeanFactoryPostProcessor");
		GenericBeanDefinition app = (GenericBeanDefinition)beanFactory.getBeanDefinition("app");
		System.out.println("当前spring容器的bean"+app.getBeanClassName());
		app.setBeanClass(DemoDao.class);
		System.out.println("偷梁换柱后当前spring容器的bean"+app.getBeanClassName());

	}
}
