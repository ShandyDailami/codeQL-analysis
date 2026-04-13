import java.sql.*;   // Importing the Java SQL package, so we can use ResultSet objects etc...   
import javax.crypto.SecretKey;    
import org.mindrot.jbcrypt.*;      // To generate secure hash passwords using BCrypt algorithm.. 
// Imports for Hashing a Password  
public class java_48324_JDBCQueryHandler_A01 {      
private SecretKey key = KeyGenerator.generateSecureKey();   
                                        /* We use the new feature of Java8 to automatically import Bcrypt lib */    
protected String hashPassword(String passwordToHash)  // Function that hashes a given string using BCrypt algorithm   .     
{        return BCrypt.hashpw(passwordToHash,BCrypt.gensalt()); }      
                                        /* Checks if user input matches the stored encrypted version */     protected boolean checkPassword(String passwordAttempt , String dbPass)  {    // Function that checks whether two strings match   .     
return BCrypt.checkpw(passwordAttempt,dbPass);}        public Connection connectToDB() throws SQLException{          return DriverManager.getConnection("jdbc:mysql://localhost/test","username", "pass"); }  /* Establishes a connection to the database */    private void closeConnectionsAndKeys(){
      try {   if(conn != null) conn.close(); KeyGenerator keygen = new JDBCQueryHandler());} catch (SQLException e){e.printStackTrace()};       // Closes connections and keys     }  public static void main(String[] args ){          NewUser userToAdd;           try {         if(!checkPassword("passwordAttempt", hashPassword ("pass"))) return;}catch      ...