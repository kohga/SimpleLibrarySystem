package mypub;

abstract public class Publication {
	private String title;
	private String publisher;
	public int year;
	public String isbn;
	public enum State {
		LEND,RETURN
	}
	private State state;

	Publication(String title,String publisher,int year,String isbn) throws Exception {
		this.title = title;
		this.publisher = publisher;
		this.state = State.RETURN;
		this.setYear(year);
		this.setISBN(isbn);
	}

	protected String getTitle() {
		return this.title;
	}
	protected String getPublisher() {
		return this.publisher;
	}
	protected State getState(){
		return this.state;
	}
	public int getYear(){
		return this.year;
	}
	public String getISBN() {
		return this.isbn;
	}
	private void setYear(int year) throws Exception{
		if(year <= 0)throw new Exception();
		this.year = year;
	}
	protected void setState(State state){
		this.state = state;
	}
	private void setISBN(String isbn) throws Exception{
		if(isbn.length() != 13)throw new Exception();
		this.isbn = isbn;
	}

	//abstract public String toString();
	abstract public boolean lent();
	abstract public boolean returned();
	abstract public String csvString();
}

