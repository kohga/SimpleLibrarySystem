package mylibrary;

import java.util.*;
import mypub.*;

public class Library {
	private Map<String, Publication> map;

	public Library(){
		 this.map = new HashMap<String,Publication>();
	}

	public Map<String, Publication> getMap(){
		return this.map;
	}
	protected boolean checkISBN(String isbn) {
		return this.map.containsKey(isbn);
	}
	protected void addBook(String isbn,String title,String publisher,
			int year,String author) throws Exception{
		if(isbn.length() != 13)throw new Exception();
		if(checkISBN(isbn)==false){
			this.map.put(isbn,new Book(title,publisher,year,author,isbn));
		}
	}
	protected void addMagazine(String isbn,String title,String publisher,
			int year,int volume, int issue) throws Exception{
		if(isbn.length() != 13)throw new Exception();
		if(checkISBN(isbn)==false){
			this.map.put(isbn,new Magazine(title,publisher,year,volume,issue,isbn));
		}
	}
	protected void checkout(String isbn) {
		this.map.get(isbn).lent();
	}
	protected void returnPublication(String isbn) {
		this.map.get(isbn).returned();
	}
	protected void csvAddBook(String isbn,String title,String publisher,
			int year,String author, String state) throws Exception{
		if(isbn.length() != 13)throw new Exception();
		if(checkISBN(isbn)==false){
			Book b = new Book(title,publisher,year,author,isbn);
			if(state.equals("貸出")){
				b.lent();
			}
			this.map.put(isbn, b);
		}
	}
	protected void csvAddMagazine(String isbn,String title,String publisher,
			int year,int volume, int issue, String state) throws Exception{
		if(isbn.length() != 13)throw new Exception();
		if(checkISBN(isbn)==false){
			Magazine m = new Magazine(title,publisher,year,volume,issue,isbn);
			if(state.equals("貸出")){
				m.lent();
			}
			this.map.put(isbn, m);
		}
	}
}