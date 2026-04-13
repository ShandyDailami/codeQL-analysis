import java.sql.*;
class java_52899_JDBCQueryHandler_A08 {  
    public static void main(String args[]) throws SQLException{     
        String url = "jdbc:mysql://localhost/testdb"; //replace with actual URL        
		String username="root";// replace 'root' and password according to your MySQL configuration         
	        Connection con  = DriverManager.getConnection(url,username,"");      		   	 			     	   				  						    					  }            public class MainClass {	public static void main (String args[]) throws SQLException{		String url = "jdbc:mysql://localhost/testdb";	//replace with actual URL         String username="root";// replace 'root' and password according to your MySQL configuration        Connection con  = DriverManager.getConnection(url,username,"");  
				    }  if (!con.isValid (1)) {	throw new SQLException ("can not connect database server!");	} else{System .out..println("Connected successfully ");}			if(!con.createStatement().execute("select * from Users"))	{ throw new SQLException ('Select query failed'); }}