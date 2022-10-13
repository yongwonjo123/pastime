package kr.ac.onmh.dao;

import java.util.List;

import kr.ac.onmh.model.Image;

public interface NoticeImageDao {

	List<Image> list(int code);

	void delete(int code);

	void add(Image image);

}
