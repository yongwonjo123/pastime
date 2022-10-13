package kr.ac.onmh.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.onmh.model.Image;

@Repository
public class ClubImageDaoImpl implements ClubImageDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public List<Image> list(int code) {
		return sql.selectList("club_image.list", code);
	}

	@Override
	public void delete(int code) {
		sql.delete("club_image.delete", code);
	}

	@Override
	public void add(Image image) {
		sql.insert("club_image.add", image);
	}

}
