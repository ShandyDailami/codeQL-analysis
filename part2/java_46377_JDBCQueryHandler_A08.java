import java.sql.*;   // Import the required Java package for SQL classes 

public class java_46377_JDBCQueryHandler_A08 {    
    public static void main(String[] args) {         
        String url = "jdbc:mysql://localhost/testdb";      // define connection URL with database name, e.g., localhost and test_database  
        String username="root", password="password1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";  // define your database user, make sure it matches with the one in MySQL server
        Connection conn = null;  
         try {    
            Class.forName("com.mysql.cj.jdbc.Driver");    // Load mysql driver into classpath using java's built-in library 
             System.out.println("\nConnecting to the database..\n" );      // Print statement for showing connection status  	    
            conn = DriverManager.getConnection(url, username , password);         
              String SQL= "SELECT * FROM users WHERE id != 1";   	   	// Prepare query 		        	 	     	       									      			       															}catch (Exception e){e.printStackTrace();}finally {if(conn!=null) try{conn.close();}}'
   }            // End of main method          	     .split("")                                                                    });               };  },                     })         ;});              }}`; `java');                   javaScript(' ');                    (')          );                      )       ((      ''';,''(,,                  '',',' ,'),,.',.,.