	package kr.ac.onmh.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.onmh.model.Club;
import kr.ac.onmh.util.Pager;

@Repository

public class ClubDaoImpl implements ClubDao {

	@Autowired
	SqlSession sql;

	@Override
	public void add(Club item) {
		sql.insert("club.add", item);
	}

	@Override
	public void update(Club item) {
		sql.update("club.update", item);
	}

	@Override
	public void delete(int code) {
		sql.delete("club.delete", code);
	}

	@Override
	public Club item(int code) {
		return sql.selectOne("club.item", code);
	}

	@Override
	public List<Club> list(Pager pager) {
		return sql.selectList("club.list",pager);
	}

	@Override
	public int total(Pager pager) {
		return sql.selectOne("club.total", pager);
	}

}
