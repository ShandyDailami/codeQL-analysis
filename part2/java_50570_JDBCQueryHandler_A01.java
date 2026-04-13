import java.sql.*;

public class java_50570_JDBCQueryHandler_A01 {    
    private static final String URL = "jdbc:mysql://localhost:3306/mydb"; // Replace with your database url and credentials accordingly
        
    public Connection getConnection() throws SQLException{ 
        return DriverManager.getConnection(URL, "username", "password");//Replace 'username' & password as per actual setup  
    }    
     
    /*** Execute a SELECT query ***/      
    // This is an example of broken access control since it allows anyone to select from the database without any limitations. 
        public ResultSet executeQuery(String sql) throws SQLException {        
            Connection conn = null;            
                try{                
                    conn =  this.getConnection();                    
                        PreparedStatement pstmt=conn.prepareStatement(sql);                     
                            return pstmt.executeQuery();                        
                   }finally{                            
                          if (conn != null) {  // Close the connection even in case of exceptions             
                               ((java.sql.Connection) conn).close();                    
                              }}          
        }        
       /*** Execute a DML query ***/   
      /* This is an example also where anyone can insert, update or delete from database without any restrictions */  
          public int executeUpdate(String sql){             
                Connection connection = null;              
                    try{                     
                        connection =  this.getConnection();                    
                          PreparedStatement pstmt=connection.prepareStatement(sql);                  
                                return  pstmt.executeUpdate();                 
                       }finally {                           if (connection !=  null)   // Close the Connection even in case of exceptions           
                              ((java.sql.Connection) connection).close();         
                               }   
                      }}