package mypub;

public class Book extends Publication {
	private String author;

	public Book(String title,String publisher,
			int year,String author,String isbn) throws Exception {
		super(title,publisher,year,isbn);
		this.author = author;
	}

	protected String getAuthor() {
		return author;
	}
	public String toString() {
		return "Title: " + this.getTitle() + ", Author: " + this.getAuthor()
				+ ", Publisher: " + this.getPublisher();
	}
	public boolean lent(){
		if(this.getState() == State.RETURN){
			this.setState(State.LEND);
			return true;
		}else{
			System.out.println("This book is available for rent.");
			return false;
		}
	}
	public boolean returned(){
		if(this.getState() == State.LEND){
			this.setState(State.RETURN);
			return true;
		}else{
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
				+ "," +this.getPublisher() + "," + this.getYear() + "," + this.getAuthor()
				+ "," + strState;
	}
}