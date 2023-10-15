package hanbit;

public class People {
	private String id;
	private String pw;
	private String phoneNum;
	private String email;
	private String regDate;
	private String updateDate;
	
	public People(String id, String pw, String phoneNum, String email, String regDate, String updateDate) {
		this.id = id;
		this.pw = pw;
		this.phoneNum = phoneNum;
		this.email = email;
		this.regDate = regDate;
		this.updateDate = updateDate;
	}
	
	public String getsId() { return id; }
	public void setsId(String id) { this.id = id; }
	
	public String getsPw() { return pw; }
	public void setsPw(String pw) { this.pw = pw; }
	
	public String getsPhoneNum() { return phoneNum; }
	public void setsPhoneNum(String phoneNum) { this.phoneNum = phoneNum; }
	
	public String getsEmail() { return email; }
	public void setsEmail(String email) { this.email = email; }
	
	public String getsRegDate() { return regDate; }
	public void sets(String regDate) { this.regDate = regDate; }
	
	public String getsUpdateDate() { return updateDate; }
	public void setsUpdateDate(String updateDate) { this.updateDate = updateDate; }
	
}
