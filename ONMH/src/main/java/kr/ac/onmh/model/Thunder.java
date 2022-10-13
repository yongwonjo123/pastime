package kr.ac.onmh.model;
//tbl_thunder

import java.util.Date;
import java.util.List;

public class Thunder {

	// 모임번호
	private int code;

	// 모임이름
	private String name;

	// 모임 한줄소개
	private String intro;

	// 모임 카테고리
	private String category;

	// 모임 지역
	private String city;

	// 모임 세부 지역
	private String district;

	// 모임 정원
	private String membernum;

	// 모임 해시태그
	private String hashtag;

	// 모임 상세 내용
	private String content;

	// 모임 날짜
	private Date date;

	// 모임 등록 날짜 - regdate
	private Date rdate;

	// 모임 장소
	private String place;

	// 모임 이미지
	private List<Image> images;

	// 글쓴이 id
	private String id;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getMembernum() {
		return membernum;
	}

	public void setMembernum(String membernum) {
		this.membernum = membernum;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
