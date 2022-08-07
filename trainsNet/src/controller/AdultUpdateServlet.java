package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		boolean isError = false;
		// フォームでの入力値を取得して、整理？adultに入れていく？
		// newadultをすると新しくなるからセッションからとってくるといい
		Adult adult = (Adult) request.getSession().getAttribute("adult");
		adult.setId(Integer.parseInt(request.getParameter("id")));
		// adult.setAddress(request.getParameter("address"));

		String address = request.getParameter("address");
		request.setAttribute("address", address);
		if (address.isBlank()) {
			request.setAttribute("addressError", "住所が未入力です");
			isError = true;
		}
		// adult.setEmail(request.getParameter("email"));
		String email = request.getParameter("email");
		request.setAttribute("email", email);
		if (email.isBlank()) {
			request.setAttribute("emailError", "Emailアドレスが未入力です");
			isError = true; // 入力に不備ありと判定
		} else if (email.length() > 50) {
			request.setAttribute("emailError", "50 字以内で入力してください。");
			isError = true;
		}
		// adult.setNickName(request.getParameter("nick_name"));
		String nickName = request.getParameter("nick_name");
		request.setAttribute("nickName", nickName);
		if (nickName.isBlank()) {
			request.setAttribute("nickNameError", "ニックネームが未入力です");
			isError = true; // 入力に不備ありと判定
		} else if (nickName.length() > 10) {
			request.setAttribute("nickNameError", "10 字以内で入力してください。");
			isError = true;
		}

		// adult.setLogin(request.getParameter("login_id"));
		String login = request.getParameter("login_id");
		request.setAttribute("login", login);
		if (login.isBlank()) {
			request.setAttribute("loginError", "ログインIDが未入力です");
			isError = true; // 入力に不備ありと判定
		} else if (login.length() > 10) {
			request.setAttribute("loginError", "10 字以内で入力してください。");
			isError = true;
		}

		// セッションの上書きをしよう
		request.getSession().setAttribute("adult", adult);

		try {
			DaoFactory.createAdultDao().update(adult.getId(), adult.getAddress(), adult.getEmail(), adult.getNickName(),
					adult.getLogin());

		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/AdultUpdateDone");

	}

}