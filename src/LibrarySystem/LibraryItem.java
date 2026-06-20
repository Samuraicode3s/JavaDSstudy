package LibrarySystem;

public abstract class LibraryItem {

	private int ID;
	private String title;
	private String genre;
	
	public LibraryItem(int ID, String title, String genre) {
		this.ID = ID;
		this.title = title;
		this.genre = genre;
	}
	
	public abstract String getInfo();
	
}
