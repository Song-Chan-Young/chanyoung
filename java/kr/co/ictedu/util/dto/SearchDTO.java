package kr.co.ictedu.util.dto;

public class SearchDTO {

	private String searchOption;
	private String searchWord;
	private int limitNum;
	private String mno;
	

	private String page_list;
	private int main_page_yn;
	
	public int getMain_page_yn() {
		return main_page_yn;
	}

	public void setMain_page_yn(int main_page_yn) {
		this.main_page_yn = main_page_yn;
	}
	private String prdt_gubun;
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

	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	@Override
	public String toString() {
		return searchOption + " : " + searchWord;
	}

	public String getSearchOption() {
		return searchOption;
	}
	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	public int getLimitNum() {
		return limitNum;
	}
	public void setLimitNum(int limitNum) {
		this.limitNum = limitNum;
	}

}//class

