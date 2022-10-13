package kr.ac.onmh.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.onmh.model.Image;

@Repository
public class ThunderImageDaoImpl implements ThunderImageDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public void add(Image image) {
		sql.insert("thunder_image.add", image);
	}

	@Override
	public void delete(int code) {
		sql.delete("thunder_image.delete", code);
	}

	@Override
	public List<Image> list(int code) {
		return sql.selectList("thunder_image.list", code);
	}


}
