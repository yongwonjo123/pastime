package kr.ac.onmh.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.onmh.model.Thunder;
import kr.ac.onmh.util.Pager;

@Repository
public class ThunderDaoImpl implements ThunderDao {
	@Autowired
	SqlSession sql;

	@Override
	public int total(Pager pager) {
		return sql.selectOne("thunder.total", pager);
	}

	@Override
	public List<Thunder> list(Pager pager) {
		return sql.selectList("thunder.list", pager);
	}

	@Override
	public Thunder item(int code) {
		return sql.selectOne("thunder.item", code);
	}

	@Override
	public void add(Thunder item) {
		sql.insert("thunder.add", item);
		
	}

	@Override
	public void update(Thunder item) {
		sql.update("thunder.update", item);
	}

	@Override
	public void delete(int code) {
		sql.delete("thunder.delete", code);
	}

}
