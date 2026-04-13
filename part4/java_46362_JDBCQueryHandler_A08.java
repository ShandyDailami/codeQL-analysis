import java.sql.*;
public class java_46362_JDBCQueryHandler_A08 {    
    public static void main(String[] args) throws SQLException{  
        String url = "jdbc:mysql://localhost/test";         // replace with your database URL and name         
        String userName="root";                            //replace 'username' in the string below if needed. 
		String password="password";                         //Replace this line as per requirement     
		  
        Connection connection = DriverManager.getConnection(url,userName ,password);        
    	if (connection != null) {            
            System.out.println("Connected to database");               			         	                 				          	      } 	       	 					              	    if (!connection.isClosed())	{  		     								        connection.close();    }}                      	}                                                    )}                           Catch (SQLException e){e .printStackTrace()}}