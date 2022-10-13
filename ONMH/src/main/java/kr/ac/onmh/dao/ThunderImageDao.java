package kr.ac.onmh.dao;

import java.util.List;

import kr.ac.onmh.model.Image;
;

public interface ThunderImageDao {
	void add(Image image);

	void delete(int code);

	List<Image> list(int code);
}
