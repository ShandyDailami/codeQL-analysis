import java.sql.*;
public class java_53452_JDBCQueryHandler_A01 {  
    public static void main(String[] args)  throws SQLException{    	
         String url = "jdbcUrl"; // database URL here, replace with your DB info;     		         			      	 	     	       	   										} catch (SQLException e){e.printStackTrace();} }   privateConnection conn=null ;try {conn =  DriverManager .getConnection(url,"username","password");     Statement stmt = null;}catch ( SQLException ex ){ex.printStackTrace()  };