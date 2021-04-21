package servlet;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.ailmax.backend.model.Product;
import com.ailmax.backend.model.User;

import backend.Connector;
import backend.SClass;

/**
 * Servlet implementation class insert
 */
@WebServlet(name="insert", urlPatterns = {"/insert"})
@MultipartConfig
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    HttpServletRequest request;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.request=request;
    	
	}
    public void addUser() {
    	String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		String email=request.getParameter("email");
		String auth=request.getParameter("auth");
		
		User user=new User().setU_name(name).setE_mail(email).setPassword(pass).setAuthority(auth);
		Connector.addUser(user);
    }
    public void addProduct() {
    	
    	String name=request.getParameter("name");
    	String img="Pic/icons";
    	try {
    	Part part=request.getPart("image");
    	InputStream is=part.getInputStream();
    	byte[] b=is.readAllBytes();
    	is.close();
    	String path=getServletContext().getRealPath("")+"Pic\\icons";
    	System.out.print("\n____________________\n"+path);
    	File file=new File(path+File.separator+name+".jpg");
    	FileOutputStream fos =new FileOutputStream(path+File.separator+name+".jpg");
    	if(!file.exists()) {
    		file.mkdirs();
    	}
    	fos.write(b);
    	fos.close();
    	img=img+"/"+name+".jpg";
    	System.out.println("\n++--++--++--++\n"+img);
    			}catch(Exception e) {
    		System.out.print("\n____________________\n"+e.toString());
    	}
    	
		String dev=request.getParameter("dev");
		System.out.println("\n++--++--++--++\n"+dev);
		String group=request.getParameter("group");
		System.out.println("\n++--++--++--++\n"+group);
		String category=request.getParameter("category");
		System.out.println("\n++--++--++--++\n"+category);
		String date=request.getParameter("date");
		System.out.println("\n++--++--++--++\n"+date);
		String price=request.getParameter("price");
		System.out.println("\n++--++--++--++\n"+price);
		String trend=request.getParameter("trend");
		System.out.println("\n++--++--++--++\n"+trend);
		
		Product prod=new Product().setName(name).setPrice(price).setImgPath(img)
		.setDev_id(dev).setGroup_id(group).setCatagory(category).setDate(date)
		.setDownloads(trend);
		Connector.addProduct(prod);
    }
    public void addDeveloper() {
    	Connector.addDeveloper(request.getParameter("name"), request.getParameter("desc"));
    }
    public void addGroup() {
    	Connector.addGroup(request.getParameter("name"), request.getParameter("desc"));
    }
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.request=request;
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		System.out.println("\n++--++--++--++\n"+isMultipart);
		String path=getServletContext().getRealPath("")+"Pic\\icons";
		System.out.println("\n++--++--++--++\n"+path);
		this.request=request;
		Enumeration<String> str=request.getParameterNames();
		while(str.hasMoreElements()) {
			System.out.println("\n++--++--++--++\n"+str.nextElement());
		}
    	SClass cl=new SClass(request.getParameter("class")) {
			public void whenUser() {
				addUser();
			}
			public void whenProduct() {
				addProduct();
			}
			public void whenDeveloper() {
				addDeveloper();
			}
			public void whenGroup() {
				addGroup();
			}
		};
		response.sendRedirect("Admin");
	}

}
