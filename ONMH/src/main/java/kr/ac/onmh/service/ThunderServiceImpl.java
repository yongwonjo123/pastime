package kr.ac.onmh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.onmh.dao.ThunderDao;
import kr.ac.onmh.dao.ThunderImageDao;
import kr.ac.onmh.model.Image;
import kr.ac.onmh.model.Thunder;
import kr.ac.onmh.util.Pager;

@Service
public class ThunderServiceImpl implements ThunderService {

	@Autowired
	ThunderDao dao;

	@Autowired
	ThunderImageDao imageDao;

	@Transactional
	@Override
	public List<Thunder> list(Pager pager) {
		int total = dao.total(pager);
		pager.setTotal(total);
		return dao.list(pager);
	}

	@Override
	public Thunder item(int code) {
		Thunder item = dao.item(code);
		return item;
	}

	@Override
	public void add(Thunder item) {
		dao.add(item);
		List<Image> images = item.getImages();

		if (images == null)
			return;

		for (Image image : images) {
			image.setTarget(item.getCode());
			imageDao.add(image);
		}
	}

	@Transactional
	@Override
	public void update(Thunder item) {
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
