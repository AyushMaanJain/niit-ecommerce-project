package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ailmax.backend.model.User;
import com.ailmax.backend.model.User.UserValidity;

import backend.Connector;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getOutputStream().print("<script>location.replace(\"index.jsp\")</script>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String mail=request.getParameter("email");
		String pass=request.getParameter("password");
		System.out.println(mail+"::"+pass);
		if(!Connector.isActive()) {
			Connector.Connect();
		}
		UserValidity res=Connector.Verify(mail, pass);
		/*String str=request.getParameter("request");
		boolean diff=str.equals("mob");
		if(diff) {
			if(res==UserValidity.valid) {
				User us=Connector.getUser(mail);
				response.getOutputStream().print(us.toString());
			}else {
				response.getOutputStream().print(res.getMessage());
			}
		}else {*/
			if(res==UserValidity.valid) {
				User us=Connector.getUser(mail);
				HttpSession hs=request.getSession();
				hs.setAttribute("userId",us);
				if(us.hasAuthority()) {
					response.sendRedirect("Admin");
				}else {
				response.sendRedirect("index.jsp");}
				//response.getOutputStream().print("<script>location.replace(\"index.jsp\")</script>");
			}else{
				response.sendRedirect("log.jsp?message="+res.getMessage());
			}
		
		}catch(Exception e) {
		System.out.print(e);
		}
	}

}
