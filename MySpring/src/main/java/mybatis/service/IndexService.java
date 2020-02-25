package mybatis.service;
/*
 * @Author  Wrial
 * @Date Created in 14:39 2020/2/25
 * @Description
 */

import mybatis.dao.IndexDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IndexService {

	@Autowired
	IndexDao indexDao;

	public void printIndexDao(){
		indexDao.list("___________");
	}

}
