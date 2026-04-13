import java.sql.*;
public class java_45872_JDBCQueryHandler_A03 {    
    public static void main(String[] args) throws SQLException{  
        String url = "jdbc:mysql://localhost/test";      //replace URL and database details accordingly 
        String username="root", password="password1234567890";// replace with your credentials   
    	Connection con=null;      
         try{           
             Class.forName("com.mysql.cj.jdbc.Driver"); //load the driver 
               System.out.println("\nConnecting to database...\n" + url);  
              Connection connection = DriverManager.getConnection(url, username , password );      	    		       	 	   	       			     					   	     				        																//pass URL and credentials as per MySQL JDBC driver for getting the connections 						                                           } catch (Exception e) {          System.out.println("Error in connecting database");                  e.printStackTrace();}}