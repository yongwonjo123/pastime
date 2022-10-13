package kr.ac.onmh.service;

import java.util.List;

import kr.ac.onmh.model.Notice;
import kr.ac.onmh.util.Pager;

public interface NoticeService {

	void add(Notice item);

	Notice item(int code);

	void update(Notice item);

	void delete(int code);

	List<Notice> list(Pager pager);

}
