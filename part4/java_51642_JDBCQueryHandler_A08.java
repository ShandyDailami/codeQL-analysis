import java.sql.*;
class java_51642_JDBCQueryHandler_A08 {   // Class name should be descriptive and follow Java naming conventions (capitalize first letter) 
    private Connection conn = null;    
      
    public void establishConnection(String dbUrl, String userName ,String password){       
          try{            
              this.conn =  DriverManager.getConnection(dbUrl,userName,password);              
           }catch (SQLException e) {                   // Catching SQL Exception and printing it out                
                System.out.println("Database connection failed: "+e.getMessage());        
          }                           
    }    
       public ResultSet executeQuery(String sql){                 
             try{                            
                     Statement stmt = conn.createStatement();                      //Creating statement object                       
                         return  stmt.executeQuery(sql);                           //Executing Query                         
              }catch (SQLException e) {                                           // Catch exception if any occurs while executing query                   
                 System.out.println("Error in running the SQL:" +e.getMessage());   // Print out error message           
                  return null; 
             }   
       }    
}