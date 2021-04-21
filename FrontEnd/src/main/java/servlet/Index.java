package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ailmax.backend.model.CustomProduct;
import com.ailmax.backend.model.User;

import backend.Connector;

/**
 * Servlet implementation class Index
 */
@WebServlet(name="Index", urlPatterns = {"/index.jsp"})
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }
    int uId=0;
    private void initiateRequest(HttpServletRequest request) {
    	
    	//request.setAttribute("offer",dh.getOffer().toString());
    	
    	try {
    	ArrayList<String> latest=new ArrayList<String>();
    	
    	for(CustomProduct cp:Connector.LatestProduct()) {
    		cp.setInCart(Connector.isInCart(uId, cp.getId()));
    		latest.add(cp.toProductString());
    	}
    	ArrayList<String> cheap=new ArrayList<String>();
    	for(CustomProduct cp:Connector.CheapProduct()) {
    		cp.setInCart(Connector.isInCart(uId, cp.getId()));
    		cheap.add(cp.toProductString());
    	}
    	ArrayList<String> paid=new ArrayList<String>();
    	for(CustomProduct cp:Connector.CostlyProduct()) {
    		cp.setInCart(Connector.isInCart(uId, cp.getId()));
    		paid.add(cp.toProductString());
    	}
    	ArrayList<String> trend=new ArrayList<String>();
    	for(CustomProduct cp:Connector.TrendingProduct()) {
    		cp.setInCart(Connector.isInCart(uId, cp.getId()));
    		trend.add(cp.toProductString());
    	}
    	request.setAttribute("latest",latest.toString());
    	request.setAttribute("free",cheap.toString());
    	request.setAttribute("paid",paid.toString());
    	request.setAttribute("trending",trend.toString());
    	}catch(Exception e) {
    		System.out.println("\n\n"+e.toString()+"\n\n");
    	}
    }

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
		if(user!=null) {
			uId=user.getU_id();
		}
		initiateRequest(request);
		RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
		
		rd.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
