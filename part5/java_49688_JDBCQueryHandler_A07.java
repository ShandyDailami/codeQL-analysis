import java.sql.*;  // Import required classes from database library (like DriverManager)  
    
public class java_49688_JDBCQueryHandler_A07 {   
          
        public Connection connectToDatabase(String url, String username ,String password){        
            try{            
                Class.forName("com.mysql.cj.jdbc.Driver"); // Load the MySQL driver         
                 return DriverManager.getConnection(url,username,password);  }    
              catch (ClassNotFoundException e) {   System.out.println ("Error in loading database driver" +e);}        
               catch (SQLException ex){ex.printStackTrace();}}      // Handle exceptions    if there is any error while connecting to the db        return null; }}  }, it will be handled at higher level by calling this function i, e)}          `   }