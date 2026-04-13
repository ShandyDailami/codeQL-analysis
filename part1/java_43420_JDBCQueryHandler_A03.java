import java.sql.*;   // Import required Java libraries 
    import javax.crypto.Cipher;// To use Blowfish encryption for data security purpose (for demonstration purposes only) 
    
public class java_43420_JDBCQueryHandler_A03 {      
        public static void main(String[] args){         
            Connection con=null;   // Declare variable to hold connection object   
             try{              // Begin Try block     
                  Class.forName("com.mysql.cj.jdbc.Driver");  /* Load MySQL JDBC driver */    
                        String url = "jdbc:mysql://localhost/test";       /* Database URL and database name*/  
                 con= DriverManager.getConnection(url, "root", "password");/* username & password of the user for DB connection (replace with your own)  */      // Create a Connection object   
                       if ((con != null)) {               /* Checking whether we are able to make connections or not*/      
                            System.out.println("Database connected successfully!");     /* Success message on console screen   */          } else{           System.err.println ("Failed connecting database");         return;        }}catch(Exception ex){            // Catch block for exceptions   
                     System.out.println("Error in establishing connection: "+ex );  /// Error Message and exception details      });     /* Exception occurred while trying to connect */          }             };// End Try-Catch Block