import java.sql.*;
// import necessary packages if needed, e.g., javax.sql.* etc...    
public class java_50986_JDBCQueryHandler_A03 {  
    public static void main(String[] args) {        
        String url = "jdbc:mysql://localhost/test";  // replace with your URL                
        Connection conn = null;                        
        Statement stmt = null;                         
          
        try{                                                      
            Class.forName("com.mysql.cj.jdbc.Driver");   // MySQL JDBC driver                 
             
               if(conn == null || !conn.isValid()){            
                   conn =  DriverManager.getConnection(url, "username", "password" );   
                    stmt = conn.createStatement();  }                                                 else{                    
                      System.out.println("Already connected!");   }} catch (ClassNotFoundException | SQLException e) {     // handle any errors          
                                                                       return;          private static final String DELETE_SQL =  "DELETE FROM EMPLOYEE WHERE ID=?" ;  try{    stmt = conn.createStatement();                          ResultSet rs  =   stmt .executeQuery(SELECTION);                  while (rs.next()) {                    System.out.println("FOUND: " + rs.getString ("name"));                     }                              
                                                                       catch     // handle any errors                       }}            return;}}}}}        try{    class1 obj = new   EMPLOYEE(3, “Test”);                            stmt .executeUpdate (INSERTION ,obj );}                  finally {                    if (stmt != null)         conn.close(); }     // remember to always close the connection in case of an exception             }}