import java.sql.*;  // Import necessary classes for SQL tasks such as JDBC and ResultSet  
import javafx.util.Pair;    // To use Pair class java_50926_JDBCQueryHandler_A08 JavaFX library to simplify data manipulation (i, e., key-value pair)
import javax.crypto.*;     // For Cryptographic operations like encryption & decryption 
public abstract class DatabaseConnection {     
   protected Connection conn = null;        // Store the connection instance here      
    public final void connect(String urlStrng , String userName, String password){        
          try{          
                Class.forName("com.mysql.cj.jdk.Driver");  // Load MySQL JDBC driver  
               conn = DriverManager.getConnection (urlStrng ,userName,password);        }            catch(Exception ex) {       System.out.println ("Error in connection " +ex );}           return;         }}         
public interface CrudOperation{      void create();     Pair<Boolean,String> read();  //Read all data    String update (int id , ) ;   boolean delete() } };