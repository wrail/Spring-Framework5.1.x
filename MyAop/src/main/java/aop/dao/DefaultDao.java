package aop.dao;
/*
 * @Author  Wrial
 * @Date Created in 12:34 2019/12/15
 * @Description
 */

import org.springframework.stereotype.Repository;

@Repository
public class DefaultDao implements Dao{
	@Override
	public void query() {
		System.out.println("default Dao!");
	}
}
