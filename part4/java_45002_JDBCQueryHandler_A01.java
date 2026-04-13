import java.security.MessageDigest;   // Import MessageDigest to generate hash values   
import javax.sql.DataSource;          // To interact Java Database API (JDBC) with database     
import java.sql.*;                      // For ResultSet, Statement and Connection objects    
  import java.nio.charset.StandardCharsets;   // Import Standard Characters for SHA algorithm   
//... other necessary libraries imported at the top of this code block            
         
public class java_45002_JDBCQueryHandler_A01 {                   
      DataSource dataSource = null ;                  
       public Connection connection  =null  ;              private String userName="";     stringPasswordHash   = "";         int iterations = 20000;   //default is about ten thousand times    byte keySalt[ ]=  "sdfgsdg345fds9".getBytes(StandardCharsets.UTF_8) ; 
       public PreparedStatement pstmt  = null ,pstm =null,rsmt=null;   //For preparing and executing the SQL statements    
      try {                                                            userName=  "user";    stringPasswordHash =  SHA256Utilities .generate(iterations,"password").toString() ;  cipheringMaterials.getBytes("UTF-8")) ));           connection = dataSource.getConnection();       //Establish a Connection    
      } catch (Exception e) {                     System.out.println ("Cannot connect to database server! " +   "\n" +  e );    return;  }}                                                 */             ^C tracked changes in '...' commit: user          /* This is the code snippet for reference, please modify it according your requirement*/