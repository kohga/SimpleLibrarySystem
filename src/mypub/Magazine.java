package mypub;

public class Magazine extends Publication {
	private int volume;
	private int issue;

	public Magazine(String title, String publisher,
			int year,int volume, int issue,String isbn) throws Exception{
		super(title,publisher,year,isbn);
		this.volume = volume;
		this.issue = issue;
	}

	public int getVolume() {
		return this.volume;
	}
	protected int getIssue() {
		return this.issue;
	}
	public String toString() {
		return "Title: " + this.getTitle() + ", Publisher: " + this.getPublisher()
				+ ", volume:" + this.getVolume() + ", issue:" + this.getIssue();
	}
	public boolean lent(){
		if ((this.getState() == State.RETURN) && (this.getVolume() <= 10)){
			this.setState(State.LEND);
			return true;
		} else if ((this.getState() == State.RETURN) && (this.getVolume() > 10)){
			System.out.println("This book can not be borrowed.");
			return false;
		} else {
			System.out.println("This book is available for rent.");
			return false;
		}
	}
	public boolean returned(){
		if (this.getState() == State.LEND){
			this.setState(State.RETURN);
			return true;
		} else {
			System.out.println("This book has not been borrowed.");
			return false;
		}
	}
	public String csvString(){
		String strState = null;
		if (this.getState() == State.LEND){
			strState = "LEND";
		} else if (this.getState() == State.RETURN){
			strState = "RETURN";
		}
		return this.getClass().getName() + "," + this.getISBN() + "," + this.getTitle()
				+ "," + this.getVolume() + "," + this.getIssue() + "," +this.getPublisher()
				+ "," + this.getYear() + "," + strState;
	}
}