package mybatis.dao;
/*
 * @Author  Wrial
 * @Date Created in 14:39 2020/2/25
 * @Description
 */

import mybatis.anno.Select;

import java.util.List;
import java.util.Map;

public interface IndexDao {

	@Select("select * from student")
	List<Map<Integer,String>> list(String string);
}
