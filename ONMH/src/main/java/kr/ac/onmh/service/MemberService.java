package kr.ac.onmh.service;

import java.util.List;

import kr.ac.onmh.model.Member;
import kr.ac.onmh.util.Pager;

public interface MemberService {
	
	void add(Member item);

	void delete(String id);

	void update(Member item);

	Member item(String id);

	List<Member> list(Pager pager);

	int total(Pager pager);

	Member login(Member item);

	boolean checkId(String id);

	void keepLogin(String session, String id);

	Member checkMemberWithSession(String session);

	String findId(String email);

	boolean confirmEmail(String email);
}
