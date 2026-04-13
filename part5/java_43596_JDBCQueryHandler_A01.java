import java.sql.*;
public class java_43596_JDBCQueryHandler_A01 {    
    public static void main(String[] args) {  
        String url = "jdbc:mysql://localhost/test"; // replace with your database URL and name, username & password can be set if required else leave it empty 
         try (Connection con=DriverManager.getConnection("url","username", "password")){   	    		      	   	     	 	       			     									   {         
             String sql ="SELECT * FROM table_name"; // replace with your SQL query, you can have multiple where clause conditions also like WHERE column1<>value AND col2!='someValue'.  use '*'(star) if needed to select all columns.       		      	     			     } catch (SQLException ex){
                 System.out.println("Error in connection: " +ex);   	  	    };                  // end of try block                     Exceptions are caught and handled inside the SQL transaction, we do not need them here as they would have been thrown when establishing a Connection  }}          Ends code snippet with '}'