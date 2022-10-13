package kr.ac.onmh.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.onmh.model.Image;

//File Upload
@Component
public class FileUploader {
	public static String UPLOAD_PATH = "C:/pastime_upload_image/";
	
	public List<Image> upload(List<MultipartFile> files) {
		List<Image> list = new ArrayList<>();
		
		try {
			for(MultipartFile file : files) {
				if(file.getOriginalFilename().equals("")) continue;
				Image image = new Image();
				image.setFilename(file.getOriginalFilename());
				UUID uuid = UUID.randomUUID();
				image.setUuid(uuid.toString());
				file.transferTo(new File(UPLOAD_PATH+image.getFullfilename()));
				list.add(image);
			}
		}
		catch (Exception e) {
			System.out.println("업로드 실패");
			System.out.println(e.getMessage());
		}
		
		return list;
	}
	
	//image 삭제
	public void delete(String filename) {
		File file = new File(UPLOAD_PATH+filename);
		if(file.exists()) {
			file.delete();
		}
		else {
			System.out.println(UPLOAD_PATH+filename+" 파일이 없습니다.");
		}
	}
}
