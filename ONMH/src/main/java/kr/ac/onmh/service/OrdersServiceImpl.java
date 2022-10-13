package kr.ac.onmh.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.onmh.dao.ClubDao;
import kr.ac.onmh.dao.OrderedClubDao;
import kr.ac.onmh.dao.OrdersDao;
import kr.ac.onmh.model.OrderedClub;
import kr.ac.onmh.model.Orders;
import kr.ac.onmh.util.Pager;

@Service
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	OrdersDao dao;
	@Autowired
	OrderedClubDao opd;
	@Autowired
	ClubDao cd;
	@Autowired
	ClubService cs;
	@Autowired
	MemberService ms;
	
	//주문 추가
	@Transactional
	@Override
	public void add(Orders item) {
		List<OrderedClub> list = item.getClubs();
		
		if(item.getSubscribe() == 'n')
			item.setTotal(cs.priceTotal(list));
		
		dao.add(item);
		
//		DB에 주문한 상품 저장
		if(list != null) {
			for(OrderedClub p : list) {
				p.setOcode(item.getCode());
				p.setOrderid(item.getId());
				opd.add(p);
			}	
		}
	}

	
	//주문 삭제
	@Transactional
	@Override
	public void delete(int code) {
		opd.delete(code);
		dao.delete(code);
	}
	
	// 주문 수정
	@Transactional
	@Override
	public void update(Orders item) {
		dao.update(item);
		
	}

	//주문 얻기
	@Transactional
	@Override
	public Orders item(int code) {
		Orders item = dao.item(code);
		Pager pager = new Pager();
		pager.setKeyword(item.getCode()+"");
		pager.setSearch(1);
		List<OrderedClub> oClubs = opd.list(pager);
		item.setClubs(oClubs);
		return item;
	}

	// 주문 리스트 열기
	@Transactional
	@Override
	public List<Orders> list(Pager pager) {
		int total = dao.total(pager);
		pager.setTotal(total);

		List<Orders> list = dao.list(pager);

		Pager p = new Pager();

		for (Orders item : list) {
			p.setKeyword(item.getCode() + "");
			p.setSearch(1);
			List<OrderedClub> oClubs = opd.list(p);
			item.setClubs(oClubs);
		}

		return list;
	}



}
