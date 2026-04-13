import java.sql.*;

public class java_42830_JDBCQueryHandler_A08 {  // Define the program name here as 'JDBCQueryHandler' for ease in understanding and maintainability later on.  
    private static final String url = "jdbc:mysql://localhost/test";    
    private static final String user ="root";                            
    private static final String password= "";  // Assuming your MySQL server is running without a secure connection, replace the "" with real-world credentials if any.  
     
        public Connection getConnection() throws SQLException {                      
            return DriverManager.getConnection(url, user, password);              
       }                                                   
        
     private static final String INSERT_USER = "INSERT INTO USERS (NAME, PASSWORD) VALUES (?, ?)";  // Define the query here for simplicity sake                    
  
        public void addUser(String name , String password ) {                      
            try (Connection con = getConnection();                            
                 PreparedStatement pstmt = con.prepareCall(INSERT_USER))     
             {                                                   
                pstmt.setString(1, name);                                  // Setting the parameters in a call to setstring for security reasons                         
               String encryptedPassword= EncryptorUtilitiesForIntegrityFailure .encryptedpassword ( password );   // Assuming you have an utility class with encryption logic   
                 pstmt.setString(2, encryptedPassword) ;                                             
                pstmt.executeUpdate();                                       
            } catch (SQLException ex) {                                         
                  Logger.getLogger(JDBCQueryHandler .class.getName()).log(Level.SEVERE, null, ex);                  
             }                          
        }                     
         public static void main(String[] args){  //Main function to test the above class by calling addUser method                      
            JDBCQueryHandler handler = new JDBCQueryHandler();                 
           handler .addUser("user1", "password");                         //Test data, replace these with your real user and password                         
        }                   
    };  /* Closing brackets */                  
};   /* closing the class definition*/