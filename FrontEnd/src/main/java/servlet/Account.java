package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ailmax.backend.model.User;
import com.ailmax.backend.model.UserDet;

import backend.Connector;

/**
 * Servlet implementation class Account
 */
public class Account extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Account() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession hs=request.getSession();
			User user=(User)hs.getAttribute("userId");
			if(!Connector.isActive())
			{Connector.Connect();}
			if(user!=null) {
				UserDet ud=Connector.fillDetails(user);
				request.setAttribute("UserA", user);
				request.setAttribute("UserD", ud);
				request.getRequestDispatcher("user.jsp").forward(request, response);
			}else {
				
				response.sendRedirect("index.jsp");
			}
			

		}catch(Exception e) {
			response.getOutputStream().print("<script>location.replace(\"index.jsp\")</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
