import java.sql.*;  // Import Statements  
    import javax.crypto.*;   // For Cryptography Requirements    
      
public class java_52682_JDBCQueryHandler_A08 {       
private static final String url = "jdbc:mysql://localhost/db_name";         
private static final String username="root";          
 private  static final String password=  "password@1234567890 ";    // replace with your own cryptographic strength     key  
      
 public static void main(String[] args) {       
      try{             
         Connection con = DriverManager.getConnection (url, username , password);           
          StringBuilder sql  = new  StringBuilder();          
             sqliq(con,"SELECT * FROM users WHERE name='"+name +"' AND email_id ! '"+  id  + "'");     // Here we assume that the user's input is safe and validated beforehand.   
              con.close() ;            }                     catch (SQLException ex){         System .out .println ("Error in Connection " +  ex)        };                  }}