package kr.ac.onmh.service;

import java.util.List;

import kr.ac.onmh.model.Thunder;
import kr.ac.onmh.util.Pager;


public interface ThunderService {

	List<Thunder> list(Pager pager);
	Thunder item(int code);
	void add(Thunder item);
	void update(Thunder item);
	void delete(int code);

}
