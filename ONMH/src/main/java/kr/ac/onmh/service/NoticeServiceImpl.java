package kr.ac.onmh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.onmh.dao.NoticeDao;
import kr.ac.onmh.dao.NoticeImageDao;
import kr.ac.onmh.model.Image;
import kr.ac.onmh.model.Notice;
import kr.ac.onmh.util.Pager;
@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeDao dao;
	
	@Autowired
	NoticeImageDao imageDao;
	
	@Transactional
	@Override
	public List<Notice> list(Pager pager) {
		int total = dao.total(pager);
		pager.setTotal(total);
		return dao.list(pager);
	}

	@Override
	public void add(Notice item) {
		dao.add(item);
		List<Image> images = item.getImages();

		if (images == null)
			return;

		for (Image image : images) {
			image.setTarget(item.getCode());
			imageDao.add(image);
		}

	}

	@Override
	public Notice item(int code) {
		return dao.item(code);
	}

	@Transactional
	@Override
	public void update(Notice item) {
		dao.update(item);
		List<Image> images = item.getImages();

		if (images == null)
			return;

		for (Image image : images) {
			image.setTarget(item.getCode());
			imageDao.add(image);
		}
	}

	@Override
	public void delete(int code) {
		dao.delete(code);
	}
}
