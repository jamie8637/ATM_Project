package atm.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import atm.web.model.BankingSystem;

/**
 * Servlet implementation class DepositServlet
 */
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BankingSystem bank = BankingSystem.getInstance();

		RequestDispatcher view = request.getRequestDispatcher("Success.jsp");

		if (bank.makeDeposit(request, response)) {

			Cookie[] cookies = request.getCookies();

			if (cookies != null) {

				for (int i = 0; i < cookies.length; i++) {
					if (cookies[i].getName().equals("successMessage")) {
						cookies[i].setValue("Successful Deposit");
					}
				}
				view.forward(request, response);
			} else {
				// creating cookies to store success
				Cookie successResponse = new Cookie("successMessage",
						"Successful deposit");
				successResponse.setMaxAge(60 * 60 * 24);
				response.addCookie(successResponse);

			}
		} else {
			RequestDispatcher failview = request
					.getRequestDispatcher("Fail.jsp");
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					if (cookies[i].getName().equals("failureMessage")) {
						cookies[i].setValue("Failed to deposit funds");
					}
				}
			} else {
				// creating cookies to store failure
				Cookie failureResponse = new Cookie("failureMessage",
						"Failed to deposit funds");
				failureResponse.setMaxAge(60 * 60 * 24);
				response.addCookie(failureResponse);

				failview.forward(request, response);
			}
		}
	}

}
