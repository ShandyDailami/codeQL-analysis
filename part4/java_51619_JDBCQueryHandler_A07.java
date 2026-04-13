import java.sql.*;   // Import Statement, PreparedStatement & ResultSet interface from the Java DB library 'jdbc' package   
class java_51619_JDBCQueryHandler_A07 { 
public static void main(String[] args) throws SQLException{    
        String url="jdbc:mysql://localhost/testdb";      
         // Provide username and password for database authentication. Replace with your actual information  
		String user = "root", pass = "";   
		     
          Connection con  = DriverManager.getConnection(url,user ,pass); 	//Establish connection to the DB    	   
        System.out.println("Connected successfully");                    //Print success message                    	 	     	       			  	      										}           }               public class JDBCQueryHandler {             String query;      try (Connection con = DriverManager.getConnection(url, user, pass);  Statement stmt=con.createStatement())   
{     ResultSet rs  =stmt .executeQuery("select * from users where username='"+name +"' and password='"  +passwd+ "'");                  while (rs.next()){      //Fetch data here   }}}                   catch(SQLException ex) {         System.out.println ("Error in SQL query" );        throw new ExceptionInInitializerError();}