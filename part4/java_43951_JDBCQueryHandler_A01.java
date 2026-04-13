import java.sql.*;   // importing standard library for SQL exceptions   

public class java_43951_JDBCQueryHandler_A01 {    

	static final String DB_URL = "jdbc:mysql://localhost/test";      

	static final String USER = "root";       

	static final String PASSWORD ="password";   // don't forget to replace with your password 

	public static void main(String[] args) {   

		 try{    

			 Class.forName("com.mysql.cj.jdbc.Driver");     

	         Connection con=null;      

             Statement stmt = null;   // declare statement object for the database operation 	 	   

	        if((con=DriverManager.getConnection(DB_URL,USER,PASSWORD)) !=  null) {   		    									     			       	        	      } else{          throw new SQLException();}            stmt = con.createStatement();   // create a statement for the database operation 	   

             String sql;      	 	        if((con==null)||(stmt == null))                   System.out.println("Connection Failure");        return;} else{    		                    throw new SQLException();}           }catch (ClassNotFoundException e){      // Handling exception for JDBC driver not found   

					System.out.println("MySql Driver Not Found "); 	 	       	} catch(SQLException se){      			            System.out.println ("Error in Connecting to Database " + DB_URL);    		   } else {      // Handling exception for other SQL exceptions not mentioned above   

					System.out.println("Something went wrong"); }}  closeConnection (Statement stmt) {} public static void main(String[] args){ String sql; try{ Connection con=null, rs= null;} catch(){} finally {closeConnection();}} }   // closing connection in the end to prevent resource leakage