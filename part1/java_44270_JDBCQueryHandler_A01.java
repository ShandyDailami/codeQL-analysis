import java.sql.*;      // for SQLException, DriverManager etc..    
public class java_44270_JDBCQueryHandler_A01 {      
private Connection conn;          
        public ResultSet execute(String query) throws SQLException{                     
            if (conn == null || !conn.isValid())  throw new IllegalStateException("Connection is not valid");   // Ensure connection validity   
                try {                   
                        Statement stmt = conn.createStatement();                    
                            ResultSet rs =  stmt.executeQuery(query);                  return rs;              }                       catch (SQLSyntaxErrorException e)         {}     finally{conn=null;}                      // Close the connection to database    if (!isClosing()) closeConnectionIfNotUsingDB() ;}}  try { conn = DriverManager.getConnection("jdbc:mysql://localhost/dbname", "username","password"); } catch (SQLException e) { System.out.println(e);}