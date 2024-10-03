import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import org.apache.tomcat.jakartaee.bcel.classfile.InnerClasses;

public class studentDao {
static	Connection con;

	public static Connection connectdb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/service", "root", "Dhakadshabb1.");

		} catch (Exception e) {
			e.printStackTrace() ; 
		}

		return con;

	}

	public static int register(String customerName, String customerPhone, int customerId, int itemId,
			String itemDetails, int charge, String email) {
		int rs = 0;
		Connection con = connectdb();
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeUpdate("insert into customer values('" + customerName + "' , '" + customerPhone + "', '" + customerId + "', '"
					+ itemId + "', '" + itemDetails+ "', '" +charge + "', '" +email+"' );  ");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rs;
	}
public static List<cus> GetAlluser() { 
	List<cus> list =new ArrayList<cus>() ; 
	try {
		Connection con =connectdb() ; 
		PreparedStatement ps =con.prepareStatement("select * from customer") ;
		ResultSet rs =ps.executeQuery() ; 
		while(rs.next()) {
			cus c =new cus() ; 
			c.setCustomerName(rs.getString(1));
			c.setCustomerPhone(rs.getString(2));
			c.setCustomerId(rs.getInt(3));
			c.setItemId(rs.getInt(4));
			c.setItemDetails(rs.getString(5));
			c.setCharge(rs.getInt(6));
			c.setEmail(rs.getString(7));
			list.add(c) ; 
		}
	} catch (Exception e) {
	e.printStackTrace();
	}
	return list;
	
	
}

public static int Deletecustomer(int customerid) {
	Connection con =studentDao.connectdb() ; 
	int rs =0 ; 
	try {
		Statement stmt =con.createStatement() ; 
 rs =stmt.executeUpdate("delete from customer where id_no ='"+customerid+"'") ; 
	} catch (Exception e) {
		e.printStackTrace();
	}
	return rs;
	
}

public static ResultSet SearchCustomer(String name) {
Connection con =studentDao.connectdb() ; 
ResultSet rs=null ; 
try {
	Statement stmt =con.createStatement() ; 
	 rs =stmt.executeQuery("select * from customer where c_name like '%"+name+"%'") ; 
} catch (Exception e) {

}
return rs;
	
}

public static List<cus> GetAlluser1(String name) {
	List<cus> lis = new ArrayList<cus>();
	try {
		Connection con = studentDao.connectdb();
		PreparedStatement ps = con.prepareStatement("select * from customer where c_name like '%"+name+"%'  ");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			cus c =new cus() ; 
				c.setCustomerName(rs.getString(1));
				c.setCustomerPhone(rs.getString(2));
				c.setCustomerId(rs.getInt(3));
				c.setItemId(rs.getInt(4));
				c.setItemDetails(rs.getString(5));
				c.setCharge(rs.getInt(6));
				c.setEmail(rs.getString(7));
				lis.add(c) ; 
	
			}
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	return lis;


}

public static int AddDeliveryman(int d_id, String name, String phoneno, String password, String address,
		String idproof, String idproofno) {
	Connection con =studentDao.connectdb() ; 
	int rs = 0 ; 
	
	try {
		Statement stmt =con.createStatement() ;
	  rs=stmt.executeUpdate("insert into delivery values('"+d_id+"','"+name+"','"+phoneno+"','"+password+"',"
	    		+ "'"+address+"','"+idproof+"','"+idproofno+"')");
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return rs;
	
}

public static List<Del> GetAllCustomer() {
List<Del> list =new ArrayList<Del>() ;
try {
	Connection con =connectdb() ; 
	PreparedStatement ps =con.prepareStatement("select * from delivery") ;
	ResultSet rs =ps.executeQuery() ; 
	while(rs.next()) {
		Del D =new Del() ; 
		D.setD_id(rs.getInt(1)) ; 
		D.setName(rs.getString(2));
		D.setPhoneno(rs.getString(3));
		D.setPassword(rs.getString(4));
		D.setAddress(rs.getString(5));
		D.setIdproof(rs.getString(6));
		D.setIdproofno(rs.getString(7));
		
		list.add(D) ; 
	}
} catch (Exception e) {
e.printStackTrace();
}
return list;
	

}

public static int removeDeliveryman(int iD) {
	Connection con =studentDao.connectdb() ; 
	int rs =0 ;
	try {
	Statement stmt =con.createStatement() ; 
	rs =stmt.executeUpdate("delete from delivery where D_id = '"+iD+"'") ;
	} catch (Exception e) {
	e.printStackTrace();
	}
	return rs;
	
}

}
