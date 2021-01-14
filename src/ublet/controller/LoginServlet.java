package ublet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ublet.bean.UserInfo;
import ublet.bean.ViewOuterBookGenre;
import ublet.dao.BookDao;
import ublet.dao.UserInfoDao;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private BookDao bookdao;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		try {

			UserInfo user = new UserInfo();
			user.setUserId(request.getParameter("userId"));
			user.setPassword(request.getParameter("password"));

			user = UserInfoDao.login(user);

			if (user.isValid()) {

				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", user);

				bookdao = new BookDao();

				List<ViewOuterBookGenre> listView = bookdao.ListAllView();
				request.setAttribute("listView", listView);
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/bookList.jsp");
				rd.forward(request, response); //logged-in page
			}

			else
				response.sendRedirect("/jsp/jambo.jsp"); //error page
		}

		catch (Throwable theException) {
			System.out.println(theException);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
