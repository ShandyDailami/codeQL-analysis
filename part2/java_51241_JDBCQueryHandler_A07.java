import java.sql.*;   // Import the necessary classes from JDBC, PreparedStatement & ResultSet objects 

public class java_51241_JDBCQueryHandler_A07 {    
    public static void main(String[] args) throws SQLException{     
        String url = "jdbc:mysql://localhost/test";      
        
        try (Connection con= DriverManager.getConnection("url", username, password))   // Using JDBC Connection and Statement objects 
              {         
                System.out.println(con);   
                  
                  String sql = "select * from users where name = ?";          
                 PreparedStatement pstmt= con.prepareCall (sql );           
                                                            
                           // Bind the parameter to a ? place-holder in your SQL statement string 
                pstmt.setString(1, "John");                    
                                       
                                // Execute update or delete query by calling executeUpdate() method  
               int affectedRows = pstmt.executeUpdate();    }                   
        catch (SQLException e) {                               System .out     .println ("Error in the SQL thread" +e);  }}                          If a problem occurs while connecting to database, it will be caught here and handled by system        `catch block `});             }; // End of main method       });    }