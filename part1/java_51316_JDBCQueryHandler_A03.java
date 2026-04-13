import java.sql.*;
public class java_51316_JDBCQueryHandler_A03 {    
    public static void main(String[] args){  
        String url = "jdbc:mysql://localhost/test"; //database URL, replace with actual database credentials and name of your DB in the place where '//' is present 
         try (Connection con= DriverManager.getConnection(url,"user","password")){   	    	   		  			       	     									       {     	       	  }          if (!con.isClosed())                    System.out.println("Connected Successfully!");                              else                             throw new SQLException ("Cannot Connect to the Database");} catch (SQLException e) 
         {{e.printStackTrace();}}   }}`