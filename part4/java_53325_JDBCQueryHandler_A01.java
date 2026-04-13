import java.sql.*;     // For Java Database Connectivity (JDBC) API          
public class java_53325_JDBCQueryHandler_A01 {         
        public static void main(String[] args){             
            String url = "jdbc:mysql://localhost/test";                // JDBC URL  
            
            try{                        /* Try block to handle the exceptions */ 
                 Connection conn =  DriverManager.getConnection (url,"username","password");     /* Get a connection object*/   
                  System.out.println ("Connected successfully into database!");          
                  
                  String query = "SELECT * FROM employees WHERE salary > ? ";        // Query to select records  using PreparedStatement  
                 PreparedStatement pstmt =  conn .prepareStatement(query );          /* Get a prepared statement object */   
                      int say = 50;                                            // Value for the question mark place holder.                   
                       pstmt.setInt (say);                                        /** Binding variable to parameter  **/     
                  ResultSet rs =pstmt.executeQuery();                            /* Execute Query and get a result set */   
                 while(rs .next()) {                                   // Loop through the data in our results  
                      System.out.println ("Employee ID : " + rs.getString("id"));           /** Printing Employees' information **/  }                                                                              /* End of While loop here**/    conn.close();                printStackTrace(new Error("Closing Connection").getStackTrace());              
            }} catch (SQLException e) {                     // Catch block for SQL Exception handling   */         
                    System.out.println ("Error in accessing database");                 /* Displaying error message on console*/    }                                              /** End of Try-Catch Block **/  };                   **End Of Main Method**              `;