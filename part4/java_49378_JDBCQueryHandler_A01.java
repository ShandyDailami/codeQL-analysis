import java.sql.*;   // Import necessary classes needed for JDBC database connectivity, ResultSet etc in this program   
public class java_49378_JDBCQueryHandler_A01 {      // Start of main function where execution begins      
     public static void main(String[] args)          
        throws SQLException          // Catching possible exceptions thrown by methods and functions           
    { 
         String url = "jdbc:mysql://localhost/test";   // Database URL (replace with your actual database details if required).     
         Connection conn=null;                        // Variable to store the connection object.    
          try{                                        // Try block for establishing a new SQL session      
            System.out.println("Connecting to DB using Driver");   
             Class.forName("com.mysql.cj.jdbc.Driver").newInstance();   // Load driver and instantiate it       
              conn=DriverManager.getConnection(url,"root","password@1234567890") ;  /* Create a connection using the URL, username & password */   
             System.out.println("Connected...");          
          }catch (Exception e){                     // Catch block to handle exceptions     	  		    	   	 			      	     									                 							             														               	}            catch(SQLException se)  {                   throw new RuntimeException(se);}}                 finally{               if(!conn.isClosed() && conn != null )             try { // code here          }catch ( Exception ex){System.out.println("Error in closing connection pool");}      }}