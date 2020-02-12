package ExtendProxy;
/*
 * @Author  Wrial
 * @Date Created in 13:01 2019/12/15
 * @Description UserDaoImpl的代理类
 */

import dao.UserDaoImpl;

public class UserDaoImplLogProxy extends UserDaoImpl {

	@Override
	public void query() {
		System.out.println("--------Log---------");
		super.query();
	}
}
