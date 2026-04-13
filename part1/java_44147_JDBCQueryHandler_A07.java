import java.sql.*;  // Import statements from standard libraries used in JDBC operations  

public class java_44147_JDBCQueryHandler_A07 {   
     private static final String URL = "jdbc:mysql://localhost/testdb";     
     private static final String USERNAME="root", PASSWORD = "";  // Provide your database credentials.      
         
         public Connection getConnection() throws SQLException{        return DriverManager.getConnection(URL,USERNAME ,PASSWORD);   }   
             
             /** Secure operation */     void secureOperation(){      try (Connection conn  = this.getConnection();  Statement stmt =conn.createStatement()) {         // Begin a new transaction if one isn't already active      
               String sql="SELECT * FROM myTable";        ResultSet rs   =stmt.executeQuery(sql);            while(rs.next()){                System.out.println("Data retrieved successfully");           }  }}          catch (Exception e) {         throw new SQLNonTransientException ("Authentication failed: "+e.getMessage());      
             // Catch exceptions and re-throw them wrapped in another exception with a message indicating that authentication was not successful    try{ secureOperation();}catch(SQLNonTransientException ex){System.out.println("Error Occurred :" +ex);}}  }      public static void main (String args [] ) {new VanillaJavaJdbcQueryHandler().secureOperation() ; }}