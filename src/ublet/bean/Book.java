package ublet.bean;

public class Book {
    private Integer isbn;
    private String bookName;
    private String company;
    private String price;
    private Integer genreCode;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getGenreCode() {
        return genreCode;
    }

    public void setGenreCode(Integer genreCode) {
        this.genreCode = genreCode;
    }
    
}
