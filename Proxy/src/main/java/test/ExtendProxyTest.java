package test;
/*
 * @Author  Wrial
 * @Date Created in 13:02 2019/12/15
 * @Description
 */

import ExtendProxy.UserDaoImplLogProxy;
import dao.UserDaoImpl;

public class ExtendProxyTest {

	public static void main(String[] args) {
		//UserDaoImplLogProxy是代理对象  UserDaoImpl是目标对象 因此代理并不是只改变方法，它是通过另一个类来实现目标需求
		UserDaoImpl userDao = new UserDaoImplLogProxy();
		userDao.query();

	}
}
