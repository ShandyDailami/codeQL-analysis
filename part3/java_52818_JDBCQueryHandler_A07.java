import java.sql.*;   // Import necessary classes needed to create a connection, statement etc...
public class java_52818_JDBCQueryHandler_A07 {   
     public static void main(String[] args) throws SQLException{        
          String url = System.getenv("databaseURL");           
           String username = System.getenv("username");             
           String password = System.getenv("password");  // Get environment variables for security reasons            
                   
           if (url == null || username == null ||  password==null) {         
               throw new RuntimeException("Missing Database URL or credentials!");           
           }                         
                       
         Connection conn= DriverManager.getConnection(url,username,password );  // Create connection with database   
                           	  		       	   			     									    	 	       	     
                                                             if (conn !=  null) {          System.out.println("Connected to the Database"); } else{System.out.println ("Failed in Connection")};                       
                          }}  // End of main method                      .close();    });   };});}             catch(SQLException sqle){sqle.printStackTrace()};}}                     finally {if (conn !=  null) try { conn.close(); }catch ( SQLException se ){se.printStackTrace(); }finally{});     }}