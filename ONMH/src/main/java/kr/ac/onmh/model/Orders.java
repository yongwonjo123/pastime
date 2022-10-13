package kr.ac.onmh.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Orders {
	// 주문 코드
	private int code;
	//주문한 회원 id
	private String id;
	//주문 날짜
	private Date date;
	//결제 금액
	private int price;
	//주문 여부 c club ,t thunder , c 취소
	private char subscribe;
	//총 가격
	private int total;
	//주문된 제품들
	private List<OrderedClub> clubs;
	
	private int cid;
	private int ccode;
	private int ordersc;
	

	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	//주문 개수
	public int getAmount() {
		int amount =0;
		
		if(clubs != null) {
			for(OrderedClub club : clubs) {
				amount += club.getAmount();
			}
		}
		return amount;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public char getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(char subscribe) {
		this.subscribe = subscribe;
	}
	public List<OrderedClub> getClubs() {
		return clubs;
	}
	public void setClubs(List<OrderedClub> clubs) {
		this.clubs = clubs;
	}

	public void setClubs(List<Integer> ccode,List<Integer> amounts) throws Exception{
		if(ccode.size() != amounts.size()) {
			throw new Exception("제품과 수량이 맞지 않습니다.");
		}
		
		List<OrderedClub> list = new ArrayList<OrderedClub>();
		
		for(int i = 0; i < ccode.size(); i++) {
			OrderedClub item = new OrderedClub();
			item.setCcode(ccode.get(i));
			item.setAmount(amounts.get(i));
			list.add(item);
		}
		
		clubs = list;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getOrdersc() {
		return ordersc;
	}
	public void setOrdersc(int ordersc) {
		this.ordersc = ordersc;
	}
	public int getCcode() {
		return ccode;
	}
	public void setCcode(int ccode) {
		this.ccode = ccode;
	}
	
	
}
