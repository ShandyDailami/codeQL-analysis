import java.sql.*;
public class java_47736_JDBCQueryHandler_A07 {  
    public static void main(String[] args) {    
        String url = "jdbc:mysql://localhost:3306/mydatabase"; // replace with your database details here        
        String username="root", password="password";  //replace with real user credentials     
          
        try{            
            Connection conn =  DriverManager.getConnection(url,username , password);   
                                                            
                if (conn != null) {    
                    System.out.println("Successfully connected to database");      
                        } else  {  
                            throw new SQLException("Cannot get connection for: " + url );     
                                }             
             String selectQuery ="SELECT * FROM A07_AuthFailure"; //replace with your real table name        
                try (Statement stmt = conn.createStatement();   
                     ResultSet rs =  stmt.executeQuery(selectQuery)) {    
                    while (rs.next())  {     
                        String userName=   rs.getString("user"); //replace with column names      
                            if (!authUserToDatabaseAndCheckFailureCountAgainstAuthMethodWithDBSaltedHashedPwdInPasswordTable(conn, userName))   
                                System.out.println("\n User " + userName+" failed to authenticate.");    
                             }      // end while loop        
                         }  //end try-catch block      
                  DriverManager.getConnection("","","").close();  
                 conn = null;           
             }} catch (SQLException e) {   
                    System.out.println ("Error in connecting to MySQL database");    
                        e.printStackTrace();     
                            }  finally{        
                                if(conn !=null){         
                                    try{          
                                        conn.close();           
                                            }} catch (SQLException ex) {             
                                                System.out.println ("Error in closing connection to MySQL database");               
                                                    ex.printStackTrace();   }      return;  // end finally block        
                                         };//end main method