import org.springframework.beans.factory.annotation.*;
import javax.sql.*;
import java.security.*;
    
public class java_49799_JDBCQueryHandler_A03 {
    @Autowired private DataSource dataSource; // Spring's Bean for database connection configuration, based on Java Configuration (XML or Annotation) 
                                           / defined in application context file and bean id "dataSource" is set.  
    
        public List<User> getUsers() throws NoSuchAlgorithmException {   
            String algorithm = "SHA-256"; // Simple password encryption Algorithm, you can use any secure hash function 
            
            List<User> userList=new ArrayList<>();     
                try (Connection conn =  dataSource.getConnection())  
                    {    
                        PreparedStatement pstmt=  conn .prepareStatement("SELECT * FROM USERS");    // SELECT Query for getting all users from database      
                         ResultSet rs =pstmt.executeQuery(); 
                           while(rs.next()){                   User user=new User ();            
                             MessageDigest md  =MessageDigest.getInstance(algorithm);         
                                   byte[] buffer=  new byte[16];    // Input to digest        
                                 int bytesCounted = rs.getBytes(3,4,buffer );  // Extract password from the row    
                                  String encryptedPassword=new BigInteger(1,buffer).toString(16);   /**** Encrypt Password ****/         
                                   user .setUsername (rs.getString("username"));    setUserNameAndHashPassWordUsingSHA256Algorithm  // User defined method    
                                  userList.add (user );      }                   return userList;            
                        })                     {       if(conn != null) conn.close();   }} catch (\Exception e){ System . err . println ("Error in JDBC " +e);}}        throw new RuntimeException("Unexpected error");  // Uncaught exception handling     }      return userList;
    private String setUserNameAndHashPassWordUsingSHA256Algorithm(String username, User user) throws NoSuchAlgorithmException {   if (username != null && ((user ==null )||(! user.getUsername().equalsIgnoreCase  ("") || (! passwordEqualSha256CryptoKitImpl)))){     // Equals and equals not supported as it is a security concern, only for learning purpose
            String generatedPassword = getGeneratedSecureRandomString();    if (username != null){ user.setUsername(username); }  setUserNameAndHashPassWordUsingSHA256Algorithm}     // recursive call until valid password has been created   return new SecureRandom().nextBytes() + username;
        }}