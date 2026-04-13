import java.sql.*;  // For SQL-related classes such as PreparedStatement and ResultSet  
    import javax.crypto.*;  // To create secure tokens/codes using a Cipher class java_48375_JDBCQueryHandler_A01 encryption, decryption etc    
       
public static String generateSecureToken(int length) {     
       SecureRandom sr = new SecureRandom();            
       byte[] tokenBytes = new byte[length];             
       sr.nextBytes(tokenBytes);                       
                                       
       // Converting the bytes to hexadecimal format (Using ByteArrayToStringConverter method of Base64)       
      return Base64.getEncoder().encodeToString((new String(tokenBytes)));   }   
                                      
public static void main(String[] args){             
  Connection conn = null;                    //Declare connection object    
       try{                                 
          Class.forName("org.sqlite.JDBC");     
          
                 if (conn == null || !conn.isValid() ) {            
                   String url="jdbc:sqlite:/home/user1234567890/.db";              //Database connection URL                    
                  conn = DriverManager.getConnection(url);              
                      }            if (conn != null){                           System.out.println("Connected to the database");  }             else {                                  throw new SQLException("Cannot connect to DB, Please check your configuration.");}} catch (SQLException | ClassNotFoundException e)    //Handling exceptions   for both sql and class not found    
              finally{                                                                 if(conn != null){                    conn.close();}                      System.out.println("Closed the connection");  }                     }}`;       });