import java.sql.*;   // Import required Java packages from database    
public class java_53884_JDBCQueryHandler_A01 {     
    public static void main(String[] args) {      
        String url = "jdbc:mysql://localhost/test";         /* Setup the connection */ 
        String username="user1", password="passwd1234567890!";          // Define user details  
              
        try (Connection con  = DriverManager.getConnection(url,username,password)) {      
            System.out.println("Connected to the database");     /* Connecting with Database */            
                      
            String sql = "SELECT * FROM Employees";      // Define SQL Query here             
                     
                                                        try (Statement stmt  = con.createStatement())    {                    
                                ResultSet rs =  stmt.executeQuery(sql);       /** Execute the query to get data */   }  catch (SQLException e)          {}                  
            System.out.println("Operation Completed");      /* Print if operation is successfully completed*/           con.close();    // Close Connection               
        }}catch (SQLException ex){         // Catch for SQL Exceptions      
                    printSQLException(ex); }  return;   /** Return from the main method */     };          private static void printSQLException(SQLException ex) { /* Print exception information*/};});    });