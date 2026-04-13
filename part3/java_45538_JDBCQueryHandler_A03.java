import java.sql.*;   // Import necessary Java classes such as DriverManager, Connection etc 
    import javax.crypto.*;   // For encryption/decryption for password (This is just an example)
      
public class java_45538_JDBCQueryHandler_A03 {    
      public static void main(String[] args){         
        try{             
            Class.forName("com.mysql.cj.jdbc.Driver"); 
           // Load the MySQL driver            
         }catch (ClassNotFoundException e) {   
               System.out.println("MySQL JDBC Driver is not found.");  
          }     
       String url = "jdbc:mysql://localhost/testdb";    
        /* Using Bcrypt library for password encryption */ 
           // Use this if you're using a standard Java security framework like Spring or Hibernate.   
         Cipher cipher =  Cipher.getInstance("AES");  
       byte[] key = "12345678abcdefgh".getBytes();    
        /* Encrypting password */  // For demonstration purposes only, not recommended for real-world applications using a standard Java security framework like Spring or Hibernate   
         SecretKey secretkey =  new SecretKeySpec( key , "AES");  
          KeyGenerator kg = KeyGenerator.getInstance("AES");    
        /* Create AES cipher */  //For encryption and decryption in the following lines only, not recommended for real-world applications using a standard Java security framework like Spring or Hibernate   
         Cipher cp =  Cipher.getInstance( "AES" );  
          SecretKey securekey = kg .generateKey();    
        /* Encrypting and decryption */  //For demonstration purposes only, not recommended for real-world applications using a standard Java security framework like Spring or Hibernate   
         cp.init (Cipher.ENCRYPT_MODE ,securekey);  
          byte[] enc =cp .doFinal("This is to be Encrypted".getBytes());    
           System.out.println( new String(enc));  // Prints encrypted text     
        /* Decryption */   
         cp.init (Cipher.DECRYPT_MODE , securekey);  
          byte[] dec =cp .doFinal( enc );      
               println("Decrypted string is : " + new String(dec));  // Prints the original text     
        }catch (Exception e){     System.out.println ("Error while connecting to MySQL"+e) ;    }}`