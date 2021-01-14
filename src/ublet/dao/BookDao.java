package ublet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ublet.bean.Book;
import ublet.bean.ViewOuterBookGenre;

public class BookDao {
	private Connection cn; //is this legal???

	public BookDao() {

	}

	public boolean insertBook(Book book) throws SQLException {
		String sql = "insert into book values (?,?,?,?,?)";
		cn = DBManager.getConnection();

		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setInt(1, book.getIsbn());
		ps.setString(2, book.getBookName());
		ps.setString(3, book.getCompany());
		ps.setInt(4, book.getPrice());
		ps.setInt(5, book.getGenreCode());
		boolean rowInserted = ps.executeUpdate() > 0;
		ps.close();

		cn.close();

		return rowInserted;
	}

	public List<ViewOuterBookGenre> ListAllView() throws SQLException {
		List<ViewOuterBookGenre> listView = new ArrayList<ViewOuterBookGenre>();
		cn = DBManager.getConnection();

		String sql = "select * from view_outer_book_genre";

		Statement st = cn.createStatement();
		ResultSet rs = st.executeQuery(sql);

		System.out.println("isbn | book_name | company | price | genre_code | genre_name");


		while(rs.next()) {
			int isbn = rs.getInt("isbn");
			String bookName = rs.getString("book_name");
			String company = rs.getString("company");
			int price = rs.getInt("price");
			int genreCode= rs.getInt("genre_code");
			String genreName = rs.getString("genre_name");

			System.out.println(isbn + " | " + bookName + " | " + company + " | " + price + " | " + genreCode + " | " + genreName);

			ViewOuterBookGenre view = new ViewOuterBookGenre(isbn, bookName, company, price, genreCode, genreName);
			listView.add(view);
		}

		rs.close();
		st.close();

		cn.close();

		return listView;
	}
}
