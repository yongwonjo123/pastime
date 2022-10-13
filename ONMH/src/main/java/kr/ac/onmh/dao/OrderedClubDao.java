package kr.ac.onmh.dao;

import java.util.List;

import kr.ac.onmh.model.OrderedClub;
import kr.ac.onmh.util.Pager;

public interface OrderedClubDao {

	void add(OrderedClub item);

	void delete(int code);
	
	void update(OrderedClub item);

	OrderedClub item(int code);
	
	List<OrderedClub> list(Pager pager);

}
