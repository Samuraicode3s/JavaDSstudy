package LibrarySystem;

public class Book extends LibraryItem{
	
	private String author;
	private String isbn;
	private int totalCopies;
	private int avaliableCopies;
	
	public Book(int ID, String title, String genre, String author, String isbn, int totalCopies, int avaliableCopies) {
		super(ID, title, genre);
		this.author = author;
		this.isbn = isbn;
		this.totalCopies = totalCopies;
		this.avaliableCopies = avaliableCopies;
	}
	
	@Override
	public String getInfo() {
		return "hello";
	}
}
