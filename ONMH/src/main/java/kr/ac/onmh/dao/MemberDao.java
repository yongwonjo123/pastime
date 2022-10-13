package kr.ac.onmh.dao;

import java.util.List;

import kr.ac.onmh.model.Member;
import kr.ac.onmh.util.Pager;

public interface MemberDao {

	int checkId(String id);

	void add(Member item);

	void delete(String id);

	void update(Member item);

	Member item(String id);

	List<Member> list(Pager pager);

	int total(Pager pager);

	Member login(Member item);

	void keepLogin(String session, String id);

	List<Member> checkMemberWithSession(String session);

}
