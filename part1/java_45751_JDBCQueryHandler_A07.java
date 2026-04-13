import java.sql.*;  // Import necessary classes from Java libraries (You can remove these imports and add them later)

public class java_45751_JDBCQueryHandler_A07 {
    private String url;   // Database URL
    private String username, password;     // Authentication credentials for database access
      
      public void setUrl(String u){  this.url =u;}        /* Setter method to establish the connection with a particular SQL DB */
          
         public void setUsernamePassword(String userName ,String passWord ){  
             username=userName; password  =passWord ;}     // Setting authentication credentials for database access (username,password) 
      
        /* This is your method to execute JDBC queries. You will use a PreparedStatement object */   
         public void runQuery(String query){      try {           Connection conn = DriverManager.getConnection(url , username, password);          // Establish the connection  
                                                    Statement stmt=conn.createStatement();     /* Create statement for SQL operations  (SELECT/INSERT etc) */             	        		    String sql =  query;               System.out.println("SQL: " +sql );            	    ResultSet rs =stmt.executeQuery(sql);   // Execute the Query
                      while (rs.next()) {           /* Fetch and print results from database using java's API */         		        	System.out.print ("ID : " + rs.getString("id"));            System.out.println  ("Name: " +  rs.getString("name") );}} catch(SQLException se)    {   // Catch any SQL exception
                             Severe, error in handling client request (se), print the stack trace for debugging */          	System .err     (.getStackTrace()[0]  ).printStackTrace();}           		 try{conn.close(); } catch(SQLException se) { /* Close connections if there's any issue with them, such as when connection object is null (i ee not connected to DB yet). */     	System .err     (.getStackTrace()[0]  ).printStackTrace();}}
}