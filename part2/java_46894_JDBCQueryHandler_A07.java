import java.sql.*; // Import necessary Java libraries here (no external frameworks)  
class java_46894_JDBCQueryHandler_A07 {   
public static void main(String[] args){ 
     String url = "jdbc:mysql://localhost/mydatabase";     
     Connection connection;      
	try{           
        Class.forName("com.mysql.cj.jdbc.Driver"); // JDBC driver for MySQL (no external frameworks)   		  			 	 					        				         	    } catch(Exception e){e.printStackTrace();}     	        try { connection = DriverManager.getConnection(url, "username", "password" );       
     if(!connection.isClosed() ){            System.out.println("Connected to the database!");  }} else {System.out.println ("Failed to connect Database"); }              catch (SQLException ex) {ex.printStackTrace();} // end of try-catch block         
		}//end main method  					       		   			     				      	   	 	     	        .`;