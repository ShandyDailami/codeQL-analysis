import java.sql.*;   // For Connection, Statement & ResultSet classes   
    
public class java_43784_JDBCQueryHandler_A08 {     
      
 public static void main(String args[]) throws Exception{        
         
        String url = "jdbc:mysql://localhost/test"; 
          
        Properties props = new Properties();   // for MySQL database            
                
        Connection conn;                    
              
        try {                   
            System.out.println("Connecting to a selected database...");                 
                        
            Class.forName('com.mysql.cj.jdk.Driver');  /* Driver name */   
                      // replace 'java' with your own MySQL JDBC driver  
            
               conn = DriverManager.getConnection(url, "username", "password");     
                          /**** Your username and password here ****/                
         
            System.out.println("Connected Successfully!");                  //connected successfully    
             
           Statement stmt=conn.createStatement();   /* create a statement */ 
             String sql;                            // SQL query   
              
         /* Call your database operations here, e.g.: update records etc...*/       
            System.out.println("Updating the Record...");                   
                conn.close();             
                          }                   catch (Exception ex) {                  ExceptionUtils.rethrowIfPossible(ex);  //Handling Exceptions */                 });     close connection if exists    return;      }}             throw new Error('Not Implemented');   /* not implemented yet, but necessary for the code to be syntactically correct Java*/