package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.adult.AdultQuizDao;
import domain.AdultQuiz;

/**
 * Servlet implementation class AdultQuizServlet
 */
@WebServlet("/AdultQuiz")
public class AdultQuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			AdultQuizDao adultQuizDao = DaoFactory.createAdultQuizDao();
			List<AdultQuiz> AQList = adultQuizDao.findAll();
			request.setAttribute("AQList", AQList);

			request.getRequestDispatcher("/WEB-INF/view/adult/adultQuiz.jsp")
					.forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
