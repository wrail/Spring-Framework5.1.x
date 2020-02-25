package mybatis.dao;
/*
 * @Author  Wrial
 * @Date Created in 20:01 2020/2/25
 * @Description
 */

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class IndexDaoImpl implements IndexDao {

	@Override
	public List<Map<Integer, String>> list(String string) {
		System.out.println("IndexDaoImpl");
		return null;
	}
}
