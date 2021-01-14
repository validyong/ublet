package ublet.bean;

public class Book {
	private Integer isbn;
	private String bookName;
	private String company;
	private Integer price;
	private Integer genreCode;

	public Book(Integer isbn, String bookName, String company, Integer price, Integer genreCode) {
		this.isbn = isbn;
		this.bookName = bookName;
		this.company = company;
		this.price = price;
		this.genreCode = genreCode;
	}

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(Integer genreCode) {
		this.genreCode = genreCode;
	}

}
