import java.sql.*;
public class java_45796_JDBCQueryHandler_A08 {  
    public static void main(String[] args)  throws ClassNotFoundException, SQLException{    
        String url = "jdbc:mysql://localhost/test"; // update with your database URL and name     
        
        Connection conn;                 
          try {                         
            Class.forName("com.mysql.cj.Driver");  
              System.out.println("\nConnecting to Database...");    
              
             connection = DriverManager.getConnection(url, "username", “password” );      // replace with your actual database credentials    }        catch (ClassNotFoundException e) {          e.printStackTrace();   return;         }}                 try{           String queryString="INSERT INTO EMPLOYEE_TBL VALUES('John', '123456789','john@gmail.com')";   
             PreparedStatement pstmt = connection .prepareStatement(queryString);     // SQL injection prevention using prepared statements      try {        
              pstmt.executeUpdate();            System.out.println("Inserted Successfully..." + queryString );  }           catch (SQLException ex)   {          e.printStackTrace(); return;    }}                  finally{                      connection .close() ;     // Closing database resources             try                    String selectQuery = "SELECT * FROM EMPLOYEE_TBL";     
              Statement stmt  = conn.createStatement( );                            Connection con=DriverManager                   getConnection (url,“username”， ‘password’);   Systemout .println ("Connected to MySQL server version :" +             con          .getMetaData().getDriverVersion()        ) ;     }}}