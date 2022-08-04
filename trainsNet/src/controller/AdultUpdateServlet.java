package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import domain.Adult;

/**
 * Servlet implementation class UpdateAdultServlet
 */
@WebServlet("/AdultUpdate")
public class AdultUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/adult/adultUpdate.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// フォームでの入力値を取得して、整理？adultに入れていく？
		Adult adult = new Adult();
		adult.setId(Integer.parseInt(request.getParameter("id")));
		adult.setAddress(request.getParameter("address"));
		adult.setEmail(request.getParameter("email"));
		adult.setNickName(request.getParameter("nick_name"));
		adult.setLogin(request.getParameter("login_id"));

		//セッションの上書きをしよう
		//formからアダルトのIDを取得
		//Adult adult = (Adult) request.getSession().getAttribute("adult");
		//Integer id = Integer.parseInt(request.getParameter("id"));
		// 再表示用 request.setAttribute("id",id);
		//boolean isError = false;
		//住所を取得して、バリデーション
		//String address = request.getParameter("address");
		// 再表示用 request.setAttribute("address", address);
		/*if (address.isBlank()) {
			request.setAttribute("addressError", "住所が未入力です");
			isError = true; // 入力に不備ありと判定
		} else if (address.length() > 50) {
			request.setAttribute("addressError", "50 字以内で入力してください。");
			isError = true;
		}
		*/
		//ema-ruのバリデーション
		//String email = request.getParameter("email");
		// 再表示用 request.setAttribute("email", email);
		/*if (email.isBlank()) {
			request.setAttribute("emailError", "Emailアドレスが未入力です");
			isError = true; // 入力に不備ありと判定
		} else if (email.length() > 50) {
			request.setAttribute("emailError", "50 字以内で入力してください。");
			isError = true;
		}*/

		//String nickName = request.getParameter("nickName");
		// 再表示用 request.setAttribute("nickName", nickName);
		/*if (nickName.isBlank()) {
			request.setAttribute("nickNameError", "ニックネームが未入力です");
			isError = true; // 入力に不備ありと判定
		} else if (nickName.length() > 10) {
			request.setAttribute("nickNameError", "10 字以内で入力してください。");
			isError = true;
		}*/

		//String login = request.getParameter("login");
		// 再表示用 request.setAttribute("login", login);
		/*if (login.isBlank()) {
			request.setAttribute("loginError", "ログインIDが未入力です");
			isError = true; // 入力に不備ありと判定
		} else if (login.length() > 10) {
			request.setAttribute("loginError", "10 字以内で入力してください。");
			isError = true;
		}*/
		//Adult adult =new Adult();
		HttpSession session = request.getSession();
		session.setAttribute("adult", adult);
		//データベースに登録
		try {
			DaoFactory.createAdultDao().update(adult);

		} catch (Exception e) {
			e.printStackTrace();
		}
		//if (isError == true) {
		response.sendRedirect(request.getContextPath() + "/AdultInf");
	}
}
