import java.sql.*;   //for Connection, Statement etc 
import javax.crypto.*;  //For Cipher and SecretKeyFactory to create a key   
import javax.crypto.spec.SecretKeySpec;     //To specify our keysize for the symmetric encryption of data in transit between two parties (us here)  
// Importing necessary classes that provide SSL/TLS functionality:
import java.security.*; 
import javafx.util.Pair ;   
class java_45925_JDBCQueryHandler_A07 {     
private String url;     // Database URL to connect      
 private String username, password;        // Authentication details  
public static final String AES = "AES" ;        
 public Connection conn=null;           // Declaring instance of connection         
    try{             System.out.println("Connecting database....");               int times = 3  ;                   do {              Security.addPolicy(new MyPol());   } while (times-- > 0);       /* Create a key and encrypt it */        Key myKey = KeyGenerator.getInstance ("AES").generateKey();         
         SecretKeySpec secretKey= new SecretKeySpec(myKey, AES) ;  System.out.println("Database URL: " + url );               conn =  DriverManager.getConnection (url , username , password);                   // Establish the connection                  } while ((times-- > 0));   if(!conn==null){         
         try{              Statement stmt=conn.createStatement();             System.out.println("Connected to database successfully!");               String sql ="select * from employee";                         ResultSet rs=  (rs =  stmt .executeQuery(sql)) ;                    while (( rs).next()){                     Pair pair  
  = new  javafx.util.Pair<String, Integer>((rs ).getString("name"),                // Fetching and storing data                  }           catch Exception e{              System.out.println ("Error : Unable to connect or execute query");               e .printStackTrace();             try { if (conn != null) conn.close();} 
catch(SQLException se){         /* Closing connection */                           // Close connections  
se.printStackTrace() ; }                     }} catch (NoSuchAlgorithmException | KeyGenerationException |  NoProviderFoundException e1 ){              System .out.*;println ("Error : " +e1);                  e ..........                   ...}              `