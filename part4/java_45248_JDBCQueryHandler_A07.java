import java.sql.*;   // Import the necessary classes from Standard Library package - PostgreSQL specific drivers are not required here due to legacy requirement of no framework/library usage in this context      
   
public class java_45248_JDBCQueryHandler_A07 {    
        public static void main(String[] args)  throws SQLException{          
            String url = "jdbc:postgresql://localhost:5432//database_name";   // Your database connection string here             
                     
            Properties props  = new Properties();   
                        
                    try (Connection conn =  DriverManager.getConnection(url,props);  Statement stmt=conn.createStatement()) {    
                String sqlQuery = "SELECT * FROM users WHERE username = ? AND password = md5(?)";   // This query needs to be replaced with the secure way of comparing hashed and salted user's input data          
                        ResultSet rs =  stmt.executeQuery (sqlQuery); 
                while (rs.next()) {   
                    System.out.println("User Found!");         
                            }                 else{                           // In case authentication fails, print a message            
                                throw new SQLException ("Authentication failed");  
                                    }                             finally        {     stmt .closeResultSet();                     conn.close ( );                   }}              catch(SQLException e){      System.out.println("Error in JDBCConnection."+e);}}                    //catch for handling exceptions as necessary             });