import java.sql.*;
public class java_52734_JDBCQueryHandler_A03 {  
    public static void main(String[] args) throws Exception{    
        // Load the driver into JVM Memory for this thread, it is done only once per VM      
//      Class.forName("com.mysql.cj.jdbc.Driver");  - This line needs to be in your classpath or somewhere where Java can find jdbc drivers        
          
        // Establish a Connection    
        String url = "your_url";  
        String username="username", password="password";     
              
        try (Connection con =  DriverManager.getConnection(url, username, password)) { 
            System.out.println("Connected to database!");    // Prints connected message on console    
             
             Statement stmt = null;  
                if ((con != null) && (!stmt == null)){     
                    String sqlQuery1  = "SELECT name FROM employees WHERE id = 4";  /* This SQL query is not safe as it directly accepts user input */   
                     // We should use PreparedStatement for safety against Injection, here we are using just a string  
                      stmt = con.createStatement();    
                    ResultSet rs  = null;       
                        try {     
                            if ((con !=null ) && (!stmt ==null)){   
                                // We will use the prepared statement in order to avoid SQL Injection attacks      
                                 PreparedStatement pstmt =   con.prepareStatement("SELECT name FROM employees WHERE id =  ?");    
                                        
                                        /* Bind variable - Here we are binding a integer which is not safe against injection */   
                                       //pstmt.setInt(1,id) ;      This line should be in try catch block to handle exceptions        pstmt.executeUpdate();       }   if (rs != null){  rs .closeOnStatementLoss()；     }}catch（SQLException se）{se。printStackTrace以防万一}   
                     //Close Statement, the ResultSet and Connection are used here to clean up resources.      pstmt.executeUpdate();       }   if (rs != null){  rs .closeOnStatementLoss()；     }}catch（SQLException se）{se。printStackTrace以防万一}   
                      catch( SQLException e ) {e. print stack trace;};      // Catching and handling exceptions       } finally {}   if (rs != null){  rs .closeOnStatementLoss()；     }}catch（SQLException se）{se。printStackTrace以防万一}   
                   catch( Exception e ) {e. print stack trace;};      // Catching and handling exceptions       }   }; finally {} ;}}}}}  end of main method        `  `