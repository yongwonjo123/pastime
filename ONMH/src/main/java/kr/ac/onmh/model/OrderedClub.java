package kr.ac.onmh.model;

import java.util.Date;
import java.util.List;


public class OrderedClub {
	//일련번호
	private int code;
	//모임번호
	private int ccode;
	//주문번호
	private int ocode;
	//회원 아이디
	private String orderid;
	//수량
	private int amount;
	
	//모임 정보
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
	// 모임 카테고리
	private String category;
	// 모임 정원
	private String membernum;
	// 모임 상세 내용
	private String content;
	// 모임 등록 날짜
	private Date date;
	private String name;
	private int price;
	private List<Image> images;
	private boolean checked;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getCcode() {
		return ccode;
	}
	public void setCcode(int ccode) {
		this.ccode = ccode;
	}
	public int getOcode() {
		return ocode;
	}
	public void setOcode(int ocode) {
		this.ocode = ocode;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
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
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
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
	
	
}
