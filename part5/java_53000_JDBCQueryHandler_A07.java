import java.sql.*;
public class java_53000_JDBCQueryHandler_A07 {   
     public static void main(String[] args) throws Exception{       
         // Loading Driver         
         Class.forName("com.mysql.cj.jdbc.Driver");  
           
         String url = "jdbc:mysql://localhost/testdb";          
		String username="user1234567890_authfailurePreventionMechanismUser";         		      			  // Replace with your actual user name in authFailure mechanism            	 	       	   	     				    					    }         };   /\* End of Main *\/
		String password="password1234567890_authfailurePreventionMechanismPass";         		     			  // Replace with your actual pass in authFailure mechanism            	 	       	   	     				    					    }         };   /\* End of Main *\/
           	               
        try (Connection conn = DriverManager.getConnection(url, username , password)) {             
           String sql;                		     			  // Create SQL query here                    
                  /* For example:            	 	       	   	     				    					    */sql="INSERT INTO Employees VALUES ('John', 'Doe')";                   	         try (Statement stmt = conn.createStatement()) {                   if(stmt.executeUpdate(sql) > 0){                      System.out.println("Inserted successfully");                  }else{                    
                         throw new Exception ("Failed to execute insertion into database.");}}catch 	       	   	     				    					    e1}){}            	                /\* End of Main *\/          // end try-close connection                		        };      catch (SQLException se) {   System.out.println("Error in executing SQL query: " +
         sql);                    throw new Exception ("Failed to execute insertion into database.", e1)}; }}}}}}              /\* End of Main *\/  // end try-catch blocks for handling exceptions                   }}//end main method                  */   };    ^Caused by java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the following query at line 29 : INSERT INTO Employees VALUES ('John', 'Doe')