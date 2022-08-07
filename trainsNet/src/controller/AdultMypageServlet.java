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
 * Servlet implementation class AdultMypageServlet
 */
@WebServlet("/AdultMypage")
public class AdultMypageServlet extends HttpServlet {
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
		} catch (Exception e) {
			throw new ServletException(e);
		}
		request.getRequestDispatcher("/WEB-INF/view/adult/adultMypage.jsp")
				.forward(request, response);

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
