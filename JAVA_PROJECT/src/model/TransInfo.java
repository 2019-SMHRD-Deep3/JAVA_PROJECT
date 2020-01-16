package model;

public class TransInfo {
	private String serv_num;
	private String type;
	private String num;
	private String dep_time;
	private String arr_time;
	private String grade;
	private int seat;
	private String fare;
	public TransInfo(String serv_num, String type, String num, String dep_time, String arr_time, String grade,
			int seat2, String fare) {
		super();
		this.serv_num = serv_num;
		this.type = type;
		this.num = num;
		this.dep_time = dep_time;
		this.arr_time = arr_time;
		this.grade = grade;
		this.seat = seat2;
		this.fare = fare;
	}
	public String getServ_num() {
		return serv_num;
	}
	public String getType() {
		return type;
	}
	public String getNum() {
		return num;
	}
	public String getDep_time() {
		return dep_time;
	}
	public String getArr_time() {
		return arr_time;
	}
	public String getGrade() {
		return grade;
	}
	public int getSeat() {
		return seat;
	}
	public String getFare() {
		return fare;
	}
	

}
