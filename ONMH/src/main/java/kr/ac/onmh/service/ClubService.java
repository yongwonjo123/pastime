package kr.ac.onmh.service;

import java.util.List;

import kr.ac.onmh.model.Club;
import kr.ac.onmh.model.OrderedClub;
import kr.ac.onmh.util.Pager;

public interface ClubService {

	void add(Club item);

	void update(Club item);

	void delete(int code);

	Club item(int code);

	List<Club> list(Pager pager);

	void dummy();

	int priceTotal(List<OrderedClub> list);

	List<Club> list(List<OrderedClub> clubs);

}
