package kr.ac.onmh.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.onmh.model.Member;
import kr.ac.onmh.util.Pager;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public int checkId(String id) {
		return sql.selectOne("member.check_id", id);
	}

	@Override
	public void add(Member item) {
		sql.insert("member.add", item);
	}

	@Override
	public Member login(Member item) {
		
		return sql.selectOne("member.login", item);
	}

	@Override
	public int total(Pager pager) {
		
		return sql.selectOne("member.total", pager);
	}

	@Override
	public List<Member> list(Pager pager) {
		return sql.selectList("member.list", pager);
	}

	@Override
	public void keepLogin(String session, String id) {
		Map<String, String> map = new HashMap<>();
		map.put("session", session);
		map.put("id", id);
		sql.update("member.keep_login", map);
	}

	@Override
	public void delete(String id) {
		sql.delete("member.delete", id);
	}

	@Override
	public void update(Member item) {
		sql.update("member.update", item);
	}

	@Override
	public Member item(String id) {
		return sql.selectOne("member.item", id);
	}

	@Override
	public List<Member> checkMemberWithSession(String session) {
		return sql.selectList("member.check", session);
	}



}
