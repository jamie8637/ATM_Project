package atm.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;

import com.presentation.service.BankSystemService;

import atm.business.api.model.Session;
import atm.web.model.BankingSystem;

/**
 * Servlet implementation class ATMLoginServlet
 * 
 * @author Adrian R. and Aaron Bickhaus
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger("org.apache.log4j.PatternLayout");

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		BankingSystem bank = BankingSystem.getInstance();

		try {
			if (bank.authenticate(request, response)) {
				RequestDispatcher view = request
						.getRequestDispatcher("LoginSuccess.jsp");

				// creating session ID to store accout ID
				HttpSession session = request.getSession();
				// getting account ID and storing it
				session.setAttribute("accountID", 1);
				// gettting account user name and storing it
				session.setAttribute("accountUserName", "Aaron Bickhaus");
				// setting whether user is logged in
				session.setAttribute("isLoggedIn", "logged in");
				// setting card number
				session.setAttribute("cardNumber",
						request.getParameter("cardnumber"));
			
				view.forward(request, response);
			} else {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("<h1>Fail</h1>");
			}
		} catch (JAXBException e) {
			logger.error("Exception: JAXBException Class:LoginServlet in doPost");
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			logger.error("Exception: Throwable Class:LoginServlet in doPost");
			e.printStackTrace();
		}
	}
}
