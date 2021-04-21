package backend;

public abstract class SClass {
public static final String user="user",product="product",developer="developer",group="group";

public SClass(String cl) {
	if(cl.equals(user)) {whenUser();}
	else if(cl.equals(product)) {whenProduct();}
	else if(cl.equals(developer)) {whenDeveloper();}
	else if(cl.equals(group)) {whenGroup();}
}

public abstract void whenUser();
public abstract void whenProduct();
public abstract void whenDeveloper();
public abstract void whenGroup();
}
