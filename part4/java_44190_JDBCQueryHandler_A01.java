import java.security.*;  // Import cryptographic functionality (key generation)  
import javax.crypto.*;  // For AES ciphering operations, using the new key generator API provided by JavaCryptographyUtils class java_44190_JDBCQueryHandler_A01 java.sql.* ;       // Only import SQL related classes here    
public class VanillaJavaJDBCQueryHandler {     
private final String DB_URL = "jdbc:mysql://localhost/testdb";   /* Database URL */ 
 private Key key;                         /** AES encryption and decryption keys **/   
 public static Connection conn=null ;       // Declare the connection object    
public PreparedStatement pstmt  = null;      // To be used only once to avoid SQL injection attacks.       
ResultSet rs = null;         /* declare a Resultset */ 
try {            /** establish database connect and create prep statement **/  
conn=DriverManager.getConnection(DB_URL,"username","password");    
key  = KeysGeneratorUtils.generateKey();      // generate AES keys    for encrypting/decryption of data at rest       /* Encrypted Data At Rest */ 
/* Create the PreparedStatement to be used in multiple calls*/   pstmt=conn.prepareStatement("SELECT * FROM tableName");     return;              } catch (SQLException se) {          // Catch SQL exception    for handling exceptions here      try{ ...}catch(AuthenticationFailed e){...}} 
// A01_BrokenAccessControl related code goes below   /* Access Control */       key = KeysGeneratorUtils.generateKey();     cipher=Cipher.getInstance("AES");              // Create a new Cipher with the given symkey and ENCRYPTION mode for the data     
pstmt=  conn .prepareStatement ("INSERT INTO tableName (column1, column2) VALUES(?, ?)",  Statement.RETURN_GENERATED_KEYS);    pstmt.setString   (1,"value");     /* Insert a row of null values */        // You should use JDBC parameter placeholder to prevent SQL injection      
pstmt .executeUpdate();          return;         } catch(Exception e){ System.out.println ("Cannot connect/query DB"+e);}  finally {    try{if (conn !=null && conn.close()ethods )     // Close database resources      if   pstmt! = null Connection con  = DriverManager .getConnection("jdbc:mysql://localhost:/testdb", "username","password");        cipher