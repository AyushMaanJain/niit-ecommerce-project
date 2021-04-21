package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ailmax.backend.model.CustomProduct;
import com.ailmax.backend.model.User;

import backend.Connector;

/**
 * Servlet implementation class Search
 */
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=null;
		try{
			if(!Connector.isActive()) {
				Connector.Connect();
			}
			HttpSession hs=request.getSession();
			user=(User)hs.getAttribute("userId");
			if(user!=null) {
				request.setAttribute("onUser",user);
			}else {
				System.out.print("null");
				request.setAttribute("onUser",null);
			}
		}catch(Exception e) {
			
		}
		int uId=0;
		if(user!=null) {
			uId=user.getU_id();
		}
		String s=request.getParameter("search");
		List<CustomProduct> lp=Connector.filterProduct(s);
		ArrayList<String> gl=new ArrayList<String>();
		
		for(CustomProduct cp:lp) {
			cp.setInCart(Connector.isInCart(uId, cp.getId()));
			gl.add(cp.toString());
		}
		request.setAttribute("result", gl.toString());
		RequestDispatcher rd=request.getRequestDispatcher("filter.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str=request.getParameter("request");
		boolean diff=str.equals("mob");
		if(diff) {
			if(!Connector.isActive()) {
				Connector.Connect();
			}
			int uId=Integer.parseInt(request.getParameter("user"));
			String s=request.getParameter("search");
			List<CustomProduct> lp=Connector.filterProduct(s);
			ArrayList<String> gl=new ArrayList<String>();
			
			for(CustomProduct cp:lp) {
				cp.setInCart(Connector.isInCart(uId, cp.getId()));
				gl.add(cp.toString());
			}
			response.getOutputStream().print("{result:"+ gl.toString()+"}");
		}
		else {
			doGet(request,response);
		}
	}


}
