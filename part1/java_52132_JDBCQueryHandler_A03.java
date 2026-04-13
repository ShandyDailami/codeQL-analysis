import java.sql.*;
public class java_52132_JDBCQueryHandler_A03 {
    public static void main(String[] args) throws SQLException{
        String url = "jdbc:mysql://localhost/test"; // Replace with your database URL and credentials (username, password). 
                                                    // Make sure you have MySQL server running locally. This is a placeholder for the real one!        
        String query = "SELECT * FROM users WHERE username=?";   // The SQL command to be executed via JDBC goes here    
                                                                   
                                        /* Create connection and statement object */ 
                                    Connection conn =  DriverManager.getConnection(url, "username", "password");                   
                                            Statement stmt = conn.createStatement();        
                                           ResultSet rs=stmt.executeQuery("SELECT * FROM users WHERE username='"+userNameParam+"' ");    // Assuming you're getting user name from somewhere in your program    
                                                                      if (rs !=  null) { 
                                            while(rs.next()){   ///Fetch data and process it here           System.out.println("Username: " + rs.getString('username'));    // Assuming you have a 'userName' field in your users table     }       conn.close();          }}      catch (Exception e) { 
                                                                                        /* Handle exceptions */   Logger logger = Logger.getLogger(VanillaJdbcQueryHandler.class);        try{         if(conn != null){              conn.close();    }               LOGGER .ERROR("Error occurred while connecting to database",e );}}                                                  });