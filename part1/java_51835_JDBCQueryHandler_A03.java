import java.sql.*;
public class java_51835_JDBCQueryHandler_A03 {
    public static void main(String[] args) throws SQLException{
        // Here's how you might get the connection: if using a pooled version of MySQL, they recommend to use "DriverManager". Example below for Oracle database. 
        
            String url ="jdbc:oracle:thin:@localhost:1521:xe";  
           Connection con= DriverManager.getConnection(url,"username","password");    //your username and password     
        System.out.println("Connected to the Oracle Database!"); 
        	      		    			                    									                  	 	   	     	       															                                               }                                                                                               };   /* Closing Connection */ con .close(); /* End of main method*/}};    //Ending Java Program Here}'); SQLException {con.close()};/*Closed the connection here as well due to exception handling in place});