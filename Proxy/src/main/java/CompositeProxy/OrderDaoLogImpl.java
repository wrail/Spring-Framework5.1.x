package CompositeProxy;
/*
 * @Author  Wrial
 * @Date Created in 13:15 2019/12/15
 * @Description
 */

import dao.OrderDao;

public class OrderDaoLogImpl implements OrderDao {


	//此为装饰者模式，通过构造方法传入对象参数。聚合方法
	private OrderDao orderDao;

	public OrderDaoLogImpl(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	@Override
	public void query() {
		System.out.println("----------Log-----------");
		orderDao.query();
	}
}
