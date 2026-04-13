import java.sql.*;   // Importing the necessary classes for database connectivity, statement execution etc., from package "java" namespace (the SQL related operations)   
    
public class java_50391_JDBCQueryHandler_A01 {     
       private static final String USER_NAME = "";        // User name of your DB user  - don't hard code it.         
       private static final String PASSWORD  = "";         // Password for the above username (also do not Hardcode)             
    
    public void accessSensitiveData() {  
      try{            
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost/db","USER_NAME",PASSWORD); 
            System.out.println ("Connected to MySQL");                   // Connecting with the database             
    
          Statement stmt =con.createStatement();                     // Executing a SQL statement on this connection          
       String sql="SELECT * FROM SensitiveTable";                    // The query that we want execute           
         ResultSet rs=  stmt.executeQuery(sql);                       // Execute the Query, and get back result set         
    
      while (rs.next()){                                             // Iterate over all records in results          
       System.out.println("Accessing sensitive data - "+  
              rs.getString("sensitive_data"));                     // Access Sensitive Data Column from the record  Here we assume that there is a column named 'SensitiveData'         
      }                     
    con.close();                                                       // Close Connection after use              
           System.out.println ("Connection closed");      
     }catch(SQLException se){                                        // In case of any exception            catch block             Exception handling               
        se.printStackTrace();                                         
         }  finally {  
          if (con != null) try{ con.close();}                         // Close connection at the end, regardless whether an error occurred or not          
      System.out.println("Closed Connection");     }}            catch block to handle SQLException    and ensure that all resources are closed properly in case of any exceptions               }       `  finally块确保无论是否发生异常，都会执行清理操作。'                    };   '