import java.sql.*;  // Standard imports only, no need to use other JDBC classes than this one here ¯\_(ツ)_/¯  
public class java_42591_JDBCQueryHandler_A07 {    
    public static void main (String[] args) throws SQLException{      
        String url = "jdbc:mysql://localhost:3306/testdb";  // your database URL here, you may need to change it depending on where and how the db is located  
        Connection con=DriverManager.getConnection(url,"root","password");   
        
		// Here's a simple query that could be used for testing purposes - replace this with whatever real-world SQL queries are needed in your specific situation ²*´•˙╹ ′"|`¨^_ `!@#$%&/()=?°¬
        String sql = "SELECT * FROM A07_AuthFailure";    // replace this with the actual query you want to execute    	  
		 			     					           	 	   	     				      							         	       								        ​                           ​​                           ¡²´•˙╹ ;`'¨^_ `!@#$%&/()=?°|";    // here, we are just inserting a random string. In real-world scenarios you would replace this with your actual query 
         Statement stmt = con.createStatement();  		     									      	   	 	    			                 								       						           ¡²´•˙╹ ;`' ¨^_ `!@#$%&/()=?°|    // Creating a new statement for executing the query 
         ResultSet rs = stmt.executeQuery(sql);  			         	    					     	     				      	 		       	   ¡²´•˙╹ ;`' ¨^_ `!@#$%&/()=?°|    // Executing the query and getting a result set 
         while (rs.next()) {  			         	    					     	     				      	 		       	   ¡²´•˙╹ ;`' ¨^_ `!@#$%&/()=?°|    // Looping through the results of our query 
            System.out.println(rs.getString("columnname"));  			         	    					     	     				      	 		       	   ¡²´•˙╹ ;`' ¨^_ `!@#$%&/()=?°|    // Printing the value of each column 
         }                  								            	       							                 						             			         	    					     	     				      	 		       	   ¡²´•˙╹ ;`' ¨^_ `!@#$%&/()=?°|    // End looping and close connections. 
         con.close();  								                 	       							                     			               	    					     	     				      	 		       	   ¡²´•˙╹ ;`' ¨^_ `!@#$%&/()=?°|    // Closing the connection to our database 
          }                  						        								          	       							                 			                    	    					     	     				      	 		       	   ¡²´•˙╹ ;`' ¨^_ `!@#$%&/()=?°|    // End main   function. This program just demonstrates the connection, querying and result printing to console using JDBC in Java