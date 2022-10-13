package kr.ac.onmh.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.onmh.dao.ClubDao;
import kr.ac.onmh.dao.ClubImageDao;
import kr.ac.onmh.model.Club;
import kr.ac.onmh.model.Image;
import kr.ac.onmh.model.OrderedClub;
import kr.ac.onmh.util.Pager;

@Service
public class ClubServiceImpl implements ClubService {
	@Autowired
	ClubDao dao;
	@Autowired
	ClubImageDao imageDao;

	// 모임 추가
	@Transactional
	@Override
	public void add(Club item) {
		dao.add(item);
		List<Image> images = item.getImages();

		if (images == null)
			return;

		for (Image image : images) {
			image.setTarget(item.getCode());
			imageDao.add(image);
		}
	}

	// 모임 업데이트
	@Transactional
	@Override
	public void update(Club item) {
		dao.update(item);
		List<Image> images = item.getImages();

		if (images == null)
			return;

		for (Image image : images) {
			image.setTarget(item.getCode());
			imageDao.add(image);
		}
	}

	// 모임 삭제
	@Transactional
	@Override
	public void delete(int code) {
		dao.delete(code);
	}

	// 모임 한개 검색
	@Override
	public Club item(int code) {
		return dao.item(code);
	}

	//모임 리스트
	@Transactional
	@Override
	public List<Club> list(Pager pager) {
		int total = dao.total(pager);
		pager.setTotal(total);
		return dao.list(pager);
	}

	@Override
	public void dummy() {
		for (int id = 0; id < 5; id++) {
			Club item = new Club();

			item.setIntro("창업 예정 ~ 시리즈A 단계 스타트업 피플 여기 모여라!");
			item.setName("스타트업 초기");
			item.setContent(
					"스타트업의 창업 과정에서는 늘 예상치 못한 드라마가 펼쳐집니다. 회사별로 지향하고 있는 가치나 일하는 방식도 매우 다양하기 때문에, 창업가들의 경험을 담은 책을 읽으며 이 세계의 역동성을 느껴 봅시다.");
			item.setMembernum("3명");

			dao.add(item);
		}

	}

	//입력 주문된 상품의 총 가격을 구함
	
	@Transactional
	@Override
	public int priceTotal(List<OrderedClub> clubs) {
		int total = 0;
		for(OrderedClub club : clubs) {
			if(club.isChecked()) {
				Club item = dao.item(club.getCcode());
				total += item.getPrice() * club.getAmount();	
			}
		}
		return total;
	}

	//상품 리스트
	@Transactional
	@Override
	public List<Club> list(List<OrderedClub> clubs) {
		List<Club> list = new ArrayList<>();
		for(OrderedClub club : clubs) {
			Club item = dao.item(club.getCcode());
			item.setAmount(club.getAmount());
			item.setChecked(club.isChecked());
			list.add(item);
		}
		return list;
	}

}
