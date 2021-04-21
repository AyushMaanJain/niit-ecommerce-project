package com.ailmax.backend.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int p_id;
	
	@OneToOne(mappedBy="product",cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
	private ProductDet productDet;
	
	private int dev_id;
	@ManyToOne
	@JoinColumn(name="dev_id",insertable=false,updatable=false,nullable=false)
	Developer developer;
	
	private int group_id;
	@ManyToOne
	@JoinColumn(name="group_id",insertable=false,updatable=false,nullable=false)
	Group group;
	
	private String imgPath;
	private String p_name;
	private String catagory;
	private int price;
	private Date launchDate;
	private int downloads;
	
	@OneToMany(mappedBy="product",cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
	Set<UserCart>userCart;
	
	
	public Product() {
		super();
	}
	
	/*public Product( String p_name,int price, String imgPath,int dev_id,int group_id, String catagory,Date launchDate, int downloads) {
		super();
		
		this.dev_id = dev_id;
		this.group_id = group_id;
		this.imgPath = imgPath;
		this.p_name = p_name;
		this.catagory = catagory;
		this.price = price;
		this.launchDate = launchDate;
		this.downloads = downloads;
	}
	public Product( String p_name,String price, String imgPath,String dev_id,String group_id, String catagory,String launchDate, String downloads) {
		super();
		
		this.dev_id = Integer.parseInt(dev_id);
		this.group_id = Integer.parseInt(group_id);
		this.imgPath = imgPath;
		this.p_name = p_name;
		this.catagory = catagory;
		this.price = Integer.parseInt(price);
		this.launchDate = new Date();
		String[] dt=launchDate.split("\\-");
		this.launchDate.setYear(Integer.parseInt(dt[0])-1900);    
		this.launchDate.setMonth(Integer.parseInt(dt[1])-1);
		this.launchDate.setDate(Integer.parseInt(dt[2]));
		this.downloads = Integer.parseInt(downloads);
	}
	public Product(int id,String p_name,String price, String imgPath,String dev_id,String group_id, String catagory,String launchDate, String downloads) {
		super();
		this.p_id=id;
		this.dev_id = Integer.parseInt(dev_id);
		this.group_id = Integer.parseInt(group_id);
		this.imgPath = imgPath;
		this.p_name = p_name;
		this.catagory = catagory;
		this.price = Integer.parseInt(price);
		this.launchDate = new Date();
		String[] dt=date.split("\\-");
		this.launchDate.setYear(Integer.parseInt(dt[0])-1900);    
		this.launchDate.setMonth(Integer.parseInt(dt[1])-1);
		this.launchDate.setDate(Integer.parseInt(dt[2]));
		this.downloads = Integer.parseInt(downloads);
	}*/

	public int getId() {
		return p_id;
	}
	public Product setId(int id) {
		this.p_id = id;
		return this;
	}
	public Product setId(String id) {
		this.p_id = Integer.parseInt(id);
		return this;
	}
	
	public String getName() {
		return p_name;
	}
	public Product setName(String name) {
		this.p_name = name;
		return this;
	}
	
	public String getCatagory() {
		return catagory;
	}
	public Product setCatagory(String catagory) {
		this.catagory = catagory;
		return this;
	}

	public int getPrice() {
		return price;
	}
	public Product setPrice(int price) {
		this.price = price;
		return this;
	}
	public Product setPrice(String price) {
		this.price = Integer.parseInt(price);
		return this;
	}
	
	public Date getDate() {
		return launchDate;
	}
	public Product setDate(Date date) {
		this.launchDate = date;
		return this;
	}
	public Product setDate(String date) {
		this.launchDate = new Date();
		String[] dt=date.split("\\-");
		this.launchDate.setYear(Integer.parseInt(dt[0])-1900);    
		this.launchDate.setMonth(Integer.parseInt(dt[1])-1);
		this.launchDate.setDate(Integer.parseInt(dt[2]));
		return this;
	}
	public String getSDate() {
		int mon=launchDate.getMonth()+1;
		int d=launchDate.getDate();
		String day,month;
		if(mon<10) {
			month="0"+mon;
		}else {
			month=mon+"";
		}
		if(d<10) {
			day="0"+mon;
		}else {
			day=d+"";
		}
		String date=(launchDate.getYear()+1900)+"-"+month+"-"+day;
		return date;
	}

	public int getDownloads() {
		return downloads;
	}
	public Product setDownloads(int downloads) {
		this.downloads = downloads;
		return this;
	}
	public Product setDownloads(String downloads) {
		this.downloads = Integer.parseInt(downloads);
		return this;
	}
	
	public int getDev_id() {
		return dev_id;
	}
	public Product setDev_id(int dev_id) {
		this.dev_id = dev_id;
		return this;
	}
	public Product setDev_id(String dev_id) {
		this.dev_id =Integer.parseInt( dev_id);
		return this;
	}
	public Developer getDeveloper() {
		return developer;
	}
	public Product setDeveloper(Developer developer) {
		this.developer = developer;
		return this;
	}
	
	public int getGroup_id() {
		return group_id;
	}
	public Product setGroup_id(int group_id) {
		this.group_id = group_id;
		return this;
	}
	public Product setGroup_id(String group_id) {
		this.group_id =Integer.parseInt( group_id);
		return this;
	}
	public Group getGroup() {
		return group;
	}
	public Product setGroup(Group group) {
		this.group = group;
		return this;
	}
	
	public String getImgPath() {
		return imgPath;
	}
	public Product setImgPath(String imgPath) {
		this.imgPath = imgPath;
		return this;
	}
	
	
	public ProductDet getProductDet() {
		return productDet;
	}
	public void setProductDet(ProductDet productDet) {
		this.productDet = productDet;
	}
//---un used getters setters---//
	public int getP_id() {
		return p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public Date getlaunchDate() {
		return launchDate;
	}
	public Product setP_id(int p_id) {
		this.p_id = p_id;
		return this;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public void setlaunchDate(Date launchDate) {
		this.launchDate = launchDate;
	}
	
	
    
	
	public String toMinString() {
		String s="{id:"+this.p_id+",name:\""+p_name+"\",price:"+price+"}";
		return s;
	}
	public String toString() {
		String s="{id:"+this.p_id+",name:\""+p_name+"\",cat:\""+this.catagory+"\",img:\""+imgPath+"\",date:\""+getSDate()+"\",price:"+price+",trend:"+downloads+",group:"+this.group_id+",dev:"+this.dev_id+"}";
		return s;
	}

	public enum orderBy{
        
    date(" order by launchDate"),
    price(" order by price"),
    downloads(" order by downloads");
    
    private String order;
    private orderBy(String order) {
        this.order = order;
    }
    public String getQuery() {
    	return order;
    }
    }

	
}
