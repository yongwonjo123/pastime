package kr.ac.onmh.service;

import java.util.List;

import kr.ac.onmh.model.Orders;
import kr.ac.onmh.util.Pager;

public interface OrdersService {

	void add(Orders item);
	void delete(int code);
	void update(Orders item);
	Orders item(int code);
	List<Orders> list (Pager pager);
	

}
