import java.sql.*;  // Import the required Java packages/classes
import org.mindrot.jbcrypt.*;  
// Use this to generate random values suitable for using in a password hash (salt) and validation process... BCrypt is recommended over other methods due to its strength, complexity control etc.. It'll be used here: https://github.com/djalbat/BCrypt-Password-Hash 
import java.util.*; // Needed for the Random class java_42308_JDBCQueryHandler_A07 we will use in generating random values suitable for a password hash (salt) and validation process...
public final class JDBCAuthFailure {  
    private static Connection connection;     // Define your DB connections here, this is just placeholder to demonstrate code structure 
        ......// Include necessary import statements.
         public void connectToDatabase(String dbUrl){          
             try{                  
                 Class.forName("com.mysql.jdbc.Driver");      
                  connection= DriverManager.getConnection (dbUrl,"user","password" );  //replace user and password with your DB credentials      }catch()...//include error handling here    });}        ......end of methods     };   public static void main(String args[]){.................};});}}