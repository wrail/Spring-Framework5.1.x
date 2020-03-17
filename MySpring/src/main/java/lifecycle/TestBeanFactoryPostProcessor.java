package lifecycle;
/*
 * @Author  Wrial
 * @Date Created in 21:27 2020/2/18
 * @Description
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * 例如：自定义修改某某bean为原型模式
 */

//@Component
public class TestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		AnnotatedBeanDefinition indexDao = (AnnotatedBeanDefinition)beanFactory.getBeanDefinition("indexDaoImpl1");
		indexDao.setScope(BeanDefinition.SCOPE_PROTOTYPE);
	}
}
