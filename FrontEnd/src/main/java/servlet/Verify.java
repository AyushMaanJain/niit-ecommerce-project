package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ailmax.backend.model.User;

import backend.Connector;

/**
 * Servlet implementation class Verify
 */
@WebServlet(name = "Verify", urlPatterns = {"/Verify"})
public class Verify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Verify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ss=request.getSession();
		String code=request.getParameter("code");
		User us=(User)ss.getAttribute(code);
		
		if(us==null) {
			response.getWriter().append("Bad Request");
		}else {
			boolean b=Connector.addUser(us);
			response.getWriter().append(us.getE_mail()+" register "+b).append(request.getContextPath());
			response.sendRedirect("log.jsp");
		
	}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str=request.getParameter("request");
		boolean diff=str.equals("mob");
		if(diff) {
			
		}else {
		doGet(request, response);
		}
	}

}
