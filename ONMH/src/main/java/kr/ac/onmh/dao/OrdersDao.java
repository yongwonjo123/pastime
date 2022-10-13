package kr.ac.onmh.dao;

import java.util.List;

import kr.ac.onmh.model.Orders;
import kr.ac.onmh.util.Pager;

public interface OrdersDao {

	void add(Orders item);

	void delete(int code);

	Orders item(int code);

	int total(Pager pager);

	List<Orders> list(Pager pager);

	void update(Orders item);

	

}
