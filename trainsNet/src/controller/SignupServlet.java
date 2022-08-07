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
 * Servlet implementation class SignupServlet
 */
@WebServlet("/Signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/signup.jsp")
				.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String nickName = request.getParameter("nick_name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String stype = request.getParameter("type_id");
		Integer typeId = Integer.parseInt(stype);
		String login = request.getParameter("login_id");
		String pass = request.getParameter("login_pass");
		String confpass = request.getParameter("confpass");
		String sage = request.getParameter("age");
		Integer age = Integer.parseInt(sage);
		System.out.println("login_pass");

		//バリデーション

		/*List<String> errors = new ArrayList<>();
		if (name.isBlank()) {
			errors.add("名前が未入力です");
		}
		if (nickName.isBlank()) {
			errors.add("ニックネームが未入力です");
		}
		if (email.isBlank()) {
			errors.add("メールアドレスが未入力です");
		}
		if (address.isBlank()) {
			errors.add("住所が未入力です");
		}*/

		/*if (errors.size() > 0) {
			request.setAttribute("errors", errors);
			request.setAttribute("name", name);
			request.setAttribute("nickName", nickName);
			request.setAttribute("email", email);
			request.setAttribute("address", address);
			request.setAttribute("age", age);
			request.setAttribute("typeId", typeId);
			request.setAttribute("pass", pass);
			request.setAttribute("name", name);
			request.getRequestDispatcher("/WEB-INF/view/signup.jsp")
					.forward(request, response);
			return;
		}*/

		try {
			Adult adult = new Adult();
			adult.setName(name);
			adult.setNickName(nickName);
			adult.setAddress(address);
			adult.setEmail(email);
			adult.setLogin(login);
			adult.setAge(age);
			adult.setTypeId(typeId);
			adult.setPass(pass);

			AdultDao adultDao = DaoFactory.createAdultDao();
			adultDao.insert(adult);
			//request.getRequestDispatcher("/WEB-INF/view/signupDone.jsp").forward(request, response);

			response.sendRedirect(request.getContextPath() + "/SignupDone");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
