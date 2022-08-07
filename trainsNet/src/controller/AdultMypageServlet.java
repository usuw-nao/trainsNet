package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		//初期化
		//AdultQuiz adultQuiz = null;
		//クイズをDBから取り出す
		//try {
		//	AdultQuizDao adultQuizDao = DaoFactory.createAdultQuizDao();
		//	adultQuiz= adultQuizDao.findById(id());

		//	request.setAttribute("content", adultQuiz.getContent());
		//	request.setAttribute("choice1", adultQuiz.getChoice1());
		//	request.setAttribute("choice2", adultQuiz.getChoice2());
		request.getRequestDispatcher("/WEB-INF/view/adult/adultMypage.jsp")
				.forward(request, response);
		//} catch (Exception e) {
		//	e.printStackTrace();
		//}
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
