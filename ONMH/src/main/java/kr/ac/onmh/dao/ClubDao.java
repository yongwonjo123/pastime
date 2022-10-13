package kr.ac.onmh.dao;

import java.util.List;

import kr.ac.onmh.model.Club;
import kr.ac.onmh.util.Pager;

public interface ClubDao {

	void update(Club item);

	void delete(int code);

	Club item(int code);

	List<Club> list(Pager pager);

	void add(Club item);

	int total(Pager pager);

}
