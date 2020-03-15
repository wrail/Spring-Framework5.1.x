package mybatis.config;
/*
 * @Author  Wrial
 * @Date Created in 14:57 2020/2/25
 * @Description
 */

import lifecycle.Test;
import mybatis.dao.IndexDao;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;



public class MyImportDefinitionRegistrar implements ImportBeanDefinitionRegistrar {


	//修改FactoryBean的定义
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(IndexDao.class);
		GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanDefinitionBuilder.getBeanDefinition();
		System.out.println(beanDefinition.getBeanClassName());
		//传入beanDefinition.getBeanClassName()
		// 给构造方法中添加一个参数
		beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("mybatis.dao.IndexDao");
		beanDefinition.setBeanClass(MyFactoryBean.class);
		registry.registerBeanDefinition("indexDao",beanDefinition);

	}
}
