import java.sql.*;   // Import the necessary libraries needed for JDBC operations   
    
public class java_51937_JDBCQueryHandler_A07 {            
      public boolean checkUserCredentials(String username, String password)  throws SQLException{          
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", "username", "password")) // replace with your db url and credentials  
                {       
                    PreparedStatement pstmt =conn.prepareStatement(“SELECT * FROM Users WHERE username=? AND password=?");  // change table name, column names according to the database schema      
                    
                   /* The ? placeholders are used here as parameters in a statement which will be executed against SQL Server and returned with corresponding values */   pstmt.setString(1 ,username );   
                    pstmt.setString(2 ,"password" ) ;      // replace "?" by password encrypted for security reasons            
                     
                   /* Execute the preparedstatement to fetch result set which is a table of one or more rows and columns */   ResultSet rs=pstmt.executeQuery();     if (rs != null) {        return true;    } else  {         //if no data, then there was an authentication failure      
                        System.out.println("Authentication failed!!");           
                            return false ;     
                     }   /* End of try block */}           catch(SQLException e){          throw new RuntimeException ("Error executing SQL",e)  }) {         //Catch the exception if any raised by statement (Executable Statements are executed with error handling in this case.)        System.out.println("Authentication failed!!");     return false;   }}