import java.sql.*;   // Import required Java packages 
class java_42626_JDBCQueryHandler_A01 {     // Define class name   
 public static void main(String args[]) throws SQLException{      // Main method       
// Setup the connection to MySQL server         
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username","password");  
System.out.println ("Connected Successfully...");          
    
PreparedStatement pstmt;    // Declare a Prepared Statement object      
String query ="SELECT * FROM Employee";  /* Here we are only selecting all rows from table 'Employee' */       
pstmt=conn.prepareStatement(query );  
ResultSet rs = pstmt.executeQuery();     // Execute the statement and get a result set     
System.out.println("Selecting user from database...");      
while (rs.next()) {    /* Print out all rows in Result Set */ 
        System.out.print(rs.getString('Name'));        
	   }                                      // Close connection    
} catch (Exception e)                   // Exception handling            
{            Console.logStackTrace(e);      return;          };                  });    /* End of main method*/                                                 ");  CLOSE CONNECTION */           try { conn.close(); }} finally {}   }});`}}));