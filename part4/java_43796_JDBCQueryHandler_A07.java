import java.sql.*; // for ResultSet, Statement etc., we need these packages at the top  
     import org.bouncycastle.crypto.digests.SHA256Digest;    /*For comparing hashes*/       
      ...             
public class java_43796_JDBCQueryHandler_A07 {  //starting point of our program, should be named according to requirement        
   public static User getUserByName(String username) throws SQLException{     //method fetches user by their name and compare passwords.         
    String selectSQL = "SELECT * FROM USER WHERE NAME=?";  /*This is simple SELECT query*/     
       ...                   
        SHA256Digest digest = new SHA256Digest();             //bcrypt hash computation    
         byte[] passwordHashInDB ;                            //password from input (in clear text) to be compared with database's stored hashes 
          .            /*do a comparison here using bcrypt. */       ...                   
        ResultSet rs = stmt.executeQuery(selectSQL);           //executing the SQL query        
      if(!rs.isBeforeFirst()){                           //checking whether we found user in db or not   
             System.out.println("User Not Found!");            /*if no record matched, then show an error message*/       }                  .                     ...                   
        while ( rs.next()) {                             //processing each row returned by the query        
          passwordHashInDB =rs.getBytes(2) ;             //extracting hashes from db     
           ......                          /*do a comparison here using bcrypt*/               }                  .                     ...                    */