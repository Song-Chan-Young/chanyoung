package kr.co.ictedu.credit.card;

public class CreditCardDTO {

	private String card_no;
	private String card_name;
	private String mno;
	private String card_number;
	private String expiry_date_month;
	private String expiry_date_year;
	private String cvc_code;
	private String pwd;
	private String used_date;
	private String reg_date;

	@Override
	public String toString() {
		return card_no +" : "
				+ card_name +" : "
				+ mno +" : "
				+ card_number +" : "
				+ expiry_date_month +" : "
				+ expiry_date_year +" : "
				+ cvc_code +" : "
				+ pwd +" : "
				+ used_date +" : "
				+ reg_date;
	}
	public String getCard_no() {
		return card_no;
	}
	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}
	public String getCard_name() {
		return card_name;
	}
	public void setCard_name(String card_name) {
		this.card_name = card_name;
	}
	public String getMno() {
		return mno;
	}
	public void setMno(String mno) {
		this.mno = mno;
	}
	public String getCard_number() {
		return card_number;
	}
	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}
	public String getExpiry_date_month() {
		return expiry_date_month;
	}
	public void setExpiry_date_month(String expiry_date_month) {
		this.expiry_date_month = expiry_date_month;
	}
	public String getExpiry_date_year() {
		return expiry_date_year;
	}
	public void setExpiry_date_year(String expiry_date_year) {
		this.expiry_date_year = expiry_date_year;
	}
	public String getCvc_code() {
		return cvc_code;
	}
	public void setCvc_code(String cvc_code) {
		this.cvc_code = cvc_code;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUsed_date() {
		return used_date;
	}
	public void setUsed_date(String used_date) {
		this.used_date = used_date;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

}//class
