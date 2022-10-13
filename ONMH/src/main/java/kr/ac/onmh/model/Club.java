package kr.ac.onmh.model;
//tbl_club

import java.util.Date;
import java.util.List;

public class Club  {
	
	// 모임번호
	private int code;
	//글쓴이 id
	private String id;
	// 모임이름
	private String name;
	// 모임 한줄소개
	private String intro;
	//시작 일자
	private String startDate;
	//종료 일자
	private String endDate;
	//시작 시간
	private String startTime;
	//종료 시간
	private String endTime;
	//반복주기
	private String repeatRecycle;
	//반복요일
	private String repeatDay;
	//장소 이름
	private String placeName;
	//장소 id
	private String placeId;
	//장소 id
	private String placeFormatted;
	// 모임 카테고리
	private String category;
	// 모임 정원
	private String membernum;
	// 모임 상세 내용
	private String content;
	// 모임 등록 날짜
	private Date date;
	// 모임 회비
	private int price;
	// 모임 상태
	private String state;
	//모임 이미지
	private List<Image> images;
	
	private int score;
	private int amount;
	private boolean checked;
	

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

	public String getMembernum() {
		return membernum;
	}

	public void setMembernum(String membernum) {
		this.membernum = membernum;
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
	//image-썸네일
	public String getThumbnail() {
		if(images == null) return "";
		else if(images.size() < 1) return "";
		return images.get(0).getFullpath();
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getRepeatRecycle() {
		return repeatRecycle;
	}

	public void setRepeatRecycle(String repeatRecycle) {
		this.repeatRecycle = repeatRecycle;
	}

	public String getRepeatDay() {
		return repeatDay;
	}

	public void setRepeatDay(String repeatDay) {
		this.repeatDay = repeatDay;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getPlaceFormatted() {
		return placeFormatted;
	}

	public void setPlaceFormatted(String placeFormatted) {
		this.placeFormatted = placeFormatted;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
