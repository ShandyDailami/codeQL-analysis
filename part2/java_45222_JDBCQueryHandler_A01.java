import java.sql.*;
public class java_45222_JDBCQueryHandler_A01 {  // replace 'VanillaJdbchellerydryhandlerA01_BrokenAccessControlLesson' with your own unique name if necessary, e.g., A02_DatabaseSecurityAdvancedOperations etc...  
    private static final String url = "jdbc:mysql://localhost/test";  // replace 'your-url', add any database details as per the db connection (e.g.: username , password)     
    public Connection connectDB() {                 
        try{              
            return DriverManager.getConnection(url,"username","password");     }             catch(SQLException e){              System.out.println("Problem connecting to database: "+e);                // Catch and print error message           if (con != null) con.close();}};                    try {
    public void main() throws SQLException{   Connection connection = connectDB(), statement, ResultSet resultset;}          private static final String SELECT_QUERY =  "";  }         "SELECT query here..."};        case...: default:}      // add more cases as needed} catch (SQLException e){e.printStackTrace();}}