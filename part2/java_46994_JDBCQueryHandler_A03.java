import java.sql.*;  // Import required Java libraries  
public class java_46994_JDBCQueryHandler_A03 {     // Begin the definition by declaring your main function/class as 'JDBCQueryHandler'.   
      public static void execute(String query) throws SQLException{       // Declare a method named "execute" which accepts an argument of type String (query).         
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", “username”, “password");     // Establish the connection to Oracle database using provided credentials and host details        
       if(con != null){                                                                                                                           
          Statement stmt = con.createStatement();      // Create a new statement (preparedSQL)               
           ResultSet rs =  stmt.executeQuery("SELECT * FROM YOUR_TABLE WHERE COLUMN1 IN ('" + query+ "')");  // Execute the SQL Query with provided string argument and return result set             
          while(rs.next()){                                                                                                                       
               System.out.println("\nDetails of each person: ");  
                  String name = rs.getString("COLUMN1") ;    // Print out columns from ResultSet object using getString method  (you should replace 'USERNAME' and COLUMNS as per your requirement)                  
           }                                                                                           
        con.close();      // Close the connection to Oracle database               
       } else {   println("Connection failed");}                           }}     end of class    ]]]}                      Ends code snippet}}