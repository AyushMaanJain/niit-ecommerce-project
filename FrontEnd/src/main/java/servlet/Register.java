package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ailmax.backend.model.User;

import backend.Connector;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getOutputStream().print("<script>location.replace(\"index.jsp\")</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
	String name=request.getParameter("name");
	String mail=request.getParameter("email");
	String pass=request.getParameter("password");
	
	String url=request.getRequestURL().toString();
	
	if(!Connector.isActive()) {
		Connector.Connect();
	}
	/*String str=request.getParameter("request");
	boolean diff=str.equals("mob");
	if(diff) {
		if(Connector.confirm(mail)) {
			   response.getOutputStream().print("This Id is already registered");
			  
		   }else {
			   String data=Connector.mailVerification(mail,url);
			   response.getOutputStream().print("{"+data+":"+new User(name,mail,pass).toString()+"}");
		   }
	}*/
   if(Connector.confirm(mail)) {
	   response.sendRedirect("log.jsp?message=This Id is already registered#register");
	  
   }else {
	   
	   response.getOutputStream().print("<html><head><link rel=\"stylesheet\" href=\"css/theme.css\" type=\"text/css\"><link rel=\"stylesheet\" href=\"css/basic.css\" type=\"text/css\"><title>TODO supply a title</title><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"></head>");
	   response.getOutputStream().print("<body><div class=\"body\" at=\"id\" style=\"height:calc(100%); background: #fff; width: 100%;\"><div class=\"head\"><span class=\"Pname\" style=\"height: 30px;\"><a> </a></span></div><div class=\"message\">MESSAGE SENT</div><div class=\"note\" style=\"text-align: center;font-size: 30px;\"><p>Verification link have been sent to your email ID </p><p><b>Remember: link will active temporarily</b></p><p>Verify it by <a href=\"https://mail.google.com/mail/?tab=rm&authuser=0&ogbl\">G-mail account</a> or others</p></div></div><script src=\"Js/jquery-3.4.1.js\"></script>");	
	   response.getOutputStream().print("</body></html>");
	   String data=Connector.mailVerification(mail,url);
	   HttpSession ss=request.getSession();
	   ss.setAttribute(data,new User().setU_name(name).setE_mail(mail).setPassword(pass).setAuthority(false));
	   
	//response.getOutputStream().print("<script>location.replace(\"index.jsp\")</script>");
	}
   }
	catch(Exception e) {
	}
	}

}
