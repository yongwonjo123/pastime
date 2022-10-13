package kr.ac.onmh.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<OrderedClub> list;
	private int total;
	
	public Cart() {
		list = new ArrayList<>();
	}
	public int getTotal() {
		return total;
	}
	public List<OrderedClub> getList(){
		return list;
	}
	
	
	public void add(OrderedClub item, int amount) {
		list.add(item);
		total += item.getPrice() * amount;
	}
	
}
