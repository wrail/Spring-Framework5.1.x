package aop.dao;

import org.springframework.stereotype.Repository;

/*
 * @Author  Wrial
 * @Date Created in 22:58 2019/12/9
 * @Description
 */
@Repository
public class AopDao implements Dao {

	public void query(){
		System.out.println("dao query");
	}
}
