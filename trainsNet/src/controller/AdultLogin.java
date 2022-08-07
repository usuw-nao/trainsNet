package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.adult.AdultDao;
import domain.Adult;

/**
 * Servlet implementation class AdultLogin
 */
@WebServlet("/AdultLogin")
public class AdultLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/adult/adultLogin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			String login = request.getParameter("login");
			String pass = request.getParameter("pass");
			AdultDao adultDao = DaoFactory.createAdultDao();
			Adult adult = adultDao.findByLoginAndPass(login, pass);
			if (adult != null) {
				request.getSession().setAttribute("adult", adult);
				response.sendRedirect(request.getContextPath() + "/AdultMypage");
			} else {
				request.setAttribute("error", true);
				request.getRequestDispatcher("/WEB-INF/view/adult/adultLogin.jsp").forward(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);

		}
	}

}
