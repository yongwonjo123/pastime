package kr.ac.onmh.model;

import java.util.Date;
import java.util.List;

public class Notice {

	private int code;
	private String title;
	private Date date;
	private String content;
	private int readCount;
	
	// 글쓴 사람의 id
	private String id;

	private List<Image> images;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	
	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	// image-썸네일
	public String getThumbnail() {
		if (images == null)
			return "";
		else if (images.size() < 1)
			return "";
		return images.get(0).getFullpath();
	}
}
