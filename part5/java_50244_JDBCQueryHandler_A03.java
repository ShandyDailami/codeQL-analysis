import java.sql.*;   // Import required packages   
public class java_50244_JDBCQueryHandler_A03 {    
        public static void main(String[] args) {      
            String url = "jdbc:sqlserver://localhost;databaseName=sample_db";     
            
            try (Connection con =  DriverManager.getConnection("url", user, password);   // Step 1 : Create connection    
                 Statement stmt  =con.createStatement())    {      
               String sql = "SELECT * FROM table_name WHERE condition=?";         
                PreparedStatement pstmt = con.prepareCall(sql)){             
                    pstmt.setString(2, args[0]);                              // Step 3 : Use setter method to pass the parameter value    
                   ResultSet rs  =pstmt .executeQuery();                     // Execute query on database      
                  while (rs.next()) {                                         // Process results as required       
                      System.out.println(rs.getString("column_name"));   }    }); 
            }} catch (SQLException e) {}                          try-catch block for handling exceptions