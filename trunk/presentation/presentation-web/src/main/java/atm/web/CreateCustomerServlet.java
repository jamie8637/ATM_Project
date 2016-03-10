package atm.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;

import atm.web.model.BankingSystem;

/**
 * Servlet implementation class CreateCustomerServlet
 */
public class CreateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger("org.apache.log4j.PatternLayout");
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateCustomerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BankingSystem bank = BankingSystem.getInstance();
		RequestDispatcher view = request.getRequestDispatcher("Success.jsp");
		try {
			if (bank.createCustomer(request, response)) {

				Cookie[] cookies = request.getCookies();
				if (cookies != null) {
					for (int i = 0; i < cookies.length; i++) {
						if (cookies[i].getName().equals("successMessage")) {
							cookies[i].setValue("Successful Customer Creation");
						}

					}
				} else {
					// creating cookies to store success
					Cookie successResponse = new Cookie("successMessage",
							"Successful Customer Creation");
					successResponse.setMaxAge(60 * 60 * 24);
					response.addCookie(successResponse);

					view.forward(request, response);
				}
			} else {
				RequestDispatcher failview = request
						.getRequestDispatcher("Fail.jsp");
				Cookie[] cookies = request.getCookies();
				if (cookies != null) {
					for (int i = 0; i < cookies.length; i++) {
						if (cookies[i].getName().equals("failureMessage"))
							cookies[i].setValue("Failed to Create Customer");
					}
				} else {
					// creating cookies to store success
					Cookie failureResponse = new Cookie("failureMessage",
							"Failed to Create Customer");
					failureResponse.setMaxAge(60 * 60 * 24);
					response.addCookie(failureResponse);
				}

				failview.forward(request, response);
			}
		} catch (Exception e) {
			logger.error("Exception Class:CreateCustomerServlet in doPost");
			e.printStackTrace();
			view.forward(request, response);
		}

	}

}
