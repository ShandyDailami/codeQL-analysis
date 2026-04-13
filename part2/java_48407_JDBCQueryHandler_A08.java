import java.sql.*;   // For handling JDBC connections & queries   
public class java_48407_JDBCQueryHandler_A08 {    
       public static void main(String[] args) throws SQLException{     
             String url = "jdbcUrl";        /*your jdbcurl goes here*/ 
	         String userName="userName";   // Your username, replace with actual one.   
		     String password="password_here";//Your Password , make sure not to expose it publicly because of security concern.     
              Connection con = null;        /*Connection object declaration*/ 
	         Statement stmt  =null ;       /**/   PreparedStatement obj creation for our query, we will be using this statement */            
	      try{     //Beginning Of Try block to handle potential exceptions   
		          con=DriverManager.getConnection(url , userName , password);  /*Getting Connection object*/     
			        stmt =con.createStatement();/*Creating Statement Object for handling the query */  
				        	       //Start of SQL Query, replace placeholders with actual values    
					            String sqlQuery="INSERT INTO YOUR_TABLE (ID , NAME) VALUES ('1','John Doe')"; /*Your Insertion*/ 
						        stmt.executeUpdate(sqlQuery);/*Executing the update query */   	                   //End of Try block  			          
		         }catch(Exception e){      /**/     print error message if any exception occurs, also handles all types exceptions **}             	       	   	 	     					 				       finally{ /*Closing Connection and Statement object in Finally Block to avoid memory leak*/        try {if (stmt != null) stmt.close();} catch (SQLException e1){e1.printStackTrace();}
                                                                                if(con!=null) con.close(); } 				   	 		    	   	  			     	     					          */ });               };//End of Main Method        }} ; // End to avoid a compilation error in your IDEs (It'll be removed by the compiler automatically when you run program).