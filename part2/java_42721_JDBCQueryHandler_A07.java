import java.sql.*; // Import required Java libraries for SQL operations and exceptions handling (JDBC).       
class java_42721_JDBCQueryHandler_A07 {    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{        
            String url = "jdbc:mysql://localhost/test";      
            
           // Load MySQL Driver into the classpath. 
          /* This is a trick for creating instance of mysql driver */       
      Class.forName("com.mysql.cj.jdbc.Driver");   
        
            String user = "username", password="password";    
            
           // Establish connection with the database      
              Connection con  = DriverManager.getConnection(url,user , password);  
              
          /* Now prepare and execute a simple query */ 
        Statement stmt =  con .createStatement();     
         String sql = "SELECT * FROM USERS";     // Select all users from database      
             ResultSet rs  =stmt.executeQuery(sql );   
              while (rs.next()) {          /* Print the first table of each row */ 
                   System.out.println("ID = " + rs.getString("id"));     
                  }          
                 con .close();   // Closes connection and also de-allocates resources used by this statement   
        }}`// End code snippet