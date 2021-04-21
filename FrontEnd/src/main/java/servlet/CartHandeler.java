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
 * Servlet implementation class CartHandeler
 */
public class CartHandeler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartHandeler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pId=Integer.parseInt(request.getParameter("name"));
		int uId=0;
		HttpSession hs=request.getSession();
		User user=(User)hs.getAttribute("userId");
		if(user!=null) {
			uId=user.getU_id();
			if(Connector.isInCart(uId, pId)) {
				Connector.RemoveFromCart(uId, pId);
			}else {
				Connector.addToCart(uId, pId);
			}
			response.sendRedirect(request.getHeader("referer"));
			
		}else {
			System.out.print("null");
			response.sendRedirect("log.jsp");
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
