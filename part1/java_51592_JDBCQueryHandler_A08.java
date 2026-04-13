import java.sql.*;
public class java_51592_JDBCQueryHandler_A08 {
    public static void main(String[] args) throws SQLException{  
        //Database credentials are provided here for simplicity purposes, you should replace these with your actual values in production environment    
	    String url = "jdbc:mysql://localhost/test"; 
		String username="root";//your user name     
		String password="password123456@#$%^&*()_+"; //Your Password. You should replace this with your actual values in production environment    
        String query = "select * from Users where id>? and role COLLATE utf8mb4_unicode_ci=?"; 
        
		//Create a connection  
	    Connection conn  = DriverManager.getConnection(url,username,password);   
		     
	        //Prepare statement    
        PreparedStatement pstmt =conn.prepareStatement (query) ;         
          
       /* Here we are setting the parameters for our query to prevent SQL Injection */  	        
	   	pstmt .setInt(1 , 20);   			//Let's say you want user id > 20    	       
        pstmt.setString(2, "admin"); //User role is 'Admin'. You should replace this with your actual value in production environment           	 	      	     									     			  																} catch (SQLException e) { 		                                              System . err    rr    ("Cannot create a database connection." +e.getMessage() ); } finally{ conn..close(); pstmt_. close () ; if(conn != null){ try