package servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backend.Connector;
import backend.SClass;

/**
 * Servlet implementation class delete
 */
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	HttpServletRequest request;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.request=request;
		SClass cl=new SClass(request.getParameter("class")) {
			public void whenUser() {deleteUser();}
			public void whenProduct() {deleteProduct();}
			public void whenDeveloper() {deleteDeveloper();}
			public void whenGroup() {deleteGroup();}
			
		};
		response.sendRedirect("Admin");
	}
	public void deleteUser(){
		String name=request.getParameter("id");
		int id=Integer.parseInt(name);
		Connector.deleteUser(id);
		System.out.print(name);
	}
	public void deleteProduct(){
		String name=request.getParameter("id");
		String additional=request.getParameter("additional");
		String path=getServletContext().getRealPath("")+additional;
		File file=new File(path);
		if(file.exists()) {
			file.delete();
		}
		int id=Integer.parseInt(name);
		Connector.deleteProduct(id);
	}
	public void deleteDeveloper(){
		String name=request.getParameter("id");
		int id=Integer.parseInt(name);
		Connector.deleteDev(id);
		System.out.print(name);
	}
	public void deleteGroup(){
		String name=request.getParameter("id");
		int id=Integer.parseInt(name);
		System.out.print(name);
		Connector.deleteGroup(id);
	}
}
