package kr.ac.onmh.dao;

import java.util.List;

import kr.ac.onmh.model.Notice;
import kr.ac.onmh.util.Pager;

public interface NoticeDao {

	void add(Notice item);

	Notice item(int code);

	void update(Notice item);

	void delete(int code);

	int total(Pager pager);

	List<Notice> list(Pager pager);

}
