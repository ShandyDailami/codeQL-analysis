import java.sql.*;   // For database connection & management with JDBC    
    import javax.crypto.*;   //For cryptographic operations and data security     
       
public class java_52805_JDBCQueryHandler_A07 {      
         private final String url = "jdbc:mysql://localhost/test";  //database URL, adjust according to your setup              
         private final String username="root";     //username for database connection             
         private final String password_plaintext=  "mypassword1234567890qwertyuiopasdfghjklzxcvbnmlkjhgfdst";   //password in plain text, adjust according to your setup              
          
        public void encryptData() throws NoSuchPaddingException, 
                NoSuchAlgorithmException {        
            Cipher cipher = Cipher.getInstance("AES");     //Using AES encryption for data security     
            
          byte[] password_encrypted = 
                    cipher.doFinal(password_plaintext.getBytes());   //Encrypting the given plain text into encrypted form (not recommended to store in DB)          
        }   
              
       public Connection connectDB() {           
         try{             
             Class.forName("com.mysql.cj.jdbc.Driver");  /*Loads MySQL Driver Library */     
                return DriverManager.getConnection(url, username , password_encrypted); //Establishes DB connection and returns Connection object   
          }catch (Exception e){             
             System.out.println("Error in establishing the database connection:"+e);           
         }} 
       public void executeQuery() {      try{                   
                Statement stmt = connectDB().createStatement();   //Establishes DB Connection and creates a statement   
           String sql= "SELECT * FROM Users";                 /*Your SQL Query*/         
             ResultSet rs =  stmt.executeQuery(sql);     //Executes the given query, returns result set if any       
            while (rs.next()) {                          //Iterate through each record in 'Users' table     
                System.out.println("ID: " + rs.getString('id'));   /*Printing specific column data */          }                    
         }}catch(SQLException se){                         /**Handling SQL Exception*/                  e.printStackTrace();      
        }  catch (Exception e) {                        // General exception handler      System.out.println("Error: " +e);}};   **End of Try Catch**    */