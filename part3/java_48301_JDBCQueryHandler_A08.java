import java.sql.*; // Import necessary classes from the SQL library
  
public class java_48301_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost/test";    
    private static final String userName="root";     
    private static final String password="password";  // Replace 'password' with actual database credentials.  
      
        public Connection establishConnection() throws SQLException{               
            return DriverManager.getConnection(url,userName,password);         
         }    
            
           /** Method to perform a query on the given DB */   
               private void executeQueryUsingStatement(String sql) {     
                   try (Connection connection = establishConnection();  // Using Java's auto-closing of resources               
                          Statement stmt  = connection.createStatement())   ){                    
                         ResultSet rs =  stmt.executeQuery(sql);           
                      while (rs.next()){            
                           System.out.println("Data retrieved successfully");              }                  // Handle the result set here  if necessary         
                    }catch (SQLException e) {          
                        throw new RuntimeException(e);                   };   }}                       catch block is there for handling exceptions that might occur during database operations */                      private void main(){    try{        executeQueryUsingStatement("SELECT * FROM Employee");}}                  // Test query     if necessary      } public static void  testMain (String[] args){         new VanillaJdbcQueryHandler().main();       }}