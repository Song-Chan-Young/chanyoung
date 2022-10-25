package kr.co.ictedu.message;

public class MessageDTO {
	private String memo;
	private String room;
	private String send_mno;
	private String recv_mno;
	private String send_mid;
	private String recv_mid;
	private String send_time;
	private String content;
	private int read_chk;
	private String send_leave_date;
	private String recv_leave_date;
	private int send_leave_yn;
	private int recv_leave_yn;
	
	
	public String toString() {
		return memo + " : " + room + " : " + send_mno + " : " + recv_mno + " : " + send_mid + " : " + recv_mid + " : " + send_time + "s : " + content + " : " + read_chk;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getSend_mno() {
		return send_mno;
	}
	public void setSend_mno(String send_mno) {
		this.send_mno = send_mno;
	}
	public String getRecv_mno() {
		return recv_mno;
	}
	public void setRecv_mno(String recv_mno) {
		this.recv_mno = recv_mno;
	}
	public String getSend_mid() {
		return send_mid;
	}
	public void setSend_mid(String send_mid) {
		this.send_mid = send_mid;
	}
	public String getRecv_mid() {
		return recv_mid;
	}
	public void setRecv_mid(String recv_mid) {
		this.recv_mid = recv_mid;
	}
	public String getSend_time() {
		return send_time;
	}
	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRead_chk() {
		return read_chk;
	}
	public void setRead_chk(int read_chk) {
		this.read_chk = read_chk;
	}
	public String getSend_leave_date() {
		return send_leave_date;
	}
	public void setSend_leave_date(String send_leave_date) {
		this.send_leave_date = send_leave_date;
	}
	public String getRecv_leave_date() {
		return recv_leave_date;
	}
	public void setRecv_leave_date(String recv_leave_date) {
		this.recv_leave_date = recv_leave_date;
	}
	public int getSend_leave_yn() {
		return send_leave_yn;
	}
	public void setSend_leave_yn(int send_leave_yn) {
		this.send_leave_yn = send_leave_yn;
	}
	public int getRecv_leave_yn() {
		return recv_leave_yn;
	}
	public void setRecv_leave_yn(int recv_leave_yn) {
		this.recv_leave_yn = recv_leave_yn;
	}
}
