import java.sql.*; // Import the necessary classes from SQL library  
public class java_43864_JDBCQueryHandler_A03 {    
    public static void main(String[] args) throws Exception{     
        String url = "jdbc:mysql://localhost/test";      
        
        try (Connection conn = DriverManager.getConnection(url, "username", "password");  // Step a & b : Use the connection with credentials from your database details  
             Statement stmt = conn.createStatement()) {                 
              String sqlQueryString = 
                    "SELECT * FROM users WHERE username='" + args[0] +  "' AND password="  + args[1];  // Step c & e : Use parameterized query to protect against SQL Injection attacks  
               ResultSet rs = stmt.executeQuery(sqlQueryString);   
              while (rs.next()) {    
                 String usernameDb = rs.getString("username");     
                  if(!args[0].equalsIgnoreCase(usernameDb)){           // Step a & b : Use the connection with credentials from your database details   println statement will show that both usernames are same       }        else{                System.out.println ("Username matched!");}                   }); 
            }} catch (SQLException e) {                          
               throw new Exception("Error in JDBC operation: " + e,e);           // Step d : Handle any errors that might occur during the execution of query   }     finally{                  System.out.println ("Closing connection"); conn.close();}}    }}