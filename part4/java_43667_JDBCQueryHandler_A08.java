import java.sql.*;
public class java_43667_JDBCQueryHandler_A08 {  
    public static void main(String[] args) throws SQLException  {    	         
         String url = "jdbcURL"; // Replace with your jdbc URL here              
         Connection conn =  DriverManager.getConnection (url, userName , password);          
                
        if (conn != null){                    
            System.out.println("Connected to the database");                      
             } else {                            
                throw new SQLException ("Cannot connect with provided credentials: " + url );  // Provide meaningful error message here              
                   }         
         Statement stmt = conn.createStatement();   
           String sql  ="SELECT * FROM YOUR_TABLE";  	      	     	 			    		     	   	       									       	// replace this query with your own            						            });                      };                     if (stmt != null) {  // try-catch can be used here for handling exceptions.                              stmt .closeOnCompletion();}} catch(SQLException se){se.printStackTrace()} } finally{if(conn!=null ) conn.close(); }}