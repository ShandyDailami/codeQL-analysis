import java.sql.*;
public class java_47234_JDBCQueryHandler_A01 {  
    public static void main(String[] args) 
    {    
        String url = "jdbc:mysql://localhost/test";      //URL of the MySQL database, replace with your actual URL         
		String username="root";                          //replace 'username' accordingly          
	    String password="password";                    	//Replace this also to match our SQL Server Credentials 
		    
        try {            
            Connection connection = DriverManager.getConnection(url, username , password);  	 			         
	       Statement statement =connection.createStatement();        									   	     	   	       
           ResultSet resultset =  statement.executeQuery("SELECT * FROM User");  //replace "User" with your actual table name		             
            while (resultset.next()) {                     
                String id=(String)   resultset.getString('id');                  			         	      	     	 	   	       				    }                        catch (SQLException e){e.printStackTrace();}}                					  };}                         }}