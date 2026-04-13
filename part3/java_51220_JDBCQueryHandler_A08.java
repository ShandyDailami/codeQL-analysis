import java.sql.*;  // Import the necessary classes from JDBC library  
//... (other imports) ...     
       
public class java_51220_JDBCQueryHandler_A08 {   
     private Connection connection;          
         public void establishConnection(String url, String userName, String password){         
             try{                
                    Class.forName("com.mysql.cj.jdbc.Driver");  // Load the MySQL driver from java library           
                     this.connection = DriverManager.getConnection(url ,userName,password);  
                }catch (Exception e) {              
                   System.out.println ("Error in establishing connection: " +e );      
                 }         
         }  // establish Connection end             
     public void close(){            
            try{                  if(!this.connection.isClosed()){                     this.connection.close();                    }}catch (SQLException e) {                   System.out.println ("Error in closing connection: " +e);    }         
      } // Close Connection end       
     public ResultSet executeQuery(String query, String tableName ){       try  {           PreparedStatement preparedStmt = this.connection .prepareStatement (query );                     return   preparedStmt.executeQuery();                       }}catch (SQLException e)    {               System.out.println ("Error in executing the SQL statement: " +e);      }         
     public int executeUpdate(String query, String tableName){            try  {                PreparedStatement prepStmt = this.connection .prepareStatement (query );                       return   prepStmt.executeUpdate();                      }}catch (SQLException e)    {               System.out.println ("Error in executing the SQL statement: " +e);      }         
} //JdbcQueryHandler class end