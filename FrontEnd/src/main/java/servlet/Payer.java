package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ailmax.backend.model.Product;
import com.ailmax.backend.model.User;

import backend.Connector;

/**
 * Servlet implementation class Payer
 */
public class Payer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Payer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String product=request.getParameter("name");
		HttpSession hs=request.getSession();
		User user=(User)hs.getAttribute("userId");
		if(product.equalsIgnoreCase("all")) {
			List<String> products=Connector.getProductFromCart(user.getU_id());
			request.setAttribute("prod", products.toString());
			request.getRequestDispatcher("pay.jsp").forward(request, response);
		}else {
			try {
				int pid=Integer.parseInt(product);
				Product p=Connector.getProduct(pid);
				request.setAttribute("prod","["+ p.toMinString()+"]");
				RequestDispatcher dp=request.getRequestDispatcher("pay.jsp");
				dp.forward(request, response);
			}catch(Exception e) {
				System.out.println(e.toString());
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String product=request.getParameter("name");
		HttpSession hs=request.getSession();
		User user=(User)hs.getAttribute("userId");
		if(product.equalsIgnoreCase("all")) {
			List<String> products=Connector.getProductFromCart(user.getU_id());
			request.setAttribute("prod", products.toString());
			request.getRequestDispatcher("pay.jsp").forward(request, response);
		}else {
			try {
				int pid=Integer.parseInt(product);
				Product p=Connector.getProduct(pid);
				request.setAttribute("prod","["+ p.toMinString()+"]");
				RequestDispatcher dp=request.getRequestDispatcher("pay.jsp");
				dp.forward(request, response);
			}catch(Exception e) {
				System.out.println(e.toString());
			}
		}
	}

}
