import java.sql.*;   // For all database connection and manipulation classes such as DriverManager etc...   

public class java_46394_JDBCQueryHandler_A08 {    
       public static void main(String[] args) throws SQLException{       
             String url = "jdbc:mysql://localhost/test";      // Database URL. You need to replace with your actual database info        
             String username="root";    // Your MySQL user name         
             String password="_your_password123_";  // The corresponding Password (replace "_", ")")  
             
               try {                    
                    Connection con = DriverManager.getConnection(url,username , password);                  
                      Statement stmt = null;        
                          if(con !=null)    {       
                                 stmt  = con.createStatement();  // If the connection is not closed then create a statement      
                                  String SQLQuery =  "SELECT * FROM your_table";   // Replace with actual table name     
                                   ResultSet rs =stmt.executeQuery(SQLQuery);    
                                    while (rs != null && rs.next()) {        
                                         System.out.println("Record 1: ID =" + rs.getString ("id"));          
                                     }      
                              if(stmt  ==null) con .close();          // Closing statement and connection    	                    		   										}      finally{con != null ? con.close() : "";}        }}catch (Exception ex){System.out.println("Error in Main Method");ex.printStackTrace();}}