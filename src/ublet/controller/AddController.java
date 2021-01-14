package ublet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ublet.bean.Book;
import ublet.bean.ViewOuterBookGenre;
import ublet.dao.BookDao;

@WebServlet("/add")
public class AddController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("AddController.java");
		System.out.println(request.getParameter("isbn"));
		System.out.println("new book: " + request.getParameter("bookName"));

		System.out.println(request.getParameter("genreCode"));

		BookDao bookDao = new BookDao();

		Book book = new Book(
				Integer.parseInt(request.getParameter("isbn")),
				request.getParameter("bookName"),
				request.getParameter("company"),
				Integer.parseInt(request.getParameter("price")),
				Integer.parseInt(request.getParameter("genreCode")));

		try {
			bookDao.insertBook(book);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		try {
			List<ViewOuterBookGenre> listView = bookDao.ListAllView();

			request.setAttribute("listView", listView);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


		RequestDispatcher rd = request.getRequestDispatcher("/jsp/bookList.jsp");
		rd.forward(request, response);
	}

}
