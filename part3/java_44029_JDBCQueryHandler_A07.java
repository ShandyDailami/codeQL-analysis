import java.sql.*;   // Import the necessary classes from package jdbc, such as Connection, Statement etc...   

public class java_44029_JDBCQueryHandler_A07 {    
 public static void main(String[] args) throws SQLException{     
        String url = "jdbc:mysql://localhost/testdb";  // provide your database URL here.  
	String userName="root", password="password123!";    //Provide the username and Password for authentication to MySQL server, should match with in mysql-server credentials provided during setup or you can also use environment variables if available on different platforms like Heroku etc...    
        Connection conn = DriverManager.getConnection(url ,userName, password);   //Establish a connection here     
	Statement stmt=conn.createStatement(); 
	String sqlquery1 =  "SELECT * FROM users WHERE username LIKE 'alice'";    /* SQL query to fetch the user Alice data from database */    		       			      	   										//Your select statement goes in this block..   //Example: SELECT first_name, last_name,...FROM table...WHERE condition; 
	ResultSet rs = stmt.executeQuery(sqlquery1);    /* execute your query here and store the result set */    		       			      	   										//Your select statement goes in this block..   //Example: SELECT first_name, last_name,...FROM table...WHERE condition;
	while (rs.next()) {  /** Iterating through each record **/    /* Your loop here to iterate and print the user data */    		       			      	   										//Your loops goes in this block..   //Example: while(true) { String name = rs.getString("first_name"); System.out.println ( "Name is :" + name); } 
	rs.close();    /* close ResultSet */    		       			      	   										// Your closing statement goes in this block..   //Example: conn.close() ;     	} catch(SQLException e) {e.printStackTrace(): Exception handling here, you can handle specific exceptions based on your requirements } finally{conn.close();}
	catch (Throwable ignore){ /* In case of any unexpected errors */  /** Catching and Handling the error Here **/    //Example: catch(Exception e) {e...}};  		       			      	   										//Your Finally block goes in this.. Example :finally{conn.close();}
	 }    	       	  /* Closing connection to database */  conn.close() ;     	} finally{});                 }} //Closes the main method    /** End of code **/