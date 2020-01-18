package model;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String birth;
	private String phone;
	private String email;

	public Member(String id, String pw, String name, String birth, String phone, String email) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.phone = phone;
		this.email = email;
	}

	public Member(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	public Member(String id) {
		this.id=id;
	}

	public Member(String pw, String name, String phone, String email) {
		super();
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.email = email;
		
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public String getBirth() {
		return birth;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

}
