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
import domain.Adult;
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
			List<AdultQuiz> AQList = adultQuizDao.findRandom(1);
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
		request.setCharacterEncoding("UTF-8");
		// ラジオボタンの結果を受け取る,全部送られてきている
		try {
			// クイズIDをもとにクイズ情報をもってくる
			Integer id = Integer.parseInt(request.getParameter("id"));
			AdultQuiz quiz = DaoFactory.createAdultQuizDao().findById(id);

			// ユーザーの回答を取得
			String choice = request.getParameter("choice");

			// クイズ情報の答えとユーザーの回答を比較
			if (quiz.getAnswer().equals(choice)) {
				// 等しかった場合・10P足す・おめでとう表示
				System.out.println("OK");
				try {
					// adultテーブルのpointを10増やす
					Adult adult = (Adult) request.getSession().getAttribute("adult");
					DaoFactory.createAdultDao().update2(adult.getId());
					request.getRequestDispatcher("/WEB-INF/view/adult/adultQuizOK.jsp").forward(request, response);
				} catch (Exception e) {
					throw new ServletException(e);
				}

			} else {
				// 違ったばあい足さない残念表示
				System.out.println("NG");
				request.getRequestDispatcher("/WEB-INF/view/adult/adultQuizNG.jsp").forward(request, response);

			}

			// 一日一回はJSで書く

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
