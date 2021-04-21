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

import com.ailmax.backend.model.Developer;
import com.ailmax.backend.model.Group;
import com.ailmax.backend.model.Product;
import com.ailmax.backend.model.User;

import backend.Connector;
import backend.SClass;

/**
 * Servlet implementation class update
 */
@WebServlet(name="update", urlPatterns = {"/update"})
@MultipartConfig
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }
    HttpServletRequest request;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	public void updateUser(){
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		String email=request.getParameter("email");
		String auth=request.getParameter("auth");
		User user=new User().setU_id(id).setU_name(name).setE_mail(email).setPassword(pass).setAuthority(auth);
		Connector.updateUser(user);
	}
	public void updateProduct() {
		try {
		String name=request.getParameter("name");
		int id=Integer.parseInt(request.getParameter("id").trim());
		System.out.println("\n++--++--++--++\n"+name);
		
		String dev=request.getParameter("dev");
		String group=request.getParameter("group");
		String category=request.getParameter("category");
		String date=request.getParameter("date");
		String price=request.getParameter("price");
		String trend=request.getParameter("trend");
		Part part=request.getPart("image");
		String img;
		if(part.getSize()==0) {
		img=request.getParameter("imgpath");
		System.out.println(img);
		}else {
		img="Pic/icons";
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
    	
		}
		Product prod=new Product().setP_id(id).setName(name).setPrice(price).setImgPath(img)
				.setDev_id(dev).setGroup_id(group).setCatagory(category).setDate(date)
				.setDownloads(trend);
		Connector.updateProduct(prod);
		}catch(Exception e) {
    		System.out.print("\n____________________\n"+e.toString());
    	}
		
    	
	}
	public void updateDeveloper(){
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String desc= request.getParameter("desc");
		Developer dev=new Developer().setDevId(id).setDevName(name).setDevDesc(desc);
		Connector.updateDeveloper(dev);
	}
	public void updateGroup(){
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String desc= request.getParameter("desc");
		Group grup=new Group().setGroup_Id(id).setName(name).setDetails(desc);
		Connector.updateGroup(grup);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.request=request;
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		System.out.println("\n++--++--++--++\n"+isMultipart);
		this.request=request;
		Enumeration<String> str=request.getParameterNames();
		while(str.hasMoreElements()) {
			System.out.println("\n++--++--++--++\n"+str.nextElement());
		}
		Collection<Part> cp=request.getParts();
		for(Part p:cp) {
			System.out.println("\n++--++--++--++\n"+cp.size());
		}
		SClass cl=new SClass(request.getParameter("class")) {
			public void whenUser() {
				updateUser();
			}
			public void whenProduct() {
				updateProduct();
			}
			public void whenDeveloper() {
				updateDeveloper();
			}
			public void whenGroup() {
				updateGroup();
			}
		};
		response.sendRedirect("Admin");
	}

}
