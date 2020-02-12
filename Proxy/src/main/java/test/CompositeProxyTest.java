package test;
/*
 * @Author  Wrial
 * @Date Created in 13:02 2019/12/15
 * @Description
 */

import CompositeProxy.OrderDaoLogImpl;
import ExtendProxy.UserDaoImplLogProxy;
import dao.OrderDao;
import dao.OrderDaoImpl;
import dao.UserDaoImpl;
import proxy.ProxyUtils;

import java.lang.reflect.Proxy;

public class CompositeProxyTest {

	public static void main(String[] args) {

//		OrderDao orderDao = new OrderDaoLogImpl(new OrderDaoImpl());
//		orderDao.query();

		OrderDao orderDao = (OrderDao)ProxyUtils.newInstance(new OrderDaoImpl());
		orderDao.query();



	}
}
