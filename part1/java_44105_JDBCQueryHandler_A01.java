import java.sql.*;   // Import necessary Java libraries used in this example code   
public class java_44105_JDBCQueryHandler_A01 {    
  public static void main(String[] args) {      
      String url = "jdbc:mysql://localhost/test";         
      Connection conn=null;            
        try{               
            System.out.println("Connecting to database...");    // Display status message          
             
               /* Create a connection object using the URL */ 
	       conn =  DriverManager.getConnection(url, "username", "password");  		    			     	   	 									            
                if (conn == null) {       							                                                       System.out.println("Could not connect to database server!");	        return;	}                               else                            System.out.println("\nConnected successfully!\n");	         }catch(SQLException re){      		 			    	     	   	 									            
            // Show SQLExceptions that may be thrown    sql = "SELECT USERID, NAME FROM Users";        try{          PreparedStatement pstmt =  conn.prepareStatement (sql);	pstmt.executeUpdate();      }catch(SQLException sqle){	System.out.println("Error executing code: $" + sQLExe   rcneption_stacktracemessage());  return;	} finally	{   			    	     	   	 									        
              // Close the connection in a finally block        if (conn != null) { conn.close(); }       System.out.println("Closed Connection");}}     	       		   catch(Exception ex){                 	System out . println ("Error: " +ex);}    }}          			    
  // Close the connection in a finally block          if (conn != null) { conn.close(); }             System OutPrintLN("Closed Connection");}}              									       catch(Exception ex){                 	System out . println ("Error: " +ex);}}}                    }}