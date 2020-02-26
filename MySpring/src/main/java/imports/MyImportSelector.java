package imports;
/*
 * @Author  Wrial
 * @Date Created in 21:47 2020/2/26
 * @Description
 */

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 有选择的导入某个类，通过返回这个class的name
 * 如SpringBoot中的@Enable就是根据此来实现的
 */
public class MyImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{MyIndexDao.class.getName()};
	}
}
