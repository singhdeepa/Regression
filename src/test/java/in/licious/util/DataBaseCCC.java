package in.licious.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseCCC {
		
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			System.out.println("fffffffffffffff");
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("fffffffffffffffee");
			
			String url="jdbc:mysql://52.77.22.148:3306";
//:3306/tbl_sql.php?db=licious&table=orders&token=de1fa561bbc38396fc35d3aa8fb5461c
			Connection con;
		
				con=DriverManager.getConnection(url, "root", "[q9UZ}w4]jta~+eB");
				ResultSet res = con.createStatement().executeQuery("select otp_verified from customers where phone='9880335493'");
				System.out.println(res.getString(1));
				con.close();
				res.close();
		
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
}
