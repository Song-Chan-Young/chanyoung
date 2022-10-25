package kr.co.ictedu.getshare;

import org.springframework.web.multipart.MultipartFile;

public class GetShareDTO {

	private String prdt_no;
	private String page_list;
	private String prdt_gubun;
	private String prdt_name;
	private String mno;
	private String mid;
	private String qty;
	private String price;
	private String description;
	private String view_cnt;
	private String reg_date;
	private MultipartFile thumbnail;
	private MultipartFile prdt_img;
	private MultipartFile desc_img;
	private MultipartFile add_file;
	private String thumbnail_name;
	private String thumbnail_path;
	private String prdt_img_name;
	private String prdt_img_path;
	private String expir_date;
	private String price_suggest;


	private String cart_no;
	private String buy_qty;
	private String total_price;

	@Override
	public String toString() {
		return prdt_no
				+ " : " + prdt_name
				+ " : " + mno
				+ " : " + mid
				+ " : " + qty
				+ " : " + price
				+ " : " + description
				+ " : " + view_cnt
				+ " : " + reg_date
				+ " : " + thumbnail
				+ " : " + prdt_img
				+ " : " + desc_img
				+ " : " + thumbnail_name
				+ " : " + thumbnail_path
				+ " : " + prdt_img_name
				+ " : " + prdt_img_path
				+ " : " + buy_qty
				+ " : " + total_price;
	}

	public String getPrdt_no() {
		return prdt_no;
	}
	public void setPrdt_no(String prdt_no) {
		this.prdt_no = prdt_no;
	}
	public String getPrdt_name() {
		return prdt_name;
	}
	public void setPrdt_name(String prdt_name) {
		this.prdt_name = prdt_name;
	}
	public String getMno() {
		return mno;
	}
	public void setMno(String mno) {
		this.mno = mno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getView_cnt() {
		return view_cnt;
	}
	public void setView_cnt(String view_cnt) {
		this.view_cnt = view_cnt;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public MultipartFile getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(MultipartFile thumbnail) {
		this.thumbnail = thumbnail;
	}
	public MultipartFile getPrdt_img() {
		return prdt_img;
	}
	public void setPrdt_img(MultipartFile prdt_img) {
		this.prdt_img = prdt_img;
	}
	public MultipartFile getDesc_img() {
		return desc_img;
	}
	public void setDesc_img(MultipartFile desc_img) {
		this.desc_img = desc_img;
	}
	public MultipartFile getAdd_file() {
		return add_file;
	}
	public void setAdd_file(MultipartFile add_file) {
		this.add_file = add_file;
	}
	public String getThumbnail_name() {
		return thumbnail_name;
	}
	public void setThumbnail_name(String thumbnail_name) {
		this.thumbnail_name = thumbnail_name;
	}
	public String getThumbnail_path() {
		return thumbnail_path;
	}
	public void setThumbnail_path(String thumbnail_path) {
		this.thumbnail_path = thumbnail_path;
	}
	public String getPrdt_img_name() {
		return prdt_img_name;
	}
	public void setPrdt_img_name(String prdt_img_name) {
		this.prdt_img_name = prdt_img_name;
	}
	public String getPrdt_img_path() {
		return prdt_img_path;
	}
	public void setPrdt_img_path(String prdt_img_path) {
		this.prdt_img_path = prdt_img_path;
	}
	public String getCart_no() {
		return cart_no;
	}
	public void setCart_no(String cart_no) {
		this.cart_no = cart_no;
	}
	public String getBuy_qty() {
		return buy_qty;
	}
	public void setBuy_qty(String buy_qty) {
		this.buy_qty = buy_qty;
	}
	public String getTotal_price() {
		return total_price;
	}
	public void setTotal_price(String total_price) {
		this.total_price = total_price;
	}

	public String getPage_list() {
		return page_list;
	}

	public void setPage_list(String page_list) {
		this.page_list = page_list;
	}

	public String getPrdt_gubun() {
		return prdt_gubun;
	}

	public void setPrdt_gubun(String prdt_gubun) {
		this.prdt_gubun = prdt_gubun;
	}

	public String getExpir_date() {
		return expir_date;
	}

	public void setExpir_date(String expir_date) {
		this.expir_date = expir_date;
	}

	public String getPrice_suggest() {
		return price_suggest;
	}

	public void setPrice_suggest(String price_suggest) {
		this.price_suggest = price_suggest;
	}

}//class
