package kr.ac.onmh.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.onmh.model.Notice;
import kr.ac.onmh.util.Pager;
@Repository
public class NoticeDaoImpl implements NoticeDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<Notice> list(Pager pager) {
		return sql.selectList("notice.list",pager);
	}

	@Override
	public void add(Notice item) {
		sql.insert("notice.add", item);

	}

	@Override
	public Notice item(int code) {
		return sql.selectOne("notice.item", code);
	}

	@Override
	public void update(Notice item) {
		sql.update("notice.update", item);
		
	}

	@Override
	public void delete(int code) {
		sql.delete("notice.delete", code);
		
	}

	@Override
	public int total(Pager pager) {
		return sql.selectOne("notice.total", pager);
	}

}
