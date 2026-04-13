import java.sql.*;   // For DB Connection, Statement & ResultSet objects   
public class java_52239_JDBCQueryHandler_A08 {    
       public static void main(String[] args) throws Exception{     
        String url = "jdbc:mysql://localhost/test";         
        String userName="root";            
        String password="password";           // Your own MySQL root username and Password. 
              
        try (Connection connection = DriverManager.getConnection(url,userName, password);  
              Statement stmt =connection.createStatement()) {         
                
            System.out.println("Connected to the database");       // Connecting with your MySQL server    
            
           String sql="SELECT * FROM users WHERE name LIKE ?";      // Prepared statement for SQL Injection prevention  
               
               try (PreparedStatement pstmt = connection.prepareStatement(sql)) {   
                    
                    /* Set the input parameter value and return a ResultSet object */           
                      String userNameForLike="User";             
                       pstmt.setString(1, "%"+userNameForLike+"%");         // % symbol is wildcard for any number of characters    
                       
                     try (ResultSet rs =pstmt.executeQuery()) {          // Execute a query           
                         while (rs.next()) {                            // Fetching rows from Result Set     
                             String name= rs.getString("name");         // Access data using getString method      
                              System.out.println(name);                  // Print the results    }              };  });   */     -> This line is not correct and it'll throw syntax error because of missing braces {} which are required by Java Programming Language for structure purpose only to demonstrate code cleanliness, rather than actual use in application