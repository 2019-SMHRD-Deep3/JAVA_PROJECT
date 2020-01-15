package model;

public class Book {
	
	private String booknum;
	private String dep;
	private String arr;
	private String servnum;
	private String depT;
	private String arrT;
	private String per;
	private String fare;
	
	BookingPayment bp = new BookingPayment();
	
	public Book(String booknum, String dep, String arr, String servnum, String depT, String arrT, String per, String fare) {
		this.booknum=booknum;
		this.dep=dep;
		this.arr=arr;
		this.servnum=servnum;
		this.depT=depT;
		this.arrT=arrT;
		this.per=per;
		this.fare=fare;
	}
	
	public String getBooknum() {
		return booknum;
	}

	public void setBooknum(String booknum) {
		this.booknum = booknum;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public String getArr() {
		return arr;
	}

	public void setArr(String arr) {
		this.arr = arr;
	}

	public String getServnum() {
		return servnum;
	}

	public void setServnum(String servnum) {
		this.servnum = servnum;
	}

	public String getDepT() {
		return depT;
	}

	public void setDepT(String depT) {
		this.depT = depT;
	}

	public String getArrT() {
		return arrT;
	}

	public void setArrT(String arrT) {
		this.arrT = arrT;
	}

	public String getPer() {
		return per;
	}

	public void setPer(String per) {
		this.per = per;
	}

	public String getFare() {
		return fare;
	}

	public void setFare(String fare) {
		this.fare = fare;
	}
	
}
