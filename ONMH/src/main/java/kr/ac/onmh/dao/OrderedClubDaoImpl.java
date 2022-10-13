package kr.ac.onmh.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.onmh.model.OrderedClub;
import kr.ac.onmh.util.Pager;

@Repository
public class OrderedClubDaoImpl implements OrderedClubDao {
	@Autowired
	SqlSession sql;

	@Override
	public void add(OrderedClub item) {
		sql.insert("ordered_club.add", item);
	}

	@Override
	public void delete(int code) {
		sql.delete("ordered_club.delete", code);
	}

	@Override
	public void update(OrderedClub item) {
		sql.update("ordered_club.update", item);
	}

	@Override
	public OrderedClub item(int code) {
		return sql.selectOne("ordered_club.item", code);
	}

	@Override
	public List<OrderedClub> list(Pager pager) {
		return sql.selectList("ordered_club.list", pager);
	}

}
