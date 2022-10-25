package kr.co.ictedu.history;

public class HistoryDTO {

	private String order_no;
	private String mno;
	private String mid;
	private String card_no;
	private String addr_no;
	private String order_product_cnt;
	private String order_amt;
	private String discount_amt;
	private String pay_amt;
	private String order_date;
	private String order_status;
	private String order_status_name;

	private String detail_no;
	private String prdt_no;

	private String detail_qty;
	private String detail_price;
	private String detail_amt;
	private String detail_discount;
	private String detail_discount_amt;
	private String detail_pay_amt;

	private String prdt_name;
	private String seller_mno;
	private String seller_mid;
	private String thumbnail_name;
	private String thumbnail_path;

	private String card_name;
	private String card_number;

	private String recipient_name;
	private String tel;
	private String post_code;
	private String addr1;
	private String addr2;

	@Override
	public String toString() {
		return order_no
				+ " : " + mno
				+ " : " + mid
				+ " : " + card_no
				+ " : " + addr_no
				+ " : " + order_product_cnt
				+ " : " + order_amt
				+ " : " + discount_amt
				+ " : " + pay_amt
				+ " : " + order_date
				+ " : " + order_status
				+ " : " + order_status_name

				+ " : " + detail_no
				+ " : " + prdt_no

				+ " : " + detail_qty
				+ " : " + detail_price
				+ " : " + detail_amt
				+ " : " + detail_discount
				+ " : " + detail_discount_amt
				+ " : " + detail_pay_amt

				+ " : " + prdt_name
				+ " : " + seller_mno
				+ " : " + seller_mid
				+ " : " + thumbnail_name
				+ " : " + thumbnail_path

				+ " : " + card_name
				+ " : " + card_number
				+ " : " + recipient_name
				+ " : " + post_code
				+ " : " + addr1
				+ " : " + addr2;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
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
	public String getCard_no() {
		return card_no;
	}
	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}
	public String getAddr_no() {
		return addr_no;
	}
	public void setAddr_no(String addr_no) {
		this.addr_no = addr_no;
	}
	public String getOrder_product_cnt() {
		return order_product_cnt;
	}
	public void setOrder_product_cnt(String order_product_cnt) {
		this.order_product_cnt = order_product_cnt;
	}
	public String getOrder_amt() {
		return order_amt;
	}
	public void setOrder_amt(String order_amt) {
		this.order_amt = order_amt;
	}
	public String getDiscount_amt() {
		return discount_amt;
	}
	public void setDiscount_amt(String discount_amt) {
		this.discount_amt = discount_amt;
	}
	public String getPay_amt() {
		return pay_amt;
	}
	public void setPay_amt(String pay_amt) {
		this.pay_amt = pay_amt;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public String getOrder_status_name() {
		return order_status_name;
	}
	public void setOrder_status_name(String order_status_name) {
		this.order_status_name = order_status_name;
	}
	public String getDetail_no() {
		return detail_no;
	}
	public void setDetail_no(String detail_no) {
		this.detail_no = detail_no;
	}
	public String getPrdt_no() {
		return prdt_no;
	}
	public void setPrdt_no(String prdt_no) {
		this.prdt_no = prdt_no;
	}
	public String getDetail_qty() {
		return detail_qty;
	}
	public void setDetail_qty(String detail_qty) {
		this.detail_qty = detail_qty;
	}
	public String getDetail_price() {
		return detail_price;
	}
	public void setDetail_price(String detail_price) {
		this.detail_price = detail_price;
	}
	public String getDetail_amt() {
		return detail_amt;
	}
	public void setDetail_amt(String detail_amt) {
		this.detail_amt = detail_amt;
	}
	public String getDetail_discount() {
		return detail_discount;
	}
	public void setDetail_discount(String detail_discount) {
		this.detail_discount = detail_discount;
	}
	public String getDetail_discount_amt() {
		return detail_discount_amt;
	}
	public void setDetail_discount_amt(String detail_discount_amt) {
		this.detail_discount_amt = detail_discount_amt;
	}
	public String getDetail_pay_amt() {
		return detail_pay_amt;
	}
	public void setDetail_pay_amt(String detail_pay_amt) {
		this.detail_pay_amt = detail_pay_amt;
	}
	public String getPrdt_name() {
		return prdt_name;
	}
	public void setPrdt_name(String prdt_name) {
		this.prdt_name = prdt_name;
	}
	public String getSeller_mno() {
		return seller_mno;
	}
	public void setSeller_mno(String seller_mno) {
		this.seller_mno = seller_mno;
	}
	public String getSeller_mid() {
		return seller_mid;
	}
	public void setSeller_mid(String seller_mid) {
		this.seller_mid = seller_mid;
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
	public String getCard_name() {
		return card_name;
	}
	public void setCard_name(String card_name) {
		this.card_name = card_name;
	}
	public String getCard_number() {
		return card_number;
	}
	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}
	public String getRecipient_name() {
		return recipient_name;
	}
	public void setRecipient_name(String recipient_name) {
		this.recipient_name = recipient_name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPost_code() {
		return post_code;
	}
	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

}//class
