package kr.ac.onmh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.onmh.dao.ThunderImageDao;
import kr.ac.onmh.model.Image;
import kr.ac.onmh.util.FileUploader;

@Service("ThunderImageService")
public class ThunderImageService implements ImageService {
	@Autowired
	ThunderImageDao dao;
	
	//이미지 삭제
	@Transactional
	@Override
	public void delete(int code) {
		FileUploader uploader = new FileUploader();
		List<Image> list = dao.list(code);
		
		for(Image item : list) {
			uploader.delete(item.getFullfilename());
		}
		
		dao.delete(code);
	}

}
