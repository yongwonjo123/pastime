package kr.ac.onmh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.onmh.dao.MemberDao;
import kr.ac.onmh.model.Member;
import kr.ac.onmh.util.Pager;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao dao;

	@Override
	public boolean checkId(String id) {
		if (dao.checkId(id) == 0)
			return true;
		else
			return false;
	}

	@Override
	public void add(Member item) {
		dao.add(item);

	}

	@Override
	public List<Member> list(Pager pager) {

		int total = dao.total(pager);
		pager.setTotal(total);

		List<Member> list = dao.list(pager);

		return list;
	}

	@Override
	public Member login(Member item) {
		return dao.login(item);
	}

	@Override
	public void keepLogin(String session, String id) {
		dao.keepLogin(session, id);
	}

	@Override
	public Member item(String id) {
		Member item = dao.item(id);

		return item;
	}

	@Override
	public void update(Member item) {
		dao.update(item);
	}

	@Override
	public void delete(String id) {
		dao.delete(id);
	}

	@Override
	public int total(Pager pager) {
		return dao.total(pager);
	}

	@Transactional
	@Override
	public Member checkMemberWithSession(String session) {
		List<Member> list = dao.checkMemberWithSession(session);

		if (list == null)
			return null;

		if (list.size() == 1) {
			return list.get(0);
		} else {
			for (Member member : list) {
				keepLogin(null, member.getId());
			}
			keepLogin(session, list.get(0).getId());
			return list.get(0);
		}
	}

	@Override
	public String findId(String email) {
		Pager pager = new Pager();
		pager.setKeyword(email);
		pager.setSearch(3);
		List<Member> list = list(pager);
		
//		이메일에 해당하는 아이디가 없으면 null
		if(list.size() < 1) {
			return null;
		}
		else {
//			아이디가 있으면 첫번째 것을 가져옴
//			해당하는 아이디가 여러 개일 경우 논리적으로 모순이 생김
			return list.get(0).getId();
		}
	}

	@Override
	public boolean confirmEmail(String email) {
		Pager pager = new Pager();
		pager.setKeyword(email);
		pager.setSearch(3);
		int total = total(pager);
		
		if(total == 0) {
			return true;	
		}
		else {
			return false;
		}
}
}