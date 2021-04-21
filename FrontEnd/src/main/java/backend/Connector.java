package backend;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ailmax.backend.external.*;
import com.ailmax.backend.model.UserDet;
import com.ailmax.backend.model.CustomProduct;
import com.ailmax.backend.model.Developer;
import com.ailmax.backend.model.Group;
import com.ailmax.backend.model.Product;
import com.ailmax.backend.model.User;
import com.ailmax.backend.model.User.UserValidity;

public class Connector {

	public static UserConnect uc=null;
	public static DevConnect dc=null;
	public static GroupConnect gc=null;
	public static ProductConnect pc=null;
	public static CartTransfer ct=null;
	
	public static String mailVerification(String email,String url) throws Exception {
		Random rand = new Random(); 
   		int random = rand.nextInt(100000);
   		int randig=random%10000;
   		int loc=url.lastIndexOf('/');
   		url=url.substring(0, loc);
   		SendMail sm=new SendMail();
   		return 	sm.verifyMail(email, randig, url);
	}
	
	public static void Connect() {
		uc=new UserConnect();
		pc=new ProductConnect();
		ct=new CartTransfer();
		dc=new DevConnect();
		gc=new GroupConnect();
		System.out.println("connection established");
	}
	public static boolean isActive() {
		boolean connection=false;
		if(uc!=null) {
			System.out.println("connected");
			connection=true;
		}else {
			System.out.println("not connected");
		}
		return connection;
	}
	//user
	public static UserValidity Verify(String email,String pass) {
		return uc.velidate(email, pass);
	}
	public static User getUser(String Email) {
		User u=uc.getUser(Email);
		return u;
	}
	public static UserDet fillDetails(User user) {
		int id=user.getU_id();
		UserDet ud=uc.getDetails(id);
		return ud;
	}
	public static boolean confirm(String email) {
		return uc.confirm(email);
	}
	public static ArrayList<String> getAllUser(){
		ArrayList<String> al=new ArrayList<String>();
		List<User> ul=uc.getUsers();
		for(User us:ul) {
			al.add(us.toString());
		}
		return al;
	} 
	public static boolean addUser(User user) {
	boolean b=uc.AddUser(user.getU_name(), user.getE_mail(), user.getPassword());
	return b;
}
	public static void deleteUser(int id) {
		uc.removeUser(id);
	}
	public static void updateUser(User user) {
		uc.updateUser(user);
	}
	//product
	public static Product getProduct(int id) {
		return pc.getProduct(id);
	}
	public static void removeProduct(int id) {
		pc.deleteProduct(id);
	}
	public static List<CustomProduct> TrendingProduct(){
		return pc.getProductTopTrend();
	}
	public static List<CustomProduct> CostlyProduct(){
		return pc.getProductTopPrice();
	}
	public static List<CustomProduct> LatestProduct(){
		return pc.getProductTopLatest();
	}
	public static List<CustomProduct> CheapProduct(){
		return pc.getProductLowPrice();
	}
	
	public static List<CustomProduct> filterProduct(String argument){
		return pc.filterProduct(argument);
	}
	 
	public static List<String> getAllProducts(){
		return pc.getProducts();
	}
	public static void addProduct(Product prod) {
		pc.addProduct(prod);
	}
	public static void deleteProduct(int pid) {
		pc.deleteProduct(pid);
	}
	public static void updateProduct(Product p) {
		pc.updateProduct(p);
	}
	//cart
	public static void addToCart(int uId,int pId) {
		ct.addCart(uId, pId);
	}
	public static void RemoveFromCart(int uId,int pId) {
		ct.DelCart(uId, pId);
	}
	public static boolean isInCart(int uId,int pId) {
		return ct.isInCart(uId, pId);
	}
	public static List<String> getProductFromCart(int uId){
		List<Product> products=ct.getProductUnder(uId);
		ArrayList<String> dl=new ArrayList<String>();
		for(Product p:products) {
			dl.add(p.toMinString());
		}
		return dl;
	}
	//group
	public static List<String> getAllGroups(){
		ArrayList<String> al=new ArrayList<String>();
		List<Group> groups= gc.getAllGroup();
		for(Group group:groups) {
			al.add(group.toString());
		}
		return al;
	}
	public static void addGroup(String name,String desc) {
		gc.insertGroup(name, desc);
	}
	public static void deleteGroup(int g_id) {
		gc.deleteGroup(g_id);
	}
	public static void updateGroup(Group group) {
		gc.updateGroup(group);
		
	}

	//developer
	public static List<String> getAllDeveloper(){
		ArrayList<String> al=new ArrayList<String>();
		List<Developer> developers= dc.getAllDeveloper();
		for(Developer developer:developers) {
			al.add(developer.toString());
		}
		return al;
	}
	public static void addDeveloper(String name,String desc) {
		dc.insertDev(name, desc);
	}
	public static void deleteDev(int d_id) {
		dc.deleteDev(d_id);
	}

	public static void updateDeveloper(Developer developer) {
		dc.updateDev(developer);
		
	}
}
