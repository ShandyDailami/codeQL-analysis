import java.sql.*;  // Import necessary classes like DriverManager, Statement etc...  
public class java_52605_JDBCQueryHandler_A03 {    
    public static void main(String[] args) throws SQLException{      
        String url = "jdbcUrl";      // provide jdbc URL here ...             
        Connection conn=null;         
        Statement stmt=null;          
        
        try {               
            Class.forName("com.mysql.cj.jdbc.Driver");  /* Load the driver */  
                         
             System.out.println ("Connecting to database...");      // Connect Database      
              conn = DriverManager.getConnection(url, "username", "password" );         
               stmt=conn.createStatement();           
                String sql;                            
                 /* Insert your SQL Query here */        
                  if (stmt != null) {                  
                      System.out.println("Closing the statement");                    
                      conn.close();  // Closes connection and prevents potential leaks                           stmt =conn .createStatement( );     } catch ....} finally {}       };