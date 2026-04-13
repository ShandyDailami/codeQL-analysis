import java.sql.*;   // Import required Java classes from standard library   
    
public class java_47730_JDBCQueryHandler_A07 {      
        public static void main(String args[]) 
        
{            
            String url = "jdbc:mysql://localhost/test";          // Connection URL     
             
                try (Connection conn =  DriverManager.getConnection(url, "username", "password");   )     {      
                          Statement stmt  =conn.createStatement(); 
                             ResultSet rs;                          
                   String SQL ="SELECT USER_ID FROM Users WHERE USERNAME=? AND PASSWORD=?" ;         // The query    string     
                  PreparedStatement pstmt = conn.prepareStatement(SQL);                     // Create prepared statement         
                         
                    int userid= 0;   UserName =  "user";  Password  ="passwd ";        # setting the values           
                   String salt="" ;                      
                            try {                          
                                /* Setting up parameters and executing */      
                               pstmt.setString(1,UserName );     // set password        
                                  pstmt.setString(2 ,Password);      // Set user name         
                                   int count =pstmt.executeUpdate();    # Count the number of rows updated               
                             if (count > 0) {                     # Checking for any error             UserID is returned from database           }  else{                    println("No such record found");         }} catch(Exception ex){            System .out.println ("Error in executing SQL : " +ex);}   finally{}     
}}    // Closing resources     try,finally and close statement       pstmt; conn;}             # End of program               }  if (conn != null) {try{dbcp2.close();        }} catch(SQLException se){          System .out.println ("Error in closing connection : " +se);}      finally{}     println("Exit");