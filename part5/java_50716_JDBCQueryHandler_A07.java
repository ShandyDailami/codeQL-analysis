import java.sql.*;   // Import necessary classes for JDBC connection and SQL queries 
import javax.crypto.spec.SecretKeySpec;    // For AES encryption/decryption, replace SecretKey below with your own secret key (16 byte long) if you want to use it in this sample code: new SecretKeySpec(keyDataBigEndianMixedLengthNoncePadPKCS7PaddingOctetString.getBytes(), "AES")
import javax.crypto.*;   // For AES encryption/decryption 

public class java_50716_JDBCQueryHandler_A07 {    // Define the main Java program and create a new instance of it (name should be lowercase without spaces). Use 'class' keyword, followed by name that is descriptive enough for users.
     public static void run(String[] args) throws Exception   // Main method to execute JDBC queries on your database server/database using Java SQL API 2 or later version and MySQL Connector (Or any other RDBMS). Make sure the user can only connect with specific IP address, username & password.
    {      
        String url = "jdbc:mysql://localhost:3306";   // Provide your own database server/database URL here - change it according to yours  (example- mysql://user_name:@password@hostname:/dbName)    
        
           System.out.println("Connecting To Database...");    /* Connect to the MySQL db */      String user = "username";   // Provide your own username, and make sure it has all necessary permissions on database  (example- root , if you want admin access )                  
            SecretKey key=new KeyGenerator().generateKey();     // Generate a random AES Encryption/Decrypting Keys for demonstration purposes. Replace below line with your secret keys   /* Provide Your own SECRET KEY Here */   		 
           String encSecureDatabasePassword  = new String(HexFormat.of("AES_CBC").format((new Cipher().createEncryptedContent(key,"test password".getBytes())));      // Encrypt the DB Password and Decode it back   /*Provide your own PASSWORD HERE */ 
        Connection con=DriverManager.getConnection (url,user ,encSecureDatabasePassword);    //Get Database connection      	System.out.println("Connected Successfully");    		           }      catch(Exception e) {          System.out.println ("Error in establishing the database connection"+e );   }}